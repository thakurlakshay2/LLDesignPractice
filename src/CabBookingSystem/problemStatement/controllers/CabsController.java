package CabBookingSystem.problemStatement.controllers;

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
}
