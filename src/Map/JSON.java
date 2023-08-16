package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JSON<T> {
    
    private Map<String, T> map;

    public JSON() {
        map = new HashMap<>();
    }

    public void add(String key, T value) {
        this.map.put(key, value);
    }

    public T get(String key) {
        return this.map.get(key);
    }

    // * To String
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        // El set de keys es un conjunto de strings
        Set<String> keys = this.map.keySet();
        for (String key : keys) {
            sb.append("\"");
            sb.append(key);
            sb.append("\"");
            sb.append(":");
            sb.append(this.map.get(key).toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
}
