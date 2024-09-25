package lowLevelDesigns.bookMyShow.controllers;

import lowLevelDesigns.bookMyShow.models.City;
import lowLevelDesigns.bookMyShow.models.Movie;
import lowLevelDesigns.bookMyShow.services.MovieService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    MovieService movieService;

    public MovieController() {
        movieService = new MovieService();
    }

    public void addMovie(Movie movie, City city) {
        movieService.addMovie(movie, city);
    }

    public Movie getMovieByName(String movieName) {
        return movieService.getMovieByName(movieName);
    }

    public List<Movie> getMoviesByCity(City city) {
        return movieService.getMoviesByCity(city);
    }
}
