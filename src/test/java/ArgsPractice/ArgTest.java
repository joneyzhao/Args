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
    public void should_return_illegal_when_getFlag_m_given_Arg() {
        Arg arg = new Arg("m true", schema);

        String flag = null;
        try {
            flag = arg.getFlag();
        } catch (Exception e) {
            System.out.println("参数类型非法");
        }

        assertEquals(null, flag);
    }

    @Test
    public void should_return_Boolean_when_withFlag_given_Arg() throws Exception {
        Arg arg = new Arg("l true", schema);

        Boolean flag = arg.withFlag("l");

        assertEquals(true, flag);
    }

    @Test
    public void should_return_default_Value_when_parseValue_given_Arg() throws Exception {
        Arg argOne = new Arg("l ", schema);
        Arg argTwo = new Arg("p ", schema);
        Arg argThree = new Arg("d ", schema);

        Object defaultValueOne = argOne.parseValue();
        Object defaultValueTwo = argTwo.parseValue();
        Object defaultValueThree = argThree.parseValue();

        assertEquals(false, defaultValueOne);
        assertEquals(0, defaultValueTwo);
        assertEquals("", defaultValueThree);
    }

    @Test
    public void should_return_value_when_parseValue_given_Arg() throws Exception {
        Arg arg = new Arg("l true", schema);

        Object value = arg.parseValue();

        assertEquals(true, value);
    }

    @Test
    public void should_return_value_when_parseValue_given_wrong_Arg(){
        Arg arg = new Arg("p 80 80", schema);

        Object value = null;
        try {
            value = arg.parseValue();
        } catch (Exception e) {
            System.out.println("传入的参数value中间有空格");
        }

        assertEquals(null, value);
    }
}
