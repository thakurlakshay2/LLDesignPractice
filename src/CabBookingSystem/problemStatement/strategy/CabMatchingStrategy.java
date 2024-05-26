package CabBookingSystem.problemStatement.strategy;

import CabBookingSystem.problemStatement.models.Cab;
import CabBookingSystem.problemStatement.models.Location;
import CabBookingSystem.problemStatement.models.Rider;

import java.util.List;
import java.util.Optional;

public interface CabMatchingStrategy {

    Optional<Cab> matchCabToRider(Rider rider, List<Cab> candidateCabs, Location pickup, Location dropOff);
}
