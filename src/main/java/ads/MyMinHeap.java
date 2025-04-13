
// ==================== MyMinHeap CLASS COMMENT START ====================
/**
 * MyMinHeap is a custom implementation of a min-heap data structure using MyArrayList.
 * It maintains the heap property where each parent node is less than or equal to its children.
 *
 * Features:
 * - insert(T item): Inserts an element and reorders to maintain heap
 * - extractMin(): Removes and returns the smallest element
 * - peek(): Returns the smallest element without removing
 * - heapifyUp() / heapifyDown(): Internal methods to maintain heap property
 *
 * Underlying data structure:
 * - Based on MyArrayList for random access and efficient indexing
 *
 * Requirements:
 * - T must implement Comparable<T>
 * - Or use Comparator<T> passed to constructor or method
 *
 * Usage:
 * MyMinHeap<Integer> heap = new MyMinHeap<>();
 * heap.insert(3);
 */

package ads;

public class MyMinHeap {
    private MyArrayList<Integer> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int extractMin() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        int min = heap.get(0);
        heap.remove(0);
        if (!heap.isEmpty()) {
            heap.add(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            heapifyDown(0);
        }
        return min;
    }

    public int peek() {
        if (heap.isEmpty()) throw new IllegalStateException("heap is empty");
        return heap.get(0);
    }
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index) < heap.get(parent)) {
                int temp = heap.get(index);
                heap.add(index, heap.get(parent));
                heap.remove(index + 1);
                heap.add(parent, temp);
                heap.remove(parent + 1);
                index = parent;
            } else break;
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        if (smallest != index) {
            int temp = heap.get(index);
            heap.add(index, heap.get(smallest));
            heap.remove(index + 1);
            heap.add(smallest, temp);
            heap.remove(smallest + 1);
            heapifyDown(smallest);
        }
    }
}
// ==================== MyMinHeap CLASS COMMENT END ====================