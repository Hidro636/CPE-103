
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for card class
 *
 * @author Lucas Robertson
 * @version Program 1
 */
public class CardTest {

    public CardTest() {
    }

    /**
     * Test of getRank method, of class Card.
     */
    @Test
    public void testGetRank() {
        System.out.println("Testing getRank()...");
        Card instance = new Card(5, 2);
        String expResult = "5";
        String result = instance.getRank();
        assertEquals(expResult, result);

        instance = new Card(1, 3);
        expResult = "Ace";
        result = instance.getRank();
        assertEquals(expResult, result);

        instance = new Card(12, 1);
        expResult = "Queen";
        result = instance.getRank();
        assertEquals(expResult, result);
        System.out.println("getRank() passed all tests!\n");
    }

    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuit() {
        System.out.println("Testing getSuit()...");
        Card instance = new Card(2, 1);
        String expResult = "Spades";
        String result = instance.getSuit();
        assertEquals(expResult, result);

        instance = new Card(12, 4);
        expResult = "Clubs";
        result = instance.getSuit();
        assertEquals(expResult, result);

        System.out.println("getSuit() passed all tests!\n");
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        System.out.println("Testing (overriden) toString()...");
        Card instance = new Card(1, 1);
        String expResult = "Ace of Spades";
        String result = instance.toString();
        assertEquals(expResult, result);

        instance = new Card(5, 3);
        expResult = "5 of Diamonds";
        result = instance.toString();
        assertEquals(expResult, result);

        instance = new Card(11, 2);
        expResult = "Jack of Hearts";
        result = instance.toString();
        assertEquals(expResult, result);

        System.out.println("toString() passed all tests!\n");
    }

}
