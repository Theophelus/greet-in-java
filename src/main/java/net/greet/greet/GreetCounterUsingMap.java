package net.greet.greet;

import net.greet.GreetCounter;

import java.util.Map;

public class GreetCounterUsingMap implements GreetCounter {

    Greet greets = new Greet();
    Greeted greeted = new Greeted();


    public String greet(String userName, String lang) {
        if (!userName.isEmpty()) greeted.setGreetedUsers(userName);
        return greets.greetUser(lang, userName);
    }

    //Define a method to get the size of the map
    public Map<String, Integer> getGreeted() { return greeted.getGreetedUsers(); }

    //Define a method to get single user in the map
    public Integer getSingleUser(String userName){
        return greeted.getGreetedSingleUser(userName);
    }


    public short getMapSize() {
        return (short) greeted.getGreetedUsersSize();
    }

    public void clearAllUsersInTheMap() {
        greeted.removeAllUsersInTheMap();
    }

    public Map<String, Integer> deleteSpecificUsersInsideTheMap(String userName) {
        return greeted.removeSpecificUsersInsideTheMap(userName);
    }
}
