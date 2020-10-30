import java.util.ArrayList;

/**
 * @author m04.zhang
 * @version 2020-10-28
 * @project Assignment13 in IntelliJ 2.0
 * @description
 */
public class Game {
    private Player humanPlayer, CPUPlayer;
    private final Deck deck = new Deck();
    private static final int minimumMoney = 10;
    private final Input input = new Input();

    public Game() {
        initGame();
        while (humanPlayer.getMoney() >= minimumMoney && CPUPlayer.getMoney() >= minimumMoney) {
            setPlayerBets();
            calculatePlayerScore(humanPlayer);
            calculatePlayerScore(CPUPlayer);
            checkOut();
        }
    }

    public void initHumanPlayer() {
        System.out.print("Please input your name: ");
        humanPlayer = new Player(input.getString());
    }

    public void initCPUPlayer() {
        CPUPlayer = new Player("CPU");
    }

    public void initGame() {
        System.out.println("Welcome to the Poker Game!");
        System.out.println("The game will automatically stop when one player has less than " + minimumMoney + "$.");
        initHumanPlayer();
        initCPUPlayer();
    }

    public void displayPlayersMoney(Player currentPlayer) {
        System.out.println(currentPlayer.getName() + " has " + currentPlayer.getMoney() + "$. ");
    }

    public void setPlayerBets() {
        displayPlayersMoney(humanPlayer);
        System.out.print("Hi " + humanPlayer.getName() + ", please input your bet for this round: ");
        humanPlayer.setBet(input.getIntWithBetCheck(humanPlayer));
        System.out.println();
        displayPlayersMoney(CPUPlayer);
        System.out.println("Hi " + CPUPlayer.getName() + ", please input your bet for this round: " + CPUPlayer.getMoney() / 2);
        CPUPlayer.setBet(CPUPlayer.getMoney() / 2);
    }

    public int calculateSumOfCards(ArrayList<Card> currentCardHeap) {
        int sum = 0;
        for (Card currentCard : currentCardHeap) {
            sum += currentCard.getValue();
        }
        return sum;
    }

    public boolean[] initBooleanArray(boolean[] array) {
        array[0] = false; //fiveOfAKind = false
        array[1] = false; //fourOfAKind = false
        array[2] = false; //threeOfAKind = false
        array[3] = false; //twoPairs = false
        array[4] = false; //onePairs = false
        array[5] = false; //straightFlush = false
        array[6] = true; //straight = true
        array[7] = true; //flush = true
        array[8] = false; //fullHouse = false
        array[9] = false; //highCard = false
        return array;
    }

    public int findTheLargestCardBonus(boolean[] cardsBonusType) {
        if (cardsBonusType[5]) return 10;
        if (cardsBonusType[0]) return 9;
        if (cardsBonusType[1]) return 8;
        if (cardsBonusType[8]) return 7;
        if (cardsBonusType[7]) return 6;
        if (cardsBonusType[6]) return 5;
        if (cardsBonusType[2]) return 4;
        if (cardsBonusType[3]) return 3;
        if (cardsBonusType[4]) return 2;
        return 1;
    }

    public String getTheLargestCardBonus(int largestCardBonusCode) {
        switch (largestCardBonusCode) {
            case 10:
                return "Straight Flush!";
            case 9:
                return "Five of A Kind!";
            case 8:
                return "Four of A Kind!";
            case 7:
                return "Full House!";
            case 6:
                return "Flush!";
            case 5:
                return "Straight!";
            case 4:
                return "Three of A Kind!";
            case 3:
                return "Two Pairs!";
            case 2:
                return "One Pair";
            case 1:
                return "High Cards";
        }
        return "High Cards";
    }

    public void displaySingleCard(Card card) {
        System.out.println(card.getSuit() + " of " + card.getDescription());
    }

