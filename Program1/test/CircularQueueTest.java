/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author liblabs-user
 */
public class CircularQueueTest {

    public CircularQueueTest() {
    }

    /**
     * Test of dequeue method, of class CircularQueue.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        CircularQueue instance = new CircularQueue();
        Object expResult = null;
        Object result = instance.dequeue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enqueue method, of class CircularQueue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("Testing enqueue()...");
        Object element = "Joe";
        CircularQueue instance = new CircularQueue();
        instance.enqueue(element);

        Object result = instance.size();
        Object expResult = 1;
        assertEquals(expResult, result);
        
        instance.enqueue("Phil");

        printArray(instance.unusualMethodForTestingPurposesOnly());
    }

    /**
     * Test of peek method, of class CircularQueue.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        CircularQueue instance = new CircularQueue();
        Object expResult = null;
        Object result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class CircularQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        CircularQueue instance = new CircularQueue();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private void printArray(Object[] arr) {
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

}
