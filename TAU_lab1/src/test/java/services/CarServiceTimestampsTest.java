package services;

import domain.Car;
import domain.TimeStamp;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTimestampsTest {

    @Mock
    TimeStamp timeStamp;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }
    private Car car = new Car();
    @InjectMocks
    private CarService testRepo = new CarService(new ArrayList<>());

    // simple tests for addTimestamp equal to date now()
    @Test
    public void testAddTimestampOnCreateMethod(){
        LocalDateTime localDate = LocalDateTime.parse("2007-12-03T10:15:30");
        when(timeStamp.getTimeStamp()).thenReturn(localDate);
        testRepo.create(car);
        verify(timeStamp).getTimeStamp();
        assertEquals(testRepo.cars.get(0).getAddTimestamp(), localDate);
    }

    // simple test for readTimestamps equal to date now()
    @Test
    public void testReadTimestampOnReadMethod(){
        LocalDateTime localDate = LocalDateTime.parse("2007-12-03T10:15:30");
        when(timeStamp.getTimeStamp()).thenReturn(localDate);
        Car car = new Car(0, "GD 123", "Toyota", 123);
        testRepo.cars.add(car);
        testRepo.read(0);
        verify(timeStamp).getTimeStamp();
        assertEquals(testRepo.cars.get(0).getReadTimestamps(), localDate);
    }

    // simple test for updateTimestamp equal to date now()
    @Test
    public void testUpdateTimestampOnUpdateMethod() throws InterruptedException {
        LocalDateTime localDate = LocalDateTime.parse("2007-12-03T10:15:30");
        when(timeStamp.getTimeStamp()).thenReturn(localDate);
        Car car = new Car(0, "GD 123", "Toyota", 123);
        Car newCar = new Car(0, "GD 456", "Mazda", 123);
        testRepo.cars.add(car);
        testRepo.update(0, newCar);
        verify(timeStamp).getTimeStamp();
        assertEquals(testRepo.cars.get(0).getUpdateTimestamp(), localDate);
    }

    // simple test for readTimestamps equal to date now()
    @Test
    public void testReadTimestampOnReadAllMethod() {
        LocalDateTime localDate = LocalDateTime.parse("2007-12-03T10:15:30");
        when(timeStamp.getTimeStamp()).thenReturn(localDate);
        Car car = new Car(0, "GD 123", "Toyota", 123);
        Car car2 = new Car(1, "GD 456", "Mazda", 456);
        testRepo.cars.add(car);
        testRepo.cars.add(car2);
        testRepo.readAll();
        assertEquals(testRepo.cars.get(0).getReadTimestamps(), localDate);
        assertEquals(testRepo.cars.get(1).getReadTimestamps(), localDate);
    }

    // test for timestamps method
    @Test
    public void testForGetTimestampsMethod(){
        LocalDateTime localDate = LocalDateTime.parse("2007-12-03T10:15:30");
        when(timeStamp.getTimeStamp()).thenReturn(localDate);
        Car newCar = new Car(0, "GD 456", "Mazda", 123);
        testRepo.create(car);
        testRepo.read(0);
//        testRepo.update(0, newCar);
//        verify(timeStamp).getTimeStamp();
        assertEquals(testRepo.getTimestamps(0).get(0), localDate);
        assertEquals(testRepo.getTimestamps(0).get(1), localDate);
//        assertEquals(testRepo.getTimestamps(0).get(2), localDate);
    }

    @Rule
    public final ExpectedException except = ExpectedException.none();

    // test for timestamps toggle methods
    @Test
    public void testForToggleAddTimestampMethod(){
        Car car = new Car(0, "GD 123", "Toyota", 123);
        testRepo.toggleAddTimestamp();
        testRepo.create(car);
        assertNull(testRepo.cars.get(0).getAddTimestamp());
    }

    @Test
    public void testForToggleReadTimestampMethod(){
        Car car = new Car(0, "GD 123", "Toyota", 123);
        testRepo.cars.add(car);
        testRepo.toggleReadTimestamp();
        testRepo.read(0);
        testRepo.readAll();
        assertNull(testRepo.cars.get(0).getReadTimestamps());
    }
    @Test
    public void testForToggleUpdateTimestampMethod(){
        Car car = new Car(0, "GD 123", "Toyota", 123);
        Car newCar = new Car(0, "GD 456", "Mazda", 123);
        testRepo.cars.add(car);
        testRepo.toggleUpdateTimestamp();
        testRepo.update(0, newCar);
        assertNull(testRepo.cars.get(0).getUpdateTimestamp());
    }
}
