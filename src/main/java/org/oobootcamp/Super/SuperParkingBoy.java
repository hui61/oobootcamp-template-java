package org.oobootcamp.Super;

import org.oobootcamp.ParkingBoy;
import org.oobootcamp.parkingLot.Car;
import org.oobootcamp.parkingLot.ParkingLot;
import org.oobootcamp.parkingLot.Ticket;

import java.util.List;

public class SuperParkingBoy extends ParkingBoy {

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) {
        return parkingLots.stream().reduce(ParkingLot::maxFreeAvailableRateParkingLot).get().park(car);
    }
}
