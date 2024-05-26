package CabBookingSystem.problemStatement.database;

import CabBookingSystem.problemStatement.exceptions.CabAlreadyExistsException;
import CabBookingSystem.problemStatement.exceptions.CabNotFoundExceptions;
import CabBookingSystem.problemStatement.models.Cab;
import CabBookingSystem.problemStatement.models.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabsManager {
    Map<String, Cab> cabs=new HashMap<>();

    public void createCab(final Cab newCab){
        if(cabs.containsKey(newCab.getId())){
            throw new CabAlreadyExistsException();
        }
        cabs.put(newCab.getId(),newCab);
    }

    public Cab getCab(final String cabId){
        if(!cabs.containsKey(cabId)){
            throw new CabNotFoundExceptions();
        }
        return cabs.get(cabId);
    }

    public void updateCabLocation(final String cabId,final Location newLocation){
        if(!cabs.containsKey(cabId)){
            throw new CabNotFoundExceptions();
        }
        cabs.get(cabId).setCurrentLocation(newLocation);
    }

    public void updateCabAvailability(final String cabId,final Boolean newAvailability){
        if(!cabs.containsKey(cabId)){
            throw new CabNotFoundExceptions();
        }
        cabs.get(cabId).setAvailable(newAvailability);
    }

    public List<Cab> getCabs(final Location fromPoint, final Double distance){
        List<Cab> result=new ArrayList<>();
        for(Cab cab:cabs.values()){
            if(cab.getAvailable() && cab.getCurrentLocation().distance(fromPoint)<=distance){
                result.add(cab);
            }
        }

        return result;
    }

}
