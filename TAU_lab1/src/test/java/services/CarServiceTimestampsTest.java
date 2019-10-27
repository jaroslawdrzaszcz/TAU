package services;

import domain.Car;
import domain.TimeStamp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class CarServiceTimestampsTest {

    private CarService testRepo = new CarService(new ArrayList<Car>());

    @Mock
    TimeStamp addTimestamp;

    @Mock
    TimeStamp updateTimestamp;

    @Mock
    TimeStamp readTimestamps;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    // tests for not null assertion
    @Test
    public void testAddTimestampNotNull(){
        assertNotNull(addTimestamp);
    }

    @Test
    public void testUpdateTimestampNotNull(){
        assertNotNull(updateTimestamp);
    }

    @Test
    public void testReadTimestampsNotNull(){
        assertNotNull(readTimestamps);
    }

    // simple test for addTimestamp equal to date now()
    @Test
    public void testAddTimestampOnCreateMethod(){
        Car car = new Car();
        testRepo.create(car);
        when(addTimestamp.getTimeStamp()).thenReturn(LocalDate.now());
        assertEquals(testRepo.cars.get(0).getAddTimestamp().getTimeStamp(), LocalDate.now());
    }

    // simple test for readTimestamps equal to date now()
    @Test
    public void testReadTimestampOnCreateMethod(){
        Car car = new Car(0, "GD 123", "Toyota", 123);
        testRepo.cars.add(car);
        testRepo.read(0);
        when(readTimestamps.getTimeStamp()).thenReturn(LocalDate.now());
        assertEquals(testRepo.cars.get(0).getReadTimestamps().getTimeStamp(), LocalDate.now());
    }

    // simple test for updateTimestamp equal to date now()
    @Test
    public void testUpdateTimestampOnCreateMethod(){
        Car car = new Car(0, "GD 123", "Toyota", 123);
        Car newCar = new Car(0, "GD 456", "Mazda", 123);
        testRepo.cars.add(car);
        testRepo.update(0, newCar);
        when(updateTimestamp.getTimeStamp()).thenReturn(LocalDate.now());
        assertEquals(testRepo.cars.get(0).getUpdateTimestamp().getTimeStamp(), LocalDate.now());
    }

}
