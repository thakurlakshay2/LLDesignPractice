package CabBookingSystem.problemStatement.controllers;

public class RidersController {
    private RidersManager ridersManager;
    private TripsManager tripsManager;

    public RidersController(RidersManager ridersManager, TripsManager tripsManager){
        this.ridersManager= ridersManager;
        this.tripsManager=tripsManager;
    }

    public ResponseEntity registerRider(final String riderId, final String riderName){
        ridersManager.createRider(new Rider(riderId,riderName));
        return responseEntity.ok("");
    }
}
