
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for binary heap utilities
 *
 * @author Lucas Robertson
 * @version Lab 5
 */
public class BinaryHeapUtilitiesTests {

    public BinaryHeapUtilitiesTests() {
    }

    /**
     * Test of height method, of class BinaryHeapUtilities.
     */
    @Test
    public void testHeight() {
        System.out.println("height");
        int size = 1;
        int expResult = 0;
        int result = BinaryHeapUtilities.height(size);
        assertEquals(expResult, result);

        size = 4;
        expResult = 2;
        result = BinaryHeapUtilities.height(size);
        assertEquals(expResult, result);

        size = 16;
        expResult = 4;
        result = BinaryHeapUtilities.height(size);
        assertEquals(expResult, result);
    }

    /**
     * Test of isHeap method, of class BinaryHeapUtilities.
     */
    @Test
    public void testIsHeap() {
        System.out.println("Testing isHeap()...");
        Comparable[] heap = new Integer[]{null, 7, 20, 7, 28, 72, 42, 80, 41, 41, 98, 74, 93};
        int size = 12;
        boolean expResult = true;
        boolean result = BinaryHeapUtilities.isHeap(heap, size);
        assertEquals(expResult, result);

        heap = new String[]{null, "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l"};
        result = BinaryHeapUtilities.isHeap(heap, size);
        assertEquals(expResult, result);

        heap = new Integer[]{null, 5, 1, 2, 9, 11, 6, 8, 15, 19, 22, 31};
        size = 11;
        expResult = false;
        result = BinaryHeapUtilities.isHeap(heap, size);
        assertEquals(expResult, result);

    }

    /**
     * Test of leftChildOf method, of class BinaryHeapUtilities.
     */
    @Test
    public void testLeftChildOf() {
        System.out.println("Testing leftChildOf()...");
        int index = 0;
        Comparable[] heap = new Integer[]{null, 7, 20, 7, 28, 72, 42, 80, 41, 41, 98, 74, 93};
        int size = 0;
        Object expResult = null;
        Object result = BinaryHeapUtilities.leftChildOf(index, heap, size);
        assertEquals(expResult, result);
    }

    /**
     * Test of parentOf method, of class BinaryHeapUtilities.
     */
    @Test
    public void testParentOf() {
        System.out.println("parentOf");
        int index = 0;
        Comparable[] heap = null;
        int size = 0;
        Object expResult = null;
        Object result = BinaryHeapUtilities.parentOf(index, heap, size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rightChildOf method, of class BinaryHeapUtilities.
     */
    @Test
    public void testRightChildOf() {
        System.out.println("Testing rightChildOf()...");
        int index = 0;
        Comparable[] heap = null;
        int size = 0;
        Object expResult = null;
        Object result = BinaryHeapUtilities.rightChildOf(index, heap, size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
