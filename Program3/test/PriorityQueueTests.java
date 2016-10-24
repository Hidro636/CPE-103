
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Robertson
 * @version Program 3
 */
public class PriorityQueueTests {

    public PriorityQueueTests() {
    }

    /**
     * Test of dequeue method, of class PriorityQueue.
     */
    @Test
    public void testDequeue() {
        System.out.println("Testing dequeue()...");
        PriorityQueue instance = new PriorityQueue(true);

//        instance.enqueue(3);
//        instance.enqueue(8);
//        instance.enqueue(1);
//        instance.enqueue(12);
//        instance.enqueue(14);
//        instance.enqueue(6);
        for (int i = 500; i < 1000; i++) {
            instance.enqueue(i);
        }

        for (int i = 249; i >= 0; i--) {
            instance.enqueue(i);
        }

        for (int i = 250; i < 500; i++) {
            instance.enqueue(i);
        }

        Object expResult, result;
        for (int i = 999; i >= 0; i--) {
            expResult = i;
            result = instance.dequeue();
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of enqueue method, of class PriorityQueue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("Testing enqueue()...");
        PriorityQueue instance = new PriorityQueue(false);
        instance.enqueue(7);
        instance.enqueue(20);
        instance.enqueue(28);
        instance.enqueue(41);
        instance.enqueue(41);
        instance.enqueue(72);
        instance.enqueue(98);
        instance.enqueue(74);
        instance.enqueue(7);
        instance.enqueue(42);
        instance.enqueue(43);
        instance.enqueue(80);

        instance._test();
    }

    /**
     * Test of peek method, of class PriorityQueue.
     */
    @Test
    public void testPeek() {
        System.out.println("Testing peek()...");
        PriorityQueue instance = new PriorityQueue();

        instance.enqueue(3);
        instance.enqueue(2);
        instance.enqueue(5);
        instance.enqueue(12);
        instance.enqueue(30);
        instance.enqueue(6);

        Object expResult = 2;
        Object result = instance.peek();
        assertEquals(expResult, result);

    }

    /**
     * Test of size method, of class PriorityQueue.
     */
    @Test
    public void testSize() {
        System.out.println("Testing size()...");
        PriorityQueue instance = new PriorityQueue();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);

        instance.enqueue(3);
        instance.enqueue(1);
        instance.enqueue(5);
        instance.enqueue(9);
        instance._test();

        expResult = 4;
        result = instance.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of kth method, of class PriorityQueue.
     */
    @Test
    public void testKth() {
        System.out.println("kth");
        Comparable[] arr = null;
        int size = 0;
        int k = 0;
        Object expResult = null;
        Object result = PriorityQueue.kth(arr, size, k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sort method, of class PriorityQueue.
     */
    @Test
    public void testSort() {
        System.out.println("Testing sort()...");
        Comparable[] arr = new Integer[]{1, 9, 2, 5, 23, 5, 6, 515, 1, 51, 4123, 23, 2, 1};
        int size = 14;
        PriorityQueue.sort(arr, size);

        System.out.println();

    }

}
