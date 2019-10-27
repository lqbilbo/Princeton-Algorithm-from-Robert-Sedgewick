package algs4.lesson2;

public class LinkedQueueOfStrings {

    private Node first, last;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldList = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldList.next = last;
    }

    public String enqueue() {
        String item = first.item;
        first = first.next;
        if (isEmpty())  last = null;
        return item;
    }
}
