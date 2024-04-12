package LockerManagementSystem.model;

import LockerManagementSystem.Exceptions.SlotAlreadyOccupiedException;

import java.util.Date;

public class Slot {

    private final String slotId;
    private final Size size;
    private final Locker locker;
    private  LockerItem currentLockerItem;
    private Date allocationDate;

    public Slot(String slotId, Size size, Locker locker) {
        this.slotId = slotId;
        this.size = size;
        this.locker = locker;
        this.currentLockerItem=null;
    }

    public String getSlotId(){
        return this.slotId;
    }
    public  Size getSize(){
        return this.size;
    }
    //synchronised for thread safety ..... no need to write in lld interview unless especially asked
    synchronized  public void allocatePackage(final LockerItem newLockerItem){
        if(this.currentLockerItem!=null){
            throw new SlotAlreadyOccupiedException();
        }
        this.allocationDate=new Date();
        this.currentLockerItem=newLockerItem;
    }


    synchronized  public void deallocateSLot(){this.currentLockerItem=null;}

    synchronized  public boolean isAvailable(){ return this.currentLockerItem==null;}
}
