package ArgsPractice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlagSchemaTest {
    @Test
    public void should_return_flag_when_getFlag_given_flagSchema(){
        FlagSchema flagSchema = new FlagSchema("l", ValueType.BOOLEAN);

        String flag = flagSchema.getFlag();
        assertEquals("l", flag);
    }

    @Test
    public void should_return_defaultValue_when_getDefaultValue_given_flagSchema(){
        FlagSchema flagSchema = new FlagSchema("l", ValueType.BOOLEAN);

        Object defaultValue = flagSchema.getDefaultValue();
        assertEquals(false, defaultValue);
    }

    @Test
    public void should_return_type_value_when_getType_given_flagSchema(){
        FlagSchema flagSchema = new FlagSchema("l", ValueType.BOOLEAN);

        Object type = flagSchema.getType();
//        assertEquals(Boolean.TYPE, type);
        assertEquals(ValueType.BOOLEAN, type);
    }

}
