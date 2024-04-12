package LockerManagementSystem.Strategy;

import LockerManagementSystem.model.Slot;

import java.util.List;

public interface ISlotAssignmentStrategy {
    Slot pickSlot(List<Slot> slots);
}
