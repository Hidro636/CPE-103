
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
            this.shuffle();
        }
    }

    public Card draw() {
        return this.dequeue();
    }

    public void shuffle() {

    }

}
