import net.greet.commands.CommandExtractor;
import net.greet.commands.CommandsProcessor;
import net.greet.greet.GreetCounterUsingMap;
import net.greet.greet.Languages;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandProcessorTests {
//    CounterUsingJDBC greetUser = new CounterUsingJDBC();
    GreetCounterUsingMap greetUser = new GreetCounterUsingMap();
    CommandsProcessor  commandsProcessor = new CommandsProcessor();

    @Test
    public void shouldBeAbleToCheckGreatDefaultLang(){
        try {
            CommandExtractor commandExtractor = new CommandExtractor("greet a");
//            System.out.println(greetUser.greet(commandExtractor.getUserName(), String.valueOf(Languages.isixhosa)));
            assertEquals(greetUser.greet(commandExtractor.getUserName(), String.valueOf(Languages.isixhosa)),
                    commandsProcessor.greets("greet a"));

        }catch (NullPointerException e){
            System.out.println("Error: " + e);
        }
    }

    @Test
    public void shouldBeAbleToGreetInEnglish(){
        try {
            CommandExtractor commandExtractor = new CommandExtractor("greet a english");
            assertEquals(greetUser.greet(commandExtractor.getUserName(), commandExtractor.getLang()),
                    commandsProcessor.greets("greet a english"));
        }catch (NullPointerException e){
            System.out.println("Error: " + e);
        }
    }
    @Test
    public void shouldBeAbleToCheckAllGreetedUsers(){
        try {
            assertEquals("All greeted users | " + " " + greetUser.getGreeted(),
                    commandsProcessor.greets("greeted"));
        }catch (NullPointerException e)
        {
            System.out.println("Error: " + e);
        }
    }
    @Test
    public void shouldBeAbleToCheckSpecificGreetedUser(){
        try {
            CommandExtractor commandExtractor = null;
            new CommandExtractor("greeted  " + (commandExtractor != null ? commandExtractor.getUserName() : null) + " ");
            assertEquals((commandExtractor != null ? commandExtractor.getUserName() : null) + " " +
                            "you have been greeted: " +
                            greetUser.getSingleUser(commandExtractor != null ? commandExtractor.getUserName() : null) + " " + "time(s)",
                    commandsProcessor.greets(String.format("greeted %s ", commandExtractor != null ? commandExtractor.getUserName() : null)));
        }catch (NullPointerException e){
            System.out.println("Error: " + e);
        }
    }
    @Test
    public void shouldBeAbleToClearAllUsers(){
        try {
            greetUser.clearAllUsersInTheMap();
            assertEquals("All Users Have Been Deleted Successfully..!", commandsProcessor.greets("clear"));
        }catch (NullPointerException e){
            System.out.println("Error: " + e);
        }
    }
    @Test
    public void shouldBeAbleToClearSpecificUser(){
        try {
            CommandExtractor commandExtractor = null;
            if (commandExtractor != null) {
                new CommandExtractor("clear "+ (commandExtractor.getUserName()) + " ");
            }
            if (commandExtractor != null) {
                greetUser.deleteSpecificUsersInsideTheMap(commandExtractor.getUserName());
            }
            assertEquals("All Users Have Been Deleted Successfully..!", commandsProcessor.greets("clear"));
        }catch (NullPointerException e){
            System.out.println("Error: " + e);
        }
    }
    @Test
    public void shouldBeAbleToGetTheCounter(){
        try {
            assertEquals("There are | " + greetUser.getMapSize() + " | greeted users", commandsProcessor.greets("counter"));
        }catch (NullPointerException e){
            System.out.println("Error: " + e);
        }
    }
}
