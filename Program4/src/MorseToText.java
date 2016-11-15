
import java.util.Scanner;

/**
 *
 * @author Lucas Robertson
 * @version Program 4
 */
public class MorseToText implements BSTTranslator<MorseOrder> {

    private BST<MorseOrder> bst;

    public MorseToText() {
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
                if (codes[i].getCode().compareTo(codes[i + 1].getCode()) > 0) {
                    swapped = true;
                    MorseCode temp = codes[i];
                    codes[i] = codes[i + 1];
                    codes[i + 1] = temp;
                }
            }
            iterations++;
        }

        bst = new BST<>();
        buildBST(0, MorseCode.size(), codes, bst);
    }

    private void buildBST(int low, int high, MorseCode[] codes, BST<MorseOrder> bst) {
        int mid = ((high - low) / 2) + low;

        if (mid == low) {
            return;
        }

        bst.insert(new MorseOrder(codes[mid]));
        buildBST(low, mid, codes, bst);
        buildBST(mid, high, codes, bst);
    }

    @Override
    public BST<MorseOrder> getBST() {
        return bst;
    }

    @Override
    public String translate(String s) {
        StringBuilder sb = new StringBuilder();
        Scanner in = new Scanner(s);
        in.useDelimiter(" ");
        String next;
        while (in.hasNext()) {
            next = in.next();
            if (next.equals("")) {
                sb.append(" ");
            } else {
                sb.append(bst.get(new MorseOrder(next)).getCharacter());
            }
        }

        return sb.toString().trim();
    }

}
