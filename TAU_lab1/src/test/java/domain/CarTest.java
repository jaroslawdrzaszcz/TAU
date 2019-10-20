package domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CarTest {

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
        assertNotNull(new Car(1, "GD 1234", "Toyota", 123, LocalDate.now(),LocalDate.now(), LocalDate.now()));
    }
}
