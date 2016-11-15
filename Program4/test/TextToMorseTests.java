
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

        element = "JUST. A (BUNCH) OF SYMB@LS";
        expResult = ".--- ..- ... - .-.-.-  .-  -.--.- -... ..- -. -.-. .... -.--.-  --- ..-.  ... -.-- -- -... .--.-. .-.. ...";
        result = instance.translate(element);
        assertEquals(expResult, result);
    }

    @Test
    public void test27_verifyTextToMorseBasic() {
        TextToMorse translator = new TextToMorse();

        for (int i = 0; i < MorseCode.size(); i++) {
            String text = "" + MorseCode.get(i).getCharacter();
            String morse = translator.translate(text);
            System.out.println(MorseCode.get(i).getCharacter());
            assertTrue(morse.equals(MorseCode.get(i).getCode()));
        }
    }
}
