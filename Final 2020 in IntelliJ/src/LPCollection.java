import java.util.ArrayList;

/**
 * Write a description of class LPCollection here.
 * <p>
 * Complete the rest of this programming. When you create
 * a new LPCollection object it will automatically run
 * as follows. If you choose a the entire collection shows
 * if you choose g, then the computer asks for genre and displays
 * only the genre type. Include errorChecking for upper and
 * lower case and only accept the letters as shown below
 * ------------------------------------------------------
 * My LP Collection
 * <p>
 * What would you like to see?
 * <p>
 * Whole collection (a) or by genre (g)? g
 * <p>
 * Genre type (c)lassic rock (p)op (r)ock (h)ip hop? h
 * <p>
 * Artist:      Title:      Genre:  Value:
 * <p>
 * Drake        Views       Hip Hop $19.99
 * Drake        Scorpion    Hip Hop $20.99
 * ----------------------------------------------
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LPCollection {
    private final ArrayList<LP> LPCollection = new ArrayList<>();
    private static final int maximumLength = 16;
    private final Input input = new Input();

    public static final String[] ARTIST = {"Genesis", "Genesis", "Fleetwood Mac", "Van Halen", "Van Halen", "Culture Club", "Britney Spears", "Drake", "Drake", "Journey"};
    public static final


    String[] TITLE = {"ABACAB", "Invisible Touch", "Rumours", "Diver Down", "1984", "Karma Cameleon", "Greatest Hits", "Views", "Scorpion", "Escape"};
    public static final String[] GENRE = {"Classic Rock", "Classic Rock", "Classic Rock", "Rock", "Rock", "Pop", "Pop", "Hip Hop", "Hip Hop", "Pop"};
    public static final double[] VALUE = {3.99, 5.99, 4.99, 5.99, 6.99, 3.99, 8.99, 19.99, 20.99, 9.99};


    public LPCollection() {
        displayCollection();
    }

    public void loadLPs() {
        for (int x = 0; x < 10; x++) LPCollection.add(new LP(ARTIST[x], TITLE[x], GENRE[x], VALUE[x]));
    }

    public void displayCollection() {
        loadLPs();
        System.out.println("My LP Collection\n");
        askUserOptionForDisplay();
    }

    public String generatePlaceHolder(int occupiedLength) {
        return " ".repeat(Math.max(0, maximumLength - occupiedLength));
    }

    public void displayASingleLP(LP currentLP) {
        System.out.println(currentLP.getArtist() + generatePlaceHolder(currentLP.getArtist().length())
                + currentLP.getTitle() + generatePlaceHolder(currentLP.getTitle().length())
                + currentLP.getGenre() + generatePlaceHolder(currentLP.getGenre().length()) + "$"
                + String.format("%.2f", currentLP.getValue()));
    }


    public void displayTheCollection(ArrayList<LP> LPList) {
        System.out.println("Artist:         Title:          Genre:         Value:\n");
        for (LP currentLP : LPList) displayASingleLP(currentLP);
    }

    public void displayWholeCollection() {
        displayTheCollection(LPCollection);
    }

    public void displayCollectionByType(String type) {
        ArrayList<LP> LPCollectionWithCertainGenre = new ArrayList<>();
        for (LP currentLP : LPCollection)
            if (currentLP.getGenre().equalsIgnoreCase(type)) LPCollectionWithCertainGenre.add(currentLP);
        displayTheCollection(LPCollectionWithCertainGenre);
    }

    public void askUserDisplayOptionByType() {
        System.out.print("Genre type (c)lassic rock (p)op (r)ock (h)ip hop? ");
        switch (input.getUserOptionForDisplayByType()) {
            case "c" -> {
                System.out.println();
                displayCollectionByType("Classic Rock");
            }
            case "p" -> {
                System.out.println();
                displayCollectionByType("Pop");
            }
            case "r" -> {
                System.out.println();
                displayCollectionByType("Rock");
            }
            case "h" -> {
                System.out.println();
                displayCollectionByType("Hip Hop");
            }
        }
    }

    public void askUserOptionForDisplay() {
        System.out.println("What would you like to see?\n");
        System.out.print("Whole collection (a) or by genre (g)? ");
        switch (input.getUserOptionForDisplay()) {
            case "a" -> {
                System.out.println();
                displayWholeCollection();
            }
            case "g" -> {
                System.out.println();
                askUserDisplayOptionByType();
            }
        }
    }

    public static void main(String[] args) {
        LPCollection testObject = new LPCollection();
    }
}

