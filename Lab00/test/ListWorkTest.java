import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

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

    /**
     * Test of print method, of class ListWork.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Object[] arr = {true, false, null, false, null};
        ListWork.print(arr);
    }
    
}
