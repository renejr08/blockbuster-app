package tec.bd.blockbuster;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import tec.bd.blockbuster.dao.MovieDAO;
import tec.bd.blockbuster.dao.inmemorylist.InMemoryMovieListDB;
import tec.bd.blockbuster.dao.mysql.MovieDAOImpl;

import javax.sql.DataSource;

public class ApplicationContext {


    private Blockbuster blockbuster;


    public ApplicationContext() {

        var hikariDataSource = initHikariDataSource();
        var mysqlMovies = initMysqlMovieDAO(hikariDataSource);
        var listMovies = initInMemoryListMovieDAO();

        this.blockbuster = initBlockbuster(mysqlMovies);
    }



    private static HikariDataSource initHikariDataSource() {
        HikariConfig config = new HikariConfig("/database.properties");
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    public static MovieDAO initMysqlMovieDAO(DataSource dataSource) {
        return new MovieDAOImpl(dataSource);
    }

    public static MovieDAO initInMemoryListMovieDAO() {
        return new InMemoryMovieListDB();
    }

    public static Blockbuster initBlockbuster(MovieDAO movieDAO) {
        return new Blockbuster(movieDAO);
    }

    public Blockbuster getBlockbuster() {
        return blockbuster;
    }
}
