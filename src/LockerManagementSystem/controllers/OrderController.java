package LockerManagementSystem.controllers;

import LockerManagementSystem.model.Buyer;
import LockerManagementSystem.model.LockerItem;
import LockerManagementSystem.model.Slot;
import LockerManagementSystem.services.LockerService;
import LockerManagementSystem.services.NotificationService;
import LockerManagementSystem.services.OtpService;

public class OrderController {
    private final OtpService otpService;
    private final NotificationService notificationService;
    private final LockerService lockerService;

    public OrderController(OtpService otpService, NotificationService notificationService, LockerService lockerService) {
        this.otpService = otpService;
        this.notificationService = notificationService;
        this.lockerService = lockerService;
    }
    public Slot allocateLocker(final Buyer buyer, final LockerItem lockerItem){
        final Slot slot=lockerService.allocateSlot(lockerItem);
        final String otp=otpService.generateOtp(slot);

        notificationService.notifyUser(buyer,otp ,slot);
        return slot;
    }
}
