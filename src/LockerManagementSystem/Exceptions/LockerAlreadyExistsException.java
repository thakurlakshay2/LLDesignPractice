package LockerManagementSystem.Exceptions;

public class LockerAlreadyExistsException extends  RuntimeException{
    public LockerAlreadyExistsException() {
        super("This locker already exists");
    }
}
