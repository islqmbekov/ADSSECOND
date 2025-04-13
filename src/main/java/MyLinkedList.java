// ==== MyLinkedList START ====
import java.util.Iterator;

/**
 * MyLinkedList is a custom implementation of a doubly linked list.
 * It uses inner Node<T> objects to store elements and supports standard
 * list operations like add, remove, get, set, etc.
 * The list maintains references to both head and tail for efficient insertion/removal.
 */

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        Node<T> node = new Node<>(item);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node<T> newNode = new Node<>(item);
        if (index == 0) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            if (tail == null) tail = head;
        } else if (index == size) {
            add(item);
            return;
        } else {
            Node<T> current = getNode(index);
            Node<T> prevNode = current.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        Node<T> node = getNode(index);
        node.value = item;
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public void remove(int index) {
        Node<T> node = getNode(index);
        Node<T> prevNode = node.prev;
        Node<T> nextNode = node.next;

        if (prevNode != null) prevNode.next = nextNode;
        else head = nextNode;

        if (nextNode != null) nextNode.prev = prevNode;
        else tail = prevNode;

        size--;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    @Override
    public T getFirst() {
        return head.value;
    }

    @Override
    public T getLast() {
        return tail.value;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public int indexOf(Object object) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.value.equals(object)) return i;
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        Node<T> current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.value.equals(object)) return i;
            current = current.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.value;
            current = current.next;
        }
        return array;
    }

    @Override
    public void sort() {
        Object[] array = toArray();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T a = (T) array[j];
                T b = (T) array[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        clear();
        for (Object obj : array) {
            add((T) obj);
        }
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = head;
            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}
// ==== MyLinkedList END ====
