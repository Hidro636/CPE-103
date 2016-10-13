
import java.util.NoSuchElementException;

/**
 * Circular array implementation of the SimpleQueue interface
 *
 * @author Lucas Robertson
 * @version Program 1
 * @param <T> The generic type of the queue
 */
public class CircularQueue<T> implements SimpleQueue<T> {

    private T[] arr;
    private int dIndex, eIndex, size;
    public static final int INITIAL_LENGTH = 10;

    /**
     * Constructs an empty queue with an initial capacity given by
     * INITIAL_LENGTH. This will require suppressing an unchecked warning.
     */
    public CircularQueue() {
        //this(INITIAL_LENGTH);
        arr = (T[]) new Object[INITIAL_LENGTH];
        dIndex = eIndex = size = 0;
    }

    /**
     * Constructs an empty queue with the specified initial capacity. This will
     * require suppressing an unchecked warning.
     *
     * @param initialCapacity the initial capacity of the list
     * @throws CircularQueue.MyException when there is an exception in
     * CircularQueue(int initialCapacity).
     */
    public CircularQueue(int initialCapacity) throws MyException {
        if (initialCapacity <= 0) {
            throw new MyException();
        } else {
            arr = (T[]) new Object[initialCapacity];
        }
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        if (this.size == 0) {
            throw new NoSuchElementException();
        } else {
            T value = arr[dIndex];
            if (dIndex == arr.length - 1) {
                dIndex = 0;
            } else {
                dIndex++;
            }
            size--;

            return value;
        }
    }

    @Override
    public void enqueue(T element) {
        if (eIndex == arr.length && eIndex == size) {
            resize();
        } else if (eIndex == arr.length) {
            eIndex = 0;
        }

        arr[eIndex] = element;
        size++;
    }

    private void resize() {
        T[] larger = (T[]) new Object[arr.length * 2];
        if (eIndex >= dIndex) {
            for (int i = dIndex, h = 0; i < eIndex; i++, h++) {
                larger[h] = arr[i];
            }
        } else {
            int hFinal = 0;
            for (int i = dIndex, h = 0; i < arr.length; i++, h++) {
                larger[h] = arr[i];
                hFinal = h;
            }

            for (int i = 0, h = hFinal; i < eIndex; i++, h++) {
                larger[h] = arr[i];
            }

        }

        arr = larger;
        eIndex = eIndex - dIndex;
        dIndex = 0;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if (this.size == 0) {
            throw new NoSuchElementException();
        } else {
            return arr[dIndex];
        }
    }

    @Override
    public int size() {
        //return eIndex - dIndex;
        return this.size;
    }

    public Object[] unusualMethodForTestingPurposesOnly() { //why?
        return arr;
    }

    public static class MyException extends RuntimeException {

        public MyException() {
        }

        public MyException(String s) {
            super(s);
        }
    }
}
