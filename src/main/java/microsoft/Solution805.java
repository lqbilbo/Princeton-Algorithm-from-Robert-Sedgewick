package microsoft;

import java.util.Arrays;

public class Solution805 {

    public boolean splitArraySameAverage(int[] A) {
        if(A == null || A.length == 0){
            return true;
        }
        if(A.length == 1){
            return false;
        }
        int n = A.length;
        int sumA = 0;
        for(int ele : A){
            sumA += ele;
        }
        Arrays.sort(A);
        for(int lenB = 1; lenB <= A.length / 2; lenB ++){
            if((sumA * lenB) % n == 0){
                if(check(A, sumA * lenB / n, lenB, 0)){
                    return true;
                }
            }
        }
        return false;

    }

    public boolean check(int[] A, int leftSum, int leftNum, int startIndex){
        if(leftNum == 0){
            return leftSum == 0;
        }
        if(A[startIndex] > leftSum / leftNum){
            return false;
        }
        for(int i = startIndex; i < A.length - leftNum + 1; i ++){
            if(i > startIndex && A[i] == A[i - 1]){
                continue;
            }
            if(check(A, leftSum - A[i], leftNum - 1, i + 1)){
                return true;
            }
        }
        return false;
    }
}
