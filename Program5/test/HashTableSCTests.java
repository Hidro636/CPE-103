/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class HashTableSCTests {

    

    public HashTableSCTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of collisions method, of class HashTableSC.
     */
    @Test
    public void testCollisions() {
        System.out.println("collisions");
        HashTableSC instance = null;
        long expResult = 0L;
        long result = instance.collisions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of maxCollisions method, of class HashTableSC.
     */
    @Test
    public void testMaxCollisions() {
        System.out.println("maxCollisions");
        HashTableSC instance = null;
        int expResult = 0;
        int result = instance.maxCollisions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class HashTableSC.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object element = null;
        HashTableSC instance = null;
        boolean expResult = false;
        boolean result = instance.add(element);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class HashTableSC.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object element = null;
        HashTableSC instance = null;
        boolean expResult = false;
        boolean result = instance.contains(element);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class HashTableSC.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        HashTableSC instance = null;
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadFactor method, of class HashTableSC.
     */
    @Test
    public void testLoadFactor() {
        System.out.println("loadFactor");
        HashTableSC instance = null;
        double expResult = 0.0;
        double result = instance.loadFactor();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class HashTableSC.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object element = null;
        HashTableSC instance = null;
        boolean expResult = false;
        boolean result = instance.remove(element);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class HashTableSC.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        HashTableSC instance = null;
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tableSize method, of class HashTableSC.
     */
    @Test
    public void testTableSize() {
        System.out.println("tableSize");
        HashTableSC instance = null;
        int expResult = 0;
        int result = instance.tableSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
