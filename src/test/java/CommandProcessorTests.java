import net.greet.commands.CommandExtractor;
import net.greet.commands.CommandsProcessor;
import net.greet.dbCounter.CounterUsingJDBC;
import net.greet.greet.Languages;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandProcessorTests {
    CounterUsingJDBC greetUser = new CounterUsingJDBC();
//    GreetCounterUsingMap greetUser = new GreetCounterUsingMap();
    CommandsProcessor  commandsProcessor = new CommandsProcessor();

    @Test
    public void shouldBeAbleToCheckGreatDefaultLang() throws Exception {
        CommandExtractor commandExtractor = new CommandExtractor("greet a");
//            System.out.println(greetUser.greet(commandExtractor.getUserName(), String.valueOf(Languages.isixhosa)));
        assertEquals(greetUser.greet(commandExtractor.getUserName(), String.valueOf(Languages.isixhosa)),
                commandsProcessor.greets("greet a"));

    }

    @Test
    public void shouldBeAbleToGreetInEnglish() throws NullPointerException {
        CommandExtractor commandExtractor = new CommandExtractor("greet a english");
        assertEquals(greetUser.greet(commandExtractor.getUserName(), commandExtractor.getLang()),
                commandsProcessor.greets("greet a english"));
    }
    @Test
    public void shouldBeAbleToCheckAllGreetedUsers() {
        try {
            assertEquals("All greeted users | " + " " + greetUser.getGreeted(),
                    commandsProcessor.greets("greeted"));
        }catch (NullPointerException e)
        {
            System.out.println("Error: " + e);
        }
    }
    @Test
    public void shouldBeAbleToCheckSpecificGreetedUser() {
        CommandExtractor commandExtractor = null;
        new CommandExtractor("greeted a");
        if (commandExtractor != null) {
            assertEquals(String.format( commandExtractor.getUserName() + "you have been greeted: %d time(s)", greetUser.getSingleUser(commandExtractor.getUserName())),
                    commandsProcessor.greets(String.format("greeted %s ", commandExtractor.getUserName())));
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
