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
    private int id_to_update = 0;
    private String actualResponse = "";

    @Given("prepare cars list")
    public void prepare_cars_list() {
        for (int i = 1; i <= cars_number; i++) {
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
        searchedCars = testRepo.searchCarByRegistrationExpression("NO");
    }

    @And("cars id is {string}")
    public void cars_id_is(String index) {
        int id = Integer.parseInt(index);
        for(Car car:searchedCars){
            if(car.getId()==id){
                 actualResponse = "Updated";
                 id_to_update = id;
                 break;
            }
            actualResponse = "NotUpdates";
        }
    }

    @Then("update data of this Car by new Car {string}")
    public void update_data_of_this_Car_by_new_Car(String expectedResponse)
    {
        assertEquals(expectedResponse, actualResponse);
        Car newCar = new Car(id_to_update, "NO 4567", "Toyota", 200);
        if(actualResponse.equals("Updated")){
            testRepo.toggleUpdateTimestamp();
            testRepo.update(id_to_update, newCar);
            assertEquals(newCar, testRepo.cars.get(id_to_update));
        }
    }

}

