package greet;

import java.util.HashMap;
import java.util.Map;

public class Greet implements GreetMethods{


    /*
    Define a linkList to hold an name and with selected language
    Define a property called username and language enum as an Object
    Define a constructor that will take username and Language Enum as params
     */

    private Map<String, String> greetedNames = new HashMap<>();
    private final Languages languages;
    private String userName;

    public Greet(String userName, Languages languages){
        this.userName = userName;
        this.languages = languages;
    }


    @Override
    public String greetUser(String username, String language) {

        if (username != "") {
//            username = userName;
//            if (greetedNames.containsKey(username)) {
                greetedNames.put(username, language);
            }
//        }

        //check if entered language is true increment the counter and return greetings

        return null;
    }

    @Override
    public String greeted() {
        return null;
    }

    @Override
    public void exit() {

    }

    @Override
    public void help() {
    }

//    @Override
//    public Languages languages() {
//        return lang;
//    }
}
