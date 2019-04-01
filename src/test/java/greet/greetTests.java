package greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class greetTests {

    @Test
    public void shouldBeAbleToGreetUserInIsiXhosa(){

        Greet greet = new Greet();
        assertEquals("Molo, Anele", greet.greetUser("Isixhosa", "Anele"));
    }
    @Test
    public void shouldBeAbleToGreetUserInEnglish(){

        Greet greet = new Greet();
        assertEquals("Hello, Mbali", greet.greetUser("English", "Mbali"));
    }
    @Test
    public void shouldBeAbleToGreetUserInIsZulu(){

        Greet greet = new Greet();
        assertEquals("Sawubona, Yolanda", greet.greetUser("IsiZulu", "Yolanda"));
    }
}
