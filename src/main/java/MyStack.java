// ==== MyStack START ====

/**
 * MyStack is a generic stack implementation based on MyArrayList.
 * It follows Last-In-First-Out (LIFO) principle.
 */
public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.remove(list.size() - 1); // ✅ теперь работает, потому что remove возвращает T
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.get(list.size() - 1);
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
// ==== MyStack END ====
