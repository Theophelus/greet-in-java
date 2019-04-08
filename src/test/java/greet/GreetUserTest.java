package greet;

//import static org.junit.jupiter.api.AssertEquals.assertEquals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetUserTest {
    @Test
    public void shouldBeAbleToGreetUser(){
        GreetUser greetUser = new GreetUser();
        assertEquals("Hello, Yegan", greetUser.greet("Yegan","English"));
    }

    @Test
    public void shouldGetOneForUserCounter(){
        GreetUser greetUser = new GreetUser();

        greetUser.greet("Yegan", "Isixhosa");
        greetUser.greet("Ace", "English");
        greetUser.greet("Ace", "IsiZulu");

        System.out.println(greetUser.getGreeted());

        assertEquals( 2, greetUser.getGreeted().size());
    }

    @Test
    public void shouldBeAbleToReturnTheSizeOfeTheMap(){

        GreetUser greetUser = new GreetUser();
        greetUser.greet("Yegan", "Isixhosa");
        greetUser.greet("Ace", "English");
        greetUser.greet("Anele", "IsiZulu");
        greetUser.greet("Thabang", "Isixhosa");
        greetUser.greet("Ace", "English");
        greetUser.greet("Mbali", "IsiZulu");

        System.out.println(greetUser.getMapSize());

        assertEquals(greetUser.getMapSize(), greetUser.getGreeted().size());
    }


}
