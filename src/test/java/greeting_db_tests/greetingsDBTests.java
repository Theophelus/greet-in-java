package greeting_db_tests;

import counter.Counterjdbc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class greetingsDBTests {

    final String DATABASE_URL = "jdbc:h2:./target/user";

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(DATABASE_URL,"sa","");
    }
    @BeforeEach
    public void cleanUpDatabaseTables() {
        // don't touch any code in here!!!
        try {
            try(Connection conn = getConnection()) {
                // I repeat don't touch any code in here!!!
                Statement statement = conn.createStatement();
                statement.addBatch("DELETE FROM user");
                statement.executeBatch();
                // I repeat once again don't touch any code in here!!!
            }
        } catch(Exception ex) {
            System.out.println("These test will fail until the user table is created: " + ex);
        }
    }

    @Test
    public void shouldBeAbleToGreetUser(){

        try {
            Counterjdbc counterjdbc = new Counterjdbc();
            assertEquals("Molo, anele", counterjdbc.greet("Anele", "Isixhosa") );
        }catch (Exception e){
            System.out.println("Error: " + e);
        }

    }

//    @Test
//    public void shouldBeAbleToAddUserInTheDatabase(){
//
//        try {
//            Counterjdbc counterjdbc = new Counterjdbc();
//            counterjdbc.greet("Anele", "English");
//            counterjdbc.greet("Anele", "Isixhosa");
//            counterjdbc.greet("Nannie", "IsiZulu");
//            System.out.println(counterjdbc.getGreeted());
//            assertEquals("{nannie=1, anele=2}",counterjdbc.getGreeted().toString());
//        }catch (Exception e) {
//            System.out.println("Error: " + e);
//        }
//    }
    @Test
    public void shouldBeAbleToReturnSizeTable(){
        try {
            Counterjdbc counterjdbc = new Counterjdbc();
            counterjdbc.greet("Anele", "English");
            counterjdbc.greet("Anele", "Isixhosa");
            counterjdbc.greet("Nannie", "IsiZulu");
//            System.out.println(counterjdbc.getMapSize());

            assertEquals(2, counterjdbc.getMapSize());
        }catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    @Test
    public void shouldBeToClearDatabase() {

        try {
            Counterjdbc counterjdbc = new Counterjdbc();
            //Push names into the hashMap
            counterjdbc.greet("Anele", "English");
            counterjdbc .greet("Anele", "IsiZulu");
            counterjdbc.greet("Anele","Isixhosa");
            counterjdbc.greet("Mbali","English");
            counterjdbc .clearAllUsersInTheMap();
            assertEquals(counterjdbc.getMapSize(), 0);
//        System.out.println("HashMap successfully clear" + " " + greetUser.getGreeted());
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void shouldBeAbleToDeleteSpecificUser(){

        try {
            Counterjdbc counterjdbc = new Counterjdbc();
            //Push names into the hashMap
            counterjdbc.greet("Anele", "English");
            counterjdbc.greet("Anele", "IsiZulu");
            counterjdbc.greet("Anele","Isixhosa");
            counterjdbc.greet("Yolanda","English");
            counterjdbc .greet("Mbali","English");
//        System.out.println(greetUser.getGreeted());
//        System.out.println("This user have been removed from the map" + " " + greetUser.deleteSpecificUsersInsideTheMap("Yolanda"));
            assertEquals( counterjdbc.getGreeted(), counterjdbc .deleteSpecificUsersInsideTheMap("Yolanda"));
//        System.out.println("Check how many users in the map" + " " + greetUser.getMapSize());

        }catch (Exception e){
            System.out.println("Error: " + e);
        }

    }
}
