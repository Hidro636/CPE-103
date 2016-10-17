
/**
 * A utility class for the binary heap data structure
 *
 * @author Lucas Robertson
 * @version Lab 5
 */
public class BinaryHeapUtilities {

    public static int height(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }

        return (int) (Math.log(size) / Math.log(2));
    }

    public static <T extends Comparable< ? super T>> boolean isHeap(T[] heap, int size) {
        return false;
    }

    public static <T extends Comparable<? super T>> T leftChildOf(int index, T[] heap, int size) {
        return null;
    }

    public static <T extends Comparable<? super T>> T parentOf(int index, T[] heap, int size) {
        return null;
    }

    public static <T extends Comparable<? super T>> T rightChildOf(int index, T[] heap, int size) {
        return null;
    }
}
