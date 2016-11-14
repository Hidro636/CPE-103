
import java.util.ArrayList;

/**
 *
 * @author Lucas Robertson
 * @version <insert>
 */
public class DeleteME {

    public static void main(String[] args) {
        ArrayList<Character> chars = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            chars.add(MorseCode.get(i).getCharacter());
        }

        boolean swapped = true;
        int iterations = 0;
        while (swapped) {
            swapped = false;

            for (int i = 0; i < chars.size() - 1 - iterations; i++) {
                if (chars.get(i).compareTo(chars.get(i + 1)) > 0) {
                    swapped = true;
                    char temp = chars.get(i);
                    chars.set(i, chars.get(i + 1));
                    chars.set(i + 1, temp);
                }
            }
            iterations++;
        }

        for (Character c : chars) {
            System.out.print(c + " ");
        }

        System.out.println("\nTook " + iterations);

        BST<Character> bst = buildBST(chars);
        
        System.out.println("Height: " + bst.treeHeight());
    }

    private static BST<Character> buildBST(ArrayList<Character> chars) {
        BST<Character> bst = new BST<>();
        buildBSTHelper(0, chars.size() - 1, chars, bst);

        return bst;
    }

    private static void buildBSTHelper(int low, int high, ArrayList<Character> chars, BST<Character> bst) {
        int mid = ((high - low) / 2) + low;

        if (mid == low) {
            return;
        }

        bst.insert(chars.get(mid));
        System.out.println("Inserted: " + chars.get(mid));

        buildBSTHelper(low, mid, chars, bst);
        buildBSTHelper(mid, high, chars, bst);
    }
}
