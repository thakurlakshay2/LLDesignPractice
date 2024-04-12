package LockerManagementSystem.controllers;

import LockerManagementSystem.model.Locker;
import LockerManagementSystem.model.Size;
import LockerManagementSystem.model.Slot;
import LockerManagementSystem.services.LockerService;
import LockerManagementSystem.services.OtpService;

import java.util.List;

public class LockerController {
    private final LockerService lockerService;
    private final OtpService otpService;

    public LockerController(LockerService lockerService, OtpService otpService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
    }

    public Locker createLocker(final String lockerId){
        return lockerService.createLocker(lockerId);
    }

    public Slot createSlot(final Locker locker, final Size slotSize){
        return lockerService.createSlot(locker,slotSize);
    }
    public List<Slot> getAvailableSlots(){
        return lockerService.getAllAvailableSlots();

    }

    public boolean unlockSlot(final  Slot slot ,final String otp){
        return otpService.validateOtp(slot,otp);
    }

    public void deallocateSlot(final Slot slot){
        lockerService.deallocateSlot(slot);
    }


}
