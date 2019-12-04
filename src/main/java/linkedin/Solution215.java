package linkedin;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution215 {

    public static int findKthLargest(int[] nums, int k) {
        /*Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i=0; i<nums.length; i++) {
            queue.offer(nums[i]);
        }

        int ans = 0;
        int hit = 1;
        while (!queue.isEmpty()) {
            if (hit == k) {
                ans = queue.poll();
                return ans;
            } else {
                queue.poll();
                hit++;
            }
        }
        return ans;*/
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<>(Comparator.comparingInt(n -> n));

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}

