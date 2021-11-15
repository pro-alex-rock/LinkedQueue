package linkedQueue;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue("Hello");
        queue.enqueue("Hello2");
        Object dequeue = queue.dequeue();
        Object dequeue2 = queue.dequeue();
        System.out.println(dequeue);
        System.out.println(dequeue2);
    }
}
