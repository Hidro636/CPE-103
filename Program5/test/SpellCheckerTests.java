
import java.io.FileNotFoundException;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Robertson
 * @version Program 5
 */
public class SpellCheckerTests {

    public SpellCheckerTests() {
    }

    /**
     * Test of isWord method, of class SpellChecker.
     */
    @Test
    public void testIsWord() throws FileNotFoundException {
        System.out.println("Testing isWord()...");
        String s = "monkey";
        SpellChecker instance = new SpellChecker("smalldictionary.txt");
        boolean expResult = true;
        boolean result = instance.isWord(s) && instance.isWord(s.toUpperCase());
        assertEquals(expResult, result);

        assertFalse(instance.isWord("cereal"));
    }

    /**
     * Test of processFile method, of class SpellChecker.
     */
    @Test
    public void testProcessFile() throws Exception {
        System.out.println("processFile");
        String fileName = "test.txt";
        SpellChecker instance = new SpellChecker();
        HashMap<String, SpellChecker.MyStats> result = instance.processFile(fileName);

        assertEquals(result.get("this").getOccurrences(), 5);
        assertArrayEquals(new Object[]{1, 1, 3, 3, 4}, result.get("this").getLineNumbers().toArray());
        assertTrue(result.get("this").isWord());
    }

}
