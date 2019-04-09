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

    //Define a method for help
    public void help(){
        System.out.println("Valid Commands");
        System.out.println("[ greet ] followed by the name and the language the user is to be greeted in, \n"
                + "[ greeted ] should display a list of all users that has been greeted and how many time each user has been greeted, \n"
                + "[ greeted ] followed by a username returns how many times that username have been greeted,\n"
                + "[ counter ] returns a count of how many unique users has been greeted, \n"
                + "[ clear ] deletes of all users greeted and the reset the greet counter to 0,\n"
                + "[ clear ] followed by a username delete the greet counter for the specified user and decrement the greet counter by 1, \n"
                + "[ exit ] exits the application,\n");
    }
}
