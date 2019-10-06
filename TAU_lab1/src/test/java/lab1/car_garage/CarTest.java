package lab1.car_garage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CarTest {

    @Test
    public void carIsImplementedTest() {
        assertNotNull(new Car());
    }


}
