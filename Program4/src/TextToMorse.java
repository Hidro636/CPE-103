
/**
 *
 * @author Lucas Robertson
 * @version Program 4
 */
public class TextToMorse implements BSTTranslator<CharacterOrder> {

    BST<CharacterOrder> bst;

    public TextToMorse() {

        Character[] chars = new Character[54];
        for (int i = 0; i < 54; i++) {
            chars[i] = MorseCode.get(i).getCharacter();
        }

        boolean swapped = true;
        int iterations = 0;
        while (swapped) {
            swapped = false;

            for (int i = 0; i < chars.length - 1 - iterations; i++) {
                if (chars[i].compareTo(chars[i + 1]) > 0) {
                    swapped = true;
                    char temp = chars[i];
                    chars[i] = chars[i + 1];
                    chars[i + 1] = temp;
                }
            }
            iterations++;
        }

        bst = new BST<>();
        buildBST(0, chars.length, chars, bst);
    }

    private void buildBST(int low, int high, Character[] chars, BST<CharacterOrder> bst) {
        int mid = ((high - low) / 2) + low;

        if (mid == low) {
            return;
        }

        //bst.insert(new CharacterOrder(chars[mid], MorseCode.get(mid));

        buildBST(low, mid, chars, bst);
        buildBST(mid, high, chars, bst);
    }

    @Override
    public BST<CharacterOrder> getBST() {
        return bst;
    }

    @Override
    public String translate(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
