package services;

import domain.Car;
import domain.TimeStamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CarService {
    public ArrayList<Car> cars;
    private TimeStamp timeStamp = new TimeStamp();
    private boolean addToggle = true;
    private boolean readToggle = true;
    private boolean updateToggle = true;

    public CarService(){

    }

    public CarService(ArrayList<Car> cars) {
        this.cars = cars;
    }

    ArrayList<Car>readAll(){
        if(readToggle){
            for (Car car:cars){
                car.setReadTimestamps(timeStamp.getTimeStamp());
            }
        }
        return cars;
    }
    public ArrayList<Car> create(Car newCar){
        for(Car car:cars){
            if(newCar.getId()==car.getId())
                throw new IllegalArgumentException("There is car with this Id in database");
        }
        if (addToggle){
            newCar.setAddTimestamp(timeStamp.getTimeStamp());
        }
        cars.add(newCar);
        return cars;
    }

    public Car read(int id) {
        for(Car car:cars){
            if (car.getId()==id) {
                if(readToggle) {
                    car.setReadTimestamps(timeStamp.getTimeStamp());
                }
                return car;
            }
        }
        throw new NoSuchElementException("There is no such a car id in database");
    }

    public Car update(int id, Car car){
        if (car.getId()==id){
            cars.set(id, car);
            if(updateToggle) {
                car.setUpdateTimestamp(timeStamp.getTimeStamp());
            }
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

    ArrayList<LocalDateTime> getTimestamps(int id) {
        ArrayList<LocalDateTime> timeStampsList = new ArrayList<>();
        for (Car car:cars) {
            if (car.getId() == id) {
                timeStampsList.add(car.getAddTimestamp());
                timeStampsList.add(car.getReadTimestamps());
                timeStampsList.add(car.getUpdateTimestamp());
            }
        }
        return timeStampsList;
    }

    public void toggleAddTimestamp() {
        addToggle = false;
    }

    public void toggleReadTimestamp() {
        readToggle = false;
    }

    public void toggleUpdateTimestamp() {
        updateToggle = false;
    }

    public ArrayList<Car> searchCarByRegistrationExpression(String expression) {
        ArrayList<Car> searchedCars = new ArrayList<>();
        for(Car car:cars){
            if(car.getRegistration().regionMatches(true, 0, expression, 0, expression.length()))
            searchedCars.add(car);
        }
        return searchedCars;    }

    public ArrayList<Car> removeByOwnersList(ArrayList<Integer> list) {
        ArrayList<Car> removedCars = new ArrayList<>();
        for(Car car : cars){
            for(int id : list){
               if(car.getOwner_id()==id){
                    removedCars.add(car);
                }
            }
        }
        for(Car car : removedCars){
            cars.remove(car);
        }
        return removedCars;
    }
}
