package ParkingLotSystem.ParkingLotSystem.Models;

import ParkingLotSystem.Models.ParkingTicket;
import ParkingLotSystem.Models.VehicleType;

public class Vehicle {
    private final String licenceNo;
    private final VehicleType type;
    private ParkingTicket parkingTicket;

    public Vehicle(String licenceNo, VehicleType type,ParkingTicket parkingTicket) {
        this.licenceNo = licenceNo;
        this.type = type;
        this.parkingTicket=parkingTicket;
    }
}
