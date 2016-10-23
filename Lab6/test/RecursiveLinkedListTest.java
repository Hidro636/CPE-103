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
public class RecursiveLinkedListTest {

    public RecursiveLinkedListTest() {
    }

    /**
     * Test of add method, of class RecursiveLinkedList.
     */
    @Test
    public void testAdd_int_GenericType() {
        System.out.println("Testing add(index, element)...");
        int index = 0;
        Object element = "String1";
        RecursiveLinkedList instance = new RecursiveLinkedList();
        instance.add(index, element);

        Object expResult, result;
        expResult = 1;
        result = instance.size();
        assertEquals(expResult, result);

        expResult = "String1";
        result = instance.get(index);
        assertEquals(expResult, result);

        instance.add(1, "Test");
        expResult = "Test";
        result = instance.get(1);
        assertEquals(expResult, result);

        try {
            instance.add(3, "test");
            fail();
        } catch (IndexOutOfBoundsException ex) {
        }

        for (int i = 0; i < 100; i++) {
            instance.add(i);
        }

        expResult = 102;
        result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class RecursiveLinkedList.
     */
    @Test
    public void testGet() {
        System.out.println("Testing get()...");
        int index = 1;
        RecursiveLinkedList instance = new RecursiveLinkedList();
        instance.add("Test");
        instance.add("Other");
        instance.add("Something");

        Object expResult = "Other";
        Object result = instance.get(index);
        assertEquals(expResult, result);

        index = 0;
        expResult = "Test";
        result = instance.get(index);
        assertEquals(expResult, result);

        instance.add("Hmm");
        index = 3;
        expResult = "Hmm";
        result = instance.get(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class RecursiveLinkedList.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        int index = 0;
        RecursiveLinkedList instance = new RecursiveLinkedList();
        Object expResult = null;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
