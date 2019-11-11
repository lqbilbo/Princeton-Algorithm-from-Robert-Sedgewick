package gfg;

public class Problem3 {

    int getEquilibrium(int arr[], int size) {

        int leftSum = 0;
        int sum = 0;
        for (int i=0; i<size; i++) {
            sum += arr[i];
        }
        for (int i=0; i<size; ++i) {
            sum -= arr[i];
            if (leftSum == sum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main (String[] args) {
        //code
        Problem3 gfg = new Problem3();
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        int arr_size = arr.length;
        System.out.println("the equilibrium index is: " + gfg.getEquilibrium(arr, arr_size));
    }
}
