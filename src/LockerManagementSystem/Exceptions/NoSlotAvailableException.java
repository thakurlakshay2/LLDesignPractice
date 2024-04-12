package LockerManagementSystem.Exceptions;

public class NoSlotAvailableException extends  RuntimeException{
    public NoSlotAvailableException() {
        super("No slot available");
    }
}
