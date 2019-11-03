package cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.Car;
import services.CarService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class NewCar {

    private Car car;
    private CarService repo = new CarService(new ArrayList<>());

    @Given("Create New Car")
    public void create_car() {
        car = new Car(1, "GD 123", "Mazda", 123);
    }

    @When("When Car has been created")
    public void car_created() {
        repo.create(car);

    }

    @Then("Then Car has been add to database")
    public void car_added() {
        assertEquals(car, repo.read(1));
    }
}