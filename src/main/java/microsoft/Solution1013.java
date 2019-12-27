package microsoft;

public class Solution1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int len = A.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) return false;
        int subSum = sum / 3;
        int flag = subSum;
        for (int i = 0; i < len; i++) {
            flag = flag - A[i];
            if (flag == 0) {
                flag = subSum;
            }
        }
        if (flag == subSum) return true;
        else return false;
    }
}
