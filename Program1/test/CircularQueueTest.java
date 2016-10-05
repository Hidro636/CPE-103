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
        System.out.println("Testing dequeue()...");
        CircularQueue instance = new CircularQueue();

        instance.enqueue(1);
        instance.enqueue(2);
        instance.enqueue(3);

        Object expResult = 1;
        Object result = instance.dequeue();
        assertEquals(expResult, result);

        expResult = 3;
        instance.dequeue();
        instance.enqueue(4);
        result = instance.dequeue();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of peek method, of class CircularQueue.
     */
    @Test
    public void testPeek() {
        System.out.println("Testing peek()...");
        CircularQueue instance = new CircularQueue();

        instance.enqueue(3);
        instance.enqueue(2);
        instance.enqueue(1);

        Object expResult = 3;
        Object result = instance.peek();
        assertEquals(expResult, result);

        expResult = 3;
        result = instance.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of size method, of class CircularQueue.
     */
    @Test
    public void testSize() {
        System.out.println("Testing size()...");
        CircularQueue instance = new CircularQueue();
        instance.enqueue(1);
        instance.enqueue(2);
        int expResult = 2;
        int result = instance.size();
        assertEquals(expResult, result);

        instance.dequeue();
        expResult = 1;
        result = instance.size();
        assertEquals(expResult, result);

    }

    /**
     * Test adding and removing large quantities of values, as well as unique
     * enqueue/dequeue situations
     */
    @Test
    public void testMisc() {
        System.out.println("Testing misc...");
        CircularQueue instance = new CircularQueue();
        Object expResult, result;

        for (int i = 0; i < 1000000; i++) {
            instance.enqueue(i);
        }

        for (int i = 0; i < 999999; i++) {
            instance.dequeue();
        }

        expResult = 1;
        result = instance.size();
        assertEquals(expResult, result);

        instance = new CircularQueue();

        instance.enqueue(1);
        instance.enqueue(2);
        instance.enqueue(3);
        instance.enqueue(4);
        instance.enqueue(5);
        instance.enqueue(6);
        instance.enqueue(7);
        instance.enqueue(8);
        instance.enqueue(9);

        expResult = 1;
        result = instance.dequeue();
        assertEquals(expResult, result);

        for (int i = 0; i < 4; i++) {
            instance.dequeue();
        }

        expResult = 5;
        result = instance.dequeue();
        assertEquals(expResult, result);

    }

    private void printArray(CircularQueue instance) {
        System.out.print("Array: ");
        for (Object o : instance.unusualMethodForTestingPurposesOnly()) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

}
