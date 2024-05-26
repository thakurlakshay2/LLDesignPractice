package CabBookingSystem.problemStatement.strategy;

import CabBookingSystem.problemStatement.models.Cab;
import CabBookingSystem.problemStatement.models.Location;
import CabBookingSystem.problemStatement.models.Rider;

import java.util.List;
import java.util.Optional;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy{

    @Override
    public Optional<Cab> matchCabToRider(Rider rider, List<Cab> candidateCabs, Location pickup, Location dropOff) {
        return candidateCabs.stream().filter(cab->cab.getCurrentTrip()==null).findAny();
    }
}
