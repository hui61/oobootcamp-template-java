package org.oobootcamp.graduate;


import org.oobootcamp.ParkingBoy;
import org.oobootcamp.parkingLot.*;

import java.util.List;

public class GraduateParkingBoy extends ParkingBoy {


    public GraduateParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        return parkingLots.stream()
                .filter(ParkingLot::hasCapacity)
                .findFirst()
                .orElseThrow(NoCapacityException::new)
                .park(car);
    }
}
