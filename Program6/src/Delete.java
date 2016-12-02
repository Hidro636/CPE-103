
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Lucas Robertson
 * @version <insert>
 */
public class Delete {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        Huffman huffman = new Huffman("test.txt");
        huffman.compress("test.txt", "output.txt");
        huffman.decompress("output.txt", "translated.txt");
    }

}
