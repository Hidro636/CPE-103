
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Robertson
 * @version Program 4
 *
 */
public class TextToMorseTests {

    public TextToMorseTests() {
    }

    @Test
    public void testTranslate() {
        System.out.println("Testing translate()...");
        TextToMorse instance = new TextToMorse();
        String element = "HELLO WORLD";
        Object expResult = ".... . .-.. .-.. ---  .-- --- .-. .-.. -..";
        Object result = instance.translate(element);
        assertEquals(expResult, result);

        element = "THIS IS A LONGER TEST WITH SPACES AND SUCH THAT WILL BE PRETTY LONG";
        expResult = "- .... .. ...  .. ...  .-  .-.. --- -. --. . .-.  - . ... -  .-- .. - ....  ... .--. .- -.-. . ...  .- -. -..  ... ..- -.-. ....  - .... .- -  .-- .. .-.. .-..  -... .  .--. .-. . - - -.--  .-.. --- -. --.";
        result = instance.translate(element);
        assertEquals(expResult, result);
    }
}
