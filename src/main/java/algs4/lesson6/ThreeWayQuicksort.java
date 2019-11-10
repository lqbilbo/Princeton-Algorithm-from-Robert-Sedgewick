package algs4.lesson6;

public class ThreeWayQuicksort {

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)  return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)  exch(a, lt++, i++);
            else if (cmp > 0)  exch(a, i, gt--);
            else  i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w) {

        return false;
    }

}
