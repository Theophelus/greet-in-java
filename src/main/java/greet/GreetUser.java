package greet;

import java.util.Map;

public class GreetUser {

    Greet greets = new Greet();
    Greeted greeted = new Greeted();


    public String greet(String userName, String lang) {
        if (userName != "") greeted.setGreetedUsers(userName);
        return greets.greetUser(lang, userName);
    }

    //Define a method to get the size of the map
    public Map<String, Integer> getGreeted() {
        return greeted.getGreetedUsers();
    }
}
