
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Robertson
 * @version Lab 11
 */
public class ShellSortsTests {

    private final int SEED = 1337;
    private final int SIZE = 1000000;

    public ShellSortsTests() {
    }

    /**
     * Test of heapSort method, of class ShellSorts.
     */
    @Test
    public void testHeapSort() {
        System.out.println("Testing heapSort()...");
        Comparable[] array = new Integer[SIZE];

        Random r = new Random(SEED);
        for (int i = 0; i < SIZE; i++) {
            array[i] = r.nextInt();
        }

        ShellSorts.heapSort(array);

        for (int i = 0; i < SIZE - 1; i++) {
            assertTrue(array[i].compareTo(array[i + 1]) < 0);
        }
    }

    /**
     * Test of hibbard method, of class ShellSorts.
     */
    @Test
    public void testHibbard() {
        System.out.println("Testing hibbard()...");
        Comparable[] array = new Integer[SIZE];

        Random r = new Random(SEED);
        for (int i = 0; i < SIZE; i++) {
            array[i] = r.nextInt();
        }

        ShellSorts.hibbard(array);

        for (int i = 0; i < SIZE - 1; i++) {
            assertTrue(array[i].compareTo(array[i + 1]) < 0);
        }

    }

    /**
     * Test of sedgewick method, of class ShellSorts.
     */
    @Test
    public void testSedgewick() {
        System.out.println("Testing sedgewick()...");
        Comparable[] array = new Integer[SIZE];

        Random r = new Random(SEED);
        for (int i = 0; i < SIZE; i++) {
            array[i] = r.nextInt();
        }

        ShellSorts.sedgewick(array);

        for (int i = 0; i < SIZE - 1; i++) {
            assertTrue(array[i].compareTo(array[i + 1]) < 0);
        }
    }

    /**
     * Test of shell method, of class ShellSorts.
     */
    @Test
    public void testShell() {
        System.out.println("Testing shell()...");
        Comparable[] array = new Integer[SIZE];

        Random r = new Random(SEED);
        for (int i = 0; i < SIZE; i++) {
            array[i] = r.nextInt();
        }

        ShellSorts.shell(array);

        for (int i = 0; i < SIZE - 1; i++) {
            assertTrue(array[i].compareTo(array[i + 1]) < 0);
        }
    }

}
