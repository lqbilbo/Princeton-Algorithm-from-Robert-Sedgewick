package algs4.lesson4;

public class Insertion {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) {
                    exch(a, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {

        return false;
    }

    private static void exch(Comparable[] a, int i, int j) {

    }
}
