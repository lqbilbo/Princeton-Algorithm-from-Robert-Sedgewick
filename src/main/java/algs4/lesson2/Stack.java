package algs4.lesson2;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    private Node first = null;

    private Item[] s;

    public Stack() {
    }

    public Stack(Item[] s) {
        this.s = s;
    }

    private int N = 0;

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        s[N++] = item;
    }

    public Item pop() {
        Item item = s[--N];
        s[N] = null;
        return item;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    class Node {
        Item item;
        Node next;
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return s[--i];
        }
    }


}
