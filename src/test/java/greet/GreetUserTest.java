package greet;

//import static org.junit.jupiter.api.AssertEquals.assertEquals;

import net.greet.greet.GreetCounterUsingMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetUserTest {
    @Test
    public void shouldBeAbleToGreetUser(){
        GreetCounterUsingMap greetUser = new GreetCounterUsingMap();
        assertEquals("Hello, Yegan", greetUser.greet("Yegan","english"));
    }

    @Test
    public void shouldGetOneForUserCounter(){
        GreetCounterUsingMap greetUser = new GreetCounterUsingMap();

        greetUser.greet("Yegan", "isixhosa");
        greetUser.greet("Ace", "english");
        greetUser.greet("Ace", "isizulu");
        assertEquals( 2, greetUser.getGreeted().size());
    }

    @Test
    public void shouldBeAbleToReturnTheSizeOfeTheMap(){

        GreetCounterUsingMap greetUser = new GreetCounterUsingMap();
        greetUser.greet("Yegan", "isixhosa");
        greetUser.greet("Ace", "english");
        greetUser.greet("Anele", "isizulu");
        greetUser.greet("Thabang", "isixhosa");
        greetUser.greet("Ace", "english");
        greetUser.greet("Mbali", "isizulu");
        assertEquals(5, greetUser.getMapSize());
    }
    @Test
    public void shouldBeToClearHashMap() {
        GreetCounterUsingMap greetUser = new GreetCounterUsingMap();
        //Push names into the hashMap
        greetUser.greet("Anele", "english");
        greetUser.greet("Anele", "isizulu");
        greetUser.greet("Anele","isixhosa");
        greetUser.greet("Mbali","english");
        greetUser.clearAllUsersInTheMap();
        assertEquals(greetUser.getGreeted().size(), 0);
    }

    @Test
    public void shouldBeAbleToDeleteSpecificUser(){

        GreetCounterUsingMap greetUser = new GreetCounterUsingMap();
        greetUser.greet("Anele", "english");
        greetUser.greet("Anele", "isizulu");
        greetUser.greet("Anele","isixhosa");
        greetUser.greet("Yolanda","english");
        greetUser.greet("Mbali","english");
        assertEquals( greetUser.getGreeted(), greetUser.deleteSpecificUsersInsideTheMap("Yolanda"));
    }

}
