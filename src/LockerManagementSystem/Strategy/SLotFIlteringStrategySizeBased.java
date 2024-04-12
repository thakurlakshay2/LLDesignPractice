package LockerManagementSystem.Strategy;

import LockerManagementSystem.model.LockerItem;
import LockerManagementSystem.model.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class SLotFIlteringStrategySizeBased implements  ISlotFIlteringStrategy {

    @Override
    public List<Slot> filterSlots(final List<Slot> slots, final LockerItem lockerItem){
        return slots.stream().filter(slot-> slot.getSize().canAccomodate(lockerItem.getSize())).collect(Collectors.toList());
    }
}
