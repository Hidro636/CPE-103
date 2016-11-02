
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the methods that were not tested in lab 7 in BST.java
 *
 * @author Lucas Robertson
 * @version Lab 8
 */
public class BSTTests {

    public BSTTests() {
    }

    /**
     * Test of remove method, of class BST.
     */
    @Test
    public void testRemove() {
        System.out.println("Testing remove()...");
        BST instance = new BST();

        instance.insert(5);
        instance.insert(1);
        instance.insert(7);
        instance.insert(6);
        instance.insert(10);
        instance.insert(9);
        instance.insert(8);
        instance.insert(11);
        instance.insert(0);
        instance.insert(-4);
        instance.insert(-6);
        instance.insert(-2);

        Object expResult, result;

        instance.remove(7);
        expResult = 11;
        result = instance.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of treeHeight method, of class BST.
     */
    @Test
    public void testTreeHeight() {
        System.out.println("Testing treeHeight()...");
        BST instance = new BST();
        int expResult = -1;
        int result = instance.treeHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of internalPathLength method, of class BST.
     */
    @Test
    public void testInternalPathLength() {
        System.out.println("internalPathLength");
        BST instance = new BST();
        int expResult = 0;
        int result = instance.internalPathLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
