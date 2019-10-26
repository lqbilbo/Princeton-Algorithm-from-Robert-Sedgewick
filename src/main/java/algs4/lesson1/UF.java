package algs4.lesson1;

import common.StdIn;
import common.StdOut;

public class UF {

    public UF(int N) {
    }

    boolean connected(int p, int q) {
        return false;
    }

    void union(int p, int q) {

    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
    }
}
