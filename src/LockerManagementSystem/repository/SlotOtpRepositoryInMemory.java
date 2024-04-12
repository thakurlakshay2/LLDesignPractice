package LockerManagementSystem.repository;

import java.util.HashMap;
import java.util.Map;

public class SlotOtpRepositoryInMemory implements  ISlotOtpRepository{


    private final Map<String ,String> slotIdToOtpMap;


    public SlotOtpRepositoryInMemory() {
        this.slotIdToOtpMap = new HashMap<>();
    }

    public void addOtp(final String otp,final String slotId){
    slotIdToOtpMap.put(slotId,otp);
    }

    public String getOtp(final String slotId){
        return slotIdToOtpMap.get(slotId);
    }




}
