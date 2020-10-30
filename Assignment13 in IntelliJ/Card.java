
/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card {
    private String description; //five queen etc
    private String suit; //hearts clubs
    private int value; // five = 5 queen = 10

    public Card() {
        setDescription("blank");
        setSuit("blank");
        setValue(0);
    }

    public void Card(String _description, String _suit, int _value) {
        description = _description;
        suit = _suit;
        value = _value;

    }


    public void setDescription(String _description) {
        description = _description;

    }

    public String getDescription() {
        return description;
    }

    public void setSuit(String _suit) {
        suit = _suit;
    }

    public String getSuit() {
        return suit;
    }

    public void setValue(int _value) {
        value = _value;
    }

    public int getValue() {
        return value;
    }

}
