
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author Lucas Robertson
 * @version Program 3
 */
public class PriorityQueue<T> implements SimpleQueue<T> {

    private ArrayList<T> heap;
    private boolean isMax;

    /**
     * Creates a minimum PriorityQueue.
     */
    public PriorityQueue() {
        isMax = false;
        heap = new ArrayList<>();
    }

    /**
     * Creates a PriorityQueue.
     *
     * @param isMax when true, creates a maximum queue; otherwise a minimum
     * queue
     */
    public PriorityQueue(boolean isMax) {
        this.isMax = isMax;
        heap = new ArrayList<>();
    }

    /**
     * Creates a minimum PriorityQueue containing the elements in the specified
     * array. The array is not a binary heap. This constructor must build a
     * priority queue with these values. This should be easy and O ( n log n )
     * O(nlogn). The size is not necessarily the length of the array (but you
     * can be sure that it will be no bigger than the length of the array).
     *
     * @param arr the array whose elements are to be placed into this priority
     * queue
     * @param size the number of elements in the specified array (will be less
     * than or equal to the length of the array)
     */
    public PriorityQueue(T[] arr, int size) {

    }

    /**
     * Creates a PriorityQueue containing the elements in the specified array.
     * The array is not a binary heap. This constructor must build a priority
     * queue with these values. This should be easy and O ( n log n ) O(nlog⁡n).
     * The size is not necessarily the length of the array (but you can be sure
     * that it will be no bigger than the length of the array).
     *
     * @param arr the array whose elements are to be placed into this priority
     * queue
     * @param size the number of elements in the specified array (will be less
     * than or equal to the length of the array)
     * @param isMax when true, creates a maximum queue; otherwise a minimum
     * queue
     */
    public PriorityQueue(T[] arr, int size, boolean isMax) {

    }

    @Override
    public T dequeue() throws NoSuchElementException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enqueue(T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T peek() throws NoSuchElementException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static <E extends Comparable<? super E>> E kth(E[] arr, int size, int k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static <E extends Comparable<? super E>> void sort(E[] arr, int size) {
    }
}
