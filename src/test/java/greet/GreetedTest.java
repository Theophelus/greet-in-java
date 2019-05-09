package greet;

import net.greet.greet.Greeted;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetedTest {

    @Test
    public void shouldBeAbleToCountUsersInMap() {

        Greeted greeted = new Greeted();
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Mbali");
        greeted.setGreetedUsers("Yoland");
        greeted.setGreetedUsers("Zenna G");
        assertEquals(4, greeted.getGreetedUsersSize());
    }

    @Test
    public void shouldBeAbleToRemoveAllUserInTheMap() {
        Greeted greeted = new Greeted();
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Mbali");
        greeted.removeAllUsersInTheMap();
        assertEquals(greeted.getGreetedUsers().size(), 0);
    }

    @Test
    public void shouldBeAbleToRemoveSpecificUser(){

        Greeted greeted = new Greeted();
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Mbali");
        greeted.setGreetedUsers("Unalo");
        assertEquals( greeted.getGreetedUsers(), greeted.removeSpecificUsersInsideTheMap("Mbali"));
    }
}