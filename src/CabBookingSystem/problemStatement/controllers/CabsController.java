package CabBookingSystem.problemStatement.controllers;

import CabBookingSystem.problemStatement.database.CabsManager;
import CabBookingSystem.problemStatement.database.TripsManager;
import CabBookingSystem.problemStatement.models.Cab;
import CabBookingSystem.problemStatement.models.Location;
import org.springframework.http.ResponseEntity;

public class CabsController {
    private CabsManager cabsManager;
    private TripsManager tripsManager;

    public CabsController(CabsManager cabsManager, TripsManager tripsManager){
        this.cabsManager=cabsManager;
        this.tripsManager=tripsManager;
    }

    public ResponseEntity registerCab(final String cabId, final String driverName){
        cabsManager.createCab(new Cab(cabId,driverName));

        return ResponseEntiry.ok("");
    }
    public ResponseEntity updateCabLocation(final String cabId,final Double newX,final Double newY){
        cabsManager.updateCabLocation(cabId , new Location(newX,newY));
        return ResponseEntity.ok("");
    }

    public ResponseEntity updateCabAvailability(final String cabId,final Boolean newAvailability ){
        cabsManager.updateCabAvailability(cabId , newAvailability );
        return ResponseEntity.ok("");
    }
    public ResponseEntity endTrip(final String cabId){
        tripsManager.endTrip(cabsManager.getCab(cabId) );
        return ResponseEntity.ok("");
    }
}
