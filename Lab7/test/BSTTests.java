
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Robertson
 * @version Lab 7
 * @version CPE 103-03
 */
public class BSTTests {
    
    public BSTTests() {
    }

    /**
     * Test of insert method, of class BST.
     */
    @Test
    public void testInsert() {
        System.out.println("Testing insert()...");
        Comparable element = 1;
        BST instance = new BST();
        instance.insert(element);
        
        assertEquals(1, instance.size());
    }

    /**
     * Test of contains method, of class BST.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Comparable element = null;
        BST instance = new BST();
        boolean expResult = false;
        boolean result = instance.contains(element);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minimum method, of class BST.
     */
    @Test
    public void testMinimum() {
        System.out.println("minimum");
        BST instance = new BST();
        Object expResult = null;
        Object result = instance.minimum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of maximum method, of class BST.
     */
    @Test
    public void testMaximum() {
        System.out.println("maximum");
        BST instance = new BST();
        Object expResult = null;
        Object result = instance.maximum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toSortedList method, of class BST.
     */
    @Test
    public void testToSortedList() {
        System.out.println("toSortedList");
        BST instance = new BST();
        instance.toSortedList(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class BST.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        BST instance = new BST();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
