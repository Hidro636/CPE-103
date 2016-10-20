
import java.util.NoSuchElementException;
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
        System.out.println("Testing height()...");
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
    @Test(expected = NoSuchElementException.class)
    public void testLeftChildOf() {
        System.out.println("Testing leftChildOf()...");
        int index = 1;
        Comparable[] heap = new Integer[]{null, 7, 20, 7, 28, 72, 42, 80, 41, 41, 98, 74, 43};
        int size = 12;
        Object expResult = 20;
        Object result = BinaryHeapUtilities.leftChildOf(index, heap, size);
        assertEquals(expResult, result);

        index = 6;
        expResult = 43;
        result = BinaryHeapUtilities.leftChildOf(index, heap, size);
        assertEquals(expResult, result);

        index = 7;
        result = BinaryHeapUtilities.leftChildOf(index, heap, size);

        index = 2;
        expResult = 28;
        result = BinaryHeapUtilities.leftChildOf(index, heap, size);
        assertEquals(expResult, result);
    }

    /**
     * Test of parentOf method, of class BinaryHeapUtilities.
     */
    @Test
    public void testParentOf() {
        System.out.println("Testing parentOf()...");
        int index = 2;
        Comparable[] heap = new Integer[]{null, 7, 20, 7, 28, 72, 42, 80, 41, 41, 98, 74, 43};
        int size = 12;
        Object expResult = 7;
        Object result = BinaryHeapUtilities.parentOf(index, heap, size);
        assertEquals(expResult, result);
    }

    /**
     * Test of rightChildOf method, of class BinaryHeapUtilities.
     */
    @Test(expected = NoSuchElementException.class)
    public void testRightChildOf() {
        System.out.println("Testing rightChildOf()...");
        int index = 1;
        Comparable[] heap = new Integer[]{null, 7, 20, 7, 28, 72, 42, 80, 41, 41, 98, 74, 43};
        int size = 12;
        Object expResult = 7;
        Object result = BinaryHeapUtilities.rightChildOf(index, heap, size);
        assertEquals(expResult, result);

        index = 5;
        expResult = 74;
        result = BinaryHeapUtilities.rightChildOf(index, heap, size);
        assertEquals(expResult, result);

        index = 6;
        result = BinaryHeapUtilities.rightChildOf(index, heap, size);

        index = 2;
        expResult = 72;
        result = BinaryHeapUtilities.rightChildOf(index, heap, size);
        assertEquals(expResult, result);
    }

}
