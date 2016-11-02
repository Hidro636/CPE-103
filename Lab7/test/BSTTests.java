
import java.util.ArrayList;
import java.util.List;
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

        instance.insert(1);
        instance.insert(5);
        instance.insert(2);
        instance.insert(6);
        assertEquals(4, instance.size());
    }

    /**
     * Test of contains method, of class BST.
     */
    @Test
    public void testContains() {
        System.out.println("Testing contains()...");
        Comparable element = 5;
        BST instance = new BST();

        instance.insert(element);

        boolean expResult = true;
        boolean result = instance.contains(element);
        assertEquals(expResult, result);

        instance.insert(3);
        instance.insert(1);
        instance.insert(12);

        result = instance.contains(1);
        assertEquals(expResult, result);

        result = instance.contains(12);
        assertEquals(expResult, result);

        expResult = false;
        result = instance.contains(14);
        assertEquals(expResult, result);
    }

    /**
     * Test of minimum method, of class BST.
     */
    @Test
    public void testMinimum() {
        System.out.println("Testing minimum()...");
        BST instance = new BST();

        instance.insert(9);
        instance.insert(3);
        instance.insert(2);
        instance.insert(4);
        instance.insert(3);
        instance.insert(12);
        instance.insert(8);
        instance.insert(10);

        Object expResult = 2;
        Object result = instance.minimum();
        assertEquals(expResult, result);
    }

    /**
     * Test of maximum method, of class BST.
     */
    @Test
    public void testMaximum() {
        System.out.println("Testing maximum()...");
        BST instance = new BST();

        instance.insert(9);
        instance.insert(3);
        instance.insert(2);
        instance.insert(4);
        instance.insert(3);
        instance.insert(12);
        instance.insert(8);
        instance.insert(10);

        Object expResult = 12;
        Object result = instance.maximum();
        assertEquals(expResult, result);
    }

    /**
     * Test of toSortedList method, of class BST.
     */
    @Test
    public void testToSortedList() {
        System.out.println("Testing toSortedList()...");
        BST instance = new BST();

        instance.insert(4);
        instance.insert(12);
        instance.insert(3);
        instance.insert(1);
        instance.insert(8);
        instance.insert(9);
        instance.insert(12);
        instance.insert(33);
        instance.insert(-2);
        instance.insert(-5);

        List<Integer> list = new ArrayList<>();
        instance.toSortedList(list);

        System.out.print("List: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println("\n");
    }

    /**
     * Test of size method, of class BST.
     */
    @Test
    public void testSize() {
        System.out.println("Testing size()...");
        BST instance = new BST();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);

        instance.insert(result);
        expResult = 1;
        result = instance.size();
        assertEquals(expResult, result);

        expResult = 4;
        instance.insert(1);
        instance.insert(4);
        instance.insert(1);
        instance.insert(6);
    }

}
