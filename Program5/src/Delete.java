
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Lucas Robertson
 * @version <insert>
 */
public class Delete {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File f = new File("honeynet.txt");
        System.out.println(f.length() / 1024 * 120);

    }
}
