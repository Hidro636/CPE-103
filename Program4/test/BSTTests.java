
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for BST (methods that haven't been tested in previous assignments)
 *
 * @author Lucas Robertson
 * @version Program 4
 */
public class BSTTests {

    public BSTTests() {
    }

    /**
     * Test of get method, of class BST.
     */
    @Test
    public void testGet() {
        System.out.println("Testing get()...");
        Comparable element = "another";
        BST instance = new BST();

        instance.insert("test");
        instance.insert("another");
        instance.insert("hmm");
        instance.insert("yeah");
        instance.insert("words");

        Object expResult = element;
        Object result = instance.get(element);
        assertEquals(expResult, result);

        instance = new BST();

        element = new Tuple(3, 4);
        instance.insert(new Tuple(1, 2));
        instance.insert(new Tuple(5, 1));
        instance.insert(element);

        expResult = element;
        result = instance.get(new Tuple(3, 4));
        assertEquals(expResult, result);

    }

    @Test
    public void testIterator() {
        BST instance = new BST();

        instance.insert("c");
        instance.insert("b");
        instance.insert("a");
        instance.insert("d");
        instance.insert("e");

        Iterator<String> iterator = instance.iterator();
        System.out.println(iterator.next());
    }

    /**
     * For testing purposes only
     */
    private class Tuple implements Comparable<Tuple> {

        private int x;
        private int y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }

        public double mag() {
            return Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
        }

        @Override
        public int compareTo(Tuple o) {
            if (this.mag() > o.mag()) {
                return 1;
            } else if (this.mag() < o.mag()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
