package ArgsPractice;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SchemaTest {
    @Test
    public void should_return_value_type_when_getTypeOf_given_flag() {
        Set<FlagSchema> flagsSchema = new HashSet<>();
        flagsSchema.add(new FlagSchema("l", ValueType.BOOLEAN));
        flagsSchema.add(new FlagSchema("p", ValueType.INTEGER));
        flagsSchema.add(new FlagSchema("d", ValueType.STRING));

        Schema schema = new Schema(flagsSchema);

        assertEquals(Boolean.TYPE, schema.getTypeOf("l"));
        assertEquals(Integer.TYPE, schema.getTypeOf("p"));
        assertEquals(String.class.getSimpleName(), schema.getTypeOf("d"));
    }

    @Test
    public void should_return_defaultValue_when_getDefaultValue_given_flag() {
        Set<FlagSchema> flagsSchema = new HashSet<>();
        flagsSchema.add(new FlagSchema("l", ValueType.BOOLEAN));
        flagsSchema.add(new FlagSchema("p", ValueType.INTEGER));
        flagsSchema.add(new FlagSchema("d", ValueType.STRING));

        Schema schema = new Schema(flagsSchema);

        assertEquals(false, schema.getDefaultValue("l"));
        assertEquals(0, schema.getDefaultValue("p"));
        assertEquals("", schema.getDefaultValue("d"));
    }
}
