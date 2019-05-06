import net.greet.commands.CommandExtractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandExtractorTests {

    @Test
    public void shouldBeAbleToCheckGreetCommand(){
        CommandExtractor commandExtractor = new CommandExtractor("greet");
        assertEquals("greet", commandExtractor.getCommand());
    }
    @Test
    public void shouldBeAbleToCheckCommandWithNameAndLang(){
        CommandExtractor commandExtractor = new CommandExtractor("greet anele english");
        assertEquals("greet anele english", commandExtractor.getCommand()  + " " + commandExtractor.getUserName() + " " + commandExtractor.getLang());
    }
    @Test
    public void shouldBeAbleToCheckCommandExtractorItHasNameThenReturnTrue(){
        CommandExtractor commandExtractor = new CommandExtractor("greet anele");
        assertEquals(true, commandExtractor.hasName());
    }
    @Test
    public void shouldBeAbleToCheckCommandExtractorHasLangThenReturnTrue(){
        CommandExtractor commandExtractor = new CommandExtractor("greet anele isixhosa");
        assertEquals(true, commandExtractor.hasLangauge());
    }
    @Test
    public void shouldBeAbleToCheckItGetCommandAndName(){
        CommandExtractor commandExtractor = new CommandExtractor("greet anele");
        assertEquals("greet", commandExtractor.getCommand());
        assertEquals("anele", commandExtractor.getUserName());
    }
}
