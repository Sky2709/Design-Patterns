package lowLevelDesigns.bookMyShow.services;

import lowLevelDesigns.bookMyShow.models.City;
import lowLevelDesigns.bookMyShow.models.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieService {
    Map<City, List<Movie>> cityMovieMap;
    List<Movie> allMovies;

    public MovieService() {
        cityMovieMap = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie, City city) {
        allMovies.add(movie);
        List<Movie> movies = cityMovieMap.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityMovieMap.put(city, movies);
    }

    public Movie getMovieByName(String movieName) {
        for (Movie movie : allMovies) {
            if (movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getMoviesByCity(City city) {
        return cityMovieMap.get(city);

    }
}
