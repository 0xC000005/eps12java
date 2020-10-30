import java.util.ArrayList;

/**
 * @author m04.zhang
 * @version 2020-10-28
 * @project Assignment13 in IntelliJ 2.0
 * @description
 */
public class Player {
    private String name;
    private int score, money, bet;
    private ArrayList<Card> cardHeap = new ArrayList<>();

    public Player(String name) {
        setName(name);
        setMoney(100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
        setMoney(getMoney() - getBet());
        System.out.println(getName() + " has " + getMoney() + "$ left.");
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Card> getCardHeap() {
        return cardHeap;
    }

    public void setCardHeap(ArrayList<Card> cardHeap) {
        this.cardHeap = cardHeap;
    }
}
