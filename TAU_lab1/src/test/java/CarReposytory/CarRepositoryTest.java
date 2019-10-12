package CarReposytory;

import CarRepository.CarRepository;
import Domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;
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
        assertNotNull(cars.create());
    }

    @Test
    public void readMethodInCarRepositoryIsImplementedTest(){
        assertNotNull(cars.read());
    }
    @Test
    public void updateMethodInCarRepositoryIsImplementedTest(){
        assertNotNull(cars.update());
    }
    @Test
    public void deleteMethodInCarRepositoryIsImplementedTest(){
        assertNotNull(cars.delete());
    }

}
