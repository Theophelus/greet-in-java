import net.greet.GreetCounter;
import net.greet.commands.CommandsProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CommandProcessorTests {
    GreetCounter greetUser = mock(GreetCounter.class);
    // GreetCounterUsingMap greetUser = new GreetCounterUsingMap();
    CommandsProcessor commandsProcessor = new CommandsProcessor(greetUser);

    @Test
    public void shouldBeAbleToCheckGreatDefaultLang(){

        // adding behaviour to the mock
        when(greetUser.greet("mbali", "isixhosa")).thenReturn("Molo, mbali");
        // acting
        assertEquals("Molo, mbali", commandsProcessor.execute("greet mbali"));
        // checking that the mock was called as expected
        verify(greetUser).greet("mbali", "isixhosa");
    }
    @Test
    public void shouldBeAbleToGreetInEnglish() {

        // adding behaviour to the mock
        when(greetUser.greet("mbali", "english")).thenReturn("Hello, mbali");
        // acting
        assertEquals("Hello, mbali", commandsProcessor.execute("greet mbali english"));
        // checking that the mock was called as expected
        verify(greetUser).greet("mbali", "english");
    }
    @Test
    public void shouldBeAbleToCheckAllGreetedUsers() {
        assertEquals("All greeted users | " + " " + greetUser.getGreeted(), commandsProcessor.execute("greeted"));
    }
    @Test
    public void shouldBeAbleToCheckSpecificGreetedUser() {

        when(greetUser.getSingleUser("anele")).thenReturn(7);

        assertEquals("anele you have been greeted: 7 time(s)",
                    commandsProcessor.execute("greeted anele"));

        verify(greetUser).getSingleUser("anele");
    }
    @Test
    public void shouldBeAbleToClearAllUsers() {
        assertEquals("All Users Have Been Deleted Successfully..!", commandsProcessor.execute("clear"));
    }
    @Test
    public void shouldBeAbleToClearSpecificUser() {
        assertEquals("anele Have Been Deleted Successfully..!", commandsProcessor.execute("clear anele"));
    }
    @Test
    public void shouldBeAbleToGetTheCounter(){
            // adding behaviour to the mock
            when(greetUser.getMapSize()).thenReturn((short) 0);
            assertEquals("There are | 0 | greeted users", commandsProcessor.execute("counter"));
            // checking that the mock was called as expected
            verify(greetUser).getMapSize();
    }
}
