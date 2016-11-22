
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

        private List<Integer> lineNumbers;
        private int occurrences;
        private boolean isWord;

        public MyStats(List<Integer> lineNumbers, int nextLineNumber, int occurrences, boolean isWord) {
            this.lineNumbers = lineNumbers;
            this.lineNumbers.add(nextLineNumber);

            this.occurrences = occurrences;
            this.isWord = isWord;
        }

        /**
         * Returns a list containing all line numbers the string was on
         *
         * @return a list containing all line numbers the string was on
         */
        public List<Integer> getLineNumbers() {
            return this.lineNumbers;
        }

        /**
         * Returns the number of times the string has been seen.
         *
         * @return the number of times the string has been seen
         */
        public int getOccurrences() {
            return this.occurrences;
        }

        /**
         * Returns true if the string is a word; false otherwise.
         *
         * @return true if the string is a word; false otherwise
         */
        public boolean isWord() {
            return this.isWord;
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
        File file = new File(fileName);
        Scanner input = new Scanner(file);

        //Overestimate with c = 120, observed most dictionary-style text files to contain ~90-120 lines/byte
        //Should provide a decent table size given the length of the file, although long lines could break it
        //table = new HashTableSC((int) file.length() / 1024 * 120);
        table = new HashTableSC(600000);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println("Added " + line);
            table.add(line);
        }
        System.out.println(table.contains("cow"));
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
        return table.contains(s) /*|| table.contains(s.toLowerCase())*/;
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
        Scanner fileScanner = new Scanner(new File(fileName));
        Scanner lineScanner;
        HashMap<String, MyStats> map = new HashMap<>();
        int lineNumber = 1;

        String word;
        while (fileScanner.hasNextLine()) {
            lineScanner = new Scanner(fileScanner.nextLine());
            lineScanner.useDelimiter("[^\\w-']+");

            while (lineScanner.hasNext()) {
                word = lineScanner.next();

                if (map.containsKey(word)) {
                    MyStats stat = map.get(word);
                    map.put(word, new MyStats(stat.getLineNumbers(), lineNumber, stat.getOccurrences() + 1, stat.isWord));
                } else {
                    map.put(word, new MyStats(new ArrayList<Integer>(), lineNumber, 1, this.isWord(word)));
                }

            }

            lineNumber++;
        }

        fileScanner.close();

        return map;
    }
}
