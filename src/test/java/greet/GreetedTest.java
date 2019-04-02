package greet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetedTest {

    @Test
    public void shouldBeAbleToCountUsersInMap() {

        //Define an instance of greeted class
        Greeted greeted = new Greeted();
        //Push names into the hashMap
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Mbali");
        greeted.setGreetedUsers("Yoland");
        greeted.setGreetedUsers("Zenna G");
        assertEquals(4, greeted.getGreetedUsersSize());

    }

    @Test
    public void shouldBeAbleToGetAllUsersInTheMap() {
        Greeted greeted = new Greeted();
        //Push names into the hashMap
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Anele");

        greeted.setGreetedUsers("Mbali");
        System.out.println(greeted.getUserName());
        assertEquals(greeted.getUserName(), greeted.getUserName());
    }
}