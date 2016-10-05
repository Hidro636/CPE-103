
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
    private int dIndex;
    private int eIndex;
    static int INITIAL_LENGTH = 10;
    private int size;

    /**
     * Constructs an empty queue with an initial capacity given by
     * INITIAL_LENGTH. This will require suppressing an unchecked warning.
     */
    public CircularQueue() {
        //this(INITIAL_LENGTH);
        arr = (T[]) new Object[INITIAL_LENGTH];
        size = 0;
        dIndex = 0;
        eIndex = 0;
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
        arr = (T[]) new Object[initialCapacity];
        size = 0;
    }

    @Override
    public T dequeue() throws NoSuchElementException {
    }

    @Override
    public void enqueue(T element) {
        
    }

    @Override
    public T peek() throws NoSuchElementException {
    }

    @Override
    public int size() {
        return this.size;
    }

    public Object[] unusualMethodForTestingPurposesOnly() {
        return arr;
    }

    private static class MyException extends Exception {

        public MyException() {
        }

        public MyException(String s) {
            super(s);
        }
    }
}
