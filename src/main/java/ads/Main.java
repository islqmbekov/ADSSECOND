package ads;

public class Main {
    public static void main(String[] args) {
        // Проверка MyArrayList
        System.out.println("Testing MyArrayList:");
        MyList<String> arrayList = new MyArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add(1, "X");
        for (String s : arrayList) {
            System.out.print(s + " ");
        }
        System.out.println("\nRemoved B: " + arrayList.remove("B"));
        System.out.println("Element at index 1: " + arrayList.get(1));
        arrayList.clear();
        System.out.println("Is empty after clear: " + arrayList.isEmpty());
        System.out.println();

        // Проверка MyLinkedList
        System.out.println("Testing MyLinkedList:");
        MyList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(1, 15);
        for (Integer i : linkedList) {
            System.out.print(i + " ");
        }
        linkedList.remove(1);
        System.out.println("\nAfter removal at index 1:");
        for (Integer i : linkedList) {
            System.out.print(i + " ");
        }
        System.out.println("\nContains 10: " + linkedList.remove((Integer)10));
        System.out.println();

        // Проверка MyStack
        System.out.println("Testing MyStack:");
        MyStack<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        System.out.println("Top element: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Top after pop: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        System.out.println();

        // Проверка MyQueue
        System.out.println("Testing MyQueue:");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        System.out.println("Front: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Front after dequeue: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        System.out.println();

        // Проверка MyMinHeap
        System.out.println("Testing MyMinHeap:");
        MyMinHeap heap = new MyMinHeap();
        heap.insert(30);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        System.out.println("Min: " + heap.peek());
        System.out.println("Extracted min: " + heap.extractMin());
        System.out.println("New min: " + heap.peek());
    }
}
