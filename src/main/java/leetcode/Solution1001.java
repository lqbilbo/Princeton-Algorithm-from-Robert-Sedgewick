package leetcode;

import java.util.PriorityQueue;

public class Solution1001 {

    public int maxSum(int[] a, int k) {
        // Create a priority queue and insert all array elements
        // int
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : a)
            pq.add(x);

        while (k-- > 0) {
            // Retrieve and remove min element
            int temp = pq.poll();

            // Modify the minimum element and add back
            // to priority queue
            temp *= -1;
            pq.add(temp);
        }

        // Compute sum of all elements in priority queue.
        int sum = 0;
        for (int x : pq)
            sum += x;
        return sum;
    }

    // function to maximize array
    // sum after k negations.
    static void maxSumAfterNegation(int[] a,int k){

        int minPos = Integer.MAX_VALUE, sum = 0, index = -1;

        for(int i = 0; i < a.length; i++){

            // Do k negations by removing a minimum element k times
            if(k < 0){
                break;
            }

            if(a[i] < 0){
                a[i]=-a[i];
                k--;
            }

            if(a[i] < minPos && a[i] > -1){
                minPos = a[i];
                index = i;
            }
            // Compute sum of all elements
            sum+=a[i];
        }

        for(int i = k; i > 0; i--){
            a[index]=-a[index];
        }

		/*for(int i:a){
			sum+=i;
		}*/

        sum+=(2*a[index]);

        System.out.print(sum);
    }

    //Driver code
    public static void main(String[] args) {

        int[] a= {-2, 0, 5, -1, 2} ;
        maxSumAfterNegation(a, 4);

    }
}
