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
    public void create_new_car() {
        car = new Car(1, "GD 123", "Mazda", 123);
    }

    @When("Car has been created")
    public void car_has_been_created() {
        repo.toggleAddTimestamp();
        repo.create(car);
    }

    @Then("Car has been add to database")
    public void car_has_been_add_to_database()
    {
        repo.toggleReadTimestamp();
        assertEquals(car, repo.read(1));
    }
}

