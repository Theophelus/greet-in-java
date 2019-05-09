package greeting_db_tests;

import net.greet.dbCounter.CounterUsingJDBC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingsDBTests {

    final String DATABASE_URL = "jdbc:h2:./target/user";

    public Connection getConnection() throws Exception {

        return DriverManager.getConnection(DATABASE_URL,"sa","");
    }
    @BeforeEach
    public void cleanUpDatabaseTables() {

        try {

            try(Connection con = getConnection()) {
                Statement statement = con.createStatement();
                statement.addBatch("DELETE FROM user");
                statement.executeBatch();
            }

        } catch(Exception ex) {
            System.out.println("These test will fail until the user table is created: " + ex);
        }
    }

    @Test
    public void shouldBeAbleToGreetUser(){

        try {
            CounterUsingJDBC counterUsingJDBC = new CounterUsingJDBC();
            assertEquals("Molo, anele", counterUsingJDBC.greet("anele", "isixhosa") );
        }catch (Exception e){
            System.out.println("Error: " + e);
        }

    }

    @Test
    public void shouldBeAbleToAddUserInTheDatabase(){

        try {
            CounterUsingJDBC counterUsingJDBC = new CounterUsingJDBC();
            counterUsingJDBC.greet("Anele", "english");
            counterUsingJDBC.greet("Anele", "isixhosa");
            counterUsingJDBC.greet("Nannie", "isizulu");
            System.out.println(counterUsingJDBC.getGreeted());
            assertEquals("{nannie=1, anele=2}", counterUsingJDBC.getGreeted().toString());
        }catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }
    @Test
    public void shouldBeAbleToReturnSizeTable(){

        try {
            CounterUsingJDBC counterUsingJDBC = new CounterUsingJDBC();
            counterUsingJDBC.greet("Anele", "english");
            counterUsingJDBC.greet("Anele", "isixhosa");
            counterUsingJDBC.greet("Nannie", "isizulu");
            assertEquals(2, counterUsingJDBC.getMapSize());
        }catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    @Test
    public void shouldBeToClearDatabase() {

        try {
            CounterUsingJDBC counterUsingJDBC = new CounterUsingJDBC();
            //Push names into the hashMap
            counterUsingJDBC.greet("Anele", "english");
            counterUsingJDBC.greet("Anele", "isizulu");
            counterUsingJDBC.greet("Anele","isixhosa");
            counterUsingJDBC.greet("Mbali","english");
            assertEquals(counterUsingJDBC.getMapSize(), 2);
            counterUsingJDBC.clearAllUsersInTheMap();
            assertEquals(counterUsingJDBC.getMapSize(), 0);
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void shouldBeAbleToDeleteSpecificUser(){

        try {
            CounterUsingJDBC counterUsingJDBC = new CounterUsingJDBC();
            counterUsingJDBC.greet("Anele", "english");
            counterUsingJDBC.greet("Anele", "isizulu");
            counterUsingJDBC.greet("Anele","isixhosa");
            counterUsingJDBC.greet("Yolanda","english");
            counterUsingJDBC.greet("Mbali","english");
            assertEquals( counterUsingJDBC.getGreeted(), counterUsingJDBC.deleteSpecificUsersInsideTheMap("Yolanda"));
        }catch (Exception e){
            System.out.println("Error: " + e);
        }

    }
}
