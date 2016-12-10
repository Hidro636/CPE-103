
import java.io.IOException;

/**
 *
 * @author Lucas Robertson
 * @version <insert>
 */
public class Console {

    public static void main(String[] args) throws IOException {
        Huffman h = new Huffman("test.txt");
        h.compress("test.txt", "out.txt");
    }
}
