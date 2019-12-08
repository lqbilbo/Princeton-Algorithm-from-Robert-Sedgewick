package linkedin;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution432 {


    Map<String, Integer> map;
    Map<Integer, String> maxAndminMap;
    int max;
    int min;
    /** Initialize your data structure here. */
    public Solution432() {
        map = new TreeMap<>();
        maxAndminMap = new HashMap<>();
        max = 0;
        min = Integer.MAX_VALUE;
    }

    private void setMapItem(String key) {
        if (map.get(key) > max) {
            max = map.get(key);
            maxAndminMap.put(0, key);
        }
        if (map.get(key) < min) {
            min = map.get(key);
            maxAndminMap.put(1, key);
        }
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.get(key) == null) {
            map.put(key, 1);
        } else {
            map.put(key, map.get(key) + 1);
        }
        setMapItem(key);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (map.get(key) == null) {
            return;
        } else if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
        setMapItem(key);
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (maxAndminMap.size() > 0) {
            return maxAndminMap.get(0);
        }
        return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (maxAndminMap.size() > 1) {
            return maxAndminMap.get(1);
        }
        return "";
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}
