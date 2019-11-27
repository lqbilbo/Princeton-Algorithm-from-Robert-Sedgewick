package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution169 {

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * Intuition
     * If we had some way of counting instances of the majority element as +1+1 and instances of any other element as
     * -1−1, summing them would make it obvious that the majority element is indeed the majority element.
     * @param nums
     * @return
     */
    public static int majorityElementWithBMVoting(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElementWithBMVoting(nums));
    }
}
