
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the SimpleLinkedStack class
 *
 * @author Lucas Robertson
 * @version Program 2
 */
public class SimpleLinkedStackTests {

    public SimpleLinkedStackTests() {
    }

    /**
     * Test of peek method, of class SimpleLinkedStack.
     */
    @Test
    public void testPeek() {
        System.out.println("Testing peek()...");
        SimpleLinkedStack instance = new SimpleLinkedStack();

        instance.push(1);

        Object expResult = 1;
        Object result = instance.peek();
        assertEquals(expResult, result);

        instance.push(5);
        instance.push(3);
        expResult = 3;
        result = instance.peek();
        assertEquals(expResult, result);

        instance.pop();
        expResult = 5;
        result = instance.peek();
        assertEquals(expResult, result);
    }

    /**
     * Test of pop method, of class SimpleLinkedStack.
     */
    @Test
    public void testPop() {
        System.out.println("Testing pop()...");
        SimpleLinkedStack instance = new SimpleLinkedStack();

        instance.push(5);

        Object expResult = 5;
        Object result = instance.pop();
        assertEquals(expResult, result);

        instance.push(1);
        instance.push(5);
        instance.pop();

        expResult = 1;
        result = instance.pop();
        assertEquals(expResult, result);
    }

    /**
     * Test of push method, of class SimpleLinkedStack.
     */
    @Test
    public void testPush() {
        System.out.println("Testing push()...");
        Object element = 3;
        SimpleLinkedStack instance = new SimpleLinkedStack();
        instance.push(element);
    }

    /**
     * Test of size method, of class SimpleLinkedStack.
     */
    @Test
    public void testSize() {
        System.out.println("Testing size()...");
        SimpleLinkedStack instance = new SimpleLinkedStack();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);

        instance.push(5);
        instance.push(2);
        instance.push(1);

        expResult = 3;
        result = instance.size();
        assertEquals(expResult, result);

        instance.pop();
        expResult = 2;
        result = instance.size();
        assertEquals(expResult, result);
    }

}
