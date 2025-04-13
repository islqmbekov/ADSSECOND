// ==== MyMinHeap START ====

/**
 * MyMinHeap is a simple min-heap implementation using MyArrayList.
 */
public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void insert(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }

    public T extractMin() {
        if (heap.size() == 0) throw new IllegalStateException("Heap is empty");
        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (heap.size() > 0) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    public T peek() {
        if (heap.size() == 0) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int left, right, smallest;
        while ((left = 2 * index + 1) < heap.size()) {
            right = left + 1;
            smallest = index;
            if (heap.get(left).compareTo(heap.get(smallest)) < 0) smallest = left;
            if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) smallest = right;
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

// ==== MyMinHeap END ====
