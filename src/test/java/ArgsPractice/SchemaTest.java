package ArgsPractice;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SchemaTest {
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
    public void should_return_value_type_when_getTypeOf_given_flag() {
        assertEquals(ValueType.BOOLEAN, schema.getTypeOf("l"));
        assertEquals(ValueType.INTEGER, schema.getTypeOf("p"));
        assertEquals(ValueType.STRING, schema.getTypeOf("d"));
    }

    @Test
    public void should_return_defaultValue_when_getDefaultValue_given_flag() {
        assertEquals(false, schema.getDefaultValue("l"));
        assertEquals(0, schema.getDefaultValue("p"));
        assertEquals("", schema.getDefaultValue("d"));
    }
}
