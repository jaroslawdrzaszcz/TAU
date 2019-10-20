package services;

import domain.Car;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class CarServiceTest {

    private CarService testRepo = new CarService(new ArrayList<Car>());
    private int cars_number = 11;

    @Before
    public void setTestRepo(){
        for(int i = 0; i < cars_number; i++ ) {
            Car car = new Car(i, "GD 123" + Integer.toString(i), "Mada v" + Integer.toString(i), 100 + i);
            testRepo.cars.add(car);
        }
    }

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
        assertNotNull(testRepo.create(new Car(11, "Test", "Test", 1)));
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

        assertNotNull(testRepo.delete(testRepo.cars.get(0)));
    }

    @Test
    public void readAllMethodTest(){
        assertEquals(cars_number, testRepo.cars.size());
    }

    @Test
    public void createMethodTest(){
        Car carToVerify = testRepo.read(5);
        assertEquals(cars_number, testRepo.cars.size());
        assertEquals(testRepo.cars.get(5), carToVerify);
    }

    @Test
    public void readMethodTest(){
        Car carToVerify = testRepo.read(5);
        assertEquals(testRepo.cars.get(5), carToVerify);
    }

    @Test
    public void updateMethodTest(){
        Car newCar = new Car(10, "Test", "Test", 100);
        testRepo.update(10, newCar);

        assertEquals(cars_number, testRepo.cars.size());
        assertEquals(testRepo.cars.get(10), newCar);
    }

    @Test
    public void deleteMethodTest(){
        testRepo.delete(testRepo.cars.get(1));
        testRepo.delete(testRepo.cars.get(5));

        assertEquals(cars_number - 2, testRepo.cars.size());
    }

    @Rule
    public final ExpectedException except = ExpectedException.none();

    @Test
    public void createMethodExceptionTest(){
        except.expect(IllegalArgumentException.class);
        except.expectMessage("There is car with this Id in database");

        assertNotNull(testRepo.create(new Car(2, "Test", "Test", 100)));
    }

    @Test
    public void readMethodExceptionTest(){
        except.expect(NoSuchElementException.class);
        except.expectMessage("There is no such a car id in database");

        assertNotNull(testRepo.read(100));
    }

    @Test
    public void updateMethodExceptionTest(){
        Car newCar = new Car(10, "Test", "Test", 100);

        except.expect(NoSuchElementException.class);
        except.expectMessage("There is no car with this Id in database");

        assertNotNull(testRepo.update(100, newCar));
    }

    @Test
    public void deleteMethodExceptionTest(){
        except.expect(NoSuchElementException.class);
        except.expectMessage("There is no such a car in database");

        Car newCar = new Car(100, "Test", "Test", 100);

        assertNotNull(testRepo.delete(newCar));
    }

}
