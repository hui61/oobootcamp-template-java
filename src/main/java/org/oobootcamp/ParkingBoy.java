package org.oobootcamp;

import org.oobootcamp.parkingLot.Car;
import org.oobootcamp.parkingLot.InvalidTicketException;
import org.oobootcamp.parkingLot.ParkingLot;
import org.oobootcamp.parkingLot.Ticket;

import java.util.List;

public abstract class ParkingBoy {

    protected final List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Car pick(Ticket ticket) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.hasParkedCar(ticket))
                .findFirst()
                .orElseThrow(InvalidTicketException::new)
                .pick(ticket);
    }

    public boolean hasCapacity() {
        return this.parkingLots.stream().anyMatch(ParkingLot::hasCapacity);
    }

    public boolean hasParkedCar(Ticket ticket) {
        return this.parkingLots.stream().anyMatch(parkingLot -> parkingLot.hasParkedCar(ticket));
    }

    public abstract Ticket park(Car car);
}
