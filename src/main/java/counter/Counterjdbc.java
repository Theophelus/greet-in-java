package counter;

import greet.Greet;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Counterjdbc implements GreetCounter {
    //define Hash Map to get name and counter in the table
    Map<String, Integer> storeData = new HashMap<>();
    Greet newGreet = new Greet();
    //SQL
    final String  INSERT_USER_SQL = "INSERT INTO user(user_name, user_count) VALUES (?, ?)";
    final String  CHECK_USER_SQL = "SELECT * FROM user WHERE user_name = ?";
    final String  GET_ALL_USERS = "SELECT * FROM user";
    final String  GET_SINGLE_USER = "SELECT user_count FROM user WHERE user_name = ?";
    final String UPDATE_USER_SQL = "UPDATE user SET user_count = ? WHERE user_name = ?";
    final String DELETE_SPECIFIC_USER = "DELETE FROM user WHERE user_name = ?";
    final String DELETE_ALL_USERS = "DELETE FROM user";

    //Database connection
    Connection con;

    //Prepared statement
    PreparedStatement pInsertData;
    PreparedStatement pCheckUser;
    PreparedStatement pUpdateUser;
    PreparedStatement pGetAllUsers;
    PreparedStatement pGetSingleUser;
    PreparedStatement pDeleteUser;
    PreparedStatement pDeleteAll;
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
            //Define prepared statements
            pInsertData = con.prepareStatement(INSERT_USER_SQL);
            pCheckUser = con.prepareStatement(CHECK_USER_SQL);
            pUpdateUser = con.prepareStatement(UPDATE_USER_SQL);
            pGetAllUsers = con.prepareStatement(GET_ALL_USERS);
            pGetSingleUser = con.prepareStatement(GET_SINGLE_USER);
            pDeleteUser = con.prepareStatement(DELETE_SPECIFIC_USER);
            pDeleteAll = con.prepareStatement(DELETE_ALL_USERS);
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
                int counter = rs.getInt("user_count") + 1;
                pUpdateUser.setInt(1,  counter);
                pUpdateUser.setString(2,user_name);
                pUpdateUser.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return newGreet.greetUser(lang, user_name);
    }
    @Override
    public Map<String, Integer> getGreeted() {
        try {
            //Get results
            ResultSet rs = pGetAllUsers.executeQuery();
            //Check every element in the Table if found push in the map..!
            while (rs.next()) storeData.put(rs.getString("user_name"), rs.getInt("user_count"));
//            else
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return storeData;
    }

    @Override
    public Integer getSingleUser(String user_name) {
        try {
            pGetSingleUser.setString(1,user_name);
            ResultSet rs = pGetSingleUser.executeQuery();
            //If the user exists get its counter
            if (rs.next()) return rs.getInt("user_count");
        }catch (SQLException e) {System.out.println("Error: " + e);}
        return 0;
    }

    @Override
    public Map<String, Integer> deleteSpecificUsersInsideTheMap(String userName) {
        try {
//            pDeleteUser.execute();
            pCheckUser.setString(1,userName);
            pDeleteUser.setString(1,userName);
            Iterator<String> user = storeData.keySet().iterator();
            ResultSet rs = pCheckUser.executeQuery();
            if (rs.next())
            while (user.hasNext())  if (user.next().contains(userName)) user.remove();
            pDeleteUser.executeUpdate();
//            con.close();
        }catch (SQLException e){
            System.out.println("Error: " + e);
        }
        return storeData;
    }

    @Override
    public void clearAllUsersInTheMap() {
        try {
            pDeleteAll.executeUpdate();
            storeData.clear();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
