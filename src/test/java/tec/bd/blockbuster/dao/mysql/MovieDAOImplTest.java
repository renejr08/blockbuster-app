package tec.bd.blockbuster.dao.mysql;

import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.jupiter.api.*;
import tec.bd.blockbuster.entity.Movie;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

public class MovieDAOImplTest extends BaseMySqlTest {

    MovieDAOImpl movieDAO;

    @BeforeEach
    public void setup() {

        this.movieDAO = new MovieDAOImpl(DS);
    }


    @Test
    public void findAllMovies() {
        var movies = this.movieDAO.findAll();
        assertThat(movies).hasSize(4);
    }

    @Test
    public void saveNewMovie() {
        Movie newMovie = new Movie("Forrest Gump", new Date(), "Drama");
        this.movieDAO.save(newMovie);
        var movies = this.movieDAO.findAll();
        assertThat(movies).hasSize(5);
    }

    @Test
    public void findById() {
        var movie = this.movieDAO.findById(1L);

        assertThat(movie.isPresent()).isTrue();
    }

}
