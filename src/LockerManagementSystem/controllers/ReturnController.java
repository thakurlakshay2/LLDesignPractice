package LockerManagementSystem.controllers;

import LockerManagementSystem.model.Buyer;
import LockerManagementSystem.model.DeliveryPerson;
import LockerManagementSystem.model.LockerItem;
import LockerManagementSystem.model.Slot;
import LockerManagementSystem.services.DeliveryPersonService;
import LockerManagementSystem.services.LockerService;
import LockerManagementSystem.services.NotificationService;
import LockerManagementSystem.services.OtpService;

public class ReturnController {

    private  final OtpService otpService;
    private final NotificationService notificationService;

    private final LockerService lockerService;

    private final DeliveryPersonService deliveryPersonService;

    public ReturnController(OtpService otpService, NotificationService notificationService, LockerService lockerService, DeliveryPersonService deliveryPersonService) {
        this.otpService = otpService;
        this.notificationService = notificationService;
        this.lockerService = lockerService;
        this.deliveryPersonService = deliveryPersonService;
    }

    public void allocateLocker(final Buyer buyer, final LockerItem lockerItem){
        final Slot slot=lockerService.allocateSlot(lockerItem);
        final String otp=otpService.generateOtp(slot);
        final DeliveryPerson deliveryPerson=deliveryPersonService.getDeliveryPerson(slot);
        notificationService.notifyUser(deliveryPerson,otp,slot);
    }
}
