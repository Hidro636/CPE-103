
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A representation of a hand of playing cards to be used in a game. Cards will
 * remain in the order they were added to the hand.
 *
 * @author Lucas Robertson
 * @version Program 1
 */
public class Hand {

    private Deck deck;
    private ArrayList<Card> hand;

    /**
     * Constructs a hand of cards of the specified size by repeatedly drawing
     * cards from the specified deck.
     *
     * @param deck the deck from which to draw cards
     * @param handSize the initial size of the player's hand
     */
    public Hand(Deck deck, int handSize) {

        if (handSize <= 0) {
            throw new IllegalArgumentException("Hand size must be positive!");
        } else if (deck.size() < handSize) {
            throw new NoSuchElementException("Deck is smaller than the hand size!");
        }

        //initialize
        this.deck = deck;
        this.hand = new ArrayList<>();

        //add cards to hand
        for (int i = 0; i < handSize; i++) {
            hand.add(deck.dequeue());
        }
    }

    /**
     * Draws a card from the deck specified in the constructor and adds it to
     * this hand.
     *
     */
    public void draw() {
        if (deck.size() == 0) {
            throw new NoSuchElementException("The deck is empty");
        }

        this.hand.add(deck.dequeue());
    }

    /**
     * Returns the card at the specified position in this hand.
     *
     * @param cardNumber the index of the card to return
     * @return the card at the specified location in this hand
     */
    public Card getCard(int cardNumber) {
        return hand.get(cardNumber);
    }

    /**
     * Removes and returns the card at the specified position in this hand.
     * Shifts any subsequent cards to the left.
     *
     * @param cardNumber the index of the card to play
     * @return the card that was played from this hand
     */
    public Card play(int cardNumber) {
        return hand.remove(cardNumber);
    }

    /**
     * Returns the number of cards in this hand.
     *
     * @return the number of cards in this hand
     *
     */
    public int size() {
        return hand.size();
    }

}
