import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class will display the Blackjack GUI
 *
 * @author Mike Mulhearn
 * @author m04.zhang
 */

public class GUI {
    /**
     * The minimum bet at the table
     */
    public static final int MIN_BET = 10;
    /**
     * Each player starts with a default of $1000
     */
    public static final int START_MONEY = 1000;


    public class Game extends JFrame implements ActionListener {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        private Choices playerChoices = new Choices();


        private PlayerPanel human;
        private PlayerPanel ai1;
        private PlayerPanel ai2;
        private PlayerPanel ai3;
        private DealerPanel dealer;

        private Deck deck;
        private boolean turnContinue;

        private Image cardImages;

        /**
         * Class to open the window to display the Blackjack GUI
         */
        public Game() {
            super("Blackjack By Max Zhang");
            getContentPane().setBackground(new Color(20, 170, 30));
            initComponents();    //initialize the components to the frame
            pack();    //pack the JFrame
            setLocationRelativeTo(null);    //center the GUI on the screen
            setResizable(false);    //disable resizing the game window
            setDefaultCloseOperation(EXIT_ON_CLOSE);    //close the window upon exiting
            setVisible(true);    //make the frame visible
        }

        /**
         * Responds to button presses
         *
         * @param e is the event that will be responded to
         */


        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            String oops = "You shouldn't be reading this text"; //Placeholder for executing actual command
            if (command.equals("Hit")) {
                giveCard(human);
                boolean busted = human.getHand().isBusted();
                turnContinue = !busted;
                playerChoices.disableSurrender();
                playerChoices.disableDouble();
            } else if (command.equals("Stand")) {
                turnContinue = false;
            } else if (command.equals("Double")) {
                human.doubleDown();
                giveCard(human);
                turnContinue = false;
            } else if (command.equals("Split")) {
                JOptionPane.showMessageDialog(this, oops);
            } else if (command.equals("Surrender")) {
                JOptionPane.showMessageDialog(this, "See ya!");
                collectCards(human);
                turnContinue = false;
            }
        }


        /**
         * Adds the components to the frame.
         */


