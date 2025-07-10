package Screen;

import java.awt.*;
import javax.swing.*;
import Assets.Sprite;


public class Card extends JPanel {
    

    // Not necessary to have multiple layers as they are not used
    // However allows for future use of layers
    private JLayeredPane layers;

    private BGPanel background;

    public Card() {
        Sprite.clearSprites();
        setOpaque(false);
        setLayout(null);


        layers = new JLayeredPane();

        background = new BGPanel("Images/bg.png");

        layers.add(background, JLayeredPane.DEFAULT_LAYER);

        layers.setOpaque(false);
        background.setOpaque(false);

        add(layers);
        resetSize();


    }

    public BGPanel getPanel() {
        return background;
    }

    public void resetSize() {
        int width = (int) (Screen.DEFAULT_WIDTH * Screen.scaleX);
        int height = (int) (Screen.DEFAULT_HEIGHT * Screen.scaleY);

        setBounds(0, 0, width, height);
        layers.setBounds(0, 0, width, height);
        background.setBounds(0, 0, width, height);

        revalidate();
        repaint();
    }

}
