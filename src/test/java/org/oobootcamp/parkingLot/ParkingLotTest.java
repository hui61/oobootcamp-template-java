package org.oobootcamp.parkingLot;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParkingLotTest {
    @Test
    public void should_return_ticket_successful_when_parking_given_park_with_8_space() throws Exception {
        ParkingLot parkingLot = new ParkingLot(8);
        Car car = new Car(UUID.randomUUID().toString());
        Ticket ticket = parkingLot.park(car);
        assertThat(ticket).isNotNull();
    }
    @Test
    void should_return_exception_when_parking_given_no_capacity_parking_lot_and_car() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car(UUID.randomUUID().toString()));
        assertThatThrownBy(() -> parkingLot.park(new Car(UUID.randomUUID().toString()))).isInstanceOf(Exception.class);
    }
}
