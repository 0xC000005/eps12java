import java.util.ArrayList;
import java.util.Collections;

/**
 * @author m04.zhang
 * @version 2020-10-28
 * @project Assignment13 in IntelliJ 2.0
 * @description
 */
public class Deck {
    ArrayList<Card> deck;
    public static final String[] SUITS = {"Hearts", "Diamonds", "Spades", "Clubs"};
    public static final String[] DESCRIPTIONS = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    public static final int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    public Deck() {
        loadDeck();
    }

    public void getNewCardDeck() {
        deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (int value : VALUES) {
                String description = DESCRIPTIONS[value - 1];
                deck.add(new Card(suit, description, value));
            }
        }
    }

    public void loadDeck() {
        getNewCardDeck();
        Collections.shuffle(deck);
    }

    public void pop5CardsToPlayer(Player currentPlayer) {
        ArrayList<Card> currentPlayerCardHeap = new ArrayList<>();
        if (deck.size() < 5) {
            System.out.println("Warning, we have less 5 cards remain in the deck, reshuffle. + \n");
            loadDeck();
        }
        for (int i = 0; i < 5; i++) {
            currentPlayerCardHeap.add(deck.get(0));
            deck.remove(0);
        }
        currentPlayer.setCardHeap(currentPlayerCardHeap);
    }

}
