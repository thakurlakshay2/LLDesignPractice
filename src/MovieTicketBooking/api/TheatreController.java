package MovieTicketBooking.api;

import MovieTicketBooking.model.Screen;

public class TheatreController {
    final private TheatreService theatreService;

    public String createTheatre(final String theatreName){
        return theatreService.createTheatre(theatreName).getId();

    }

    public String createScreenInTheatre(final String screenName,final String theatreId){
        final Theatre theatre=theatreService.getTheatre(theatreId);
        return theatreService.createScreenInTheatre(screenName,theatre).getId();
    }

//    public final createSeatInScreen(final Integer rowNo, final Integer seatNo, final String screenId){
//        final Screen screen=theatreService.getScreen(screenId);
//        return theatreService.createSeatInScreen(rowNo,seatNo,screen);
//    }
}
