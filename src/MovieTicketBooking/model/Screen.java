package MovieTicketBooking.model;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private final String id;
    private final String name;
    public final Theatre theatre;

    private  final List<Seat> seats;

    public Screen(String id, String name, Theatre theatre) {
        this.id = id;
        this.name = name;
        this.theatre = theatre;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat){
        this.seats.add(seat);
    }
}
