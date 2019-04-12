package counter;

import java.sql.Connection;
import java.sql.DriverManager;

public class Counterjdbc {

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
//        return DriverManager.getConnection(URL,user,password);
//        PreparedStatement addFruitPreparedStatement = con.prepareStatement(INSERT_FRUIT_SQL);
            con = DriverManager.getConnection(URL,user,password);

        }catch (Exception e) {
            System.out.println("These test will fail until the fruit table is created: " + e);
        }


    }

    public void addNewUser(String userName) {
//        prepared statement
//        return rs
    }



}
