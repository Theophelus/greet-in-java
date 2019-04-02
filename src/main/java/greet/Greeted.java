package greet;

import java.util.HashMap;
import java.util.Map;

public class Greeted {

    //Define a hashMap storage to hold each user with specific name and userName
    private Map<String, Integer> greetedUsers = new HashMap<>();
    private String userName;


    //Define a setter method that will be able to push users in the HashMap Map with specific.

    public void setGreetedUsers(String userName) {

//
        if (this.userName != "") this.userName = userName;
        /*
        Check if user already in a Map, if not add it
        else if already exists increment the counter.
         */
        Integer counter = greetedUsers.containsKey(this.userName) ? greetedUsers.get(this.userName) : 0;
        greetedUsers.put(this.userName,counter +1);

        /*
        Second approach:
        //get value of specific key
            Integer counter = greetedUsers(this.userName);
        //check if hashMap contain no
        //then initialize it to zero
            if(counter == null) counter = 0;
        //increment the key value by 1
            greetedUser.put(this.userName, counter + 1);
         */
    }

    //Define a getter method for to be able to get size of the hashMap
    public int getGreetedUsersSize() {
//        System.out.println(greetedUsers.size());
        return greetedUsers.size();
    }
}

