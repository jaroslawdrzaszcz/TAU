package services;

import domain.Car;

import java.util.ArrayList;

public class CarServiceImpl {

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<Car>();

        CarService carsRepo = new CarService(cars);

        for(int i = 1; i < 11; i++ ){
            Integer iString = new Integer(i);
            Car car = new Car(i, "GD 123" + iString.toString(), "Mada v" + iString.toString(), 100+i);
            carsRepo.create(car);
        }

        carsRepo.delete(5);
        carsRepo.update(8, new Car(8, "Test", "Test", 156));

        for (Car car:carsRepo.readAll()){
            System.out.println("Car id:" + car.getId()
                    + ", brand:" + car.getBrand()
                    + ", registration:" + car.getRegistration()
                    + ", Owner Id:" + car.getOwner_id());
        }
    }
}
