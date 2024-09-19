package lowLevelDesigns.bookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityTheatreMap;
    List<Theatre> allTheatres;

    public TheatreController() {
        cityTheatreMap = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    void addTheatre(Theatre theatre, City city) {
        allTheatres.add(theatre);
        List<Theatre> theatres = cityTheatreMap.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
//        for (Theatre t : theatres) {
//            System.out.println("Theatre added: " + t.getTheatreId() + " in city: " + city);
//        }
        cityTheatreMap.put(city, theatres);
    }

    Map<City, List<Theatre>> getCityTheatreMap() {
        for (Map.Entry<City, List<Theatre>> entry : cityTheatreMap.entrySet()) {
            City city = entry.getKey();
            List<Theatre> theatres = entry.getValue();
//            System.out.println("City Theatre map");
            System.out.println("City: " + city);
            for (Theatre theatre : theatres) {
                System.out.println("Theatre: " + theatre.getTheatreId());
                System.out.println("Show size: "+ theatre.getShows().size());
//                for (Show show : theatre.getShows()) {
//                    System.out.println("Show: " + show.getMovie().movieName + " in theatre " + theatre.getTheatreId());
//                }
            }
        }
        return cityTheatreMap;
    }

    Map<Theatre, List<Show>> getAllShows(City city, Movie movie) {
        // steps are
        // 1. get all theatres in the city
        // 2. get all shows in the theatre
        // 3. filter shows by movie name

        Map<Theatre, List<Show>> theatreShowMap = new HashMap<>();
        List<Theatre> theatres = cityTheatreMap.get(city);

        if (theatres != null) {
            for (Theatre theatre : theatres) {
                // get all shows in the theatre
                List<Show> shows = theatre.getShows();
                // filter shows by movie name
                List<Show> givenMovieShows = new ArrayList<>();
                for (Show show : shows) {
//                    if (show.movie.getMovieId() == movie.getMovieId()) {
//                        givenMovieShows.add(show);
//                    }
                    if (show.getMovie().equals(movie)) {
                        givenMovieShows.add(show);
                        System.out.println("Show added");
                    }
                }
                if (!givenMovieShows.isEmpty()) {
                    theatreShowMap.put(theatre, givenMovieShows);
                }
            }
        }
        for (Map.Entry<Theatre, List<Show>> entry : theatreShowMap.entrySet()) {
            Theatre theatre = entry.getKey();
            List<Show> shows = entry.getValue();
            System.out.println("Theatre Show map");
            System.out.println("Theatre: " + theatre.getTheatreId());
            for (Show show : shows) {
                System.out.println("Show: " + show.getMovie().movieName);
            }
        }
        return theatreShowMap;
    }


}
