package org.nandayo.dapi.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @since 1.5.1
 */
@SuppressWarnings("unused")
public abstract class AbstractMapManager<K, V> {
    protected final Map<K, V> MAP = new HashMap<>();

    public Set<K> keySet() {
        return MAP.keySet();
    }

    public Collection<V> values() {
        return MAP.values();
    }

    public boolean hasKey(K key) {
        return MAP.containsKey(key);
    }

    public V get(K key) {
        return MAP.get(key);
    }

    public void register(K key, V value) {
        MAP.put(key, value);
    }

    public void unregister(K key) {
        MAP.remove(key);
    }

    public void unregisterAll() {
        MAP.clear();
    }
}
