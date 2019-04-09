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

//        Greet greet = new Greet();
//        greet.greetUser("Isixhosa","Sphokazi");
//        assertEquals(greeted.getGreetedUsersSize(), 5);

    }

    @Test
    public void shouldBeAbleToGreetUserAndAddItToTheMap(){


    }

    @Test
    public void shouldBeAbleToRemoveAllUserInTheMap() {
        Greeted greeted = new Greeted();
        //Push names into the hashMap
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Mbali");
        greeted.removeAllUsersInTheMap();
        assertEquals(greeted.getGreetedUsers().size(), 0);
//        System.out.println("HashMap successfully clear" + " " + greeted.getGreetedUsers());
    }

    @Test
    public void shouldBeAbleToRemoveSpecificUser(){

        Greeted greeted = new Greeted();
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Anele");
        greeted.setGreetedUsers("Mbali");
        greeted.setGreetedUsers("Unalo");
//        System.out.println("This user have been removed from the map" + " " + greeted.removeSpecificUsersInsideTheMap("Mbali"));
        assertEquals( greeted.getGreetedUsers(), greeted.removeSpecificUsersInsideTheMap("Mbali"));

//        System.out.println("Check how many users in the map" + " " + greeted.getGreetedUsersSize());

    }
}