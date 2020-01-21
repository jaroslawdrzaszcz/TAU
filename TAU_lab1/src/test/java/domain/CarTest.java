package domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CarTest {

    private TimeStamp date = new TimeStamp();
    @Test
    public void emptyCarIsImplementedTest() {
        assertNotNull(new Car());
    }

    @Test
    public void carIsImplementedTest() {
        assertNotNull(new Car(1, "GD 1234", "Toyota", 123));
    }

    @Test
    public void carTimestampsIsImplementedTest() {
        assertNotNull(new Car(1, "GD 1234", "Toyota", 123, date.getTimeStamp(),
                date.getTimeStamp(), date.getTimeStamp()));
    }
}
