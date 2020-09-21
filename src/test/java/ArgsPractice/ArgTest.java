package ArgsPractice;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ArgTest {
    @Test
    public void should_return_flag_when_getFlag_given_Arg() throws Exception {
        Set<FlagSchema> flagsSchema = new HashSet<>();
        flagsSchema.add(new FlagSchema("l", ValueType.BOOLEAN));
        flagsSchema.add(new FlagSchema("p", ValueType.INTEGER));
        flagsSchema.add(new FlagSchema("d", ValueType.STRING));

        Schema schema = new Schema(flagsSchema);

        Arg arg = new Arg("l true", schema);

        String flag = arg.getFlag();

        assertEquals("l", flag);
    }

    @Test
    public void should_return_Boolean_when_withFlag_given_Arg() throws Exception {
        Set<FlagSchema> flagsSchema = new HashSet<>();
        flagsSchema.add(new FlagSchema("l", ValueType.BOOLEAN));
        flagsSchema.add(new FlagSchema("p", ValueType.INTEGER));
        flagsSchema.add(new FlagSchema("d", ValueType.STRING));

        Schema schema = new Schema(flagsSchema);

        Arg arg = new Arg("l true", schema);

        Boolean flag = arg.withFlag("l");

        assertEquals(true, flag);
    }

    @Test
    public void should_return_defaultValue_when_parseValue_given_Arg() throws Exception {
        Set<FlagSchema> flagsSchema = new HashSet<>();
        flagsSchema.add(new FlagSchema("l", ValueType.BOOLEAN));
        flagsSchema.add(new FlagSchema("p", ValueType.INTEGER));
        flagsSchema.add(new FlagSchema("d", ValueType.STRING));

        Schema schema = new Schema(flagsSchema);

        Arg arg = new Arg("l ", schema);

        Object value = arg.parseValue();

        assertEquals(false, value);
    }

    @Test
    public void should_return_value_when_parseValue_given_Arg() throws Exception {
        Set<FlagSchema> flagsSchema = new HashSet<>();
        flagsSchema.add(new FlagSchema("l", ValueType.BOOLEAN));
        flagsSchema.add(new FlagSchema("p", ValueType.INTEGER));
        flagsSchema.add(new FlagSchema("d", ValueType.STRING));

        Schema schema = new Schema(flagsSchema);

        Arg arg = new Arg("l true", schema);

        Object value = arg.parseValue();

        assertEquals(true, value);
    }
}
