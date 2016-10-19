
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the RPN class
 *
 * @author Lucas Robertson
 * @version Program 2
 */
public class RPNTests {

    public RPNTests() {
    }

    /**
     * Test of evaluateInfix method, of class RPN.
     */
    @Test
    public void testEvaluateInfix() {
        System.out.println("Testing evaluateInfix()...");
        String infix = "5 + ( 1 + 2 ) * 4 - 3";
        double expResult = 14;
        double result = RPN.evaluateInfix(infix);
        assertEquals(expResult, result, 0.0);

        //Easy test as long as the other two functions work
    }

    /**
     * Test of evaluateRPN method, of class RPN.
     */
    @Test
    public void testEvaluateRPN() {
        System.out.println("Testing evaluateRPN()...");
        String expression = "5 1 +";
        double expResult = 6;
        double result = RPN.evaluateRPN(expression);
        assertEquals(expResult, result, 0.0);

        expression = "5 1 2 + 4 * + 3 -";
        expResult = 14;
        result = RPN.evaluateRPN(expression);
        assertEquals(expResult, result, 0.0);

        expression = "6 4 3 + 2 - * 6 /";
        expResult = 5;
        result = RPN.evaluateRPN(expression);
        assertEquals(expResult, result, 0.0);

        expression = "5 2 4 * + 7 2 - 4 6 2 / 2 - * + 4 - +";
        expResult = 18;
        result = RPN.evaluateRPN(expression);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toRPN method, of class RPN.
     */
    @Test
    public void testToRPN() {
        System.out.println("Testing toRPN()...");
        String infix = "5 + ( 1 + 2 ) * 4 - 3";
        String expResult = "5 1 2 + 4 * + 3 -";
        String result = RPN.toRPN(infix);
        assertEquals(expResult, result);

        infix = "5 * ( 6 + 3 - 7 * 3 + 2 ) / 6";
        expResult = "5 6 3 + 7 3 * - 2 + * 6 /";
        result = RPN.toRPN(infix);
        assertEquals(expResult, result);

        infix = "8 + 3 * 4 + ( 6 - 2 + 2 * ( 6 / 3 - 1 ) - 3 )";
        expResult = "8 3 4 * + 6 2 - 2 6 3 / 1 - * + 3 - +";
        result = RPN.toRPN(infix);
        assertEquals(expResult, result);

    }

}
