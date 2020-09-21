package ArgsPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Args {
    private String argsText;

    public Args(String argsText) {
        this.argsText = argsText;
    }

    public List<KeyValuePair> scan() {
        List<String> keyValues = Arrays.asList(argsText.split("-"));
        keyValues = keyValues.stream()
                .map(keyValue -> keyValue.trim())
                .collect(Collectors.toList());
        keyValues = keyValues.subList(1, keyValues.size());

        return getKeyValuePairs(keyValues);
    }

    private List<KeyValuePair> getKeyValuePairs(List<String> keyValues) {
        List<KeyValuePair> keyValuePairs = new ArrayList<>();
        keyValues.forEach(keyValue -> {
            String [] splitKeyValue = keyValue.split(" ");
            String key = splitKeyValue[0];
            String value = splitKeyValue[1];
            keyValuePairs.add(new KeyValuePair(key, value));
        });
        return keyValuePairs;
    }
}
