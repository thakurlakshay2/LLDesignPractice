package LockerManagementSystem.services;

import LockerManagementSystem.Exceptions.NoSlotAvailableException;
import LockerManagementSystem.Strategy.ISlotAssignmentStrategy;
import LockerManagementSystem.Strategy.ISlotFIlteringStrategy;
import LockerManagementSystem.model.Locker;
import LockerManagementSystem.model.LockerItem;
import LockerManagementSystem.model.Size;
import LockerManagementSystem.model.Slot;
import LockerManagementSystem.repository.LockerRepositoryInMemory;

import java.util.List;
import java.util.UUID;

public class LockerService {
    private final LockerRepositoryInMemory lockerRepository;
    private final ISlotFIlteringStrategy slotFilterStratergy;

    private final ISlotAssignmentStrategy assignmentStrategy;

    public LockerService(LockerRepositoryInMemory lockerRepository, ISlotFIlteringStrategy slotFilterStratergy, ISlotAssignmentStrategy assignmentStrategy) {
        this.lockerRepository = lockerRepository;
        this.slotFilterStratergy = slotFilterStratergy;
        this.assignmentStrategy = assignmentStrategy;
    }


    public Slot allocateSlot(final LockerItem lockerItem){
        final List<Slot> allAvailabelSlot=lockerRepository.getAllAvailableSlots();
        final List<Slot> filteredSlot=slotFilterStratergy.filterSlots(allAvailabelSlot,lockerItem);
        final Slot slotToBeAllocated=assignmentStrategy.pickSlot(filteredSlot);

        if(slotToBeAllocated==null)
        {
        throw new NoSlotAvailableException();}

        slotToBeAllocated.allocatePackage(lockerItem);
        return slotToBeAllocated;
    }
    public Locker createLocker(final String lockerId){
        Locker newLocker=new Locker(lockerId);
        return newLocker;
    }
    public Slot createSlot(final Locker locker, final Size slotSize){
        Slot newSlot=new Slot(UUID.randomUUID().toString(),slotSize,locker);
        locker.addSlot(newSlot);
        return newSlot;
    }

    public List<Slot> getAllAvailableSlots(){
        return lockerRepository.getAllAvailableSlots();
    }

    public void deallocateSlot(final Slot slot){
        lockerRepository.deallocateSlot(slot);
    }
}
