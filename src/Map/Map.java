package Map;

import LinkedList.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Map<K, V> {

    private class Entry {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // ! ---------------------------------------------

    private LinkedList<Entry> linkedList;

    public Map() {
        linkedList = new LinkedList<>();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int size() {
        return linkedList.size();
    }

    public V get(K key) {
        for (Entry entry : linkedList) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (Entry entry : linkedList) {
            set.add(entry.key);
        }
        return set;
    }

    // Add a key-value pair to the map
    public void add(K key, V value) {
        linkedList.add(new Entry(key, value));
    }

    // Put a value for a specific key in the map
    public void put(K key, V value) {
        for (Entry entry : linkedList) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        // If the key does not exist, add a new entry
        add(key, value);
    }

}

