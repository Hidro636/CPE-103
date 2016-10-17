
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
        System.out.println("isHeap");
        Comparable[] heap = null;
        int size = 0;
        boolean expResult = false;
        boolean result = BinaryHeapUtilities.isHeap(heap, size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leftChildOf method, of class BinaryHeapUtilities.
     */
    @Test
    public void testLeftChildOf() {
        System.out.println("leftChildOf");
        int index = 0;
        Comparable[] heap = null;
        int size = 0;
        Object expResult = null;
        Object result = BinaryHeapUtilities.leftChildOf(index, heap, size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        System.out.println("rightChildOf");
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
