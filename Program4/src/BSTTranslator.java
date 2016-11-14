
/**
 *
 * @author Lucas Robertson
 * @version Program 4
 * @param <T> The generic type of the BST translator
 */
public interface BSTTranslator<T extends Comparable<? super T>> {

    public BST<T> getBST();

    /**
     * Translate the given string from one form to another
     *
     * @param s The string to be translated
     * @return a translated form of the given string
     */
    public String translate(String s);
}
