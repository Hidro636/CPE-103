
import java.io.IOException;

/**
 *
 * @author Lucas Robertson
 * @version <insert>
 */
public class Delete {

    public static void main(String[] args) throws IOException {
        Huffman huffman = new Huffman("textfile.txt");
        System.out.println(huffman.toString());
    }

}
