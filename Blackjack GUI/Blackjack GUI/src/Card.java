

/**
 * A class the represents the deck of 52 cards used in Blackjack.
 * Cards can be one of 13 faces, one of four suits, and one of two colors.
 * Methods will get the names, faces, values, suits, or colors of the cards and
 * can flip the card face up or face down.
 *
 * @author Mike Mulhearn
 */
public class Card {

    /**
     * The value of an Ace
     */
    public static final int ACE = 1;
    /**
     * The value of a Two
     */
    public static final int TWO = 2;
    /**
     * The value of a Three
     */
    public static final int THREE = 3;
    /**
     * The value of a Four
     */
    public static final int FOUR = 4;
    /**
     * The value of a Five
     */
    public static final int FIVE = 5;
    /**
     * The value of a Six
     */
    public static final int SIX = 6;
    /**
     * The value of a Seven
     */
    public static final int SEVEN = 7;
    /**
     * The value of an Eight
     */
    public static final int EIGHT = 8;
    /**
     * The value of a Nine
     */
    public static final int NINE = 9;
    /**
     * The value of a Ten
     */
    public static final int TEN = 10;
    /**
     * The value of a Jack
     */
    public static final int JACK = 11;
    /**
     * The value of a Queen
     */
    public static final int QUEEN = 12;
    /**
     * The value of a King
     */
    public static final int KING = 13;
    /**
     * The value of a Spade
     */
    public static final int SPADES = 3;
    /**
     * The value of a Diamond
     */
    public static final int DIAMONDS = 0;
    /**
     * The value of a Club
     */
    public static final int HEARTS = 2;
    /**
     * The value of a Club
     */
    public static final int CLUBS = 1;

    private int suit; //Represents the suit of the card (0-Diamond,1-Club,2-Heart,3-Spade)
    private int face; //Will contain a value from 0 to 12, from Ace to King
    private boolean isFaceUp = true; //Tells whether the card is face up or face down

    /**
     * Create a card with suit cardSuit, face cardFace, and visibility faceUp
     *
     * @param cardSuit is the suit of the card
     * @param cardFace is the face of the card
     * @param faceUp   is true when card is face up, false if face down
     */
    public Card(int cardSuit, int cardFace, boolean faceUp) {
        suit = cardSuit;
        face = cardFace;
        isFaceUp = faceUp;
    }

    /**
     * Create a card with suit cardSuit, face cardFace
     *
     * @param cardSuit is the suit of the Card
     * @param cardFace is the face of the Card
     */
    public Card(int cardSuit, int cardFace) {
        suit = cardSuit;
        face = cardFace;
        isFaceUp = true;
    }

    /**
     * Gets the suit of the card
     *
     * @return integer value with the suit of the card
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Gets the color of the card
     *
     * @return Color of the card as a String
     */
    public String getColor() {
        if (suit == 0 || suit == 2)
            return "Red";
        else
            return "Black";
    }

    /**
     * Gets the face of the Card
     *
     * @return Face of the Card
     */
    public int getFace() {
        return face;
    }

    /**
     * Gets the value of the Card
     * Uses the face of the Card to calculate the value
     * Ace is 1, 2-9 are themselves, 10 and higher are 10
     *
     * @return value of the card
     */
    public int getValue() {
        if (face >= TWO && face <= TEN)
            return face;
        else if (face > TEN)
            return 10;
        return -1;
    }

    /**
     * Gets the highest possible value of the ace
     *
     * @return integer of the highest possible value of the ace
     */
    public int getHighValue() {
        int high = getValue();
        if (high == -1) {
            return 11;
        } else {
            return high;
        }
    }

    /**
     * Gets the lowest value of the ace
     *
     * @return integer of the lowest possible value of the ace
     */
    public int getLowValue() {
        int low = getValue();
        if (low == -1) {
            return 1;
        } else {
            return low;
        }
    }

    /**
     * Flips the card over
     */
    public void flip() {
        isFaceUp = !isFaceUp;
    }

    /**
     * Determines whether the cards are face up
     *
     * @return boolean value representing whether the card is face up or down
     */
    public boolean isFaceUp() {
        return isFaceUp;
    }

    /**
     * Gets the suit name
     *
     * @return String with the suit of the card
     */
    public String getSuitName() {
        return switch (suit) {
            case DIAMONDS -> "Diamonds";
            case CLUBS -> "Clubs";
            case HEARTS -> "Hearts";
            case SPADES -> "Spades";
            default -> "Error: No Suit Found";
        };
    }

    /**
     * Gets the face name
     *
     * @return String with the face of the card
     */
    public String getFaceName() {
        return switch (face) {
            case ACE -> "Ace";
            case TWO -> "Two";
            case THREE -> "Three";
            case FOUR -> "Four";
            case FIVE -> "Five";
            case SIX -> "Six";
            case SEVEN -> "Seven";
            case EIGHT -> "Eight";
            case NINE -> "Nine";
            case TEN -> "Ten";
            case JACK -> "Jack";
            case QUEEN -> "Queen";
            case KING -> "King";
            default -> "Error: No Face Found";
        };
    }
}
