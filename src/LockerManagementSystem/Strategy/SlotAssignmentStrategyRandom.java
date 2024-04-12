package LockerManagementSystem.Strategy;

import LockerManagementSystem.model.Slot;

import java.util.List;

public class SlotAssignmentStrategyRandom implements  ISlotAssignmentStrategy {

    private final IRandomGenerator randomGenerator;

    public SlotAssignmentStrategyRandom(IRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public Slot pickSlot(List<Slot> slots) {
        if(slots.isEmpty()){
            return null;
        }
        int slotNum=randomGenerator.getRandomNumber(slots.size());
        return slots.get(slotNum);
    }
}
