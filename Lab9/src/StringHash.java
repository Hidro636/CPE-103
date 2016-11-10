
/**
 *
 * @author Lucas Robertson
 */
public class StringHash implements Hashable<String> {

    public StringHash() {
    }

    @Override
    public int hash(String input) {
        return input.hashCode();
    }

}
