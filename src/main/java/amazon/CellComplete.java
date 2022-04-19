package amazon;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED

/**
 * test1:
 * input: states=[1,0,0,0,0,1,0,0], days=1
 * expected output: [0,1,0,0,1,0,1,0]
 *
 * test2:
 * input: states=[1,1,1,0,1,1,1,1], days=2
 * expected output: [0,0,0,0,0,1,1,0]
 */
public class CellComplete {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellComplete(int[] states, int days)
    {
        // WRITE YOUR CODE HERE
        List<Integer> ans = new ArrayList<>();
        List<Integer> before = new ArrayList<>();
        int lastIndex = states.length - 1;
        for (int i=0; i<=lastIndex; i++) {
            before.add(states[i]);
        }
        for (int i=0; i<days; i++) {
            List<Integer> after = new ArrayList<>();
            for (int j=0; j<=lastIndex; j++) {
                if (j == 0) {
                    if (before.get(j+1) == 1) {
                        after.add(1);
                    } else {
                        after.add(0);
                    }
                } else
                if (j == lastIndex) {
                    if (before.get(j-1) == 1) {
                        after.add(1);
                    } else {
                        after.add(0);
                    }
                } else
                if (Objects.equals(before.get(j - 1), before.get(j + 1))) {
                    after.add(0);
                } else {
                    after.add(1);
                }
            }
            before.clear();
            for (int k=0; k<=lastIndex; k++) {
                before.add(after.get(k));
            }
            if (i == days-1) {
                for (int k=0; k<=lastIndex; k++) {
                    ans.add(before.get(k));
                }
            }
        }
        return ans;
    }
    // METHOD SIGNATURE ENDS

    public static void main(String[] args) {
        int[] states = new int[]{1,1,1,0,1,1,1,1};
        int days = 2;
        System.out.println("answer: " + cellComplete(states, days));
    }
}


