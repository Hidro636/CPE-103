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
 * @author liblabs-user
 */
public class ListWorkTest {
    
    public ListWorkTest() {
    }

    /**
     * Test of search method, of class ListWork.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        Object[] arr = {null, null};
        Object target = null;
        boolean expResult = true;
        boolean result = ListWork.search(arr, null);
        assertEquals(expResult, result);
        
        
       
    }
    
}
