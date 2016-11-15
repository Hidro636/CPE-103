
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Robertson
 * @version Lab 10
 */
public class QuadraticSortsTests {

    public QuadraticSortsTests() {
    }

    /**
     * Test of bubbleSort1 method, of class QuadraticSorts.
     */
    @Test
    public void testBubbleSort1() {
        System.out.println("Testing bubbleSort1()...");
        Comparable[] array = new Integer[]{5, 1, 9, 11, 2, 6, 1, 2, 3, 12, 7};
        QuadraticSorts.bubbleSort1(array);

        assertArrayEquals(array, new Integer[]{1, 1, 2, 2, 3, 5, 6, 7, 9, 11, 12});
    }

    /**
     * Test of bubbleSort2 method, of class QuadraticSorts.
     */
    @Test
    public void testBubbleSort2() {
        System.out.println("Testing bubbleSort2()...");
        Comparable[] array = new Integer[]{5, 1, 9, 11, 2, 6, 1, 2, 3, 12, 7};
        QuadraticSorts.bubbleSort2(array);

        assertArrayEquals(array, new Integer[]{1, 1, 2, 2, 3, 5, 6, 7, 9, 11, 12});

        array = new String[]{"alpha", "gamma", "beta", "rho", "pi", "omicron", "sigma", "epsilon"};
        QuadraticSorts.bubbleSort2(array);
        assertArrayEquals(array, new String[]{"alpha", "beta", "epsilon", "gamma", "omicron", "pi", "rho", "sigma"});

        array = new String[]{"a", "b"};
        QuadraticSorts.bubbleSort2(array);
        assertArrayEquals(array, new String[]{"a", "b"});
    }

    /**
     * Test of insertionSort method, of class QuadraticSorts.
     */
    @Test
    public void testInsertionSort() {
        System.out.println("Testing insertionSort()...");
        Comparable[] array = new Integer[]{5, 1, 9, 11, 2, 6, 1, 2, 3, 12, 7};
        QuadraticSorts.insertionSort(array);

        assertArrayEquals(array, new Integer[]{1, 1, 2, 2, 3, 5, 6, 7, 9, 11, 12});
    }

    /**
     * Test of selectionSort method, of class QuadraticSorts.
     */
    @Test
    public void testSelectionSort() {
        System.out.println("Testing  selectionSort()...");
        Comparable[] array = new Integer[]{5, 1, 9, 11, 2, 6, 1, 2, 3, 12, 7};
        QuadraticSorts.selectionSort(array);

        assertArrayEquals(array, new Integer[]{1, 1, 2, 2, 3, 5, 6, 7, 9, 11, 12});
    }

}
