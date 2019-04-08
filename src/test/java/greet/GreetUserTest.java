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
}
