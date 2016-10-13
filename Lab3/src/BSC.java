
/**
 * A class that checks for balanced symbols in a string
 *
 * @author Lucas Robertson
 * @version Lab 3
 */
public class BSC {

    /**
     * Determines whether the given string contains balanced sets of symbols.
     *
     * @param value The string to check
     * @return True if the string contains balanced symbols, false otherwise
     */
    public static boolean isBalanced(String value) {
        SimpleArrayStack stack = new SimpleArrayStack();

        for (char c : value.toCharArray()) {
            switch (c) {
                case '{':
                case '(':
                case '[':
                case '<':
                    stack.push(c);
                    break;

                case '}':
                case ')':
                case ']':
                case '>':
                    if (stack.size() == 0) {
                        return false;
                    }
                    stack.pop();
                    break;
            }
        }

        return stack.size() == 0;
    }
}
