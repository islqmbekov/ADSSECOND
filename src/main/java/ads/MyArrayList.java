// ==================== MyArrayList CLASS COMMENT START ====================
/**
 * MyArrayList is a custom implementation of a resizable array-based list.
 * It implements the MyList interface and uses a generic Object[] array as its internal storage.
 *
 * Features:
 * - Dynamic resizing when capacity is reached
 * - Supports addition, removal, search, and retrieval of elements
 * - Index-based access and manipulation
 *
 * Instance variables:
 * - Object[] elements: underlying array to store list elements
 * - int size: current number of elements in the list
 *
 * Constraints:
 * - No usage of java.util.* except Iterator
 * - All generic operations are implemented manually
 *
 * Usage:
 * MyArrayList<Integer> list = new MyArrayList<>();
 * list.add(5);
 */

package ads;


public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int length;

    public MyArrayList() {
        elements = new Object[5];
        length = 0;
    }

    @Override
    public void add(T item) {
        if (length == elements.length) {
            increaseBuffer();
        }
        elements[length++] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }
        if (length == elements.length) {
            increaseBuffer();
        }
        for (int i = length; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        length++;
    }

    private void increaseBuffer() {
        Object[] newElements = new Object[length * 2];
        for (int i = 0; i < length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--length] = null;
    }

    @Override
    public boolean remove(T item) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public void clear() {
        elements = new Object[5];
        length = 0;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < length;
            }

            @Override
            public T next() {
                return (T) elements[current++];
            }
        };
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
    }
}
// ==================== MyArrayList CLASS COMMENT END ====================