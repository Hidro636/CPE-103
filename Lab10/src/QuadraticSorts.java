
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
        int newN = 0;
        int n = array.length - 1;

        while (n > 1) {
            for (int i = 0; i < n; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    T temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    newN = i;
                }
            }
            n = newN;
        }
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T temp = array[i];
            int j;
            for (j = i - 1; j >= 0 && temp.compareTo(array[j]) < 0; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void selectionSort(T[] array) {

        int min;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i; j < array.length; j++) {
                if (array[min].compareTo(array[j]) > 0) {
                    min = j;
                }
            }

            T temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}
