

/**
 *
 * @author Lucas Robertson
 * @version Program 4
 */
public class CharacterOrder extends MorseCode implements Comparable<CharacterOrder> {

    public CharacterOrder(Character character, String code) {
        super(character, code);
    }

    @Override
    public int compareTo(CharacterOrder o) {
        return this.getCharacter().compareTo(o.getCharacter());
    }

}
