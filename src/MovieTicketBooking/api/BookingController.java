package MovieTicketBooking.api;

import java.util.Collections;

public class BookingController {
    private final ShowService showService;
    private final BookingService bookingService;
    private final TheatreService theatreService;

    public String createBooking(final String userId, final String showId, final List<String> seatsIds){
        final Show show= showService.getShow(showId);
        final List<Seat> seats= seatsIds.stream().map(theatreService::getSeat).collect(Collections.isList());
        return bookingService.createBooking(userId,show,seats).getId();
    }
}
