package MovieTicketBooking.api;

public class MovieController {
    final private MovieService movieService;

    public String createMovie(final String movieName){
        return movieService.createMovie(movieName);
    }
}
