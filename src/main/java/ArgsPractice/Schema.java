package ArgsPractice;

import java.util.Set;

public class Schema {
    public Set<FlagSchema> flagSchemas;

    public Schema(Set<FlagSchema> flagSchemas){
        this.flagSchemas = flagSchemas;
    }

    public Object getTypeOf(String flag) {
        return flagSchemas.stream()
                .filter(flagSchema -> flagSchema.equalsByFlag(flag))
                .findFirst()
                .get()
                .getType();
    }

    public Object getDefaultValue(String flag){
        return flagSchemas.stream()
                .filter(flagSchema -> flagSchema.getFlag().equals(flag))
                .findFirst()
                .get()
                .getDefaultValue();
    }


}
