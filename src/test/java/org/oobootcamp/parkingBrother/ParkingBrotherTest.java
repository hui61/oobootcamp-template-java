package org.oobootcamp.parkingBrother;

import org.junit.jupiter.api.Test;
import org.oobootcamp.parkingLot.*;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBrotherTest {
    String carLicence = "陕A00001";

    @Test
    void should_return_ticket_and_first_parking_lot_parked_car_number_add_1_when_park_given_parking_brother_with_3_parking_lot_with_capacity_and_car() {
        var parkingBrother = new ParkingBrother();
        parkingBrother.addParkingLot(new ParkingLot(1));
        parkingBrother.addParkingLot(new ParkingLot(1));
        parkingBrother.addParkingLot(new ParkingLot(1));
        var car = new Car(carLicence);
        Ticket ticket = parkingBrother.park(car);
        assertNotNull(ticket);
        assertEquals(1, parkingBrother.getParkingLotByNumber(1).getParkedCarNumber());
    }

    @Test
    void should_return_ticket_and_last_parking_lot_parked_car_number_add_1_when_park_given_parking_brother_only_last_parking_lot_with_capacity_and_car() {
        var parkingBrother = new ParkingBrother();
        parkingBrother.addParkingLot(new ParkingLot(0));
        parkingBrother.addParkingLot(new ParkingLot(0));
        parkingBrother.addParkingLot(new ParkingLot(1));
        var car = new Car(carLicence);
        var ticket = parkingBrother.park(car);
        assertNotNull(ticket);
        assertEquals(1, parkingBrother.getParkingLotByNumber(3).getParkedCarNumber());
    }

    @Test
    void should_return_no_capacity_exception_when_park_given_parking_brother_with_no_capacity_and_car() {
        var parkingBrother = new ParkingBrother();
        parkingBrother.addParkingLot(new ParkingLot(0));
        parkingBrother.addParkingLot(new ParkingLot(0));
        parkingBrother.addParkingLot(new ParkingLot(0));
        var car = new Car(carLicence);
        assertThrows(NoCapacityException.class, () -> parkingBrother.park(car));
    }

    @Test
    void should_return_car_when_pick_given_parking_brother_with_three_parking_lot_with_one_car_and_valid_ticket() {
        var parkingBrother = new ParkingBrother();
        var parkingLot1 = new ParkingLot(1);
        var parkingLot2 = new ParkingLot(1);
        var parkingLot3 = new ParkingLot(1);
        var myCar = new Car(carLicence);
        var ticket = parkingLot2.park(myCar);
        parkingBrother.addParkingLot(parkingLot1);
        parkingBrother.addParkingLot(parkingLot2);
        parkingBrother.addParkingLot(parkingLot3);
        Car car = parkingBrother.pick(ticket);
        assertEquals(myCar, car);
    }

    @Test
    void should_return_invalid_ticket_exception_when_pick_given_parking_brother_with_three_parking_lot_with_one_car_and_invalid_ticket() {
        var parkingBrother = new ParkingBrother();
        var parkingLot1 = new ParkingLot(1);
        var parkingLot2 = new ParkingLot(1);
        var parkingLot3 = new ParkingLot(1);
        var myCar = new Car(carLicence);
        var ticket = parkingLot2.park(myCar);
        parkingBrother.addParkingLot(parkingLot1);
        parkingBrother.addParkingLot(parkingLot2);
        parkingBrother.addParkingLot(parkingLot3);
        assertThrows(InvalidTicketException.class, () -> parkingBrother.pick(new Ticket("fake carLicence")));
    }
}
