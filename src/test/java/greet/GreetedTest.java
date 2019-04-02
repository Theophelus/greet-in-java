package greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetedTest {

    @Test
    public void shouldBeAbleToCountUsersInMap(){


        //Define an instance of greeted class
        Greeted greeted = new Greeted();
        //Push names into the hashMap
        greeted.setGreetedUsers("Anele");
//        greeted.setGreetedUsers("Mbali");
        assertEquals(1, greeted.getGreetedUsersSize());

    }
}
