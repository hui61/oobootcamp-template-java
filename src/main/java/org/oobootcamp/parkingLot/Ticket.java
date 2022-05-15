package org.oobootcamp.parkingLot;

public class Ticket {
    public String getCarLicence() {
        return carLicence;
    }

    private final String carLicence;

    public Ticket(String carLicence) {
        this.carLicence = carLicence;
    }
}
