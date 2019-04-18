package counter;

import java.sql.SQLException;
import java.util.Map;

public interface GreetCounter {
    String greet(String userName, String lang);
    Map<String, Integer> getGreeted();
    //Define a method to get single user in the map
    Integer getSingleUser(String userName);
    short getMapSize() throws SQLException;
    Map<String, Integer> deleteSpecificUsersInsideTheMap(String userName);
    void clearAllUsersInTheMap();
}
