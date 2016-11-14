
/**
 *
 * @author Lucas Robertson
 * @version Program 4
 */
public class MorseOrder extends MorseCode implements Comparable<MorseOrder> {

    public MorseOrder(MorseCode other) {
        super(other.getCharacter(), other.getCode());
    }

    public MorseOrder(Character character, String code) {
        super(character, code);
    }

    @Override
    public int compareTo(MorseOrder o) {
        return this.getCharacter().compareTo(o.getCharacter());
    }

}
