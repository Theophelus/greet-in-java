package greet;

//import static org.junit.jupiter.api.AssertEquals.assertEquals;

import net.greet.greet.GreetUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetUserTest {
    @Test
    public void shouldBeAbleToGreetUser(){
        GreetUser greetUser = new GreetUser();
        assertEquals("Hello, Yegan", greetUser.greet("Yegan","english"));
    }

    @Test
    public void shouldGetOneForUserCounter(){
        GreetUser greetUser = new GreetUser();

        greetUser.greet("Yegan", "isixhosa");
        greetUser.greet("Ace", "english");
        greetUser.greet("Ace", "isizulu");

//        System.out.println(greetUser.getGreeted());

        assertEquals( 2, greetUser.getGreeted().size());
    }

    @Test
    public void shouldBeAbleToReturnTheSizeOfeTheMap(){

        GreetUser greetUser = new GreetUser();
        greetUser.greet("Yegan", "isixhosa");
        greetUser.greet("Ace", "english");
        greetUser.greet("Anele", "isizulu");
        greetUser.greet("Thabang", "isixhosa");
        greetUser.greet("Ace", "english");
        greetUser.greet("Mbali", "isizulu");

//        System.out.println(greetUser.getMapSize());

        assertEquals(5, greetUser.getMapSize());
    }
    @Test
    public void shouldBeToClearHashMap() {
        GreetUser greetUser = new GreetUser();
        //Push names into the hashMap
        greetUser.greet("Anele", "english");
        greetUser.greet("Anele", "isizulu");
        greetUser.greet("Anele","Isixhosa");
        greetUser.greet("Mbali","english");
        greetUser.clearAllUsersInTheMap();
        assertEquals(greetUser.getGreeted().size(), 0);
//        System.out.println("HashMap successfully clear" + " " + greetUser.getGreeted());
    }

    @Test
    public void shouldBeAbleToDeleteSpecificUser(){

        GreetUser greetUser = new GreetUser();
        //Push names into the hashMap
        greetUser.greet("Anele", "english");
        greetUser.greet("Anele", "isizulu");
        greetUser.greet("Anele","isixhosa");
        greetUser.greet("Yolanda","english");
        greetUser.greet("Mbali","english");
//        System.out.println(greetUser.getGreeted());
//        System.out.println("This user have been removed from the map" + " " + greetUser.deleteSpecificUsersInsideTheMap("Yolanda"));
        assertEquals( greetUser.getGreeted(), greetUser.deleteSpecificUsersInsideTheMap("Yolanda"));
//        System.out.println("Check how many users in the map" + " " + greetUser.getMapSize());

    }

}
