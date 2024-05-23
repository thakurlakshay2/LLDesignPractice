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



    public ResponseEntity book(
        final String riderId,
        final Double sourceX,
        final Double sourceY,
        final Double destX,
        final Double destY){
        tripsManager.createTrip(ridersManager.getRider(riderId),new Location(sourceX,sourceY),new Location(destX,destY));
        return ResponseEntity.ok("");
    }

    public ResponseEntity fetchHistory(final String riderId){
        List<Trips> trips=tripsManager.tripHistory(ridersManager.getRider(riderId));
        return ResponseEntity.ok("");
    }
}
