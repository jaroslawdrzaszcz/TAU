package services;

import domain.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class CarServiceTimestampsTest {

    @Mock
    Date addTimestamp;

    @Mock
    Date updateTimestamp;

    @Mock
    Date readTimestamps;

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
    public void testAddTimestampTest(){

    }


}
