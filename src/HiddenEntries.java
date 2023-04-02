import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HiddenEntries {
    public static Map<String, String> map = new HashMap<>();
    public static final Set<String> HIDDEN_KEY = new HashSet<>();

    public String filterKeyToString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        List<Map.Entry<String, String>> entries = new ArrayList<>();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            if (!HIDDEN_KEY.contains(entry.getKey())) {
                entries.add(entry);
            }
        }
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<String, String> entry = entries.get(i);
            appendEntry(sb, entry);
            if (i != entries.size() - 1) {
                sb.append(",\n");
            }
        }
        return sb.toString();
    }
    private void appendEntry(StringBuilder sb, Map.Entry<String, String>  entry) {
        sb.append("\"");
        sb.append(entry.getKey());
        sb.append("\" ").append("=").append(" \"");
        sb.append(entry.getValue());
        sb.append("\"");
    }

    public static void main(String[] args) {
        map.put("1", "1234");
        map.put("2", "233");
        map.put("tewt", "asdf");
        map.put("5asga1", "11");
        map.put("151421", "11");
        map.put("5asfgggdf", "1234");
        map.put("yer6555", "1234");
        HIDDEN_KEY.add("1");
        HIDDEN_KEY.add("2");
        HIDDEN_KEY.add("151421");
        HIDDEN_KEY.add("yer6555");
        HiddenEntries hiddenEntries = new HiddenEntries();
        String mapString = hiddenEntries.filterKeyToString();
        System.out.println(mapString);
    }
}