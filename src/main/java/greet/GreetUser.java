package greet;

public class GreetUser {

    private Greet greet;
    private Greeted greeted;

    public  GreetUser(Greet greet, Greeted greeted){
        this.greet = greet;
        this.greeted = greeted;
    }

    public String greet(String userName) {
        if (userName != "") greeted.setGreetedUsers(userName);
        return greet.greetUser(Languages.valueOf(userName).getLang(), userName);
    }
}
