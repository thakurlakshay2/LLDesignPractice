package LockerManagementSystem.repository;

import LockerManagementSystem.Exceptions.LockerAlreadyExistsException;
import LockerManagementSystem.model.Locker;
import LockerManagementSystem.model.Size;
import LockerManagementSystem.model.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LockerRepositoryInMemory  implements  ISlotOtpRepository {
    private final List<Locker> allLockers;

    public LockerRepositoryInMemory() {
        this.allLockers = new ArrayList<>();
    }
    public Locker getLocker(final String id){
        for(Locker locker:allLockers){
            if(locker.getId().equals(id)){
                return locker;
            }
        }
        return null;
    }

    public Locker createLocker(final String id){
        if(getLocker(id) !=null){
            throw new LockerAlreadyExistsException();
        }
        final Locker newLocker=new Locker(id);
        return newLocker;
    }

    public Slot createSlot(final Locker locker,final  Size slotSize){
        Slot newSlot=new Slot(UUID.randomUUID().toString(),slotSize,locker);
        locker.addSlot(newSlot);

        return newSlot;
    }

    public void deallocateSlot(final Slot slot){
        slot.deallocateSLot();
    }
    public List<Slot> getAllAvailableSlots(){
        final List<Slot> result=new ArrayList<>();
        for(Locker locker:allLockers){
            result.addAll(locker.getAvailableSlot());
        }

        return result;
    }
}
