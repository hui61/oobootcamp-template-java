package org.oobootcamp.parkingLot;

public class Car {

    public String getCarLicence() {
        return carLicence;
    }

    private final String carLicence;

    public Car(String carLicence) {
        this.carLicence = carLicence;
    }
}
