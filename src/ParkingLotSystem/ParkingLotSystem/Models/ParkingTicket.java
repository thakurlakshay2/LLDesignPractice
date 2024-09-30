package ParkingLotSystem.ParkingLotSystem.Models;

import ParkingLotSystem.Models.ParkingTicketStatus;

import java.util.Date;

public class ParkingTicket {
    private final String id;
    private final ParkingTicketStatus ticketStatus;
    private final Date entryTime;
    private  Date exitTime;
    private Date payedAt;
    private final float payedAmount;

    public ParkingTicket(String id, float payedAmount) {
        this.id = id;
        this.payedAmount = payedAmount;
        this.ticketStatus = ParkingTicketStatus.Active;
        this.entryTime=new Date();
    }


    public void setExitTime( ){
        this.exitTime=new Date();
    }
}
