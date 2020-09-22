package ArgsPractice;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArgsTest {

    private Args args;
    private Schema schema;

    @Before

    public void init(){
        String argsText = "-l true -p 8080 -d user/logs";

        Set<FlagSchema> flagsSchema = new HashSet<>();
        flagsSchema.add(new FlagSchema("l", ValueType.BOOLEAN));
        flagsSchema.add(new FlagSchema("p", ValueType.INTEGER));
        flagsSchema.add(new FlagSchema("d", ValueType.STRING));

        schema = new Schema(flagsSchema);

        args = new Args(argsText, schema);
    }

    @Test
    public void should_return_ArgPairs_when_mapToArgPairs_given_String(){

        List argPairs = args.mapToArgPairs();

        List<String> expectArgPairs = Arrays.asList("l true", "p 8080", "d user/logs");

        assertEquals(expectArgPairs, argPairs);
    }

    @Test
    public void should_return_argPairsList_when_getArgPairsList_given_String() throws Exception {

        List<String> argPairs = args.mapToArgPairs();

        List<Arg> argList = args.getArgList(argPairs);

        assertEquals(3, argList.size());
        assertTrue(argList.contains(new Arg("l true", schema)));
        assertTrue(argList.contains(new Arg("p 8080", schema)));
        assertTrue(argList.contains(new Arg("d user/logs", schema)));
    }

    @Test
    public void should_return_arg_value_when_getValueOf_given_String() throws Exception {

        Object booleanValue = args.getValueOf("l");
        Object integerValue = args.getValueOf("p");
        Object StringValue = args.getValueOf("d");

        assertEquals(true, booleanValue);
        assertEquals(8080, integerValue);
        assertEquals("user/logs", StringValue);
    }
}
