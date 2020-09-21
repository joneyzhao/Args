package ArgsPractice;

public enum ValueType {
    BOOLEAN("false"),
    INTEGER("0"),
    STRING("");


    private final Object defaultValue;

    ValueType(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public String getType() {
        return this.name();
    }
}
