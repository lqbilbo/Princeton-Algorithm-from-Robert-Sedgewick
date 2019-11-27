package leetcode;

import java.util.Arrays;

public class Solution11 {

    /**
     * two points
     * The intuition behind this approach is that the area formed between the lines will always be limited by the height
     * of the shorter line. Further, the farther the lines, the more will be the area obtained.
     *
     * We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines.
     * Futher, we maintain a variable \text{maxarea}maxarea to store the maximum area obtained till now. At every step,
     * we find out the area formed between them, update \text{maxarea}maxarea and move the pointer pointing to the
     * shorter line towards the other end by one step.
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    public static int arrayPairSum(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < (nums.length - 1); i = i + 2) {
            ans += Math.min(nums[i], nums[i+1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

        int[] nums = new int[]{1,8,6,2,5,4,3,7};
        System.out.println(arrayPairSum(nums));
    }
}
