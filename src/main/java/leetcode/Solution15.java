package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

    /**
     * 3Sum
     * todo memory the code template of two points
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums);
        for (int k = 0; k < len; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k-1]) continue;
            int i = k + 1;
            int j = len - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    i++;
                } else if (sum > 0) {
                    j--;
                } else {
                    ans.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i+1]) i++;
                    while (i < j && nums[j] == nums[j-1]) j--;
                    i++;
                    j--;
                }
            }
        }
        return ans;
    }
}
