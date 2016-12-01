
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Lucas Robertson
 * @version Program 6
 */
public class Huffman {

    private Node root;

    private class Node implements Comparable<Node> {

        private char character;
        private int frequency;
        private Node left, right;

        public Node(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

        public Node(Node left, Node right) {
            this.frequency = left.frequency + right.frequency;
            this.left = left;
            this.right = right;
            this.character = Character.MIN_VALUE;
        }
        @Override
        public int compareTo(Node o) {
            if (this.frequency > o.frequency) {
                return 1;
            } else if (this.frequency < o.frequency) {
                return -1;
            } else if ((int) this.character > (int) o.character) {
                return -1;
            } else if ((int) this.character < (int) o.character) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public Huffman(String fileName) throws FileNotFoundException, IOException {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        HashMap<Character, Integer> frequencies = new HashMap<>(100);

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            char c = (char) reader.read();
            if (frequencies.containsKey(c)) {
                frequencies.put(c, frequencies.get(c) + 1);
            } else {
                frequencies.put(c, 1);
            }
        }

        reader.close();

        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (queue.size() > 1) {
            queue.add(new Node(queue.poll(), queue.poll()));
        }

        root = queue.poll();
    }

    public void compress(String inFileName, String outFileName) throws IOException {
        FileWriter writer = new FileWriter(outFileName);

    }

    public void decompress(String inFileName, String outFileName) {

    }

    @Override
    public String toString() {
        return "|" + preOrder(root, "") + "|";
    }

    private String preOrder(Node node, String string) {

        if (node.character != Character.MIN_VALUE) {
            System.out.println(node.character);
            string += node.character;
        }

        if (node.left != null) {
            string = preOrder(node.left, string);
        }

        if (node.right != null) {
            string = preOrder(node.right, string);
        }

        return string;
    }
}
