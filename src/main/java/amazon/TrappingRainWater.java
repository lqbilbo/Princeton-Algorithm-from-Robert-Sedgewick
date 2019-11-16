package amazon;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * 思路：使用two points，从左边开始获取最大覆盖的面积，从右边开始获取最大覆盖的面积，两个取最小并和原数组各个位置求差
 */
public class TrappingRainWater {

    static int trap(int[] height) {

        if (height.length == 0)  return 0;
        int ans = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = max(height[i], leftMax[i-1]);
        }
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
