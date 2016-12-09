
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Robertson
 * @version Program 6
 */
public class HuffmanTests {

    private static Huffman h;
    
    public HuffmanTests() {
    }

    @Test
    public void testExample() throws IOException {
        System.out.println("Testing given example...");
        String inFileName = "test.txt";
        String outFileName = "test_compressed.txt";
        String decompressedFile = "test_decompressed.txt";
        Huffman instance = new Huffman(inFileName);
        instance.compress(inFileName, outFileName);

        assertEquals(instance.toString(), "| bdca|");
        //assertEquals(instance.toString(), "|fwchognisrat|");

        BufferedReader reader = new BufferedReader(new FileReader(outFileName));
        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            sb.append((char) reader.read());
        }
        reader.close();

        assertEquals("11011011000011011010011010011", sb.toString());

        instance.decompress(outFileName, decompressedFile);

        reader = new BufferedReader(new FileReader(decompressedFile));
        BufferedReader reader2 = new BufferedReader(new FileReader(inFileName));

        while (reader.ready() && reader2.ready()) {
            assertEquals(reader.read(), reader2.read());
        }

        reader.close();
        reader2.close();

    }

    /**
     * Test of compress method, of class Huffman.
     */
    @Test
    public void testCompress() throws Exception {
        System.out.println("Testing compress()...");
        String inFileName = "textfile.txt";
        String outFileName = "textfile_compressed.txt";
        Huffman instance = new Huffman("textfile.txt");
        instance.compress(inFileName, outFileName);

        //Cleanup
        File file = new File(outFileName);
        //file.delete();
    }

    /**
     * Test of decompress method, of class Huffman.
     */
    @Test
    public void testDecompress() throws IOException {
        System.out.println("Testing decompress()...");
        String inFileName = "textfile_compressed.txt";
        String outFileName = "textfile_decompressed.txt";
        Huffman instance = new Huffman("textfile.txt");
        instance.compress("textfile.txt", "textfile_compressed.txt");
        instance.decompress(inFileName, outFileName);

        BufferedReader reader = new BufferedReader(new FileReader("textfile.txt"));
        BufferedReader d_reader = new BufferedReader(new FileReader("textfile_decompressed.txt"));

        while (reader.ready()) {
            assertEquals(reader.read(), d_reader.read());
        }

        reader.close();
        d_reader.close();

        File file = new File("textfile_compressed.txt");
        //file.delete();

        file = new File("textfile_decompressed.txt");
        //file.delete();
    }

    /**
     * Test of toString method, of class Huffman.
     */
    @Test
    public void testToString() throws IOException {
        System.out.println("Testing toString()...");
        Huffman instance = new Huffman("textfile.txt");
        String expResult = "|acb|";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test(timeout=10000)
   public void test04a_createHuffman_file0() throws FileNotFoundException, IOException {
      h = new Huffman("file0.txt");
      String s = h.toString();
      assertEquals("| bdca|", s);
   }
   @Test(timeout=10000)
   public void test04b_compress_file0() throws FileNotFoundException, IOException {
      h.compress("file0.txt", "file0_compressed.txt");
      Process proc = Runtime.getRuntime().exec("FC file0_compressed_solution.txt file0_compressed.txt");
      assertEquals(-1, proc.getInputStream().read());
      assertEquals(-1, proc.getErrorStream().read());
   }
   @Test(timeout=10000)
   public void test04c_decompress_file0() throws FileNotFoundException, IOException {
      h.decompress("file0_compressed.txt", "file0_copy.txt");
      Process proc = Runtime.getRuntime().exec("FC file0_copy_solution.txt file0_copy.txt");
      assertEquals(-1, proc.getInputStream().read());
      assertEquals(-1, proc.getErrorStream().read());
   }

}
