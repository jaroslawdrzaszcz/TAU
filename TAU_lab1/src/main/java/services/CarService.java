package services;

import domain.Car;
import domain.TimeStamp;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CarService {
    ArrayList<Car> cars;

    public CarService(){

    }

    public CarService(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car>readAll(){
        return cars;
    }
    public ArrayList<Car> create(Car newCar){
        for(Car car:cars){
            if(newCar.getId()==car.getId())
                throw new IllegalArgumentException("There is car with this Id in database");
        }
        TimeStamp timeStamp = new TimeStamp();
        timeStamp.setTimeStamp(LocalDate.now());
        newCar.setAddTimestamp(timeStamp);
        cars.add(newCar);
        return cars;
    }

    public Car read(int id) {
        TimeStamp timeStamp = new TimeStamp();
        for(Car car:cars){
            if (car.getId()==id)
                timeStamp.setTimeStamp(LocalDate.now());
                car.setReadTimestamps(timeStamp);
                return car;
            }
        throw new NoSuchElementException("There is no such a car id in database");
    }

    public Car update(int id, Car car){
        if (car.getId()==id){
            cars.set(id, car);
            return car;
        }
        throw new NoSuchElementException("There is no car with this Id in database");
    }

    public Car delete(Car car){
        if(cars.contains(car)){
            cars.remove(car);
            return car;
        }
        throw new NoSuchElementException("There is no such a car in database");
    }
}
