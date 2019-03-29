package greet;

public interface GreetMethods {
    /*
    Define abstract methods.
    to be able to: greetUsers, Display all users and with specific counters,
     */
//    Languages languages();
    String greetUser(String username, String language);
    String greeted();
    void exit();
    void help();
}
