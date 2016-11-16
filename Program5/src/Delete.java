
import java.io.BufferedReader;
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
        FileReader fr = new FileReader("dictionary.txt");
        BufferedReader br = new BufferedReader(fr);

        String[] words = new String[260000];

        System.out.println("Building wordlist...");
        for (int i = 0; i < 260000; i++) {
            words[i] = br.readLine();
        }

        br.close();
        fr.close();

        System.out.println("Building map...");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, word.hashCode());
        }

        System.out.println("Checking collision...");
        int col = 0;
        int i = 0;
        for (String word : words) {
            map.remove(word);
            if (map.containsValue(word.hashCode())) {
                System.out.println("Collision!");
                col++;
            }
            
            i++;
            if(i % 10 == 0) {
                System.out.print("\rIteration " + i);
            }
        }

        System.out.println("\nTotal: " + col);
    }
}
