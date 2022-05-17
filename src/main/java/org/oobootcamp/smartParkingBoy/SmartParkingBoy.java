package org.oobootcamp.smartParkingBoy;

import org.oobootcamp.parkingLot.Car;
import org.oobootcamp.parkingLot.InvalidTicketException;
import org.oobootcamp.parkingLot.ParkingLot;
import org.oobootcamp.parkingLot.Ticket;

import java.util.List;

public class SmartParkingBoy {
    private final List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        return parkingLots.stream().reduce(ParkingLot::compare).get().park(car);
    }

    public Car pick(Ticket ticket) {
        var optionalParkingLot = parkingLots.stream().filter((parkingLot -> parkingLot.hasParkedCar(ticket))).findFirst();
        if (optionalParkingLot.isEmpty()) {
            throw new InvalidTicketException();
        }
        return optionalParkingLot.get().pick(ticket);
    }
}
