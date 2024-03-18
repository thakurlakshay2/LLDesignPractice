package MovieTicketBooking.model;

import MovieTicketBooking.model.Seat;
import MovieTicketBooking.model.Show;

import java.time.Instant;
import java.util.Date;

public class SeatLock {

    private Seat seat;
    private Show show;
    private Integer timeOutInSeconds;
    private Date lockTime;
    private String lockedBy;

    public boolean isLockExpired(){
        final Instant lockInstant=lockTime.toInstant().plusSeconds(timeOutInSeconds);
        final Instant currentTime=new Date().toInstant();
        return lockInstant.isBefore(currentTime);
    }

}
