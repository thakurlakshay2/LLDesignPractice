package CabBookingSystem.problemStatement.database;

import CabBookingSystem.problemStatement.exceptions.NoCabsAvailableException;
import CabBookingSystem.problemStatement.exceptions.TripNotFoundException;
import CabBookingSystem.problemStatement.models.Cab;
import CabBookingSystem.problemStatement.models.Location;
import CabBookingSystem.problemStatement.models.Rider;
import CabBookingSystem.problemStatement.models.Trip;
import CabBookingSystem.problemStatement.strategy.CabMatchingStrategy;
import CabBookingSystem.problemStatement.strategy.PricingStrategy;

import java.util.*;

public class TripsManager {
    public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE=10.0;
    private Map<String, List<Trip>> trips=new HashMap<>();

    private CabsManager cabsManager;
    private RIdersManager rIdersManager;
    private CabMatchingStrategy cabMatchingStrategy;
    private PricingStrategy pricingStrategy;

    public TripsManager(CabsManager cabsManager, RIdersManager rIdersManager, CabMatchingStrategy cabMatchingStrategy, PricingStrategy pricingStrategy) {
        this.cabsManager = cabsManager;
        this.rIdersManager = rIdersManager;
        this.cabMatchingStrategy = cabMatchingStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    public void createTrip(final Rider rider, final Location pickup,final Location dropoff){
        final List<Cab> closeByCabs=cabsManager.getCabs(pickup,MAX_ALLOWED_TRIP_MATCHING_DISTANCE);

        final Optional<Cab> selectedCabOpt=cabMatchingStrategy.matchCabToRider(rider,closeByCabs,pickup,dropoff);

        if(!selectedCabOpt.isPresent()){
            throw new NoCabsAvailableException();
        }
        final Cab selectedCab=selectedCabOpt.get();
        final Double price=pricingStrategy.findPrice(pickup,dropoff);
        final Trip newTrip=new Trip(rider,selectedCab,price,pickup,dropoff);
        if(!trips.containsKey(rider.getId())){
            trips.put(rider.getId(),new ArrayList<>());
        }
        trips.get(rider.getId()).add(newTrip);
        selectedCab.setCurrentTrip(newTrip);

    }

    public List<Trip> tripHistory(final Rider rider){
        return trips.get(rider.getId());
    }

    public void endTrip(final Cab cab){
        if(cab.getCurrentTrip()==null){
            throw new TripNotFoundException();
        }
        cab.getCurrentTrip().finishedTripStatus();
        cab.setCurrentTrip(null);
    }
}
