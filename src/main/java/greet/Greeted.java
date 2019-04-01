package greet;

import java.util.HashMap;
import java.util.Map;

public class Greeted {

    //Define a hashMap storage to hold each user with specific name
    private Map<String, Integer> greetedUsers = new HashMap<>();

    //Define a constructor to be able to get access
    public  Greet(){}

    //Define a getter method for to be able to get data in the map
    public Map<String, Integer> getGreetedUIsers() {
        return greetedUsers;
    }
}

