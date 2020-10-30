import java.util.*;

/**
 * @author (Danny Tsang)
 * @version (Oct 26, 2020)
 */

public class Deck {
    //private Input myInput;
    private ArrayList<Card> myDeck;
    private Card tempCard, myCard, cpuCard;
    public static final String[] SUITS = {"Hearts", "Diamonds", "Spades", "Clubs"};
    // SUITS[0] = Hearts, SUITS[1] = Diamonds, 
    // SUITS[2] = Spades, SUITS[3] = Clubs, SUITS[4] = null
    public static final String[] DESCRIPTIONS = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    public static final int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    public Deck() {
        myDeck = new ArrayList<Card>();
        tempCard = new Card();
        myCard = new Card();
        cpuCard = new Card();
        // myInput = new Input();
        play();
    }

    public void addCard(Card newCard) {
        myDeck.add(newCard);
    }

    public Card takeCard() {
        Card tossCard = myDeck.get(0);
        myDeck.remove(0);
        return tossCard;
    }

    public void showDeck() {
        for (Card tempCard : myDeck) {
            System.out.println(tempCard.getDescription() + " of " + tempCard.getSuit() + " is worth " + tempCard.getValue());
        }
    }

    public void loadDeck() {
        for (int y = 0; y < 4; y++) {

            for (int x = 0; x < 13; x++) {
                tempCard.setDescription(DESCRIPTIONS[x]);
                tempCard.setSuit(SUITS[y]);
                tempCard.setValue(VALUES[x]);
                addCard(tempCard);
                tempCard = new Card();
            }

        }

    }

    public void swap(int _num1, int _num2) {
        Card tempCard = myDeck.get(_num1); //tempCard is ACe of Hearts
        myDeck.set(_num1, myDeck.get(_num2));//First card is now Two of Hearts
        myDeck.set(_num2, tempCard);// 

    }

    public void shuffle() {
        for (int x = 1; x <= 1000; x++) {
            int random1 = (int) (Math.random() * 51);
            int random2 = (int) (Math.random() * 51);
            swap(random1, random2);
        }
    }

    public void play() {
        loadDeck();
        shuffle();
        for (int x = 1; x <= 5; x++) {
            myCard = takeCard();
            System.out.println("You have " + myCard.getDescription() + " of " +
                    myCard.getSuit());
        }
        System.out.println();
        for (int x = 1; x <= 5; x++) {
            cpuCard = takeCard();
            System.out.println("I have " + cpuCard.getDescription() + " of " +
                    cpuCard.getSuit());
        }

    }

    public static void main(String[] args) {
        Deck testObject = new Deck();
    }

}
