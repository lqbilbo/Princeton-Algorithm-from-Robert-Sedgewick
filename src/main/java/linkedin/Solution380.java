package linkedin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class Solution380 {

    LinkedList<Integer> list;
    Map<Integer, Integer> map;
    int i = 0;
    /** Initialize your data structure here. */
    public Solution380() {
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!list.contains(val)) {
            list.add(val);
            map.put(++i, val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (list.contains(val)) {
            list.removeFirstOccurrence(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random(i);
        if (random.nextInt() >= 1) {
            return list.get(random.nextInt() - 1);
        }
        return list.get(0);
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */

    public static void main(String[] args) {
        Solution380 solution380 = new Solution380();
        System.out.println(solution380.insert(1));
        System.out.println(solution380.remove(2));
        System.out.println(solution380.insert(2));
        System.out.println(solution380.getRandom());
        System.out.println(solution380.remove(1));
        System.out.println(solution380.insert(2));
        System.out.println(solution380.getRandom());
    }
}
