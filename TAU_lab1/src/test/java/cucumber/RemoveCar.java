package cucumber;

import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.Car;
import services.CarService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RemoveCar {

    private int cars_number = 12;
    private CarService testRepo = new CarService(new ArrayList<>());
    private ArrayList<Car> carsList = null;

    @Given("Create Cars list")
    public void create_cars_list() {
        for (int i = 0; i < cars_number; i++) {
            Car car = new Car(i, "GD 123" + Integer.toString(i), "Mada v" + Integer.toString(i), 100 + i);
            i++;
            Car car1 = new Car(i, "NO 123" + Integer.toString(i), "Golf " + Integer.toString(i), 100 + i);
            carsList.add(car1);
            carsList.add(car);
        }
    }

    @When("cars added to database")
    public void cars_added_to_database() {
            for(Car car : carsList){
                testRepo.create(car);
            }
        }

    @When("car is registered in Gdańsk")
    public void car_is_registered_in_Gdansk() {
    }

    @But("car name is not Mazda")
    public void car_name_is_not_Mazda() {
    }

    @Then("remove this car")
    public void remove_this_car()
    {
        assertEquals(testRepo.cars.size(), cars_number);
    }
}

