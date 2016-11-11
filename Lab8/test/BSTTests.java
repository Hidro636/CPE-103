
import java.util.ArrayList;
import java.util.Arrays;
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
        Object expResult, result;
        instance.insert("a");
        instance.insert("b");
        instance.insert("c");
        instance.insert("d");
        instance.insert("e");

        //instance._print();
        instance.remove("b");
        //instance._print();

    }

    //@Test
    public void someTest() {
        BST<String> bst = new BST<String>();
        String[] strings = new String[]{"Hello", "these", "are", "some", "random", "strings.", "If", "this",
            "test", "fails", "it's", "likely", "because", "the", "BST", "code", "being", "tested",
            "uses", "compareTo", "incorrectly", "by", "looking", "for", "1", "and", "-1", "instead",
            "of", "> 0 and", "< 0."};
        String[] sortedStrings = new String[strings.length];
        String[] otherStrings = new String[]{"things", "that", "do", "not", "exist", "in", "strings"};
        ArrayList<String> sortedList = new ArrayList<String>();
        int i;

        for (i = 0; i < strings.length; i++) {
            sortedStrings[i] = strings[i];
            bst.insert(strings[i]);
        }
        for (i = 0; i < strings.length; i++) {
            assertTrue(bst.contains(strings[i]));
        }

        for (i = 0; i < otherStrings.length; i++) {
            assertFalse(bst.contains(otherStrings[i]));
        }

        Arrays.sort(sortedStrings);
        assertEquals(sortedStrings[0], bst.minimum());
        assertEquals(sortedStrings[sortedStrings.length - 1], bst.maximum());

        bst.toSortedList(sortedList);
        i = 0;
        for (String s : sortedList) {
            assertEquals("" + i, sortedStrings[i], s);
            i++;
        }
        int size = bst.size();
        assertEquals(strings.length, bst.size());

        for (String s : strings) {
            bst.remove(s);
            //System.out.print(s + ": ");
            //bst._print();
            assertFalse(bst.contains(s));
            assertEquals(--size, bst.size());
        }
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

        instance.insert(2);
        expResult = 0;
        result = instance.treeHeight();
        assertEquals(expResult, result);

        instance.insert(1);
        expResult = 1;
        result = instance.treeHeight();
        assertEquals(expResult, result);

        instance.insert(5);
        result = instance.treeHeight();
        assertEquals(expResult, result);

        instance.insert(6);
        instance.insert(7);
        instance.insert(8);
        expResult = 4;
        result = instance.treeHeight();
        assertEquals(expResult, result);

        instance.insert(4);
        instance.insert(3);
        instance.insert(0);
        result = instance.treeHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of internalPathLength method, of class BST.
     */
    @Test
    public void testInternalPathLength() {
        System.out.println("Testing internalPathLength()...");
        BST instance = new BST();
        int expResult = -1;
        long result = instance.internalPathLength();
        assertEquals(expResult, result);

        instance.insert(1);
        expResult = 0;
        result = instance.internalPathLength();
        assertEquals(expResult, result);

        instance.insert(0);
        instance.insert(2);
        expResult = 2;
        result = instance.internalPathLength();
        assertEquals(expResult, result);

        instance.insert(5);
        instance.insert(12);
        instance.insert(11);
        instance.insert(15);
        expResult = 15;
        result = instance.internalPathLength();
        assertEquals(expResult, result);

    }

}
