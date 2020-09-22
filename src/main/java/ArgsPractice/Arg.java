package ArgsPractice;

import java.util.Objects;

public class Arg {
    private final Schema schema;

    private String argPair;

    private String flag;

    public Arg(String argPair, Schema schema){
        this.argPair = argPair;
        this.schema = schema;
    }

    public Boolean withFlag(String flag){
        return null != schema.getTypeOf(flag);
    }

    public String getFlag() throws Exception {
        String [] splitKeyValue = this.argPair.split(" ");
        String flag = splitKeyValue[0];
        if (withFlag(flag)){
            return splitKeyValue[0];
        }
        throw new Exception("传入的参数不符合schema的flag类型要求！");
    }

    public Object parseValue() throws Exception {
        String [] splitKeyValue = this.argPair.split(" ");
        String flag = getFlag();
        Object defaultValue = schema.getDefaultValue(flag);

        if(splitKeyValue.length <= 1){
            return defaultValue;
        }

        Object type = schema.flagSchemas.stream()
                .filter(flagSchema -> flagSchema.equalsByFlag(flag))
                .findFirst()
                .get()
                .getType();

        if(Boolean.TYPE == type){
            return Boolean.valueOf(splitKeyValue[1]);
        }
        if(Integer.TYPE == type){
            return Integer.valueOf(splitKeyValue[1]);
        }
        if(String.class.getSimpleName() == type){
            return String.valueOf(splitKeyValue[1]);
        }

        String value = splitKeyValue[1];
        return value;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arg arg = (Arg) o;
        return Objects.equals(schema, arg.schema) &&
                Objects.equals(argPair, arg.argPair) &&
                Objects.equals(flag, arg.flag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schema, argPair, flag);
    }

}
