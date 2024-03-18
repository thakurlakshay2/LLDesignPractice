package MovieTicketBooking.model;

public class Movie {

    private  final String id;
    private final String name;

    private final MovieLanguage language;

    public Movie(String id, String name, MovieLanguage language) {
        this.id = id;
        this.name = name;
        this.language = language;
    }
}
