
import java.util.NoSuchElementException;

/**
 *
 * @author Lucas Robertson
 * @version Lab 4
 * @param <T> The generic type of the stack
 */
public class BadStack<T> implements SimpleStack<T> {

    private T[] values;
    private int size;

    public BadStack() {
        this.values = (T[]) new Object[10];
        this.size = 0;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            return values[0];
        }

    }

    @Override
    public T pop() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            T value = values[0];
            T[] newValues = (T[]) new Object[values.length - 1];
            for (int i = 1; i < values.length; i++) {
                newValues[i - 1] = values[i];
            }

            values = newValues;
            size--;
            return value;
        }
    }

    @Override
    public void push(T element) {

        //Resize every time because we can
        T[] newValues = (T[]) new Object[values.length + 1];
        newValues[0] = element;
        for (int i = 0; i < values.length; i++) {
            newValues[i + 1] = values[i];
        }

        values = newValues;
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
