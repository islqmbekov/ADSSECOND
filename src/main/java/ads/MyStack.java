// ==================== MyStack CLASS COMMENT START ====================
/**
 * MyStack is a custom implementation of a stack data structure using MyArrayList.
 * It follows Last-In-First-Out (LIFO) principle.
 *
 * Features:
 * - push(T item): Adds an item to the top of the stack
 * - pop(): Removes and returns the top item
 * - peek(): Returns the top item without removing
 * - isEmpty(): Checks if the stack is empty
 *
 * Underlying data structure:
 * - Based on MyArrayList for efficient end insertions and deletions
 *
 * Usage:
 * MyStack<Integer> stack = new MyStack<>();
 * stack.push(10);
 */


package ads;

public class MyStack<T> {
    private MyList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (list.isEmpty()) throw new IllegalStateException("stack is empty");
        T item = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return item;
    }

    public T peek() {
        if (list.isEmpty()) throw new IllegalStateException("stack is empty");
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
// ==================== MyStack CLASS COMMENT END ====================