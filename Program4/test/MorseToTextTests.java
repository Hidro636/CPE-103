
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Robertson
 * @version Program 4
 */
public class MorseToTextTests {

    public MorseToTextTests() {
    }

    /**
     * Test of translate method, of class MorseToText.
     */
    @Test
    public void testTranslate() {
        System.out.println("Testing translate()...");
        String s = ".... . .-.. .-.. ---  .-- --- .-. .-.. -.. ...";
        MorseToText instance = new MorseToText();
        String expResult = "HELLO WORLDS";
        String result = instance.translate(s);
        assertEquals(expResult, result);

        expResult = "(SOMETHING) WITH A $LOT OF .SYMBO_LS";
        s = "-.--. ... --- -- . - .... .. -. --. -.--.-  .-- .. - ....  .-  ...-..- .-.. --- -  --- ..-.  .-.-.- ... -.-- -- -... --- ..--.- .-.. ...";
        result = instance.translate(s);
        assertEquals(expResult, result);
    }

}
