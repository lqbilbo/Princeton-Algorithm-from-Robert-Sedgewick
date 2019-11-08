package gfg;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Problem1 {

    static int getMissingNo(int a[], int n) {
        int total = 1;
        for (int i = 2; i <= (n + 1); i++) {
            total += i;
            total -= a[i - 2];
        }
        return total;
    }

    static int getMissingNo2(int a[], int n) {
        int x1 = a[0];
        int x2 = 1;

        for (int i = 1; i < n; i++) {
            x1 = x1 ^ a[i];
        }
        for (int i = 2; i <= n + 1; i++) {
            x2 = x2 ^ i;
        }
        return (x1 ^ x2);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 5};
        System.out.println(getMissingNo2(arr, 5));
        System.out.println(1 ^ 2);  // 01 ^ 10 = 11
        System.out.println(2 ^ 3);  // 10 ^ 11 = 01
        System.out.println(3 ^ 4);  // 011 ^ 100 = 111
        System.out.println(4 ^ 5);  // 100 ^ 101 = 001
        System.out.println(5 ^ 6);  // 101 ^ 110 = 011
    }
}
