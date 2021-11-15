package linkedQueue;

public class LinkedQueue {
    private final int capacity = 10;
    private Node head;
    private int size;

    public synchronized void enqueue(Object value) throws InterruptedException {
        while (size == capacity) {
            wait();
        }
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
        notify();
    }

    public synchronized Object dequeue() throws InterruptedException {
        while (size == 0) {
            wait();
        }
        Object result = head.value;
        head = head.next;
        size--;

        notify();
        return result;
    }

    private static class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }
}
