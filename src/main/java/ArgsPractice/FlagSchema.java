package ArgsPractice;

public class FlagSchema {
    private final String flag;
    private final Object type;

    public FlagSchema(String flag, Object type){
        this.flag = flag;
        this.type = type;
    }

    public boolean equalsByFlag(String flag) {
        return flag.equalsIgnoreCase(this.flag);
    }

    public Object getType() {
        return this.type;
    }
}
