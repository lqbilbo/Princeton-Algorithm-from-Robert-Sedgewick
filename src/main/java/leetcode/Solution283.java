package leetcode;

public class Solution283 {

    /**
     * double point
     */
    public void moveZeroes1(int[] nums) {
        int head = 0;
        int tail = 1;
        while(tail < nums.length) {
            if(nums[head] == 0 && nums[tail] != 0 ) {
                int temp = nums[tail];
                nums[tail] = nums[head];
                nums[head] = temp;
                head++;
            } else if(nums[head] != 0) {
                head++;
            }
            tail++;
        }
    }

    /**
     * snow ball swap
     * swap the non-zero num with left most zero num
     */
    public void moveZeroes2(int[] nums) {
        int snowBallSize = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                snowBallSize++;
            }
            else if (snowBallSize > 0) {
                nums[i-snowBallSize] = nums[i];
                nums[i]=0;
            }
        }
    }

    /**
     * todo memorize the code template
     */
    public void moveZeroes3(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
    // find non-zero num
    // attribute nums[i] to nums[j](the last non-zero index)
    // if i not equals j, attribute zero to num[i]
    // j++
}

