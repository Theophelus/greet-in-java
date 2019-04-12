package greeting_db_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.fail;

public class greetingsDBTests {

    final String DATABASE_URL = "jdbc:h2:./target/user_db";

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(DATABASE_URL,"sa","");
    }
    @BeforeEach
    public void cleanUpTables() {
        // don't touch any code in here!!!
        try {
            try(Connection conn = getConnection()) {
                // I repeat don't touch any code in here!!!
                Statement statement = conn.createStatement();
//                statement.addBatch("delete from users where user_name in ('', 'Orange')");
//                statement.addBatch("update users set  =   where name = 'red apple'");
                statement.executeBatch();

                // I repeat once again don't touch any code in here!!!

            }
        } catch(Exception ex) {
            System.out.println("These test will fail until the fruit table is created: " + ex);
        }
    }

    @Test
    public void loadJdbcDriver() {

        try {

            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            fail(e);
        }
    }

    @Test
    public void connectToDatabase() {

        try {
            //Register Drivers
            Class.forName("org.h2.Driver");
            //Open connections To user_db
            Connection conn = DriverManager
                    .getConnection("jdbc:h2:./target/users_db", "sa", "");
        } catch (Exception e) {
            fail(e);
        }
    }
}
