package services;

import domain.Car;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

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

        assertNotNull(testRepo.delete(testRepo.cars.get(0)));
    }

    @Test
    public void readAllMethodTest(){
        int cars_number = 11;
        for(int i = 0; i < cars_number; i++ ){
            Integer iString = new Integer(i);
            Car car = new Car(i, "GD 123" + iString.toString(), "Mada v" + iString.toString(), 100+i);
            testRepo.cars.add(car);
        }
        assertEquals(cars_number, testRepo.cars.size());
    }

    @Test
    public void createMethodTest(){
        int cars_number = 11;
        for(int i = 0; i < cars_number; i++ ){
            Integer iString = new Integer(i);
            testRepo.create(new Car(i, "GD 123" + iString.toString(), "Mada v" + iString.toString(), 100+i));
        }
        Car carToVerify = testRepo.read(5);
        assertEquals(cars_number, testRepo.cars.size());
        assertEquals(testRepo.cars.get(5), carToVerify);
    }

    @Test
    public void readMethodTest(){
        int cars_number = 11;
        for(int i = 0; i < cars_number; i++ ){
            Integer iString = new Integer(i);
            Car car = new Car(i, "GD 123" + iString.toString(), "Mada v" + iString.toString(), 100+i);
            testRepo.cars.add(car);
        }
        Car carToVerify = testRepo.read(5);
        assertEquals(testRepo.cars.get(5), carToVerify);
    }

    @Test
    public void updateMethodTest(){
        int cars_number = 11;
        for(int i = 0; i < cars_number; i++ ){
            Integer iString = new Integer(i);
            Car car = new Car(i, "GD 123" + iString.toString(), "Mada v" + iString.toString(), 100+i);
            testRepo.cars.add(car);
        }
        Car newCar = new Car(10, "Test", "Test", 100);
        testRepo.update(10, newCar);

        assertEquals(cars_number, testRepo.cars.size());
        assertEquals(testRepo.cars.get(10), newCar);
    }

    @Test
    public void deleteMethodTest(){
        int cars_number = 11;
        for(int i = 0; i < cars_number; i++ ){
            Integer iString = new Integer(i);
            Car car = new Car(i, "GD 123" + iString.toString(), "Mada v" + iString.toString(), 100+i);
            testRepo.cars.add(car);
        }
        testRepo.delete(testRepo.cars.get(1));
        testRepo.delete(testRepo.cars.get(5));

        assertEquals(cars_number - 2, testRepo.cars.size());
    }

    @Rule
    public final ExpectedException except = ExpectedException.none();

    @Test
    public void createMethodExceptionTest(){
        int cars_number = 11;
        for(int i = 0; i < cars_number; i++ ){
            Integer iString = new Integer(i);
            Car car = new Car(i, "GD 123" + iString.toString(), "Mada v" + iString.toString(), 100+i);
            testRepo.cars.add(car);
        }
        except.expect(IllegalArgumentException.class);
        except.expectMessage("There is car with this Id in database");

        assertNotNull(testRepo.create(new Car(2, "Test", "Test", 100)));
    }

    @Test
    public void readMethodExceptionTest(){
        int cars_number = 11;
        for(int i = 0; i < cars_number; i++ ){
            Integer iString = new Integer(i);
            Car car = new Car(i, "GD 123" + iString.toString(), "Mada v" + iString.toString(), 100+i);
            testRepo.cars.add(car);
        }
        except.expect(NoSuchElementException.class);
        except.expectMessage("There is no such a car id in database");

        assertNotNull(testRepo.read(100));
    }

    @Test
    public void updateMethodExceptionTest(){
        int cars_number = 11;
        for(int i = 0; i < cars_number; i++ ){
            Integer iString = new Integer(i);
            Car car = new Car(i, "GD 123" + iString.toString(), "Mada v" + iString.toString(), 100+i);
            testRepo.cars.add(car);
        }
        Car newCar = new Car(10, "Test", "Test", 100);

        except.expect(NoSuchElementException.class);
        except.expectMessage("There is no car with this Id in database");

        assertNotNull(testRepo.update(100, newCar));
    }

    @Test
    public void deleteMethodExceptionTest(){
        int cars_number = 11;
        for(int i = 0; i < cars_number; i++ ){
            Integer iString = new Integer(i);
            Car car = new Car(i, "GD 123" + iString.toString(), "Mada v" + iString.toString(), 100+i);
            testRepo.cars.add(car);
        }
        except.expect(NoSuchElementException.class);
        except.expectMessage("There is no such a car in database");

        Car newCar = new Car(100, "Test", "Test", 100);

        assertNotNull(testRepo.delete(newCar));
    }

}
