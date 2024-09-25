package lowLevelDesigns.bookMyShow;

import lowLevelDesigns.bookMyShow.controllers.MovieController;
import lowLevelDesigns.bookMyShow.controllers.TheatreController;
import lowLevelDesigns.bookMyShow.models.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    public BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();
//        System.out.println("Initialization done");
//        System.out.println("Searching for movie AVENGERS in DELHI");
        bookMyShow.createBooking(City.DELHI, "AVENGERS");
    }

    private void initialize() {
        createMovies();
//        System.out.println("Movies created");
        createTheatres();
//        System.out.println("Theatres created");
    }

    public void createBooking(City city, String movie) {
        //flow is like this
        //1. search movie by my location
        //2. select movie
        //3. get all show w.r.t. theatre and movie
        //4. select show
        //5. get all bookedSeats
        //6. select seat

        List<Movie> movies = movieController.getMoviesByCity(city);

        Movie selectedMovie = null;
        for (Movie m : movies) {
            if (m.getMovieName().equals(movie)) {
                System.out.println("Movie found");
                selectedMovie = m;
                System.out.println("Selected movie: " + selectedMovie.getMovieName());
                break;
            }
        }
        if (selectedMovie == null) {
            System.out.println("Movie not found");
            return;
        }

        Map<Theatre, List<Show>> theatreShowMap = theatreController.getAllShows(city, selectedMovie);
        // print all shows
//        for (Map.Entry<Theatre, List<Show>> entry : theatreShowMap.entrySet()) {
//            Theatre theatre = entry.getKey();
//            List<Show> shows = entry.getValue();
//            System.out.println("Theatre: " + theatre.getTheatreId());
//            for (Show show : shows) {
//                System.out.println("Show: " + show.getShowId());
//            }
//        }

        if (theatreShowMap.isEmpty()) {
            System.out.println("No shows available for the selected movie in the specified city.");
            return;
        }

        Iterator<Map.Entry<Theatre, List<Show>>> iterator = theatreShowMap.entrySet().iterator();
        if (!iterator.hasNext()) {
            System.out.println("No theatres found for the selected movie.");
            return;
        }

        Map.Entry<Theatre, List<Show>> entry = theatreShowMap.entrySet().iterator().next(); // get first entry

        List<Show> runningShows = entry.getValue();
        if (runningShows.isEmpty()) {
            System.out.println("No running shows found for the selected movie.");
            return;
        }
        Show selectedShow = runningShows.get(0); // get first show

        int seatNumber = 30;
        List<Integer> bookedSeats = selectedShow.getBookedSeatIds();

        if (!bookedSeats.contains(seatNumber)) {
            bookedSeats.add(seatNumber);
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for (Seat screenSeat : selectedShow.getScreen().getSeats()) {
                if (screenSeat.getSeatId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(selectedShow);
        } else {
            System.out.println("seat is already booked");
            return;
        }
        System.out.println("Booking is successful");
    }

    private void createMovies() {
        Movie avengers = new Movie();
        avengers.setMovieId(1);
        avengers.setMovieName("AVENGERS");
        avengers.setMovieDurationInMinutes(128);
//        System.out.println("Movie created " + avengers.getMovieName());

        Movie joker = new Movie();
        joker.setMovieId(2);
        joker.setMovieName("JOKER");
        joker.setMovieDurationInMinutes(122);
//        System.out.println("Movie created " + joker.getMovieName());

        movieController.addMovie(avengers, City.DELHI);
//        System.out.println("Movie added to city " + avengers.getMovieName() + " " + City.DELHI);
        movieController.addMovie(joker, City.DELHI);
//        System.out.println("Movie added to city " + joker.getMovieName() + " " + City.DELHI);
        movieController.addMovie(avengers, City.BANGALORE);
//        System.out.println("Movie added to city " + avengers.getMovieName() + " " + City.BANGALORE);
        movieController.addMovie(joker, City.BANGALORE);
//        System.out.println("Movie added to city " + joker.getMovieName() + " " + City.BANGALORE);
    }

    private void createTheatres() {
        Movie avengers = movieController.getMovieByName("AVENGERS");
//        System.out.println("Movie found " + avengers.getMovieName());
        Movie joker = movieController.getMovieByName("JOKER");
//        System.out.println("Movie found " + joker.getMovieName());

        Theatre inox = new Theatre();
        inox.setTheatreId(1);
        inox.setScreens(createScreen());
        inox.setCity(City.BANGALORE);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShow(1, inox.getScreens().get(0), avengers, 10);
//        System.out.println("Show created " + inoxMorningShow.getShowId() + " " + inoxMorningShow.getMovie().getMovieName() + " in " + inox.getCity());
        Show inoxEveningShow = createShow(2, inox.getScreens().get(0), joker, 15);
//        System.out.println("Show created " + inoxEveningShow.getShowId() + " " + inoxEveningShow.getMovie().getMovieName() + " in " + inox.getCity());
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);

        Theatre pvr = new Theatre();
        pvr.setTheatreId(2);
        pvr.setScreens(createScreen());
        pvr.setCity(City.DELHI);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShow(3, pvr.getScreens().get(0), avengers, 10);
//        System.out.println("Show created " + pvrMorningShow.getShowId() + " " + pvrMorningShow.getMovie().getMovieName() + " in " + pvr.getCity());
        Show pvrEveningShow = createShow(4, pvr.getScreens().get(0), joker, 15);
//        System.out.println("Show created " + pvrEveningShow.getShowId() + " " + pvrEveningShow.getMovie().getMovieName() + " in " + pvr.getCity());
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);

        theatreController.addTheatre(inox, City.BANGALORE);
        theatreController.addTheatre(pvr, City.DELHI);
        System.out.println("Looking for city theatre map");
        theatreController.getCityTheatreMap();

        System.out.println("Movie: " + avengers.getMovieName() + " in city: " + City.BANGALORE + " in theatre: " + inox.getTheatreId() + " in screen: " + inox.getScreens().get(0).getScreenId());
        System.out.println("Movie: " + joker.getMovieName() + " in city: " + City.BANGALORE + " in theatre: " + inox.getTheatreId() + " in screen: " + inox.getScreens().get(0).getScreenId());
        System.out.println("Movie: " + avengers.getMovieName() + " in city: " + City.DELHI + " in theatre: " + pvr.getTheatreId() + " in screen: " + pvr.getScreens().get(0).getScreenId());
        System.out.println("Movie: " + joker.getMovieName() + " in city: " + City.DELHI + " in theatre: " + pvr.getTheatreId() + " in screen: " + pvr.getScreens().get(0).getScreenId());


    }

    private Show createShow(int showId, Screen screen, Movie movie, int showStartTime) {
        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime);
        return show;
    }

    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();

        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
//        System.out.println("Screen created " + screen1.getScreenId() + " " + screen1.getSeats().size());
        screens.add(screen1);
        return screens;
    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

//        System.out.println("Silver Seats created " + seats.size());

        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

//        System.out.println("Gold Seats created " + seats.size());

        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

//        System.out.println("Platinum Seats created " + seats.size());
        return seats;
    }
}
