package org.oobootcamp.parkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;

    private final Map<String, Car> parkedCar = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if (parkedCar.size() >= capacity) {
            throw new NoCapacityException();
        }
        if (parkedCar.containsKey(car.getCarLicence())) {
            throw  new DuplicateLicencePlateException();
        }
        parkedCar.put(car.getCarLicence(), car);
        return new Ticket(car.getCarLicence());
    }

    public boolean hasCapacity() {
        return this.parkedCar.size() < capacity;
    }

    public Car pick(Ticket ticket) {
        if (!parkedCar.containsKey(ticket.getCarLicence())) {
            throw new InvalidTicketException();
        }
        return this.parkedCar.get(ticket.getCarLicence());
    }

    public int getParkedCarNumber() {
        return this.parkedCar.size();
    }

    public boolean hasParkedCar(Ticket ticket) {
        return parkedCar.containsKey(ticket.getCarLicence());
    }
}
