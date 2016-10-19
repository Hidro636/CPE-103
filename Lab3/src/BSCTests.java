
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the Balanced Symbol Checker
 *
 * @author Lucas Robertson
 * @version Lab 3
 */
public class BSCTests {

    public BSCTests() {
    }

    /**
     * Test of isBalanced method, of class BSC.
     */
    @Test
    public void testIsBalanced() {
        System.out.println("Testing isBalanced()...");
        String value = "{}";
        boolean expResult = true;
        boolean result = BSC.isBalanced(value);
        assertEquals(expResult, result);

        result = BSC.isBalanced("( [ { < ( ) <( ){}>> } ] )");
        assertEquals(expResult, result);

        result = BSC.isBalanced("((fasdf(asdf)()(2312312 (fs df()()sdff))dsfsdf))");
        assertEquals(expResult, result);

        expResult = false;
        result = BSC.isBalanced("{}{");
        assertEquals(expResult, result);

        result = BSC.isBalanced("}");
        assertEquals(expResult, result);

        result = BSC.isBalanced("( [ { < ( ) <( ){}>> } ] ) )");
        assertEquals(expResult, result);

    }

}
