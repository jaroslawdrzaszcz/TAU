package services;

import domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class CarServiceTest {

    private CarService testRepo = new CarService(new ArrayList<Car>());

    @Test
    public void emptyCarRepositoryIsImplementedTest() {
        assertNotNull(new CarServiceTest());
    }

    @Test
    public void carRepositoryIsImplementedTest() {
        assertNotNull(testRepo);
    }

    @Test
    public void createMethodInCarRepositoryIsImplementedTest(){
        assertNotNull(testRepo.create(new Car(1, "Test", "Test", 1)));
    }

    @Test
    public void readMethodInCarRepositoryIsImplementedTest(){
        Car car1 = new Car(0, "GD 123", "Toyota", 123);
        testRepo.cars.add(car1);

        assertNotNull(testRepo.read(0));
    }
    @Test
    public void updateMethodInCarRepositoryIsImplementedTest(){
        Car car1 = new Car(0, "GD 123", "Toyota", 123);
        testRepo.cars.add(car1);

        assertNotNull(testRepo.update(0, new Car()));
    }
    @Test
    public void deleteMethodInCarRepositoryIsImplementedTest(){
        Car car1 = new Car(0, "GD 123", "Toyota", 123);
        testRepo.cars.add(car1);

        assertNotNull(testRepo.delete(0));
    }

}
