
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for SimpleLinkedQueue.java
 *
 * @author Lucas Robertson
 * @version Lab 2
 */
public class SimpleLinkedQueueTest {

    /**
     * Test constructor
     */
    public SimpleLinkedQueueTest() {
    }

    /**
     * Test of dequeue method, of class SimpleLinkedQueue.
     */
    @Test
    public void testDequeue() {
        System.out.println("Testing dequeue()...");
        SimpleLinkedQueue instance = new SimpleLinkedQueue();

        instance.enqueue("James");
        instance.enqueue("Lori");
        instance.enqueue("Taylor");
        instance.enqueue("Larry");

        Object expResult = "James";
        Object result = instance.dequeue();
        assertEquals(expResult, result);

        instance.dequeue();
        expResult = "Taylor";
        result = instance.dequeue();
        assertEquals(expResult, result);
    }

    /**
     * Test of enqueue method, of class SimpleLinkedQueue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("Testing enqueue()...");
        Object element = "John";

        SimpleLinkedQueue instance = new SimpleLinkedQueue();
        instance.enqueue(element);

    }

    /**
     * Test of peek method, of class SimpleLinkedQueue.
     */
    @Test
    public void testPeek() {
        System.out.println("Testing peek()...");
        SimpleLinkedQueue instance = new SimpleLinkedQueue();
        instance.enqueue("Test");

        Object expResult = "Test";
        Object result = instance.peek();
        assertEquals(expResult, result);

        instance.enqueue("Test2");
        instance.enqueue("Test3");
        result = instance.peek();
        assertEquals(expResult, result);

        instance.dequeue();
        instance.dequeue();
        expResult = "Test3";
        result = instance.peek();
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class SimpleLinkedQueue.
     */
    @Test
    public void testSize() {
        System.out.println("Testing size()...");
        SimpleLinkedQueue instance = new SimpleLinkedQueue();

        //Test 0 elements
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);

        //Test after adding elements
        instance.enqueue(3);
        instance.enqueue(5);
        instance.enqueue(12);
        instance.enqueue(0);

        expResult = 4;
        result = instance.size();
        assertEquals(expResult, result);

        //Test after removing elements
        instance.dequeue();
        expResult = 3;
        result = instance.size();
        assertEquals(expResult, result);
    }

}
