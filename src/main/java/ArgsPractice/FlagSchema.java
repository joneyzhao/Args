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

    public String getFlag() {
        return flag;
    }

    public Object getDefaultValue(){
        return this.valueType.getDefaultValue();
    }

    public Object getType() {
        if(this.valueType == ValueType.BOOLEAN){
            return Boolean.TYPE;
        }
        if(this.valueType == ValueType.INTEGER){
            return Integer.TYPE;
        }
        if(this.valueType == ValueType.STRING){
            return String.class.getSimpleName();
        }
        return null;
    }
}
