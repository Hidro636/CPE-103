
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * A representation of a standard 52 card deck.
 *
 * @author Lucas Robertson
 * @version Program 1
 */
public class Deck extends CircularQueue<Card> {

    public Deck(boolean shuffle) throws MyException {
        super(52);

        for (int s = 1; s <= 4; s++) {
            for (int r = 1; r <= 13; r++) {
                this.enqueue(new Card(r, s));
            }
        }

        if (shuffle) {
            shuffle();
        }
    }

    public Card draw() {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        }

        return this.dequeue();
    }

    public void shuffle() {

        Random r = new Random();

        //Shuffling 100 times for the sake of being thorough
        for (int c = 0; c < 100; c++) {
            int initialSize = this.size();
            //Using normal distribution to simulate splitting *near* the middle of the deck
            //26 is the mean (middle of deck), guesstimating stdv to be 3 cards?
            int location = new Double(r.nextGaussian() * 2 + (initialSize / 2)).intValue();

            //"Splitting" the deck
            CircularQueue<Card> halfA = new CircularQueue<>();
            CircularQueue<Card> halfB = new CircularQueue<>();
            for (int i = 0; i < location; i++) {
                halfA.enqueue(this.dequeue());
            }
            for (int i = location; i < initialSize - location; i++) {
                halfB.enqueue(this.dequeue());
            }

            // Simlulating each half being shuffled back into the deck, sometimes multiple cards fall at once 
            // Normal distribution again, but positive values only
            int cardCount;
            while (this.size() < initialSize) {
                cardCount = new Double(Math.abs(r.nextGaussian() * 2 + 2)).intValue();
                for (int i = 0; i < cardCount; i++) {
                    if (halfA.size() > 0) {
                        this.enqueue(halfA.dequeue());
                    }
                }

                cardCount = new Double(Math.abs(r.nextGaussian() * 2 + 2)).intValue();
                for (int i = 0; i < cardCount; i++) {
                    if (halfB.size() > 0) {
                        this.enqueue(halfB.dequeue());
                    }
                }
            }

        }

    }

}
