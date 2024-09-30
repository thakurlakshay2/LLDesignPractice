package ParkingLotSystem.ParkingLotSystem.Models;

import ParkingLotSystem.Models.ParkingSpotType;
import ParkingLotSystem.Models.Vehicle;

public class ParkingSpot {
    private final int number;
    private ParkingSpotType type;
    private Vehicle vehicle;
    private boolean isFree;

    public ParkingSpot(int number, ParkingSpotType type) {
        this.number = number;
        this.type = type;
        this.isFree=true;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public boolean isFree() {
        return isFree;
    }
    public    double getPricingPerHour(){
        switch (this.type){
            case Large -> {
                return 100;
            }
            case Compact -> {
                return 80;
            }
            case Electric -> {
                return 60;
            }
            case Handicapped -> {
                return 30;
            }
            default -> {
                return 40;
            }
        }
    }
}
