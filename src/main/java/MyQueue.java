// ==== MyQueue START ====

/**
 * MyQueue is a generic queue implementation based on MyLinkedList.
 * It follows First-In-First-Out (FIFO) principle.
 */
public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.add(item);
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.remove(0);
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }
}

// ==== MyQueue END ====