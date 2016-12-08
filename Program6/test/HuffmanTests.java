
import java.io.BufferedReader;
import java.io.File;
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

}
