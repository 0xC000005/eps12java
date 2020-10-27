import java.util.ArrayList;
import java.util.Random;


public class Deck {

    private ArrayList<Card> deck = new ArrayList<Card>();
    private final static int NUMBER_OF_DECKS = 4;
    private int numCardsRemaining;
    private int count;
    private final static int FACES_IN_DECK = 13;
    private final static int SUITS_IN_DECK = 4;
    private final static int CARDS_IN_DECK = 52;

    public Deck() {
        for (int i = 0; i < NUMBER_OF_DECKS; i++) {
            for (int j = 0; j < SUITS_IN_DECK; j++) {
                for (int k = 1; k < (FACES_IN_DECK + 1); k++) {
                    deck.add(new Card(j, k));
                }
            }
        }
        shuffle();
    }

    public void shuffle() {
        ArrayList<Card> shuffleDeck = new ArrayList<Card>();
        Random random = new Random();
        while (deck.size() > 0) {
            int cardToRemove = random.nextInt(deck.size());
            Card shuffleCard = deck.get(cardToRemove);
            deck.remove(cardToRemove);
            shuffleDeck.add(shuffleCard);
        }
        while (shuffleDeck.size() > 0) {
            Card shuffleCard = shuffleDeck.get(0);
            shuffleDeck.remove(0);
            deck.add(shuffleCard);
        }
        count = 0;
        numCardsRemaining = NUMBER_OF_DECKS * CARDS_IN_DECK;
    }

    public Card draw() {
        Card toDraw = deck.get(0);
        deck.remove(0);
        numCardsRemaining--;
        int face = toDraw.getFace();
        if (face >= Card.TWO && face <= Card.SIX)
            count++;
        if (face >= Card.TEN || face == Card.ACE)
            count--;
        return toDraw;
    }

    /**
     * Gets the current card count (AI only)
     *
     * @return Integer representing the current card count
     */
    public int getCount() {
        double decksLeft = (double) numCardsRemaining / CARDS_IN_DECK;
        return (int) Math.round(count / decksLeft);
    }

    /**
     * Adds a card to the bottom of the deck
     *
     * @param bottom is the Card to be added the bottom of the deck
     */
    public void addToBottom(Card bottom) {
        deck.add(bottom);
        if (numCardsRemaining < 20) {
            shuffle();
        }
    }

}
