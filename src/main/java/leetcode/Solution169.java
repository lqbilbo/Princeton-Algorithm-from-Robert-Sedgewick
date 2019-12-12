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

    /* ******************************** divide & conquer *******************************************************/

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    /**
     * Intuition
     * If we know the majority element in the left and right halves of an array, we can determine which is the global
     * majority element in linear time.
     * we need to count the occurrences of the left and right majority elements to determine which sub slice's answer is
     * globally correct. The overall answer for the array is thus the majority element between indices 0 and n.
     *
     * 分别求出数组左边和右边的最多的元素，然后比较两者
     * @param nums
     * @return
     */
    public int majorityElementWithDivideAndConquer(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }


    /**
     * Intuition
     * If we had some way of counting instances of the majority element as +1 and instances of any other element as
     * −1, summing them would make it obvious that the majority element is indeed the majority element.
     * Essentially, what Boyer-Moore does is look for a suffix sufsuf of nums where suf[0]suf[0] is the majority element
     * in that suffix. To do this, we maintain a count, which is incremented whenever we see an instance of our current
     * candidate for majority element and decremented whenever we see anything else.
     *
     * 元素每次出现一次就+1，变为其他的时候-1
     *
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
