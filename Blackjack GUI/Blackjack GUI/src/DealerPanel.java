import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * A container that represents the Dealer.
 * It has a hand (dealer's hand) and the card images file.
 * Similar to PlayerPanel.
 *
 * @author Mike Mulhearn
 */
public class DealerPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Hand hand;

    /**
     * Initializes a JPanel name "dealer". Card
     * graphics are dealt with automatically by paintComponent(g).
     *
     * @param cardImages card image map file
     */
    public DealerPanel(int minimumBet, Image cardImages) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //vertical layout
        setPreferredSize(new Dimension(99, 320));
        setOpaque(false);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "DEALER"));

        hand = null;

    }

    /**
     * Returns the hand of the dealer, probably for comaparison purposes.
     *
     * @return dealers hand
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Clears the hand and returns it in an ArrayList
     *
     * @return ArrayList containing the cleared hand
     */
    public ArrayList<Card> clearHand() {
        return hand.clearHand();
    }

    /**
     * Creates a hand with Card c1 and Card c2
     *
     * @param c1 First card to be added
     * @param c2 Second card to be added
     */
    public void startHand(Card c1, Card c2) {
        hand = new Hand(c1, c2);
    }

    /**
     * Flips the second card in the hand
     */
    public void flipSecond() {
        hand.get(1).flip();
        repaint();
    }

    /**
     * Checks if there's an ace in the dealer's hand
     *
     * @return Boolean representing whether an ace is present
     */
    public boolean checkAce() {
        return hand.get(0).getFace() == Card.ACE;
    }


    /**
     * Paints the cards stacked top-down in addition to the rest of the
     * components. The cards are arranged so the user can still see all of
     * the cards' values.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (hand == null) return;
        for (int i = 0; i < hand.length(); i++) {
            drawCard(g, hand.get(i), 10, 76 + 33 * i);
        }
    }

    /**
     * Paints a card image onto (x,y) of the container. A face down card will
     * be drawn accordingly.
     *
     * @param g    the graphics context
     * @param card the card to be printed
     * @param x    the x-position of the printed card in this container
     * @param y    the y-position of the printed card in this container
     */

    private void drawCard(Graphics g, Card card, int x, int y) {
        String face = "";
        String suit = "";
        String filepath = "";

        if (!card.isFaceUp()) {
            suit = "b1";
            face = "fv";
        } else {
            face = String.valueOf(card.getFace());
            if (face == "11") {
                face = "j";
            }
            if (face == "12") {
                face = "q";
            }
            if (face == "13") {
                face = "k";
            }
            switch (card.getSuit()) {
                case Card.DIAMONDS:
                    suit = "d";
                    break;
                case Card.CLUBS:
                    suit = "c";
                    break;
                case Card.HEARTS:
                    suit = "h";
                    break;
                default:
                    suit = "s";
                    break; //Spades
            }
            BufferedImage cardImg = null;
            filepath = System.getProperty("user.dir") + "\\Blackjack GUI\\src\\images\\" + suit + face + ".png";
            try {
                cardImg = ImageIO.read(new File(filepath));
            } catch (IOException e) {
            }
            g.drawImage(cardImg, x, y, 71, 96, this);

        }

    }

}
