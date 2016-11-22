
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
        boolean result = instance.isWord(s);
        assertEquals(expResult, result);
        
        
    }
    
    

    /**
     * Test of getDictionary method, of class SpellChecker.
     */
    @Test
    public void testGetDictionary() throws FileNotFoundException {
        System.out.println("getDictionary");
        SpellChecker instance = new SpellChecker();
        HashTableSC<String> expResult = null;
        HashTableSC<String> result = instance.getDictionary();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processFile method, of class SpellChecker.
     */
    @Test
    public void testProcessFile() throws Exception {
        System.out.println("processFile");
        String fileName = "";
        SpellChecker instance = new SpellChecker();
        HashMap<String, SpellChecker.MyStats> expResult = null;
        HashMap<String, SpellChecker.MyStats> result = instance.processFile(fileName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
