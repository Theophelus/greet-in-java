package greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GreetTests {
    Greet greet = new Greet();
    @Test
    public void shouldBeAbleToGreetUserInIsiXhosa(){

        assertEquals("Molo, Anele", greet.greetUser("Isixhosa", "Anele"));
    }
    @Test
    public void shouldBeAbleToGreetUserInEnglish(){

        assertEquals("Hello, Mbali", greet.greetUser("English", "Mbali"));
    }
    @Test
    public void shouldBeAbleToGreetUserInIsZulu(){

        assertEquals("Sawubona, Yolanda", greet.greetUser("IsiZulu", "Yolanda"));
    }
}
