package services;

import domain.Car;
import domain.TimeStamp;
import sun.font.DelegatingShape;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CarService {
    ArrayList<Car> cars;
    boolean addToggle = true;
    boolean readToggle = true;
    boolean updateToggle = true;

    public CarService(){

    }

    CarService(ArrayList<Car> cars) {
        this.cars = cars;
    }

    ArrayList<Car>readAll(){
        TimeStamp timeStamp = new TimeStamp();
        timeStamp.setTimeStamp(LocalDate.now());
        if(readToggle){
            for (Car car:cars){
                car.setReadTimestamps(timeStamp);
            }
        }
        return cars;
    }
    ArrayList<Car> create(Car newCar){
        for(Car car:cars){
            if(newCar.getId()==car.getId())
                throw new IllegalArgumentException("There is car with this Id in database");
        }
        TimeStamp timeStamp = new TimeStamp();
        timeStamp.setTimeStamp(LocalDate.now());
        if (addToggle){
            newCar.setAddTimestamp(timeStamp);
        }
        cars.add(newCar);
        return cars;
    }

    Car read(int id) {
        TimeStamp timeStamp = new TimeStamp();
        for(Car car:cars){
            if (car.getId()==id) {
                timeStamp.setTimeStamp(LocalDate.now());
                if(readToggle) {
                    car.setReadTimestamps(timeStamp);
                }
                return car;
            }
        }
        throw new NoSuchElementException("There is no such a car id in database");
    }

    Car update(int id, Car car){
        TimeStamp timeStamp = new TimeStamp();
        if (car.getId()==id){
            cars.set(id, car);
            timeStamp.setTimeStamp(LocalDate.now());
            if(updateToggle) {
                car.setUpdateTimestamp(timeStamp);
            }
            return car;
        }
        throw new NoSuchElementException("There is no car with this Id in database");
    }

    Car delete(Car car){
        if(cars.contains(car)){
            cars.remove(car);
            return car;
        }
        throw new NoSuchElementException("There is no such a car in database");
    }

    ArrayList<TimeStamp> getTimestamps(int id) {
        ArrayList<TimeStamp> timeStampsList = new ArrayList<>();
        for (Car car:cars) {
            if (car.getId() == id) {
                timeStampsList.add(car.getAddTimestamp());
                timeStampsList.add(car.getReadTimestamps());
                timeStampsList.add(car.getUpdateTimestamp());
            }
        }
        return timeStampsList;
    }

     void toggleAddTimestamp() {
        addToggle = false;
    }

    void toggleReadTimestamp() {
        readToggle = false;
    }

    void toggleUpdateTimestamp() {
        updateToggle = false;
    }
}
