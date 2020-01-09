package airbnb;

import java.util.Arrays;

class Solution280 {

    /**
     * 时间复杂度： O(nlogn)
     * 空间复杂度： O(1)
     * @param nums
     */
    public void wiggleSortWithSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 时间复杂度： O(n)
     * 空间复杂度： O(1)
     * @param nums
     */
    public void wiggleSortWithOnePass(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }
}
