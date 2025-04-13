package ads;

public class MyNode<T> {
    T data;
    MyNode<T> next;
    MyNode<T> prev;

    public MyNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
