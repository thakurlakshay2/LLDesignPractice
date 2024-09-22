package ParkingLotSystem.Models;

import java.util.Date;

public class ParkingTicket {
    private final String id;
    private final ParkingTicketStatus ticketStatus;
    private final Date entryTime;
    private  Date exitTime;
    private Date payedAt;
    private final float payedAmount;

    public ParkingTicket(String id) {
        this.id = id;
        this.ticketStatus = ParkingTicketStatus.Active;
        this.entryTime=new Date();
    }


    public void setExitTime( ){
        this.exitTime=new Date();
    }
}
