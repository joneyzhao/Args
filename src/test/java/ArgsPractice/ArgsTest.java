package ArgsPractice;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArgsTest {
    @Test
    public void should_return_keyValues_when_scan_given_String(){
        String argsText = "-l true -p 8080 -d user/logs";
        Args args = new Args(argsText);

        List<KeyValuePair> KeyValuePairs = args.scan();

        assertEquals(3, KeyValuePairs.size());
        assertTrue(KeyValuePairs.contains(new KeyValuePair("l", "true")));
        assertTrue(KeyValuePairs.contains(new KeyValuePair("p", "8080")));
        assertTrue(KeyValuePairs.contains(new KeyValuePair("d", "user/logs")));
    }
}
