package learn;

import java.util.Arrays;

public class MergeSortTest {

    public static int[] sortArray(int[] nums) {
        int[] dst = new int[nums.length];
        dst = Arrays.copyOf(nums, nums.length);
        mergeSort(nums, dst, 0, nums.length);
        return dst;
    }

    private static void mergeSort(int[] src, int[] dst, int start, int end) {
        if (start + 1 >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(dst, src, start, mid);
        mergeSort(dst, src, mid, end);

        int i = start, j = mid, k = start;
        while (i < mid || j < end)  {
            if (j == end || (i < mid && src[i] < src[j])) {
                dst[k++] = src[i++];
            } else {
                dst[k++] = src[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] dst = sortArray(new int[]{3,5,1,4,2,6});
        for (int d : dst) {
            System.out.print(d + ",");
        }
    }
}
