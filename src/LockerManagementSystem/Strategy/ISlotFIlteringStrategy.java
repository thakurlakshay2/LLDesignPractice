package LockerManagementSystem.Strategy;

import LockerManagementSystem.model.LockerItem;
import LockerManagementSystem.model.Slot;

import java.util.List;

public interface ISlotFIlteringStrategy {

    List<Slot> filterSlots(List<Slot> slotss, LockerItem lockerItem);
}
