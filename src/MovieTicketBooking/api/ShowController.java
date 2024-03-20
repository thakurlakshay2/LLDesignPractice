package MovieTicketBooking.api;

import java.util.Collections;

public class ShowController {
    private final ShowService ShowService;
    private final TheatreService theatreServicce;
    private final MovieService movieService;

    public String createShow(final String movieId,final String screenId,final Integer startTime,final Integer durationInSeconds){
        final Screen screen=theatreService.getScreen(screenId);
        final Movie movie =movieService.getMovie(movieId);
        return showService(movie,screen ,startTime,durationInSeconds).getId();

    }

    public List<String> getAvailableSeats(final String showId){
        final Show show= showService.getShow(showId);
        final List<Seat> availableSeats=seatsAvailiblityService.getAvailableSeats(show);
        return availableSeats.stream().map(Seat::getId).collec(Collections.toList());
    }
}
