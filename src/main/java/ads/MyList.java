package ads;
import java.util.Iterator;

public interface MyList<T> extends Iterable<T> {
    void add(T element);
    void add(int index, T element);
    void remove(int index);
    boolean remove(T element);
    T get(int index);
    int size();
    boolean isEmpty();
    void clear();
    Iterator<T> iterator();
}
