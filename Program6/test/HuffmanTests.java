
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Robertson
 * @version Program 6
 */
public class HuffmanTests {

    public HuffmanTests() {
    }

    /**
     * Test of compress method, of class Huffman.
     */
    @Test
    public void testCompress() throws Exception {
        System.out.println("compress");
        String inFileName = "";
        String outFileName = "";
        Huffman instance = null;
        instance.compress(inFileName, outFileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decompress method, of class Huffman.
     */
    @Test
    public void testDecompress() {
        System.out.println("decompress");
        String inFileName = "";
        String outFileName = "";
        Huffman instance = null;
        instance.decompress(inFileName, outFileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Huffman.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Huffman instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
