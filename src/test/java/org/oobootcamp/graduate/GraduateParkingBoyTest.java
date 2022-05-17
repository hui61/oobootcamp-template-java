package org.oobootcamp.graduate;

import org.junit.jupiter.api.Test;
import org.oobootcamp.parkingLot.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GraduateParkingBoyTest {
    String carLicence = "陕A00001";

    @Test
    void should_return_ticket_and_park_car_into_first_parking_lot_when_park_given_parking_brother_with_3_parking_lot_with_capacity_and_car() {
        var firstParkingLot = new ParkingLot(1);
        var parkingBoy = new GraduateParkingBoy(Arrays.asList(firstParkingLot, new ParkingLot(1)));

        var car = new Car(carLicence);
        Ticket ticket = parkingBoy.park(car);
        assertNotNull(ticket);
        assertEquals(car, firstParkingLot.pick(ticket));
    }

    @Test
    void should_return_ticket_and_park_car_into_last_parking_lot_when_park_given_parking_brother_only_last_parking_lot_with_capacity_and_car() {
        var secondParkingLot = new ParkingLot(1);
        var parkingBoy = new GraduateParkingBoy(Arrays.asList(new ParkingLot(0), secondParkingLot));
        var car = new Car(carLicence);
        var ticket = parkingBoy.park(car);
        assertNotNull(ticket);
        assertEquals(car, secondParkingLot.pick(ticket));
    }

    @Test
    void should_return_no_capacity_exception_when_park_given_parking_brother_with_no_capacity_and_car() {
        var parkingBoy = new GraduateParkingBoy(Arrays.asList(new ParkingLot(0), new ParkingLot(0)));
        var car = new Car(carLicence);
        assertThrows(NoCapacityException.class, () -> parkingBoy.park(car));
    }

    @Test
    void should_return_car_when_pick_given_parking_brother_with_two_parking_lot_with_one_car_and_valid_ticket() {
        var parkingLot2 = new ParkingLot(1);
        var parkingBoy = new GraduateParkingBoy(Arrays.asList(new ParkingLot(1), parkingLot2));
        var myCar = new Car(carLicence);
        var ticket = parkingLot2.park(myCar);
        Car car = parkingBoy.pick(ticket);
        assertEquals(myCar, car);
    }

    @Test
    void should_return_invalid_ticket_exception_when_pick_given_parking_brother_with_two_parking_lot_with_one_car_and_invalid_ticket() {
        var parkingLot2 = new ParkingLot(1);
        var parkingBoy = new GraduateParkingBoy(Arrays.asList(new ParkingLot(1),parkingLot2));
        var myCar = new Car(carLicence);
         parkingLot2.park(myCar);
        assertThrows(InvalidTicketException.class, () -> parkingBoy.pick(new Ticket("fake carLicence")));
    }
}
