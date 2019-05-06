import net.greet.commands.CommandsProcessor;
import net.greet.dbCounter.CounterUsingJDBC;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandProcessorTests {
    CounterUsingJDBC greetUser = new CounterUsingJDBC();
//    GreetCounterUsingMap greetUser = new GreetCounterUsingMap();
    CommandsProcessor commandsProcessor = new CommandsProcessor();

    @Test
    public void shouldBeAbleToCheckGreatDefaultLang() throws NullPointerException {
        assertEquals("Molo, anele", commandsProcessor.execute("greet anele"));
    }
    @Test
    public void shouldBeAbleToGreetInEnglish() throws NullPointerException {
        assertEquals("Hello, mbali", commandsProcessor.execute("greet mbali english"));
    }
    @Test
    public void shouldBeAbleToCheckAllGreetedUsers() throws NullPointerException {
        assertEquals("All greeted users | " + " " + greetUser.getGreeted(), commandsProcessor.execute("greeted"));
    }
    @Test
    public void shouldBeAbleToCheckSpecificGreetedUser() throws NullPointerException {
            assertEquals("anele you have been greeted: " + greetUser.getSingleUser("anele") + " " + "time(s)",
                    commandsProcessor.execute("greeted anele"));
    }
    @Test
    public void shouldBeAbleToClearAllUsers() throws NullPointerException{
        assertEquals("All Users Have Been Deleted Successfully..!", commandsProcessor.execute("clear"));
    }
    @Test
    public void shouldBeAbleToClearSpecificUser() throws NullPointerException{
        assertEquals("anele Have Been Deleted Successfully..!", commandsProcessor.execute("clear anele"));
    }
    @Test
    public void shouldBeAbleToGetTheCounter(){
        try {
            assertEquals("There are | " + greetUser.getMapSize() + " | greeted users", commandsProcessor.execute("counter"));
        }catch (NullPointerException e){
            System.out.println("Error: " + e);
        }
    }
}
