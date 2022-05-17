package org.oobootcamp.smartParkingBoy;

import org.junit.jupiter.api.Test;
import org.oobootcamp.parkingLot.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {
    private final String carLicence = "陕A00001";

    @Test
    void should_return_ticket_and_park_car_into_first_parking_lot_when_park_car_given_parking_boy_has_two_parking_lot_and_fist_one_has_larger_capacity() {
        var firstParkingLot = new ParkingLot(2);
        var smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, new ParkingLot(1)));
        var car = new Car(carLicence);
        Ticket ticket = smartParkingBoy.park(car);
        assertNotNull(ticket);
        assertEquals(car, firstParkingLot.pick(ticket));
    }

    @Test
    void should_return_ticket_and_park_car_into_second_parking_lot_when_park_car_given_parking_boy_has_two_parking_lot_and_second_one_has_larger_capacity() {
        var secondParkingLot = new ParkingLot(2);
        var smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(1), secondParkingLot));
        var car = new Car(carLicence);
        var ticket = smartParkingBoy.park(car);
        assertNotNull(ticket);
        assertEquals(car, secondParkingLot.pick(ticket));
    }

    @Test
    void should_throw_no_capacity_exception_when_park_car_given_parking_boy_has_two_parking_lot_without_capacity() {
        var smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(0), new ParkingLot(0)));
        assertThrows(NoCapacityException.class, () -> smartParkingBoy.park(new Car(carLicence)));
    }

    @Test
    void should_return_car_when_pick_car_given_parking_boy_has_two_parking_lot_with_cars_and_valid_ticket() {
        var firstParkingLot = new ParkingLot(1);
        var secondParkingLot = new ParkingLot(1);
        var myCar = new Car(carLicence);
        var ticket = firstParkingLot.park(myCar);
        secondParkingLot.park(new Car("mock carLicence"));
        var smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        assertEquals(smartParkingBoy.pick(ticket), myCar);
    }

    @Test
    void should_throw_invalid_ticket_exception_when_pick_car_given_parking_boy_has_two_parking_lot_with_cars_and_invalid_ticket() {
        var firstParkingLot = new ParkingLot(1);
        var secondParkingLot = new ParkingLot(1);
        firstParkingLot.park(new Car(carLicence));
        secondParkingLot.park(new Car("mock carLicence"));
        var smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        assertThrows(InvalidTicketException.class, () -> smartParkingBoy.pick(new Ticket("invalid ticket")));
    }
}
