package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * JSON usando Map y HashMap
 * 
 * @param <K> Key
 * @param <V> Value
 * 
 * @since 2023-07-28
 * @version 1.0
 * 
 * @see Map
 * @see HashMap
 */

public class JSON<K, V> {
    private Map<K, V> map;

    public JSON() {
        this.map = new HashMap<K, V>();
    }

    /**
     * Agrega un nuevo par key-value
     * 
     * @param key   Key a agregar
     * @param value Value a agregar
     * @since 2023-07-28
     */
    public void add(K key, V value) {
        this.map.put(key, value);
    }

    /**
     * Obtiene el valor de una key
     * 
     * @param key Key a buscar
     * @return Value del key
     * @since 2023-07-28
     */
    public V get(K key) {
        return this.map.get(key);
    }

    /**
     * Obtiene todas las keys
     * 
     * @return Set<K> Conjunto de keys
     * @since 2023-07-28
     */
    public Set<K> getKeys() {
        return this.map.keySet();
    }

    @Override
    public String toString() {
        return this.map.toString();
    }
}