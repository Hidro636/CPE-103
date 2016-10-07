
/**
 * A representation of a card in a standard 52 card deck. The ranks are "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", and "King". The suits are "Spades", "Hearts", "Diamonds", and "Clubs".
 *
 * @author Lucas Robertson
 * @version Program 1
 */
public class Card {

    /*
    SUITS ----------------
    1 = Spades
    2 = Hearts
    3 = Diamonds
    4 = Clubs
    
    RANKS ----------------
    1 = Ace
    11 = Jack
    12 = Queen
    13 = King
     */
    private int rank;
    private int suit;

    /**
     * Constructs a card with the specified rank and suit. The rank will be
     * given as a number between 1 and 13 representing "Ace" through "King". The
     * suit will be given as a number between 1 and 4 representing "Spades",
     * "Hearts", "Diamonds", and "Clubs" respectively.
     *
     * @param rank the rank of the card
     * @param suit the suit of the card
     */
    public Card(int rank, int suit) {

        if (rank < 1 || rank > 13 || suit < 1 || suit > 4) {
            throw new IllegalArgumentException("Valid arguments for rank are integers 1-13 and 1-4 for suit");
        }

        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Returns the rank of this card as a String. This will be one of "Ace",
     * "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", or "King".
     *
     * @return the rank of this card
     */
    public String getRank() {
        switch (this.rank) {
            case 1:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return String.valueOf(this.rank);

        }
    }

    /**
     * Returns the suit of this card as a String. This will be one of "Spades",
     * "Hearts", "Diamonds", or "Clubs".
     *
     * @return the suit of this card
     */
    public String getSuit() {
        switch (this.suit) {
            case 1:
                return "Spades";
            case 2:
                return "Hearts";
            case 3:
                return "Diamonds";
            case 4:
                return "Clubs";
            default: //Should never default
                return "N/A";
        }
    }

    /**
     * Returns the name of this card. This will be of the form "&lt;RANK&gt; of
     * &lt;SUIT&gt;", e.g. "Ace of Spades" or "6 of Clubs".
     *
     * @return the name of this card
     */
    @Override
    public String toString() {
        return this.getRank() + " of " + getSuit();
    }

}
