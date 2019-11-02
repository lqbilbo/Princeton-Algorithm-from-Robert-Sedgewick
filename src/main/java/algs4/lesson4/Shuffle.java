package algs4.lesson4;

import common.StdRandom;

public class Shuffle {

    public static void shuffle(Object[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(i + 1);
            exch(a, i, r);
        }
    }

    private static void exch(Object[] a, int i, int j) {

    }
}
