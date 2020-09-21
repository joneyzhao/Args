package ArgsPractice;

public class FlagSchema {
    private final String flag;
    private final ValueType valueType;

    public FlagSchema(String flag, ValueType valueType){
        this.flag = flag;
        this.valueType = valueType;
    }

    public boolean equalsByFlag(String flag) {
        return flag.equalsIgnoreCase(this.flag);
    }

    public ValueType getType() {
        return this.valueType;
    }
}
