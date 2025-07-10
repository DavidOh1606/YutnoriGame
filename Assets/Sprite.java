package Assets;

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

import javax.imageio.ImageIO;
import java.io.*;

import Screen.*;

import java.util.List;
import java.util.ArrayList;

public class Sprite extends JPanel {

    private float rescaleFactor;
    private boolean rescale;

    private BufferedImage image;
    private int defaultWidth;
    private int defaultHeight;

    private BufferedImage defaultImage;

    private int x;
    private int y;

    private float alpha;


    private static List<Sprite> sprites = new ArrayList<>();

    public Sprite(String file) {

        rescale = true;
        rescaleFactor = 1.0f;
        x = 0;
        y = 0;
        alpha = 1.0f;
        setImage(file);
        setOpaque(false);
        setAlignmentX(0.5f);
        sprites.add(this);
    }

    public void setImage(String file) {
        setImage(Sprite.getBufferedImage(file));
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        defaultWidth = image.getWidth();
        defaultHeight = image.getHeight();
        defaultImage = image;
        resetSize();
    }

    public static BufferedImage getBufferedImage(String file) {
        BufferedImage buffered = null;
        
        try {
            buffered = ImageIO.read(new File(file));
        }

        catch (IOException e) {
            System.exit(-1);
        }

        return buffered;
    }

    public void resetSize() {

        float minScale = Math.min(Screen.scaleX, Screen.scaleY);
        int newWidth = (int) (defaultWidth * minScale);
        int newHeight = (int) (defaultHeight * minScale);

        if (rescale) {
            newWidth = (int) (newWidth * rescaleFactor);
            newHeight = (int) (newHeight * rescaleFactor);
        }

        Image tempImage = defaultImage.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
        BufferedImage newImage = new BufferedImage(newWidth, newHeight, defaultImage.getType());

        Graphics2D g2D = newImage.createGraphics();
        g2D.drawImage(tempImage, 0, 0, null);
        g2D.dispose();

        image = newImage;

        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        revalidate();
        repaint();
    }


    public static void resetSpriteSizes() {
        for (Sprite sprite : sprites) {
            sprite.resetSize();
        }
    }

    public static void clearSprites() {
        sprites.clear();
    }


    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(int[] position) {
        setPosition(position[0], position[1]);
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        repaint();
    }

    public int getPosX() {
        return x;
    }

    public int getPosY() {
        return y;
    }

    public BufferedImage getSpriteImage() {
        return image;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        float[] scales = {alpha, alpha, alpha, alpha};
        float[] offsets = new float[4];
        RescaleOp rop = new RescaleOp(scales, offsets, null);
        
        g2D.drawImage(image, rop, x, y);
    }

    public void setRescaleFactor(float rescaleFactor) {
        this.rescaleFactor = rescaleFactor;
    }

    public void setRescale(boolean rescale) {
        this.rescale = rescale;
    }

    public float getRescaleFactor() {
        return rescaleFactor;
    }
}