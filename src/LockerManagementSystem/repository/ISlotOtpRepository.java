package LockerManagementSystem.repository;

public interface ISlotOtpRepository {

    void addOtp(String otp,String slotId);

    String getOtp(String slotId);

}
