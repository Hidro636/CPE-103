
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
        System.out.println("bubbleSort2");
        Comparable[] array = null;
        QuadraticSorts.bubbleSort2(array);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertionSort method, of class QuadraticSorts.
     */
    @Test
    public void testInsertionSort() {
        System.out.println("insertionSort");
        Comparable[] array = null;
        QuadraticSorts.insertionSort(array);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectionSort method, of class QuadraticSorts.
     */
    @Test
    public void testSelectionSort() {
        System.out.println("selectionSort");
        Comparable[] array = null;
        QuadraticSorts.selectionSort(array);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
