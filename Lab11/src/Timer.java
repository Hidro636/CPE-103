
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

/**
 * Class that times and prints the sorting methods in ShellSorts.java
 *
 * @author Lucas Robertson
 * @version Lab 11
 */
public class Timer {

    private static final int SEED = 1337;
    private static final int[] SIZES = new int[]{2500, 5000, 10000, 20000, 500000, 1000000};
    private static long start;
    private static long end;

    public static void main(String[] args) throws FileNotFoundException {

        long start;
        long end;
        Integer[] ints = new Integer[5];

        //timeHeapSort();
        //timeShellSort();
        //timeHibbard();
        //timeSedgewick();
    }

    private static void timeHeapSort() throws FileNotFoundException {
        System.out.println("Timing heap sort...");
        long[] deltas = new long[SIZES.length];
        Integer[][] set = getRandomArraySet();
        for (int i = 0; i < SIZES.length; i++) {
            start = System.currentTimeMillis();
            ShellSorts.heapSort(set[i]);
            end = System.currentTimeMillis();
            deltas[i] = end - start;
        }

        writeSet(deltas, "Heap Sort");
    }

    private static void timeShellSort() throws FileNotFoundException {
        System.out.println("Timing shell sort...");
        long[] deltas = new long[SIZES.length];
        Integer[][] set = getRandomArraySet();
        for (int i = 0; i < SIZES.length; i++) {
            start = System.currentTimeMillis();
            ShellSorts.shell(set[i]);
            end = System.currentTimeMillis();
            deltas[i] = end - start;
        }

        writeSet(deltas, "Shell Sort");
    }

    private static void timeHibbard() throws FileNotFoundException {
        System.out.println("Timing hibbard...");
        long[] deltas = new long[SIZES.length];
        Integer[][] set = getRandomArraySet();
        for (int i = 0; i < SIZES.length; i++) {
            start = System.currentTimeMillis();
            ShellSorts.hibbard(set[i]);
            end = System.currentTimeMillis();
            deltas[i] = end - start;
        }

        writeSet(deltas, "Hibbard Variation");
    }

    private static void timeSedgewick() throws FileNotFoundException {
        System.out.println("Timing sedgewick...");
        long[] deltas = new long[SIZES.length];
        Integer[][] set = getRandomArraySet();
        for (int i = 0; i < SIZES.length; i++) {
            start = System.currentTimeMillis();
            ShellSorts.sedgewick(set[i]);
            end = System.currentTimeMillis();
            deltas[i] = end - start;
        }

        writeSet(deltas, "Sedgewick Variation");
    }

    private static void writeSet(long[] times, String name) throws FileNotFoundException {
        PrintStream stream = new PrintStream(new FileOutputStream("report.txt", true));
        stream.println(name + ":");
        for (int i = 0; i < times.length; i++) {
            stream.println("\t" + SIZES[i] + " elements\t(observed):\t" + times[i] + "ms");
        }
        stream.println();
        stream.close();
    }

    private static Integer[][] getRandomArraySet() {
        Random r = new Random(SEED);

        Integer[][] set = new Integer[SIZES.length][];
        for (int i = 0; i < SIZES.length; i++) {
            set[i] = new Integer[SIZES[i]];
            for (int j = 0; j < SIZES[i]; j++) {
                set[i][j] = r.nextInt();
            }
        }

        return set;
    }
}
