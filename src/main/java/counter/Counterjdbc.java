package counter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Objects;

public class Counterjdbc implements GreetCounter {

    Connection con;
    //Define a method to for connecton String
    public Counterjdbc() throws Exception{
        try {
            ///Define three strings
            final String URL = "jdbc:h2:./target/user_db";
            String user = "sa";
            String password = "";
            //Register Drivers
            Class.forName("org.h2.Driver");
            //Define a method to create connection strings to the database
            con = DriverManager.getConnection(URL,user,password);
            final String INSERT_USERS_SQL = "INSERT INTO user(user_name, user_counter) values(?, ?)";
            //Define a PreparedStatement
            PreparedStatement addUserPreparedStatement = con.prepareStatement(INSERT_USERS_SQL);
        }catch (Exception e) {
            System.out.println("These test will fail until the fruit table is created: " + e);
        }
        Objects.requireNonNull(con).close();
    }

    public void addNewUser(String userName) {
//        prepared statement
//        return rs
    }



}
