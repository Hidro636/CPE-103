
import java.util.NoSuchElementException;

/**
 *
 * @author Lucas Robertson
 * @version Program 4
 * @param <T> The generic type of the stack
 */
public class SimpleArrayStack<T> implements SimpleStack<T> {

    private T[] values;
    private int size;

    public SimpleArrayStack() {
        this.values = (T[]) new Object[10];
        this.size = 0;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            return values[size - 1];
        }

    }

    @Override
    public T pop() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            T value = values[size - 1];
            size--;
            return value;
        }
    }

    @Override
    public void push(T element) {

        //Resize if needed
        if (size == values.length) {
            T[] larger = (T[]) new Object[values.length * 2];
            for (int i = 0; i < values.length; i++) {
                larger[i] = values[i];
            }
            values = larger;
        }

        values[size] = element;
        size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * For testing purposes?
     *
     * @return the capacity of the internal array containing the values of this
     * stack
     */
    public int capacity() {
        return this.values.length;
    }
}
