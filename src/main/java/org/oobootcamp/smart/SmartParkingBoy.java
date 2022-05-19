package org.oobootcamp.smart;

import org.oobootcamp.ParkingBoy;
import org.oobootcamp.parkingLot.Car;
import org.oobootcamp.parkingLot.ParkingLot;
import org.oobootcamp.parkingLot.Ticket;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) {
        return parkingLots.stream().reduce(ParkingLot::maxFreeAvailableParkingLot).get().park(car);
    }
}
