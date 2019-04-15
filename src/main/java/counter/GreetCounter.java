package counter;

import java.util.Map;

public interface GreetCounter {
    String greet(String userName, String lang);
    Map<String, Integer> getGreeted();
}
