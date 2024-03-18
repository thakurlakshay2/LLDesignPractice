package MovieTicketBooking.model;


public class Seat {
    private final String id;
    private final int rowNo;
    private final int seatNo;

    private SeatingStatus seatingStatus;
    public Seat(String id, int rowNo, int seatNo) {
        this.id = id;
        this.rowNo = rowNo;
        this.seatNo = seatNo;
        this.seatingStatus=SeatingStatus.Empty;
    }

    public boolean isFilled(){
        return this.seatingStatus==SeatingStatus.Empty;
    }

    public void fillSeat(){
        if(this.seatingStatus== SeatingStatus.Filled){
            throw new InvalidSeatBookingEception();
        }
        this.seatingStatus=SeatingStatus.Filled;
    }
    public void  emptySeat(){
        this.seatingStatus=SeatingStatus.Empty;
    }
}
