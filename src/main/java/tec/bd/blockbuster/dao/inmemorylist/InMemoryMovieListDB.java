package tec.bd.blockbuster.dao.inmemorylist;

import tec.bd.blockbuster.dao.MovieDAO;
import tec.bd.blockbuster.entity.Movie;

import java.util.List;
import java.util.Optional;

public class InMemoryMovieListDB implements MovieDAO {


    @Override
    public Optional<Movie> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void save(Movie movie) {

    }

    @Override
    public Optional<Movie> update(Movie movie) {
        return Optional.empty();
    }

    @Override
    public void delete(Long aLong) {

    }
}
