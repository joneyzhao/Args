package ArgsPractice;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SchemaTest {
    @Test
    public void should_return_value_type_when_given_flag() {
        Set<FlagSchema> flagsSchema = new HashSet<>();
        flagsSchema.add(new FlagSchema("l", Boolean.TYPE));
        flagsSchema.add(new FlagSchema("p", Integer.TYPE));
        flagsSchema.add(new FlagSchema("d", String.class.getSimpleName()));

        Schema schema = new Schema(flagsSchema);

        assertEquals(Boolean.TYPE, schema.getTypeOf("l"));
        assertEquals(Integer.TYPE, schema.getTypeOf("p"));
        assertEquals(String.class.getSimpleName(), schema.getTypeOf("d"));
    }
}
