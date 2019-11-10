package algs4.lesson7;

public class UnorderedMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

    public Key delMax() {
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (less(max, i))  max = i;
        }
        exch(max, N-1);
        return pq[--N];
    }

    private void exch(int a, int b) {

    }

    private boolean less(int a, int b) {
        return false;
    }
}
