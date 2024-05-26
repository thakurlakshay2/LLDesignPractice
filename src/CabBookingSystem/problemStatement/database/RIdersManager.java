package CabBookingSystem.problemStatement.database;

import CabBookingSystem.problemStatement.exceptions.RiderNotFoundException;
import CabBookingSystem.problemStatement.exceptions.RidersAlreadyExistsException;
import CabBookingSystem.problemStatement.models.Rider;

import java.util.HashMap;
import java.util.Map;

public class RIdersManager {
    Map<String , Rider> riders=new HashMap<>();
    public void createRider(final Rider newRider){
        if(riders.containsKey(newRider.getId())){
            throw new RidersAlreadyExistsException();
        }
        riders.put(newRider.getId(), newRider);
    }

    public Rider getRider(final String riderId){
        if(!riders.containsKey(riderId)){
            throw new RiderNotFoundException();
        }
        return  riders.get(riderId);
    }
}
