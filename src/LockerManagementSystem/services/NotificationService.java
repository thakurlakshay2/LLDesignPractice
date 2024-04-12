package LockerManagementSystem.services;

import LockerManagementSystem.model.LockerUser;
import LockerManagementSystem.model.Slot;

public class NotificationService {
    public void notifyUser(final LockerUser user, final String otp, final Slot slot){
        System.out.println("Sending  Notification of otp: "+ otp +"to: "+user+" for slot: " +slot);
    }
}
