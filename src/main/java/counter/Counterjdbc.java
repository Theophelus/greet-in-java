package counter;

import greet.Greet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Counterjdbc implements GreetCounter {
    //Define an instance of greet class
    Greet newGreet = new Greet();
    final String  INSERT_USER_SQL = "INSERT INTO user(user_name, user_count) VALUES (?, ?)";
    final String  CHECK_USER_SQL = "SELECT * FROM user WHERE user_name = ?";
    final String UPDATE_USER_SQL = "UPDATE user SET user_count = ? WHERE user_name = ?";
    Connection con;
    PreparedStatement pInsertData;
    PreparedStatement pCheckUser;
    PreparedStatement pUpdateUser;
    //Define a method to for connecton Stringar
    public Counterjdbc() {
        try{
            ///Define three strings
            final String URL = "jdbc:h2:./target/user";
            String user = "sa";
            String password = "";
            //Register Drivers
            Class.forName("org.h2.Driver");
            //Define a method to create connection strings to the database
            con = DriverManager
                    .getConnection(URL,user,password);
            pInsertData = con.prepareStatement(INSERT_USER_SQL);
            pCheckUser = con.prepareStatement(CHECK_USER_SQL);
            pUpdateUser = con.prepareStatement(UPDATE_USER_SQL);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public String greet(String user_name, String lang) {
        try {
            //prepared statement
            pCheckUser.setString(1,user_name);
            ResultSet rs = pCheckUser.executeQuery();
            //Check if user doesn't exists
            if (!rs.next()){
                pInsertData.setString(1, user_name);
                pInsertData.setInt(2,1);
                pInsertData.execute();
            }else {
                int counter = rs.getInt("user_count");
                pUpdateUser.setInt(1,  counter + 1);
                pUpdateUser.setString(2,user_name);
                pUpdateUser.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return newGreet.greetUser(lang, user_name);
    }


}
