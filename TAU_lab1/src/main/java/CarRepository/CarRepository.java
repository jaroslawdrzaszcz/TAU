package CarRepository;

import Domain.Car;

import java.util.ArrayList;

public class CarRepository {
    private ArrayList<Car> cars;

    public  CarRepository(){

    }

    public CarRepository(ArrayList<Car> cars) {
        this.cars = cars;
        Car car1 = new Car(1, "GD 123", "Toyota", 123);
        cars.add(car1);
    }

    public Car create(){
        return new Car();
    }

    public Car read(){
        return new Car();
    }

    public Car update(){
        return new Car();
    }

    public Car delete(){
        return new Car();
    }
}
