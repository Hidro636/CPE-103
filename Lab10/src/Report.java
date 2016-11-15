
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

/**
 *
 * @author Lucas Robertson
 * @version <insert>
 */
public class Report {

    public static final int size1 = 2500;
    public static final int size2 = 5000;
    public static final int size3 = 10000;
    public static final int size4 = 20000;

    public static void main(String args[]) throws FileNotFoundException {
        PrintStream stream = new PrintStream(new File("report.txt"));

        long start;
        long end;
        Integer[] arr;

        //<editor-fold defaultstate="collapsed" desc="Bubble sort 1">
        System.out.println("Timing bubble sort 1...");
        arr = buildArray(size1);
        start = System.currentTimeMillis();
        QuadraticSorts.bubbleSort1(arr);
        end = System.currentTimeMillis();
        long bubble1_1 = end - start;

        arr = buildArray(size2);
        start = System.currentTimeMillis();
        QuadraticSorts.bubbleSort1(arr);
        end = System.currentTimeMillis();
        long bubble1_2 = end - start;

        arr = buildArray(size3);
        start = System.currentTimeMillis();
        QuadraticSorts.bubbleSort1(arr);
        end = System.currentTimeMillis();
        long bubble1_3 = end - start;

        arr = buildArray(size4);
        start = System.currentTimeMillis();
        QuadraticSorts.bubbleSort1(arr);
        end = System.currentTimeMillis();
        long bubble1_4 = end - start;
//</editor-fold>

        System.out.println("Timing insertion sort...");
        arr = buildArray(size1);
        start = System.currentTimeMillis();
        QuadraticSorts.insertionSort(arr);
        end = System.currentTimeMillis();
        long insertion_1 = end - start;

        arr = buildArray(size2);
        start = System.currentTimeMillis();
        QuadraticSorts.insertionSort(arr);
        end = System.currentTimeMillis();
        long insertion_2 = end - start;

        arr = buildArray(size3);
        start = System.currentTimeMillis();
        QuadraticSorts.insertionSort(arr);
        end = System.currentTimeMillis();
        long insertion_3 = end - start;

        arr = buildArray(size4);
        start = System.currentTimeMillis();
        QuadraticSorts.insertionSort(arr);
        end = System.currentTimeMillis();
        long insertion_4 = end - start;

        System.out.println("Timing selection sort...");
        arr = buildArray(size1);
        start = System.currentTimeMillis();
        QuadraticSorts.selectionSort(arr);
        end = System.currentTimeMillis();
        long selection_1 = end - start;

        arr = buildArray(size2);
        start = System.currentTimeMillis();
        QuadraticSorts.selectionSort(arr);
        end = System.currentTimeMillis();
        long selection_2 = end - start;

        arr = buildArray(size3);
        start = System.currentTimeMillis();
        QuadraticSorts.selectionSort(arr);
        end = System.currentTimeMillis();
        long selection_3 = end - start;

        arr = buildArray(size4);
        start = System.currentTimeMillis();
        QuadraticSorts.selectionSort(arr);
        end = System.currentTimeMillis();
        long selection_4 = end - start;

        stream.println("Bubble sort 1:");
        stream.println("\t" + size1 + " elements\t(observed): " + bubble1_1 + " ms");
        stream.println("\t" + size2 + " elements\t(observed): " + bubble1_2 + " ms");
        stream.println("\t" + size3 + " elements\t(observed): " + bubble1_3 + " ms");
        stream.println("\t" + size4 + " elements\t(observed): " + bubble1_4 + " ms");
        stream.println();

        stream.println("Insertion sort: ");
        stream.println("\t" + size1 + " elements\t(observed): " + insertion_1 + " ms");
        stream.println("\t" + size2 + " elements\t(observed): " + insertion_2 + " ms");
        stream.println("\t" + size3 + " elements\t(observed): " + insertion_3 + " ms");
        stream.println("\t" + size4 + " elements\t(observed): " + insertion_4 + " ms");
        stream.println();

        stream.println("Selection sort: ");
        stream.println("\t" + size1 + " elements\t(observed): " + selection_1 + " ms");
        stream.println("\t" + size2 + " elements\t(observed): " + selection_2 + " ms");
        stream.println("\t" + size3 + " elements\t(observed): " + selection_3 + " ms");
        stream.println("\t" + size4 + " elements\t(observed): " + selection_4 + " ms");

        stream.close();

    }

    public static Integer[] buildArray(int n) {
        Random r = new Random(9123);

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt();
        }

        return arr;
    }
}