    public void displayPlayerCardHeap(ArrayList<Card> currentPlayerCardHeap, String name) {
        System.out.println("Here is " + name + "'s five cards: ");
        System.out.println();
        for (Card currentCard : currentPlayerCardHeap) {
            displaySingleCard(currentCard);
        }
        System.out.println();
    }

    public void calculatePlayerScore(Player currentPlayer) {
        System.out.println();
        deck.pop5CardsToPlayer(currentPlayer);
        boolean[] cardsBonusType = initBooleanArray(new boolean[10]);
        ArrayList<Card> currentPlayerCardHeap = currentPlayer.getCardHeap();

        displayPlayerCardHeap(currentPlayerCardHeap, currentPlayer.getName());

        int[] cardValues = new int[14];
        for (int i = 0; i < currentPlayerCardHeap.size(); i++) {
            Card currentCard = currentPlayerCardHeap.get(i);
            cardValues[currentCard.getValue()]++;
            if (i != 4)
                if (!currentPlayerCardHeap.get(i).getSuit().equals(currentPlayerCardHeap.get(i + 1).getSuit()))
                    cardsBonusType[7] = false;
        }

        for (int i = 0; i < 13; i++) {
            if (cardValues[i] == 5) cardsBonusType[0] = true;
            if (cardValues[i] == 4) cardsBonusType[1] = true;
            if (cardValues[i] == 3) cardsBonusType[2] = true;
            if (cardValues[i] == 2) {
                if (cardsBonusType[4]) cardsBonusType[3] = true;
                else cardsBonusType[4] = true;
            }
            if (((cardValues[i] == 1) && (cardValues[i + 1] != 1))) cardsBonusType[6] = false;
        }
        if (cardsBonusType[6] && cardsBonusType[7]) cardsBonusType[5] = true;
        if (cardsBonusType[2] && cardsBonusType[4]) cardsBonusType[8] = true;

        int cardBonus = findTheLargestCardBonus(cardsBonusType);
        System.out.println(currentPlayer.getName() + " got " + getTheLargestCardBonus(cardBonus));
        int playerScore = calculateSumOfCards(currentPlayerCardHeap) + cardBonus;
        currentPlayer.setScore(playerScore);
        System.out.println(currentPlayer.getName() + "'s score = " + calculateSumOfCards(currentPlayerCardHeap) + " + " + cardBonus + " = " + currentPlayer.getScore());
    }

    public void displayScores(Player winner, Player loser, int statusCode) {
        System.out.println(winner.getName() + ": " + winner.getScore() + " vs. " + loser.getName() + ": " + loser.getScore());
        if (statusCode == 1) {
            System.out.println(winner.getName() + " is the winner for this round! ");
        }
        if (statusCode == 2) {
            System.out.println("There is no winner for this round! ");
        }
    }

    public void checkOut() {
        System.out.println();
        if (humanPlayer.getScore() > CPUPlayer.getScore()) {
            displayScores(humanPlayer, CPUPlayer, 1);
            transMoney(humanPlayer, CPUPlayer, 1);
        }
        if (humanPlayer.getScore() < CPUPlayer.getScore()) {
            displayScores(CPUPlayer, humanPlayer, 1);
            transMoney(CPUPlayer, humanPlayer, 1);
        }
        if (humanPlayer.getScore() == CPUPlayer.getScore()) {
            displayScores(humanPlayer, CPUPlayer, 2);
            transMoney(humanPlayer, CPUPlayer, 2);
        }
        System.out.println();
    }

    public void transMoney(Player winner, Player loser, int statusCode) {
        if (statusCode == 1) {
            System.out.println(winner.getName() + " got $" + loser.getBet() + " from this round. ");
            winner.setMoney(winner.getMoney() + winner.getBet() + loser.getBet());
        }
        if (statusCode == 2) {
            winner.setMoney(winner.getMoney() + winner.getBet());
            loser.setMoney(loser.getMoney() + loser.getBet());
        }
    }

    public static void main(String[] args) {
        Game testGame = new Game();
    }
}
