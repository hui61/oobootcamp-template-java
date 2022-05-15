package org.oobootcamp.parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ParkingLotTest {
    private final String carLicence = "陕A00001";
    @Test
    void should_return_ticket_when_park_given_park_lot_with_capacity_and_a_car() throws Exception {

        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car(carLicence);
        Ticket ticket = parkingLot.park(car);
        assertNotNull(ticket);
    }

    @Test
    void should_return_no_capacity_exception_when_park_given_no_capacity_parking_lot_and_car() {
        ParkingLot parkingLot = new ParkingLot(0);
        var car = new Car(carLicence);
        assertThrows(NoCapacityException.class, () -> parkingLot.park(car));
    }

    @Test
    void should_return_duplicate_licence_plate_exception_when_park_given_parking_lot_with_capacity_and_duplicate_car_licence_car() throws Exception {
        var parkingLot = new ParkingLot(2);
        var car1 = new Car(carLicence);
        var car2 = new Car(carLicence);
        parkingLot.park(car1);
        assertThrows(DuplicateLicencePlateException.class, () -> parkingLot.park(car2));
    }

    @Test
    void should_return_car_when_pick_given_parking_lot_with_car_and_ticket() {
        var parkingLot = new ParkingLot(1);
        var car = new Car(carLicence);
        Ticket ticket = parkingLot.park(car);
        var actualCar = parkingLot.pick(ticket);
        assertEquals(car, actualCar);
    }

    @Test
    void should_return_car_when_pick_given_parking_lot_with_two_card_and_one_ticket() {
        var parkingLot = new ParkingLot(2);
        var car = new Car(carLicence);
        var myCarLicence = "陕A00002";
        var myCar = new Car(myCarLicence);
        parkingLot.park(car);
        var myTicket = parkingLot.park(myCar);
        var actualCar = parkingLot.pick(myTicket);
        assertEquals(myCar, actualCar);
    }

    @Test
    void should_return_invalid_ticket_exception_when_pick_given_parking_lot_with_car_and_one_invalid_ticket() {
        var parkingLot = new ParkingLot(1);
        var car = new Car(carLicence);
        parkingLot.park(car);
        assertThrows(InvalidTicketException.class, () -> parkingLot.pick(new Ticket("fake ticket")));
    }
}
