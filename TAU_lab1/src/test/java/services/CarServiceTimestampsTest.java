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

    @Test
    public void testReadTimestampOnCreateMethod(){
        addTimestamp.setTimeStamp(LocalDate.now());
        Car car = new Car();
        testRepo.create(car);
        when(addTimestamp.getTimeStamp()).thenReturn(LocalDate.now());
        assertEquals(testRepo.cars.get(0).getAddTimestamp().getTimeStamp(), LocalDate.now());
    }
}
