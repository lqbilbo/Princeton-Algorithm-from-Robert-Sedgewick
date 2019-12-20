package libs.collection;

import java.util.*;

public class FastTreeMap {

    protected TreeMap map = null;

    protected boolean fast = false;

    public FastTreeMap() {
        super();
        this.map = new TreeMap<>();
    }

    public FastTreeMap(Comparator comparator) {
        super();
        this.map = new TreeMap(comparator);
    }

    public FastTreeMap(Map map) {
        super();
        this.map = new TreeMap(map);
    }

    public FastTreeMap(SortedMap map) {
        super();
        this.map = new TreeMap(map);
    }

    public boolean getFast() {
        return this.fast;
    }

    public void setFast(boolean fast) {
        this.fast = fast;
    }

    public Object get(Object key) {
        if (fast) {
            return map.get(key);
        } else {
            synchronized (map) {
                return map.get(key);
            }
        }
    }

    public int size() {
        if (fast) {
            return map.size();
        } else {
            synchronized (map) {
                return map.size();
            }
        }
    }

    public boolean isEmpty() {
        if (fast) {
            return map.isEmpty();
        } else {
            synchronized (map) {
                return map.isEmpty();
            }
        }
    }

    public boolean containsKey(Object key) {
        if (fast) {
            return map.containsKey(key);
        } else {
            synchronized (map) {
                return map.containsKey(key);
            }
        }
    }

    public boolean containsValue(Object value) {
        if (fast) {
            return map.containsValue(value);
        } else {
            synchronized (map) {
                return map.containsValue(value);
            }
        }
    }

    public Comparator comparator() {
        if (fast) {
            return map.comparator();
        } else {
            synchronized (map) {
                return map.comparator();
            }
        }
    }

    public Object firstKey() {
        if (fast) {
            return map.firstKey();
        } else {
            synchronized (map) {
                return map.firstKey();
            }
        }
    }

    public Object lastKey() {
        if (fast) {
            return map.lastKey();
        } else {
            synchronized (map) {
                return map.lastKey();
            }
        }
    }

    public Object put(Object key, Object value) {
        if (fast) {
            synchronized (this) {
                TreeMap temp = (TreeMap) map.clone();
                Object result = temp.put(key, value);
                map = temp;
                return result;
            }
        } else {
            synchronized (map) {
                return map.put(key, value);
            }
        }
    }

    public void putAll(Map in) {
        if (fast) {
            synchronized (this) {
                TreeMap temp = (TreeMap) map.clone();
                temp.putAll(in);
                map = temp;
            }
        } else {
            synchronized (map) {
                map.putAll(in);
            }
        }
    }

    public Object remove(Object key) {
        if (fast) {
            synchronized (this) {
                TreeMap temp = (TreeMap) map.clone();
                Object result = temp.remove(key);
                map = temp;
                return result;
            }
        } else {
            synchronized (map) {
                return map.remove(key);
            }
        }
    }

    public void clear() {
        if (fast) {
            synchronized (this) {
                map = new TreeMap<>();
            }
        } else {
            synchronized (map) {
                map.clear();
            }
        }
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Map)) {
            return false;
        }
        Map mo = (Map) o;

        if (fast) {
            if (mo.size() != map.size()) {
                return false;
            }
            Iterator i = map.entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry e = (Map.Entry) i.next();
                Object key = e.getKey();
                Object value = e.getValue();
                if (value == null) {
                    if (!(mo.get(key) == null && mo.containsKey(key))) {
                        return false;
                    }
                } else {
                    if (!value.equals(mo.get(key))) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            synchronized (map) {
                if (mo.size() != map.size()) {
                    return false;
                }
                Iterator i = map.entrySet().iterator();
                while (i.hasNext()) {
                    Map.Entry e = (Map.Entry) i.next();
                    Object key = e.getKey();
                    Object value = e.getValue();
                    if (value == null) {
                        if (!(mo.get(key) == null && mo.containsKey(key))) {
                            return false;
                        }
                    } else {
                        if (!value.equals(mo.get(key))) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
    }

    public int hashCode() {
        if (fast) {
            int h = 0;
            Iterator i = map.entrySet().iterator();
            while (i.hasNext()) {
                h += i.next().hashCode();
            }
            return h;
        } else {
            synchronized (map) {
                int h = 0;
                Iterator i = map.entrySet().iterator();
                while (i.hasNext()) {
                    h += i.next().hashCode();
                }
                return h;
            }
        }
    }

    public Object clone() {
        FastTreeMap results = null;
        if (fast) {
            results = new FastTreeMap(map);
        } else {
            synchronized (map) {
                results = new FastTreeMap(map);
            }
        }
        results.setFast(getFast());
        return results;
    }

    public SortedMap headMap(Object key) {
        if (fast) {
            return map.headMap(key);
        } else {
            synchronized (map) {
                return map.headMap(key);
            }
        }
    }

    public SortedMap subMap(Object fromKey, Object toKey) {
        if (fast) {
            return map.subMap(fromKey, toKey);
        } else {
            synchronized (map) {
                return map.subMap(fromKey, toKey);
            }
        }
    }

    public SortedMap tailMap(Object key) {
        if (fast) {
            return map.tailMap(key);
        } else {
            synchronized (map) {
                return map.tailMap(key);
            }
        }
    }
}
