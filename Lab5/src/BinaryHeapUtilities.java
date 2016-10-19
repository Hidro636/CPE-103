
import java.util.NoSuchElementException;

/**
 * A utility class for the binary heap data structure
 *
 * @author Lucas Robertson
 * @version Lab 5
 */
public class BinaryHeapUtilities {

    /**
     * Calculates the height of the heap given it's size. This will involve a
     * log (base 2).
     *
     * @param size the number of elements in the heap
     * @return the height of the heap
     * @throws IllegalArgumentException if the specified size is non-positive
     */
    public static int height(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }

        return (int) (Math.log(size) / Math.log(2)); //logbase2(size)
    }

    /**
     * Checks to see if data in the specified array meets the heap order
     * property for binary heaps. The heap order property requires that all
     * children must be greater than or equal to their parent. A precondition
     * (requirement the caller must meet) is that the first value is at index 1.
     * Note that an empty heap will have a size of zero and a non-empty heap's
     * size is also its last valid index—a bit different than a traditional
     * array.
     *
     * @param <T> The generic type of the heap to check
     * @param heap the array of elements, starting at index 1, to check
     * @param size the number of elements in the array
     * @return true if size is positive and the array of elements meets the
     * order property required for binary heaps; false otherwise
     */
    public static <T extends Comparable< ? super T>> boolean isHeap(T[] heap, int size) {
        //make sure it's a valid heap and the 0 index is empty
        if (heap[0] != null || size <= 0) {
            return false;
        }

        //Check that each element's parent is less than it
        for (int i = size; i > 1; i--) {
            if (heap[i].compareTo(heap[i / 2]) == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the left-child of the specified element.
     *
     * @param <T> the generic type of the heap
     * @param index the index of the element whose left-child is desired
     * @param heap the heap containing the elements
     * @param size the number of elements in the heap
     * @return the left-child of the specified element
     * @throws IndexOutOfBoundsException if the index is non-positive or greater
     * than size
     * @throws NoSuchElementException if the specified element does not have a
     * left-child
     * @throws IllegalArgumentException if the array is not a heap
     */
    public static <T extends Comparable<? super T>> T leftChildOf(int index, T[] heap, int size) {
        if (index * 2 >= size) {
            throw new IndexOutOfBoundsException();
        } else if (heap[index * 2] == null) {
            throw new NoSuchElementException();
        } else if (!isHeap(heap, size)) {
            throw new IllegalArgumentException();
        }

        return heap[2 * index];
    }

    /**
     * Returns the parent of the specified element.
     *
     * @param <T> the generic type of the heap
     * @param index the index of the element whose parent is desired
     * @param heap the heap containing the elements
     * @param size the number of elements in the heap
     * @return the parent of the specified element
     * @throws IndexOutOfBoundsException if the index is non-positive or greater
     * than size
     * @throws NoSuchElementException if the specified element does not have a
     * left-child
     * @throws IllegalArgumentException if the array is not a heap
     */
    public static <T extends Comparable<? super T>> T parentOf(int index, T[] heap, int size) {
        if (index <= 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index / 2 < 1 || heap[index / 2] == null) {
            throw new NoSuchElementException();
        } else if (!isHeap(heap, size)) {
            throw new IllegalArgumentException();
        }

        return heap[index / 2];
    }

    /**
     * Returns the right-child of the specified element.
     *
     * @param <T> the generic type of the heap
     * @param index the index of the element whose right-child is desired
     * @param heap the heap containing the elements
     * @param size the number of elements in the heap
     * @return the right-child of the specified element
     * @throws IndexOutOfBoundsException if the index is non-positive or greater
     * than size
     * @throws NoSuchElementException if the specified element does not have a
     * left-child
     * @throws IllegalArgumentException if the array is not a heap
     */
    public static <T extends Comparable<? super T>> T rightChildOf(int index, T[] heap, int size) {
        if ((index * 2) + 1 >= size) {
            throw new IndexOutOfBoundsException();
        } else if (heap[(index * 2) + 1] == null) {
            throw new NoSuchElementException();
        } else if (!isHeap(heap, size)) {
            throw new IllegalArgumentException();
        }

        return heap[(index * 2) + 1];
    }
}
