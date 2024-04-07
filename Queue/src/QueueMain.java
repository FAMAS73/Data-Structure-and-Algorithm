public class QueueMain {
    public static void main(String[] args) {
        Queue  queue = new Queue();
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(9);
        queue.enqueue(1);
        // queue.enqueue(0);
        queue.dequeue();//

        queue.printQueue();
        queue.printArray();
    }
}
