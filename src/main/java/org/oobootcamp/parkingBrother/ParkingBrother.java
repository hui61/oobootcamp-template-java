package org.oobootcamp.parkingBrother;


import org.oobootcamp.parkingLot.*;

import java.util.ArrayList;
import java.util.Optional;

public class ParkingBrother {
    private final ArrayList<ParkingLot> parkingLots =  new ArrayList<>();

    public ParkingLot getParkingLotByNumber(int i) {
        return parkingLots.get(i-1);
    }

    public Ticket park(Car car) {
        var optionalParkingLot = parkingLots.stream().filter((ParkingLot::hasCapacity)).findFirst();
        if (optionalParkingLot.isEmpty()) {
            throw new NoCapacityException();
        }
        return optionalParkingLot.get().park(car);
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public Car pick(Ticket ticket) {
        var optionalParkingLot = parkingLots.stream().filter((parkingLot -> parkingLot.hasParkedCar(ticket))).findFirst();
        if (optionalParkingLot.isEmpty()){
            throw new InvalidTicketException();
        }
        return optionalParkingLot.get().pick(ticket);
    }
}
