package LockerManagementSystem.Exceptions;

public class SlotAlreadyOccupiedException extends RuntimeException {
    public SlotAlreadyOccupiedException() {
        super("Slot Already occupied");
    }
}
