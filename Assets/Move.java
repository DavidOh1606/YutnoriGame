package Assets;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Move extends Sprite implements MouseListener {
    
    private static final String FILE = "Images/move.png";

    private static final ImageIcon ICON = new ImageIcon(FILE);

    private int dist;

    private boolean mouseOver;
    private String text;

    public Move(int dist, String text) {
        super(FILE);

        this.dist = dist;
        this.text = text;

        mouseOver = false;

        JLabel textLabel = new JLabel(this.text);
        setBorder(new EmptyBorder(new Insets(5, 0, 0, 0)));

        add(textLabel);

        addMouseListener(this);
        setRescaleFactor(0.8f);
        resetSize();

    }

    public int getDistance() {
        return dist;
    }

    public boolean mouseOver() {
        return mouseOver;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if (GM.moveSelection == this || GM.gameOver) {
            return;
        }


        if (GM.moveSelection != null) {
            GM.moveSelection.setAlpha(1.0f);
            GM.moveSelection.repaint();
        }


        GM.moveSelection = this;



        if (GM.selection != null) {
            GM.map.clearOptions();
            GM.map.displaySelections(this.dist);
        }

        setAlpha(0.8f);
        repaint();
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        if (GM.gameOver) {
            return;
        }

        mouseOver = true;

        if (GM.moveSelection == this) {
            return;
        }

        setAlpha(0.8f);
        repaint();
    }

    public void mouseExited(MouseEvent e) {
        if (GM.gameOver) {
            return;
        }

        mouseOver = false;

        if (GM.moveSelection == this) {
            return;
        }


        setAlpha(1.0f);
        repaint();
    }

    public int getDist() {
        return dist;
    }

    public String toString() {
        return text;
    }

}