        private void initComponents() {
            deck = new Deck();
            turnContinue = true;

            setLayout(new BorderLayout(10, 10));

            dealer = new DealerPanel(MIN_BET, cardImages);
            add(dealer, BorderLayout.LINE_START);

            JPanel players = new JPanel();
            players.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "PLAYERS"));
            human = new PlayerPanel("Human - You", true, -1, START_MONEY, MIN_BET, cardImages);
            ai1 = new PlayerPanel("Computer 1", false, PlayerPanel.EASY, START_MONEY, MIN_BET, cardImages);
            ai2 = new PlayerPanel("Computer 2", false, PlayerPanel.HARD, START_MONEY, MIN_BET, cardImages);
            ai3 = new PlayerPanel("Computer 3", false, PlayerPanel.HARD, START_MONEY, MIN_BET, cardImages);
            players.add(human);
            players.add(ai1);
            players.add(ai2);
            players.add(ai3);
            players.setOpaque(false);
            add(players, BorderLayout.CENTER);
            playerChoices.addListener(this);
            add(playerChoices, BorderLayout.PAGE_END);
            playerChoices.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "CHOICES"));
        }


        /**
         * Gives or takes money from each player
         *
         * @param player
         */

        private void payOut(PlayerPanel player) {
            // surrender check
            if (player.getHand().length() == 0)
                return;

            // blackjack hands
            boolean playerHasBJ = player.getHand().isBlackJack();
            boolean dealerHasBJ = dealer.getHand().isBlackJack();
            if (playerHasBJ && dealerHasBJ) {
                player.addWinnings(player.getCurrentBet());
                if (player.isHuman())
                    JOptionPane.showMessageDialog(this, "We both have Blackjack," +
                            " a push. Your $" + player.getCurrentBet() + "bet is returned.");
                return;
            } else if (playerHasBJ && !dealerHasBJ) {
                player.addWinnings(player.getCurrentBet() * 5 / 2);
                if (player.isHuman())
                    JOptionPane.showMessageDialog(this, "Not bad, Blackjack. " +
                            "You win $" + player.getCurrentBet() * 5 / 2 + ".");
                return;
            } else if (!playerHasBJ && dealerHasBJ) {
                player.addWinnings(0);
                if (player.isHuman())
                    JOptionPane.showMessageDialog(this, "I have Blackjack. " +
                            "Sorry, you lose.");

                return;
            }

            // busting check
            boolean playerHasBusted = player.getHand().isBusted();
            boolean dealerHasBusted = dealer.getHand().isBusted();
            if (playerHasBusted) {
                player.addWinnings(0);
                if (player.isHuman())
                    JOptionPane.showMessageDialog(this, "You have busted. " +
                            "Sorry, you lose.");
                return;
            } else if (dealerHasBusted) {
                player.addWinnings(player.getCurrentBet() * 2);
                if (player.isHuman())
                    JOptionPane.showMessageDialog(this, "Damn, I've busted. " +
                            "You get $" + player.getCurrentBet() * 2 + ".");
                return;
            }

            // normal hands
            int playerValue = player.getHand().getBestValue();
            int dealerValue = dealer.getHand().getBestValue();
            if (playerValue > dealerValue) {
                player.addWinnings(player.getCurrentBet() * 2);
                if (player.isHuman())
                    JOptionPane.showMessageDialog(this, "Looks like you've won. " +
                            "Take your $" + player.getCurrentBet() * 2 + ".");
                return;
            } else if (playerValue == dealerValue) {
                player.addWinnings(player.getCurrentBet());
                if (player.isHuman())
                    JOptionPane.showMessageDialog(this, "A push. Your $" +
                            player.getCurrentBet() + "bet is returned.");
                return;
            } else {
                player.addWinnings(0);
                if (player.isHuman())
                    JOptionPane.showMessageDialog(this, "My hand wins. Better luck" +
                            " next time.");
                return;
            }
        }

        /**
         * Deals cards to the dealer
         *
         * @param dealer The dealer to deal cards to
         */
        private void dealerCards(DealerPanel dealer) {
            Card c1 = deck.draw();
            Card c2 = deck.draw();
            dealer.startHand(c1, c2);
            dealer.flipSecond();
        }

        /**
         * Deals cards to the player
         *
         * @param player The player to deal cards to
         */

        private void dealCards(PlayerPanel player) {
            Card c1 = deck.draw();
            Card c2 = deck.draw();
            player.startHand(c1, c2);
        }

        /**
         * Collects cards from the dealer
         */
        private void collectDealerCards() {
            ArrayList<Card> toCollect = dealer.clearHand();
            for (Card c : toCollect) {
                deck.addToBottom(c);
            }
        }

        /**
         * Collects cards from the player
         *
         * @param player The player to collect cards from
         */

        private void collectCards(PlayerPanel player) {
            ArrayList<Card> toCollect = player.clearHand();
            for (Card c : toCollect) {
                deck.addToBottom(c);
            }
        }

        /**
         * Gives a card to the player
         *
         * @param player
         */

        private void giveCard(PlayerPanel player) {
            player.getHand().addCard(deck.draw());
        }

        /**
         * Enables and disables some buttons
         *
         * @param hitState       The hit button
         * @param standState     The stand button
         * @param doubleState    The double button
         * @param splitState     The split button
         * @param surrenderState The surrender button
         */

        private void setButtonState(boolean hitState, boolean standState,
                                    boolean doubleState, boolean splitState, boolean surrenderState) {
            if (hitState) playerChoices.enableHit();
            else playerChoices.disableHit();
            if (standState) playerChoices.enableStand();
            else playerChoices.disableStand();
            if (doubleState) playerChoices.enableDouble();
            else playerChoices.disableDouble();
            if (splitState) playerChoices.enableSplit();
            else playerChoices.disableSplit();
            if (surrenderState) playerChoices.enableSurrender();
            else playerChoices.disableSurrender();
        }

        /**
         * Asks for bets from players
         */

        private void askBets() {
            human.askBet(deck.getCount());
            ai1.askBet(deck.getCount());
            ai2.askBet(deck.getCount());
            ai3.askBet(deck.getCount());
        }

        /**
         * Deals out cards to players and dealer
         */

        private void deal() {
            dealerCards(dealer);
            dealCards(human);
            dealCards(ai1);
            dealCards(ai2);
            dealCards(ai3);
        }

        /**
         * Asks for AI to do their turns
         */

        public void doAITurns() {
            int aiAction;
            do {
                aiAction = ai1.askComputerAction(dealer.getHand().get(0));
            } while (parseAIActions(ai1, aiAction) == true);
            do {
                aiAction = ai2.askComputerAction(dealer.getHand().get(0));
            } while (parseAIActions(ai2, aiAction) == true);
            do {
                aiAction = ai3.askComputerAction(dealer.getHand().get(0));
            } while (parseAIActions(ai3, aiAction) == true);
        }

        /**
         * Processes the AI's actions
         *
         * @param ai     The AI to parse actions for
         * @param action The action to do
         * @return boolean representing whether the AI will continue to play
         */

        private boolean parseAIActions(PlayerPanel ai, int action) {
            switch (action) {
                case 0:
                    return false;
                case 1:
                    giveCard(ai);
                    return true;
                case 2:
                    return false; //AI never surrenders anyway
                case 3:
                    ai.doubleDown();
                    giveCard(ai);
                    return false;
                default:
                    return false;
            }
        }

        /**
         * Does the dealer's turn
         */

        public void doDealerTurn() {
            dealer.flipSecond();
            while (dealer.getHand().getBestValue() < 17) {
                dealer.getHand().addCard(deck.draw());
            }
        }

        /**
         * Gives out the money
         */

        public void doPayOuts() {
            payOut(ai1);
            payOut(ai2);
            payOut(ai3);
            payOut(human);
        }

        /**
         * Clears the cards on the table
         */

        private void reset() {
            collectCards(human);
            collectCards(ai1);
            collectCards(ai2);
            collectCards(ai3);
            collectDealerCards();
            turnContinue = true;
        }

    }

    /**
     * Runs the Game
     *
     * @param args Main Method
     */
    public static void main(String[] args) {
        GUI b = new GUI();
        Game game = b.new Game();
        JOptionPane.showMessageDialog(game, "Welcome to Mike Mulhearn's House of Cards. " +
                "Today we will be indulging ourselves in a game of Blackjack. " +
                "Please take your seat.");

        while (true) {

            if (game.human.getMoney() < MIN_BET) {
                JOptionPane.showMessageDialog(game, "You don't have enough money to play. YOU LOSE!");
                System.exit(0);
            }

            System.out.println(game.deck.getCount()); //debug mode

            game.askBets();
            game.deal();
            game.repaint();
            game.setButtonState(true, true, true, false, true);
            if (game.human.getCurrentBet() > game.human.getMoney())
                game.playerChoices.disableDouble();
            while (game.turnContinue) {
                game.repaint();
            }
            game.setButtonState(false, false, false, false, false);
            game.doAITurns();
            game.repaint();
            game.doDealerTurn();
            game.repaint();
            game.doPayOuts();
            game.reset();
        }
    }

}