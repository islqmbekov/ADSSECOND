// ==================== MyLinkedList CLASS COMMENT START ====================
/**
 * MyLinkedList is a custom implementation of a doubly linked list.
 * It implements the MyList interface and uses an internal node class MyNode
 * that holds references to both next and previous elements.
 *
 * Features:
 * - Doubly linked structure allows efficient insertion and deletion from both ends
 * - Traversal in both directions
 * - Index-based access and manipulation
 * - Prevents circular reference loops in implementation
 *
 * Inner class:
 * - private class MyNode<E>: stores element, next, and previous node links
 *
 * Instance variables:
 * - MyNode<E> head: reference to the first node
 * - MyNode<E> tail: reference to the last node
 * - int size: total number of elements in the list
 *
 * Usage:
 * MyLinkedList<String> list = new MyLinkedList<>();
 * list.add("Hello");
 */


package ads;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private MyNode<T> head;
    private MyNode<T> tail;
    private int length;

    public MyLinkedList() {
        head = tail = null;
        length = 0;
    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public void add(int index, T item) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }

        MyNode<T> newNode = new MyNode<>(item);

        if (index == length) {
            add(item);
            return;
        } else if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = head;
            }
        } else {
            MyNode<T> current = getNode(index);
            MyNode<T> previous = current.prev;
            newNode.next = current;
            newNode.prev = previous;

            if (previous != null) {
                previous.next = newNode;
            }
            current.prev = newNode;

            if (index == 0) {
                head = newNode;
            }
        }

        length++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    private MyNode<T> getNode(int index) {
        checkIndex(index);
        MyNode<T> current;
        if (index < length / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = length - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
    }


    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode<T> toRemove = getNode(index);

        if (toRemove.prev != null) toRemove.prev.next = toRemove.next;
        else head = toRemove.next;

        if (toRemove.next != null) toRemove.next.prev = toRemove.prev;
        else tail = toRemove.prev;

        length--;
    }

    public boolean remove(T item) {
        MyNode<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(item)) {
                remove(index);
                return true;
            }
            current = current.next;
            index++;
        }
        return false;
    }



    @Override
    public void clear() {
        head = tail = null;
        length = 0;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
// ==================== MyLinkedList CLASS COMMENT END ====================