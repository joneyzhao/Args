package ArgsPractice;

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

        String value = splitKeyValue[1];
        return value;
    }
}
