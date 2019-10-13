package services;

import domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class CarServiceTest {

    CarService cars = new CarService(new ArrayList<Car>());

    @Test
    public void emptyCarRepositoryIsImplementedTest() {
        assertNotNull(new CarServiceTest());
    }

    @Test
    public void carRepositoryIsImplementedTest() {
        assertNotNull(cars);
    }

    @Test
    public void createMethodInCarRepositoryIsImplementedTest(){
        assertNotNull(cars.create(new Car(1, "Test", "Test", 1)));
    }

    @Test
    public void readMethodInCarRepositoryIsImplementedTest(){
        assertNotNull(cars.read(0));
    }
    @Test
    public void updateMethodInCarRepositoryIsImplementedTest(){
        assertNotNull(cars.update(1, new Car()));
    }
//    @Test
//    public void deleteMethodInCarRepositoryIsImplementedTest(){
//        assertNotNull(cars.delete(0));
//    }

}
