package cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.Car;
import services.CarService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UpdateCarData {
    private int cars_number = 10;
    private CarService testRepo = new CarService(new ArrayList<>());
    private ArrayList<Car> carsList = new ArrayList<>();
    private ArrayList<Car> searchedCars;
    private Car newCar = new Car(5, "NO 4567", "Toyota", 200);

    @Given("prepare cars list")
    public void prepare_cars_list() {
        for (int i = 0; i < cars_number; i++) {
            Car car = new Car(i, "GD 123" + Integer.toString(i), "Golf v" + Integer.toString(i), 100 + i);
            i++;
            Car car1 = new Car(i, "NO 123" + Integer.toString(i), "Mazda " + Integer.toString(i), 100 + i);
            carsList.add(car);
            carsList.add(car1);
        }
    }

    @When("add cars to database")
    public void add_cars_to_database() {
        for(Car car : carsList){
            testRepo.create(car);
        }
    }

    @When("car is registered in Olsztyn")
    public void car_is_registered_in_Olsztyn() {
        searchedCars = testRepo.searchCarByRegistrationExpression("NP");
    }

    @And("cars id is 5")
    public void cars_id_is_5() {
        for(Car car:searchedCars){
            if(car.getId()==5){
                Car car_to_update = car;
            }
        }
    }

    @Then("update data of this Car by new Car")
    public void update_data_of_this_Car_by_new_Car()
    {
        testRepo.toggleUpdateTimestamp();
        testRepo.update(5, newCar);
        assertEquals(newCar, testRepo.read(5));
    }

}

