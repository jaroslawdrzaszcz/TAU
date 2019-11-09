package services;

import domain.Car;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CucumberLabTest {

    private CarService testRepo = new CarService(new ArrayList<Car>());
    private int cars_number = 6;

    @Before
    public void setTestRepo(){
        for(int i = 0; i < cars_number; i++ ) {
            Car car = new Car(i, "GD 123" + Integer.toString(i), "Mada v" + Integer.toString(i), 100 + i);
            Car car1 = new Car(i, "NO 123" + Integer.toString(i), "Golf " + Integer.toString(i), 110 + i);
            testRepo.toggleAddTimestamp();
            testRepo.cars.add(car1);
            testRepo.cars.add(car);
        }
    }

    @Test
    public void emptyCarRepositoryIsImplementedTest() {
        assertNotNull(new CarServiceTest());
    }

    @Test
    public void searchByRegularRegistrationExpressionMethodIsImplementedTest(){
        assertNotNull(testRepo.searchCarByRegistrationExpression("GD"));
    }

    @Test
    public void searchByRegularRegistrationExpressionMethodInCarRepositoryTest(){
        ArrayList<Car> searchedCars = testRepo.searchCarByRegistrationExpression("NO");
        assertEquals(cars_number, searchedCars.size());

    }

}
