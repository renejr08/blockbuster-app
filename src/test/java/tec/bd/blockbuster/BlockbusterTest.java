package tec.bd.blockbuster;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tec.bd.blockbuster.dao.MovieDAO;
import tec.bd.blockbuster.entity.Movie;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class BlockbusterTest {

    @Mock
    MovieDAO movieDAO;

    @InjectMocks
    Blockbuster blockbuster;


    @Test
    public void whenNoMoviesThenEmptyList() {

        given(movieDAO.findAll()).willReturn(Collections.emptyList());

        List<Movie> movieList = blockbuster.getAllMovies();

        verify(movieDAO, times(1)).findAll();

        assertThat(movieList).isEmpty();
    }

    @Test
    public void whenNewMovieIsAddedThenMovieListSizeIsOne() {

        var movie = new Movie(1L, "Star Wars");

        given(movieDAO.findAll()).willReturn(List.of(movie));

        blockbuster.addNewMovie(movie);
        List<Movie> movieList = blockbuster.getAllMovies();

        verify(movieDAO, times(1)).save(movie);
        verify(movieDAO, times(1)).findAll();

        assertThat(movieList).hasSize(1);
        assertThat(movieList.stream().findFirst().get().getTitle()).isEqualTo("Star Wars");
    }

    @Test
    public void whenTwoMoviesAreAddedThenMovieListSizeIsTwo() {

        var starWars = new Movie(1L, "Star Wars");
        var joker = new Movie(2L, "Joker");

        given(movieDAO.findAll()).willReturn(List.of(starWars, joker));

        blockbuster.addNewMovie(starWars);
        blockbuster.addNewMovie(joker);
        List<Movie> movieList = blockbuster.getAllMovies();

        verify(movieDAO, times(1)).save(starWars);
        verify(movieDAO, times(1)).save(joker);
        verify(movieDAO, times(1)).findAll();

        assertThat(movieList).hasSize(2);
        assertThat(movieList.get(0).getTitle()).isEqualTo("Star Wars");
        assertThat(movieList.get(1).getTitle()).isEqualTo("Joker");
    }
//
//    @Test
//    public void verifyIfMovieIdIsPresent() {
//        Blockbuster blockbuster = new Blockbuster();
//        var starWars = new Movie(1L, "Star Wars");
//        blockbuster.addNewMovie(starWars);
//        Movie movie = blockbuster.getMovie(1L);
//
//        assertThat(movie.getTitle()).isEqualTo("Star Wars");
//    }
//
//    @Test
//    public void verifyIfMovieIdIsNotPresent() {
//        Blockbuster blockbuster = new Blockbuster();
//        var starWars = new Movie(1L, "Star Wars");
//        blockbuster.addNewMovie(starWars);
//        Movie movie = blockbuster.getMovie(33L);
//
//        assertThat(movie).isNull();
//    }
//
//    @Test
//    public void verifyIfMovieNameIsPresent() {
//        Blockbuster blockbuster = new Blockbuster();
//        var starWars = new Movie(1L, "Star Wars");
//        blockbuster.addNewMovie(starWars);
//        Movie movie = blockbuster.getMovie("Star Wars");
//
//        assertThat(movie.getTitle()).isEqualTo("Star Wars");
//    }
//
//    @Test
//    public void verifyIfMovieIsNotPresent() {
//        Blockbuster blockbuster = new Blockbuster();
//        Movie movie = blockbuster.getMovie("Star Wars");
//
//        assertThat(movie).isNull();
//    }
//
//    @Test
//    public void whenMovieIsReNamedThenUseNewName() {
//
//        Blockbuster blockbuster = new Blockbuster();
//        var movie = new Movie(1L, "Star Wars");
//        blockbuster.addNewMovie(movie);
//        blockbuster.editMovieTitle("Star Wars", "Star Wars by George Lucas");
//        var nonExists = blockbuster.getMovie("Star Wars");
//        var actual = blockbuster.getMovie("Star Wars by George Lucas");
//
//        assertThat(nonExists).isNull();
//        assertThat(actual.getTitle()).isEqualTo("Star Wars by George Lucas");
//    }


}
