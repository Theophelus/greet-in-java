package net.greet;

import java.util.Map;

public interface GreetCounter {
    String greet(String userName, String lang);
    Map<String, Integer> getGreeted();
    Integer getSingleUser(String userName);
    short getMapSize();
    Map deleteSpecificUsersInsideTheMap(String userName);
    void clearAllUsersInTheMap();
}
