
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
    static int INITIAL_LENGTH = 10;

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
        arr = (T[]) new Object[initialCapacity];
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        if (this.size == 0) {
            throw new NoSuchElementException("The queue is empty!");
        }

        T value = arr[dIndex];
        dIndex = (dIndex + 1) % arr.length;
        size--;
        return value;
    }

    @Override
    public void enqueue(T element) {
        if (size() + 1 == arr.length) {
            resize();
        }

        arr[eIndex] = element;
        eIndex = (eIndex + 1) % arr.length;
        size++;
    }

    @Override
    public T peek() throws NoSuchElementException {
        return arr[dIndex];
    }

    @Override
    public int size() {
        //return eIndex - dIndex;
        return size;
    }

    public Object[] unusualMethodForTestingPurposesOnly() {
        return arr;
    }

    private void resize() {
        T[] larger = (T[]) new Object[arr.length * 2];
        System.arraycopy(arr, 0, larger, 0, arr.length);
        arr = larger;
    }

    public void _testDiagnosticPrint() {
        System.out.print("Array: ");
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println("\neIndex: " + eIndex);
        System.out.println("dIndex: " + dIndex);
    }

    private static class MyException extends Exception {

        public MyException() {
        }

        public MyException(String s) {
            super(s);
        }
    }
}
