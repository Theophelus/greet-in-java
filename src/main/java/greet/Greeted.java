package greet;

import java.util.HashMap;
import java.util.Iterator;
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
        Check if Map containKey, if true get the key n initialise it to zero
        else if already exists increment the counter.
         */
        Integer counter = greetedUsers.containsKey(this.userName) ? greetedUsers.get(this.userName) : 0;
        greetedUsers.put(this.userName,counter +1);
        /*
        //Second approach:
        //get value of specific key
            Integer counter = greetedUsers.get(this.userName);
        //check if hashMap contain no
        //then initialize it to zero
            if(counter == null) greetedUsers.put(this.userName, 1);
            else
                //increment the key value by 1
                greetedUsers.put(this.userName, counter + 1);
         */
    }

    //Define a getter method for to be able to get size of the hashMap
    public int getGreetedUsersSize() {
        return greetedUsers.size();
    }

    //Define a method to return all the names inside the list
    public Map<String, Integer> getGreetedUsers() {
        return greetedUsers;
    }


    //Define a method to remove specific  users inside the map
    public Map<String, Integer> removeSpecificUsersInsideTheMap(String userName){

        /*
        1) Get the iterator over the HashMap/create iterator
        2) Loop over the HashMap
        3) Check if current key is the HashMap
        4) If it exits remove it
        5) Return the HashMap
         */

        Iterator<String> user = greetedUsers.keySet().iterator();
        while (user.hasNext()) if (user.next().contains(userName)) user.remove();
        return greetedUsers;

    }
    //Define a method to remove all users
    public void removeAllUsersInTheMap(){
        greetedUsers.clear();
//        getGreetedUsers().clear();
    }
}

