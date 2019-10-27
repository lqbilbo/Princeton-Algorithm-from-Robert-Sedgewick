package algs4.lesson2;

/**
 * stack considerations
 *
 * overflow and underflow
 * - underflow: throw exception if pop from an empty stack
 * - overflow: use resizing array for array implementation
 *
 * loitering. holding a reference to an object when it is no longer needed.
 */
public class FixedCapacityStackOfStrings {

    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;
        return item;
    }
}
