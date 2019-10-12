package repositories;

import domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class CarRepositoryTest {

    CarRepository cars = new CarRepository(new ArrayList<Car>());

    @Test
    public void emptyCarRepositoryIsImplementedTest() {
        assertNotNull(new CarRepositoryTest());
    }

    @Test
    public void carRepositoryIsImplementedTest() {
        assertNotNull(cars);
    }

    @Test
    public void createMethodInCarRepositoryIsImplementedTest(){
        assertNotNull(cars.create(new Car()));
    }

    @Test
    public void readMethodInCarRepositoryIsImplementedTest(){
        assertNotNull(cars.read(1));
    }
    @Test
    public void updateMethodInCarRepositoryIsImplementedTest(){
        assertNotNull(cars.update(new Car()));
    }
//    @Test
//    public void deleteMethodInCarRepositoryIsImplementedTest(){
//        assertNotNull(cars.delete(0));
//    }

}
