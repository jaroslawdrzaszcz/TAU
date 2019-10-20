package domain;

import java.time.LocalDate;
import java.util.Date;

public class Car {
    private int id;
    private String registration;
    private String brand;
    private int owner_id;
    private LocalDate addTimestamp;
    private LocalDate updateTimestamp;
    private LocalDate readTimestamps;

    public Car(){
    }

    public Car(int id, String registration, String brand, int owner_id) {
        this.id = id;
        this.registration = registration;
        this.brand = brand;
        this.owner_id = owner_id;
    }

    public Car(int id, String registration, String brand, int owner_id, LocalDate addTimestamp, LocalDate updateTimestamp, LocalDate readTimestamps) {
        this.id = id;
        this.registration = registration;
        this.brand = brand;
        this.owner_id = owner_id;
        this.addTimestamp = addTimestamp;
        this.updateTimestamp = updateTimestamp;
        this.readTimestamps = readTimestamps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public LocalDate getAddTimestamp() {
        return addTimestamp;
    }

    public void setAddTimestamp(LocalDate addTimestamp) {
        this.addTimestamp = addTimestamp;
    }

    public LocalDate getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(LocalDate updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public LocalDate getReadTimestamps() {
        return readTimestamps;
    }

    public void setReadTimestamps(LocalDate readTimestamps) {
        this.readTimestamps = readTimestamps;
    }
}
