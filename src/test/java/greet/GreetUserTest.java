package greet;

import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.AssertEquals.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetUserTest {
    @Test
    public void shouldBeAbleToGreetUser(){
        GreetUser greetUser = new GreetUser("","");
        assertEquals("Hello, Yegan", greetUser.greet("Yegan"));
    }

//    @Test
//    public void shouldGetOneForUserCounter(){
//        GreetUser greetUser = new GreetUser(greet, greeted);
//        greetUser.greet("Yegan");
//        assertEquals("Yegan greet count: 1", greetUser.greeted("Yegan"));
//
//    }

}
