package LockerManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Locker {
    private final List<Slot> slots;
    private final String id;

    public Locker( String id) {
        this.slots = new ArrayList<>();
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void addSlot(final Slot newSlot){
        this.slots.add(newSlot);
    }

    public List<Slot> getAvailableSlot(){
        final List<Slot> result=new ArrayList<>();
        for(Slot slot:this.slots){
            if(slot.isAvailable()){
                result.add(slot);

            }
        }

        return result;
    }
}
