package org.oobootcamp.manager;

import org.oobootcamp.ParkingBoy;
import org.oobootcamp.parkingLot.*;

import java.util.List;

public class ParkingManager {

    private final List<ParkingBoy> parkingBoys;
    private final List<ParkingLot> parkingLots;

    public ParkingManager(List<ParkingBoy> parkingBoys, List<ParkingLot> parkingLots) {
        this.parkingBoys = parkingBoys;
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        if (parkingBoys.stream().anyMatch(ParkingBoy::hasCapacity)) {
            return parkingBoys.stream().filter(ParkingBoy::hasCapacity).findFirst().get().park(car);
        }

        return this.parkingLots.stream()
                .filter(ParkingLot::hasCapacity)
                .findFirst()
                .orElseThrow(NoCapacityException::new)
                .park(car);
    }

    public Car pick(Ticket ticket) {
        if (parkingBoys.stream().anyMatch(parkingBoy -> parkingBoy.hasParkedCar(ticket))) {
            return parkingBoys.stream().filter(parkingBoy -> parkingBoy.hasParkedCar(ticket)).findFirst().get().pick(ticket);
        }

        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.hasParkedCar(ticket))
                .findFirst()
                .orElseThrow(InvalidTicketException::new)
                .pick(ticket);
    }
}
