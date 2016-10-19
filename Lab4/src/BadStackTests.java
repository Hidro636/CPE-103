
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for BadStack
 *
 * @author Lucas Robertson
 * @version Lab 3
 */
public class BadStackTests {

    public BadStackTests() {
    }

    /**
     * Test of peek method, of class SimpleArrayStack.
     */
    @Test
    public void testPeek() {
        System.out.println("Testing peek()...");
        BadStack instance = new BadStack();

        instance.push(1);
        instance.push(2);
        instance.push(3);

        Object expResult = 3;
        Object result = instance.peek();
        assertEquals(expResult, result);

        System.out.println("All peek() tests passed!\n");
    }

    /**
     * Test of pop method, of class SimpleArrayStack.
     */
    @Test
    public void testPop() {
        System.out.println("Testing pop()...");
        BadStack instance = new BadStack();

        instance.push("String1");

        //Test first element
        Object expResult = "String1";
        Object result = instance.pop();
        assertEquals(expResult, result);

        //Test after resize
        for (int i = 0; i < 20; i++) {
            instance.push(String.valueOf(i));
        }

        for (int i = 0; i < 5; i++) {
            instance.pop();
        }
        expResult = "14";
        result = instance.pop();
        assertEquals(expResult, result);

        System.out.println("All pop() tests passed!\n");
    }

    /**
     * Test of push method, of class SimpleArrayStack.
     */
    @Test
    public void testPush() {
        System.out.println("Testing push()...");
        Object element = "test";
        BadStack instance = new BadStack();
        instance.push(element);

        //Test resizing (adding lots of elements)
//        for (int i = 0; i < 1000000; i++) {
//            instance.push(String.valueOf(i));
//        }
        System.out.println("All push() tests passed!\n");
    }

    /**
     * Test of size method, of class SimpleArrayStack.
     */
    @Test
    public void testSize() {
        System.out.println("Testing size()...");
        BadStack instance = new BadStack();
        int expResult, result;

        //Test constructed stack
        expResult = 0;
        result = instance.size();
        assertEquals(expResult, result);

        //Test a few items added
        expResult = 4;
        instance.push(3);
        instance.push(2);
        instance.push(15);
        instance.push(1);
        result = instance.size();
        assertEquals(expResult, result);

        //Test a few items removed
        expResult = 2;
        instance.pop();
        instance.pop();
        result = instance.size();
        assertEquals(expResult, result);

        //Test after resize
        for (int i = 0; i < 20; i++) {
            instance.push(i);
        }
        expResult = 22;
        result = instance.size();
        assertEquals(expResult, result);

        System.out.println("All size() tests passed!\n");
    }

    /**
     * Test of capacity method, of class SimpleArrayStack.
     */
    @Test
    public void testCapacity() {
        System.out.println("Testing capacity()...");
        BadStack instance = new BadStack();
        int expResult = 10;
        int result = instance.capacity();
        assertEquals(expResult, result);

        for (int i = 0; i < 20; i++) {
            instance.push(i);
        }
        expResult = 30;
        result = instance.capacity();
        assertEquals(expResult, result);

        System.out.println("All capacity() tests passed!");
    }

}
