
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * PrimeTools tests
 *
 * @author Lucas Robertson
 * @version Lab 9
 */
public class PrimeToolsTest {

    public PrimeToolsTest() {
    }

    @Test
    public void runGeneric() {

//        for (int i = 1; i < 100; i++) {
//            if (PrimeTools.isPrime(i)) {
//                System.out.println(i);
//            }
//        }
        assertEquals(0, 0); //Pass by default
    }

    /**
     * Test of isPrime method, of class PrimeTools.
     */
    @Test
    public void testIsPrime() {
        System.out.println("Testing isPrime()...");
        int value = 4;
        boolean expResult = false;
        boolean result = PrimeTools.isPrime(value);
        assertEquals(expResult, result);
        
        value = 3;
        expResult = true;
        result = PrimeTools.isPrime(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of nextPrime method, of class PrimeTools.
     */
    @Test
    public void testNextPrime() {
        System.out.println("nextPrime");
        int value = 0;
        int expResult = 0;
        int result = PrimeTools.nextPrime(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
