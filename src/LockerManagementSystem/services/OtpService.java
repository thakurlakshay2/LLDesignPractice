package LockerManagementSystem.services;

import LockerManagementSystem.Strategy.IOtpGenerator;
import LockerManagementSystem.model.Slot;
import LockerManagementSystem.repository.SlotOtpRepositoryInMemory;

public class OtpService {
    private final IOtpGenerator otpGenerator;

    private  final SlotOtpRepositoryInMemory slotOtpRepository;

    public OtpService(IOtpGenerator otpGenerator, SlotOtpRepositoryInMemory slotOtpRepository) {
        this.otpGenerator = otpGenerator;
        this.slotOtpRepository = slotOtpRepository;
    }

    public String generateOtp(final Slot slot){
        final String otp=otpGenerator.generateOtp();
        slotOtpRepository.addOtp(otp,slot.getSlotId());
        return otp;
    }

    public boolean validateOtp(final Slot slot, final String otp){
        final String savedOtp=slotOtpRepository.getOtp(slot.getSlotId());
        return savedOtp!=null && savedOtp.equals(otp);
    }
}
