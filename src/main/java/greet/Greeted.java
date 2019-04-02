package greet;

import java.util.HashMap;
import java.util.Map;

public class Greeted {

    //Define a hashMap storage to hold each user with specific name and userName
    private Map<String, Integer> greetedUsers = new HashMap<>();
    private String userName;


    //Define a setter method that will be able to push users in the HashMap Map with specific.

    public void setGreetedUsers(String user) {

        if (userName != "") userName = user;

        Integer counter = greetedUsers.get(userName);

        //Check if user already in a Map, if not add it
        if (greetedUsers.containsKey(userName)) greetedUsers.put(userName, 1);
        //else if already exists increment the counter.
//        else greetedUsers.put(userName,counter + 1);
    }

    //Define a getter method for to be able to get size of the hashMap
    public int getGreetedUsersSize() {
//        System.out.println(greetedUsers.size());
        return greetedUsers.size();
    }
}
