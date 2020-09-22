package ArgsPractice;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValueTypeTest {
    @Test
    public void should_return_DefaultValue_when_getDefaultValue_given_type(){

        assertEquals("BOOLEAN", ValueType.BOOLEAN.getType());
        assertEquals(false, ValueType.BOOLEAN.getDefaultValue());

        assertEquals("INTEGER", ValueType.INTEGER.getType());
        assertEquals(0, ValueType.INTEGER.getDefaultValue());

        assertEquals("STRING", ValueType.STRING.getType());
        assertEquals("", ValueType.STRING.getDefaultValue());
    }
}
