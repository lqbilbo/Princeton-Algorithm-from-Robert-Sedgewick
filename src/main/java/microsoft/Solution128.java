package microsoft;

import java.util.*;

public class Solution128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        Arrays.sort(nums);
        int longestCons = 1, count = nums[0];
        List<Integer> consList = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - count > 1) {
                consList.add(longestCons);
                longestCons = 1;
            } else if (nums[i] == count) {
                continue;
            } else {
                longestCons++;
            }
            count = nums[i];
        }
        consList.add(longestCons);
        Collections.sort(consList);
        return consList.get(consList.size() - 1);
    }

    public int longestConsecutiveWithHashSet(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
