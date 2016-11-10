
import java.util.Random;

/**
 *
 * @author Lucas Robertson
 * @version Lab 9
 */
public class MyHash implements Hashable<String> {


    public MyHash() {

    }

    /**
     * Creates a hash by generating a 'fairly' unique 
     * @param input
     * @return
     */
    @Override
    public int hash(String input) {
        int seed = 0;

        for (int i = 0, j = input.length() - 1; i < input.length(); i++) {
            seed += ((int) input.charAt(i) * (int) input.charAt(j));
        }
        seed *= (int) input.charAt(0);
        seed *= (int) input.charAt(input.length() - 1);
        seed *= (int) input.charAt(input.length() / 2);

        Random r = new Random(seed);

        return r.nextInt(100000000);
    }
}
