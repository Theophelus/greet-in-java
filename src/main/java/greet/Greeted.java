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


    //Define a method to remove all users inside the map
    public Map<String, Integer> removeAllUsersInsideTheMap(String userName){
//        for (Map.Entry<String, Integer> i: greetedUsers.entrySet()) {
//            if (i.equals(userName)) {
//                greetedUsers.remove(i);
//            }
//       }

        return null;
    }


}

