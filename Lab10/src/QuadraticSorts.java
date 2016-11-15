
/**
 *
 * @author Lucas Robertson
 * @version Lab 10
 */
public class QuadraticSorts {

    public static <T extends Comparable<? super T>> void bubbleSort1(T[] array) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    T temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void bubbleSort2(T[] array) {

    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] array) {

    }

    public static <T extends Comparable<? super T>> void selectionSort(T[] array) {

    }
}
