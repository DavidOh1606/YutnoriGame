package Assets;

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

public class Sprite extends JPanel {

    private Image image;

    private BufferedImage bufferedImage;
    private int x;
    private int y;

    private float alpha;

    public Sprite(ImageIcon imageIcon) {

        x = 0;
        y = 0;
        alpha = 1.0f;
        image = imageIcon.getImage();
        bufferedImage = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        bufferedImage.getGraphics().drawImage(image, 0, 0, null);
        setOpaque(false);
        setAlignmentX(0.5f);
        setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));

    }

    public void setImage(ImageIcon imageIcon) {
        this.image = imageIcon.getImage();
        bufferedImage.getGraphics().drawImage(image, 0, 0, null);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(int[] position) {
        this.x = position[0];
        this.y = position[1];
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public int getPosX() {
        return x;
    }

    public int getPosY() {
        return y;
    }

    public BufferedImage getSpriteImage() {
        return bufferedImage;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        float[] scales = {1f * alpha, 1f * alpha, 1f * alpha, 1f * alpha};
        float[] offsets = new float[4];
        RescaleOp rop = new RescaleOp(scales, offsets, null);
        
        g2D.drawImage(bufferedImage, rop, x, y);
    }
}