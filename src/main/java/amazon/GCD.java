package amazon;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
import java.util.Arrays;

public class GCD {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr)
    {
        // WRITE YOUR CODE HERE
        Arrays.sort(arr);
        int ans = 1;
        for (int i=2; i<=arr[0]; i++) {
            for (int j=0; j<arr.length; j++) {
                if (arr[j] % i != 0) {
                    ans = 1;
                    break;
                }
                ans = i;
            }

        }
        return ans;
    }
    // METHOD SIGNATURE ENDS
}