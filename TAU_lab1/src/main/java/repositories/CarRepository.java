package repositories;

import domain.Car;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CarRepository {
    private ArrayList<Car> cars;

    public  CarRepository(){

    }

    public CarRepository(ArrayList<Car> cars) {
        this.cars = cars;
        Car car1 = new Car(0, "GD 123", "Toyota", 123);
        cars.add(car1);
    }

    public ArrayList<Car>readAll(){
        return cars;
    }
    public Car create(Car newCar){
        for(Car car:cars){
            if(newCar.getId()==car.getId())
                throw new IllegalArgumentException("There is car with this Id in database");
        }
        cars.add(newCar);
        return newCar;
    }

    public Car read(int id) {
        for(Car car:cars){
            if (car.getId()==id)
                return car;
            }
        throw new NoSuchElementException("There is no such a car id in database");
    }

    public Car update(Car updatedCar){
        for(Car car:cars){
            if (car.getId()==updatedCar.getId()){
                car.setRegistration(updatedCar.getRegistration());
                car.setBrand(updatedCar.getBrand());
                car.setOwner_id(car.getOwner_id());
            }
            return car;
        }
        throw new NoSuchElementException("There is car with this Id in database");
    }

    public Car delete(int id){
        for (Car car:cars){
            if (car.getId()==id)
                cars.remove(car);
            return null;
        }
        throw new NoSuchElementException("There is no such a car in database");
    }
}
