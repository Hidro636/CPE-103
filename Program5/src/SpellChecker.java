
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lucas Robertson
 * @version Program 5
 */
public class SpellChecker {

    private HashTableSC<String> table;

    public class MyStats {

        /**
         * Returns a list containing all line numbers the string was on
         *
         * @return a list containing all line numbers the string was on
         */
        public List<Integer> getLineNumbers() {
            throw new UnsupportedOperationException();
        }

        /**
         * Returns the number of times the string has been seen.
         *
         * @return the number of times the string has been seen
         */
        public int getOccurrences() {
            throw new UnsupportedOperationException();
        }

        /**
         * Returns true if the string is a word; false otherwise.
         *
         * @return true if the string is a word; false otherwise
         */
        public boolean isWord() {
            throw new UnsupportedOperationException();
        }

    }

    /**
     * Creates and initializes a HashTableSC to contain all the words from the
     * provided dictionary if dictionary.txt is not found
     *
     * @throws FileNotFoundException
     */
    public SpellChecker() throws FileNotFoundException {
        Scanner input = new Scanner(new File("dictionary.txt"));
        table = new HashTableSC(600000);

        while (input.hasNextLine()) {
            table.add(input.nextLine());
        }

        input.close();
    }

    /**
     * Creates and initializes a HashTableSC to contain all the words from the
     * specified file
     *
     * @param fileName the name of the dictionary file from which you will read
     * words
     * @throws FileNotFoundException if the specified file is not found
     */
    public SpellChecker(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        table = new HashTableSC(600000);

        while (input.hasNextLine()) {
            table.add(input.nextLine());
        }

        input.close();

    }

    /**
     * Determines if the specified string is a word based on the current
     * dictionary. To be a word, either the input string must appear in the
     * dictionary verbatim, or a lowercase version of the string must appear in
     * the dictionary.
     *
     * @param s the string to check for correct spelling
     * @return true if the specified string is a word based on the current
     * dictionary
     */
    public boolean isWord(String s) {
        return table.contains(s) || table.contains(s.toLowerCase());
    }

    /**
     * Returns the hash table of words begin used as a dictionary.
     *
     * @return the hash table of words being used as a dictionary
     */
    public HashTableSC<String> getDictionary() {
        return table;
    }

    /**
     * Reads though the specified file and returns a HashMap mapping each string
     * in the file to an instance of SpellChecker.MyStats. MyStats contains
     * information about if the string is spelled correctly, how many times the
     * string occurs, and on which line numbers it occurs. Line numbers start at
     * 1.
     *
     * @param fileName the name of the file from which you will read strings
     * @return a HashMap mapping each string in the given file to an instance of
     * MyStats maintaining various statistics for that string
     * @throws java.io.FileNotFoundException if the specified file is not found
     */
    public HashMap<String, SpellChecker.MyStats> processFile(String fileName) throws FileNotFoundException {
        throw new UnsupportedOperationException();
    }
}
