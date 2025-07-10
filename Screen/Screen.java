package Screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Assets.Sprite;

public class Screen extends JFrame implements ComponentListener {
    
    public static final String TITLE = "Yutnori";
    public static final int DEFAULT_WIDTH = 1024;
    public static final int DEFAULT_HEIGHT = 768;

    public static float scaleX = 1.0f;
    public static float scaleY = 1.0f;

    private static Screen screen = new Screen();

    private static CardLayout cardLayout;
    private static JPanel cards;
    private static Card card;

    private Screen() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setTitle(TITLE);

        setIconImage(new ImageIcon("Images/yut_icon.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cards = new JPanel();
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);
        add(cards);
        
        card = new Menu();
        cards.add(card, "");
        cardLayout.show(cards, "");

        addComponentListener(this);

        setVisible(true);
    }

    public static Screen getScreen() {
        return screen;
    }

    public static void resetScreenSize() {
        int newWidth = screen.getWidth();
        int newHeight = screen.getHeight();

        scaleX = ((float) newWidth) / DEFAULT_WIDTH;
        scaleY = ((float) newHeight) / DEFAULT_HEIGHT;

        screen.setSize(newWidth, newHeight);
    }

    public static void setCard(Card newCard) {
        Screen.card = newCard;
        cards.add(card, "");
        cardLayout.show(cards, "");
    }

    public void componentResized(ComponentEvent e) {
        resetScreenSize();
        Sprite.resetSpriteSizes();
        card.resetSize();
    }

    public void componentShown(ComponentEvent e) {

    }

    public void componentHidden(ComponentEvent e) {

    }

    public void componentMoved(ComponentEvent e) {

    }


}
