
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
            enqueue(arr[i]);
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
            enqueue(arr[i]);
        }
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        if (heap.size() <= 1) {
            throw new NoSuchElementException();
        }

        T element = heap.get(1);
        heap.set(1, heap.get((int) size()));
        heap.remove((int) size());

        int i = 1;
        while (true) {
            if (size() == 2 && (heap.get(1).compareTo(heap.get(2)) > 0) == !isMax) {
                swap(1, 2);
		break;
            }

		/*
		* IF: left child exists
		* AND: parent is greater than left child (or smaller for max)
		* AND: Right child exists) 
		*
		*/
            if (i * 2 < heap.size() && (heap.get(i).compareTo(heap.get(i * 2)) > 0) == !isMax && (((i * 2 + 1 < heap.size() && heap.get(i * 2).compareTo(heap.get(i * 2 + 1)) <= 0) == !isMax) || (i * 2 + 1 >= heap.size()))) {
		

                swap(i, i * 2);
                i *= 2;
            } else if (i * 2 + 1 < heap.size() && (heap.get(i).compareTo(heap.get(i * 2 + 1)) > 0) == !isMax) {
                swap(i, i * 2 + 1);
                i = (i * 2) + 1;
            } else {
                break;
            }
        }

        return element;
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
            return heap.get(1);
        }
    }

    @Override
    public int size() {
        return heap.size() - 1;
    }

    public static <E extends Comparable<? super E>> E kth(E[] arr, int size, int k) {
        PriorityQueue<E> queue;
        if(k < size - k + 1) {
            queue = new PriorityQueue<>(false);
            for (int i = 0; i < k; i++) {
                queue.enqueue(arr[i]);
            }
            for (int i = k; i < size; i++) {
                if(arr[i].compareTo(queue.peek()) > 0) {
                    queue.dequeue();
                    queue.enqueue(arr[i]);
                }
            }
            
        } else {
            queue = new PriorityQueue<>(true);
            for (int i = 0; i < size - k + 1; i++) {
                queue.enqueue(arr[i]);
            }
            
            for (int i = size - k + 1; i < size; i++) {
                if(arr[i].compareTo(queue.peek()) < 0) {
                    queue.dequeue();
                    queue.enqueue(arr[i]);
                }
            }
        }
        
        return queue.dequeue();
        
    }

    /**
     * Sorts the specified array into ascending order. For example: {A, B, C,
     * ..., Z} or {1, 2, 3, ..., N}. You must use your PriorityQueue to sort the
     * data. If you enqueue all the elements into a minimum queue, when you
     * dequeue them they will come out in ascending order. Put them back in the
     * specified array as you dequeue and you are done. The amount of work
     * should be O ( n log n ) O(nlogn)—not a bad sort!
     *
     * @param <E> the type of elements in the array
     * @param arr the array to be sorted
     * @param size the number of elements in the array to be sorted (will be
     * less than or equal to the length of the array)
     */
    public static <E extends Comparable<? super E>> void sort(E[] arr, int size) {
        PriorityQueue<E> queue = new PriorityQueue<>(arr, size);

        for (int i = 0; i < size; i++) {
            arr[i] = queue.dequeue();
        }
    }

    private void swap(int index1, int index2) {
        heap.set(0, heap.get(index1));
        heap.set(index1, heap.get(index2));
        heap.set(index2, heap.get(0));
        heap.set(0, null);
    }
}
