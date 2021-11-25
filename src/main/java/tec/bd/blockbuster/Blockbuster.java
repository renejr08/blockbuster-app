package tec.bd.blockbuster;

import tec.bd.blockbuster.dao.MovieDAO;
import tec.bd.blockbuster.entity.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Blockbuster {

    private MovieDAO movieDAO;

    public Blockbuster(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    /**
     * Lista todas las peliculas
     * @return
     */
    public List<Movie> getAllMovies() {
        return this.movieDAO.findAll();
    }

    /**
     * Agrega una pelicula
     * @param movie
     */
    public void addNewMovie(Movie movie) {
        this.movieDAO.save(movie);
    }

    /**
     * Obtiene una pelicula por titulo
     * @param movieName
     * @return
     */
    public Movie getMovie(String movieName) {
        return this.movieDAO.findByTitle(movieName).orElse(null);
    }

    /**
     * Obtiene una pelicula por movieId
     * @param movieId
     * @return
     */
    public Movie getMovie(long movieId) {
        return this.movieDAO.findById(movieId).orElse(null);
    }

    public void editMovieTitle(String currentMovieName, String newMovieName) {
        var movie = this.getMovie(currentMovieName);
        movie.setTitle(newMovieName);
    }

    /**
     * Borra una pelicula
     * @param movieId
     */
    public void remove(long movieId) {
        this.movieDAO.delete(movieId);
    }

}
