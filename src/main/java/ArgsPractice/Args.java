package ArgsPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Args {

    private List<Arg> argList = new ArrayList<>();
    private String argsText;
    private Schema schema;

    public Args(String argsText, Schema schema) {
        this.argsText = argsText;
        this.schema = schema;
    }

    public List mapToArgPairs() {
        List<String> argPairsList = Arrays.asList(argsText.split("-"));
        argPairsList = argPairsList.stream()
                .map(keyValue -> keyValue.trim())
                .collect(Collectors.toList());
        argPairsList = argPairsList.subList(1, argPairsList.size());

        return argPairsList;
    }

    public List<Arg> getArgList(List<String> argPairs) {
        argPairs.forEach(argPair -> {
            argList.add(new Arg(argPair, schema));
        });
        System.out.println(argList);
        return argList;
    }

    public Object getValueOf(String flag) throws Exception {
        getArgList(mapToArgPairs());
        return argList.stream()
                .filter(arg -> {
                    try {
                        return arg.getFlag().equals(flag);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .findFirst()
                .get()
                .parseValue();
    }
}
