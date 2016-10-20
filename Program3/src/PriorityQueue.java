
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author Lucas Robertson
 * @version Program 3
 * @param <T> The generic type of the priority queue
 */
public class PriorityQueue<T extends Comparable<? super T>> implements SimpleQueue<T> {

    private ArrayList<T> heap;
    private boolean isMax;

    /**
     * Creates a minimum PriorityQueue.
     */
    public PriorityQueue() {
        isMax = false;
        heap = new ArrayList<>();
        heap.add(null);

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
        heap.add(null);
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
        isMax = false;
        heap = new ArrayList<>();

        heap.add(null);
        for (int i = 0; i < size; i++) {
            heap.add(arr[i]);
        }
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
        this.isMax = isMax;
        heap = new ArrayList<>();

        heap.add(null);
        for (int i = 0; i < size; i++) {
            heap.add(arr[i]);
        }
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        T value = heap.get(1);
        heap.set(1, heap.remove(heap.size() - 1));

        int i = 1;
        while ((i * 2) + 1 < heap.size() - 1) {
            if ((heap.get(i).compareTo(heap.get(i * 2)) < 0) == !isMax || (heap.get(i).compareTo(heap.get(i * 2 + 1)) < 0) == !isMax) {
                if (heap.get(i * 2).compareTo(heap.get(i * 2 + 1)) < 0) { //i * 2 + 1 is larger
                    swap(i, i * 2);
                    i *= 2;
                } else {
                    swap(i, i * 2 + 1);
                    i = i * 2 + 1;
                }
            }
        }

        return value;
    }

    @Override
    public void enqueue(T element
    ) {
        heap.add(element);

        for (int i = heap.size() - 1; i > 1; i /= 2) {
            if ((heap.get(i).compareTo(heap.get(i / 2)) < 0) == !isMax) {
                swap(i, i / 2);
            } else {
                break;
            }
        }
    }

    @Override
    public T peek() throws NoSuchElementException {
        if (heap.size() <= 1) {
            throw new NoSuchElementException();
        } else {
            return heap.get(0);
        }
    }

    @Override
    public int size() {
        return heap.size() - 1;
    }

    public static <E extends Comparable<? super E>> E kth(E[] arr, int size, int k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static <E extends Comparable<? super E>> void sort(E[] arr, int size) {
    }

    private void swap(int index1, int index2) {
        heap.set(0, heap.get(index1));
        heap.set(index1, heap.get(index2));
        heap.set(index2, heap.get(0));
        heap.set(0, null);
    }

    public void _test() {
        for (T t : heap) {
            System.out.print(t + " ");
        }

        System.out.println();
    }
}
