/**
 * @author m04.zhang
 * @version 2020-10-28
 * @project Assignment13 in IntelliJ 2.0
 * @description
 */
public class Card {
    private String description, suit;
    private int value;

    public Card(String suit, String description, int value) {
        setDescription(description);
        setSuit(suit);
        setValue(value);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
