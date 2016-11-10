
/**
 *
 * @author Lucas Robertson
 * @version Lab 9
 */
public class BetterHash implements Hashable<String> {

    public BetterHash() {

    }

    @Override
    public int hash(String input) {
        int hash = 0;
        int len = input.length();

        for (int i = 0; i < len; i++) {
            // There are 95 displayable ASCII characters, 97 is the next prime...
            hash = hash * 97 + input.charAt(i);
        }

        return hash;
    }

}
