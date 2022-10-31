package TRJavaHWs.lesson9.hw;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    String del = " ";

    public Map<String, Object> parse(String s) {
        Map<String, Object> map = new HashMap<>();
        if (s.contains(del)) {
            Operations operation = Operations.valueOf(s.substring(0, s.indexOf(del)).toUpperCase());
            map.put("Operation", operation);
            if (s.split(del).length > 1) {
                map.put("Item or Category", s.substring(s.indexOf(del) + 1));
            }
        }
            else {
            map.put("Operation", s.toUpperCase());
        }

        return map;
    }
}
