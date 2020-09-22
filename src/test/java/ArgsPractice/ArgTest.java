package ArgsPractice;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ArgTest {
    private Schema schema;

    @Before
    public void init(){
        Set<FlagSchema> flagsSchema = new HashSet<>();
        flagsSchema.add(new FlagSchema("l", ValueType.BOOLEAN));
        flagsSchema.add(new FlagSchema("p", ValueType.INTEGER));
        flagsSchema.add(new FlagSchema("d", ValueType.STRING));

        schema = new Schema(flagsSchema);
    }

    @Test
    public void should_return_flag_when_getFlag_given_Arg() throws Exception {
        Arg arg = new Arg("l true", schema);

        String flag = arg.getFlag();

        assertEquals("l", flag);
    }

    @Test
    public void should_return_Boolean_when_withFlag_given_Arg() throws Exception {
        Arg arg = new Arg("l true", schema);

        Boolean flag = arg.withFlag("l");

        assertEquals(true, flag);
    }

    @Test
    public void should_return_defaultValue_when_parseValue_given_Arg() throws Exception {
        Arg arg = new Arg("l ", schema);

        Object value = arg.parseValue();

        assertEquals(false, value);
    }

    @Test
    public void should_return_value_when_parseValue_given_Arg() throws Exception {
        Arg arg = new Arg("l true", schema);

        Object value = arg.parseValue();

        assertEquals(true, value);
    }
}
