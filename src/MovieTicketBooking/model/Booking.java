package MovieTicketBooking.model;

import Cache_LLD.Algorithms.exceptions.InvalidNodeException;

import java.util.List;

public class Booking {
    private final String id;
    private final Show show;

    private final List<Seat> seatsBooked;

    private final String user;

    private  BookingStatus bookingStatus;

    public Booking(String id, Show show, List<Seat> seatsBooked, String user) {
        this.id = id;
        this.show = show;
        this.seatsBooked = seatsBooked;
        this.user = user;
        this.bookingStatus = BookingStatus.Created;
    }

    public boolean isConfirmed(){
        return  this.bookingStatus==BookingStatus.Confirmed;
    }

    public void confirmBooking(){
        if(this.bookingStatus != BookingStatus.Created){
            throw  new InvalidStateException();
        }

        this.bookingStatus=BookingStatus.Confirmed;
    }

    public void expiredBooking(){
        if(this.bookingStatus!=BookingStatus.Created){
            throw new InvalidStateException();
        }
        this.bookingStatus=BookingStatus.Expired;
    }
}
