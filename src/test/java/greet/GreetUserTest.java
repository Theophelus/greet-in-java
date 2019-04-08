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
    @Test
    public void shouldBeToClearHashMap() {
        GreetUser greetUser = new GreetUser();
        //Push names into the hashMap
        greetUser.greet("Anele", "English");
        greetUser.greet("Anele", "IsiZulu");
        greetUser.greet("Anele","Isixhosa");
        greetUser.greet("Mbali","English");
        greetUser.clearAllUsersInTheMap();
        assertEquals(greetUser.getGreeted().size(), 0);
        System.out.println("HashMap successfully clear" + " " + greetUser.getGreeted());
    }

    @Test
    public void shouldBeAbleToDeleteSpecificUser(){

        GreetUser greetUser = new GreetUser();
        //Push names into the hashMap
        greetUser.greet("Anele", "English");
        greetUser.greet("Anele", "IsiZulu");
        greetUser.greet("Anele","Isixhosa");
        greetUser.greet("Yolanda","English");
        greetUser.greet("Mbali","English");
        System.out.println(greetUser.getGreeted());
        System.out.println("This user have been removed from the map" + " " + greetUser.deleteSpecificUsersInsideTheMap("Yolanda"));
        assertEquals( greetUser.getGreeted(), greetUser.deleteSpecificUsersInsideTheMap("Yolanda"));
        System.out.println("Check how many users in the map" + " " + greetUser.getMapSize());

    }


}
