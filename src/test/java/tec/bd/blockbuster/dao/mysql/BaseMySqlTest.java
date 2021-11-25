package tec.bd.blockbuster.dao.mysql;

import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;

public abstract class BaseMySqlTest {

    private static final String DB_URL = "jdbc:h2:mem:blockbuster;MODE=MYSQL;DB_CLOSE_ON_EXIT=TRUE;TRACE_LEVEL_SYSTEM_OUT=1;";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "";
    protected DataSource dataSource;

    public static DataSource DS;


    @BeforeAll
    public static void beforeAll() {
        initDB();
    }

    public static void initDB() {
        try {
            System.out.println("Open Database Connection");
            JdbcDataSource jdbcDataSource = new JdbcDataSource();
            jdbcDataSource.setUrl(DB_URL);
            jdbcDataSource.setUser(DB_USERNAME);
            jdbcDataSource.setPassword(DB_PASSWORD);
            DS = jdbcDataSource;
            RunScript.execute(DS.getConnection(), new FileReader("src/test/resources/blockbuster-db.sql"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

//    public void closeDB() {
//        try {
//            System.out.println("Close Database Connection");
//            this.dataSource.
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
