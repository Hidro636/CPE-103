
/**
 *
 * @author Lucas Robertson
 * @version Lab 11
 */
public class ShellSorts {

    static <T extends Comparable<? super T>> void heapSort(T[] array) {
        PriorityQueue.sort(array, array.length);
    }

    static <T extends Comparable<? super T>> void hibbard(T[] array) {
        int[] gaps = calculateHibbard(8);
        sort(array, gaps);
    }

    static <T extends Comparable<? super T>> void sedgewick(T[] array) {
        int[] gaps = calculateSedgewick(8);

        sort(array, gaps);
    }

    static <T extends Comparable<? super T>> void shell(T[] array) {
        int[] gaps = new int[]{128, 64, 32, 16, 8, 4, 2, 1};
        sort(array, gaps);
    }

    private static <T extends Comparable<? super T>> void sort(T[] a, int[] gaps) {
        int j;
        //for (int gap = a.length / 2; gap > 0; gap /= 2) {
        for (int gap : gaps) {
            for (int i = gap; i < a.length; i++) {
                T tmp = a[i];
                for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
    }

//    private static <T extends Comparable<? super T>> void sort(T[] array, int[] gaps) {
//        T temp;
//        for (int gap : gaps) {
//
//            for (int i = gap; i < array.length; i++) {
//                temp = array[i];
//                int j;
//                for (j = i; j >= gap && array[j - gap].compareTo(temp) > 0; j -= gap) {
//                    array[j] = array[j - gap];
//                }
//
//                array[j] = temp;
//            }
//        }
//    }
    private static int[] calculateHibbard(int n) {
        int[] gaps = new int[n];
        for (int i = 0; i < n; i++) {
            gaps[i] = (int) Math.pow(2, i + 1) - 1;
        }
        return gaps;
    }

    private static int[] calculateSedgewick(int n) {
        int[] gaps = new int[n];
        gaps[0] = 1; //prefix
        for (int i = 1; i < n; i++) {
            gaps[i] = (int) Math.pow(4, i) + (3 * (int) Math.pow(2, i - 1)) + 1;
        }
        return gaps;
    }

}
