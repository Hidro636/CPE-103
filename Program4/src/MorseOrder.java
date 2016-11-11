
/**
 *
 * @author Lucas Robertson
 * @version Program 4
 */
public class MorseOrder extends MorseCode implements Comparable<MorseOrder> {

    public MorseOrder(MorseCode other) {
        super(other);
    }

    public MorseOrder(Character character, String code) {
        super(character, code);
    }

    @Override
    public int compareTo(MorseOrder o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
