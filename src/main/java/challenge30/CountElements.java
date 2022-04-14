package challenge30;

import java.util.HashMap;
import java.util.HashSet;

public class CountElements {
    public int countElements(int[] arr) {
        int ans = 0;
        HashSet<Integer> hashSet = new HashSet();
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i : arr) {
            hashSet.add(i);
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i)+1);
            } else {
                hashMap.put(i, 1);
            }
        }
        for (int i : hashSet) {
            if (hashSet.contains(i+1)) {
                ans = ans + hashMap.get(i);
            }
        }
        return ans;
    }
}
