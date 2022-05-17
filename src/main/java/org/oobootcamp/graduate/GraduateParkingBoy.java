package org.oobootcamp.graduate;


import org.oobootcamp.parkingLot.*;

import java.util.List;

public class GraduateParkingBoy {
    private final List<ParkingLot> parkingLots;

    public GraduateParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        var optionalParkingLot = parkingLots.stream().filter((ParkingLot::hasCapacity)).findFirst();
        if (optionalParkingLot.isEmpty()) {
            throw new NoCapacityException();
        }
        return optionalParkingLot.get().park(car);
    }

    public Car pick(Ticket ticket) {
        var optionalParkingLot = parkingLots.stream().filter((parkingLot -> parkingLot.hasParkedCar(ticket))).findFirst();
        if (optionalParkingLot.isEmpty()) {
            throw new InvalidTicketException();
        }
        return optionalParkingLot.get().pick(ticket);
    }
}
