// ==================== MyQueue CLASS COMMENT START ====================
/**
 * MyQueue is a custom implementation of a queue using MyLinkedList.
 * It follows First-In-First-Out (FIFO) principle.
 *
 * Features:
 * - enqueue(T item): Adds an item to the end of the queue
 * - dequeue(): Removes and returns the front item
 * - peek(): Returns the front item without removing
 * - isEmpty(): Checks if the queue is empty
 *
 * Underlying data structure:
 * - Based on MyLinkedList for efficient front and end operations
 *
 * Usage:
 * MyQueue<String> queue = new MyQueue<>();
 * queue.enqueue("first");
 */


package ads;

public class MyQueue<T> {
    private MyList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.add(item);
    }

    public T dequeue() {
        if (list.isEmpty()) throw new IllegalStateException("Queue is empty");
        T item = list.get(0);
        list.remove(0);
        return item;
    }

    public T peek() {
        if (list.isEmpty()) throw new IllegalStateException("queue is empty");
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
// ==================== MyQueue CLASS COMMENT END ====================