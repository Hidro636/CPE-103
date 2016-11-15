
import java.util.NoSuchElementException;

/**
 *
 * @author Lucas Robertson
 * @version Program 4
 */
public class TextToMorse implements BSTTranslator<CharacterOrder> {

    BST<CharacterOrder> bst;

    public TextToMorse() {

        MorseCode[] codes = new MorseCode[MorseCode.size()];
        for (int i = 0; i < MorseCode.size(); i++) {
            codes[i] = MorseCode.get(i);
        }

        boolean swapped = true;
        int iterations = 0;

        //Sort
        while (swapped) {
            swapped = false;

            for (int i = 0; i < codes.length - 1 - iterations; i++) {
                if (codes[i].getCharacter().compareTo(codes[i + 1].getCharacter()) > 0) {
                    swapped = true;
                    MorseCode temp = codes[i];
                    codes[i] = codes[i + 1];
                    codes[i + 1] = temp;
                }
            }
            iterations++;
        }

        bst = new BST<>();
        buildBST(0, codes.length, codes, bst);
    }

    private void buildBST(int low, int high, MorseCode[] codes, BST<CharacterOrder> bst) {
        int mid = ((high - low) / 2) + low;

        if (mid == low) {
            return;
        }

        bst.insert(new CharacterOrder(codes[mid]));
        buildBST(low, mid, codes, bst);
        buildBST(mid, high, codes, bst);
    }

    @Override
    public BST<CharacterOrder> getBST() {
        return bst;
    }

    @Override
    public String translate(String s) {

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(" ");
            } else {
                try {
                    sb.append(bst.get(new CharacterOrder(c)).getCode());
                    sb.append(" ");
                } catch (NoSuchElementException ses) {

                } catch (Exception ex) {
                    throw ex;
                }
            }
        }

        return sb.toString().trim();
    }

}
