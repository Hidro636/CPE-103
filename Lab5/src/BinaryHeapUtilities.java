
/**
 * A utility class for the binary heap data structure
 *
 * @author Lucas Robertson
 * @version Lab 5
 */
public class BinaryHeapUtilities {

    public static int height(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }

        return (int) (Math.log(size) / Math.log(2));
    }

    public static <T extends Comparable< ? super T>> boolean isHeap(T[] heap, int size) {
        //make sure it's a valid heap and the 0 index is empty
        if (heap[0] != null) {
            return false;
        }

        //Check that all elements past the specified size are null
        for (int i = size + 1; i < heap.length; i++) {
            if (heap[i] != null) {
                return false;
            }
        }

        //Check that each element's parent is less than it
        for (int i = size; i > 1; i--) {
            if (heap[i].compareTo(heap[i / 2]) == -1) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<? super T>> T leftChildOf(int index, T[] heap, int size) {
        return null;
    }

    public static <T extends Comparable<? super T>> T parentOf(int index, T[] heap, int size) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return heap[index / 2];
    }

    public static <T extends Comparable<? super T>> T rightChildOf(int index, T[] heap, int size) {
        return null;
    }
}
