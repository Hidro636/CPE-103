
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
        file.delete();
    }

    @Test
    public void testCompressTime() throws IOException {
        System.out.println("Testing compress() time...");
        String smallFile = "war.txt";
        String largeFile = "rockyou.txt";

        long start, end, smallTime, largeTime;
        Huffman huffman = new Huffman(smallFile);

        start = System.currentTimeMillis();
        huffman.compress(smallFile, "c_" + smallFile);
        end = System.currentTimeMillis();

        smallTime = end - start;

        huffman = new Huffman(largeFile);
        start = System.currentTimeMillis();
        huffman.compress(largeFile, "c_" + largeFile);
        end = System.currentTimeMillis();
        largeTime = end - start;

        assertEquals(smallTime, largeTime / 11, 300);

        File file = new File("c_war.txt");
        file.delete();
        file = new File("c_rockyou.txt");
        file.delete();
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
        file.delete();

        file = new File("textfile_decompressed.txt");
        file.delete();

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
