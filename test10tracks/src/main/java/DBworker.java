import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBworker {
    private final String HOST = "jdbc:h2:tcp://localhost/~/test";
    private final String USERNAME = "sa";
    private final String PASSWORD = "";

    private Connection connection;

    public DBworker(){
        try {
            connection = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.connection;
    }


}
