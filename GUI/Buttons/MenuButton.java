package GUI.Buttons;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import Assets.Sprite;


public abstract class MenuButton extends Sprite implements MouseListener {
    

    private static final String FILE = "Images/move.png";
    private static final ImageIcon ICON = new ImageIcon(FILE);

    public MenuButton(String text) {
        super(ICON);

        JLabel textBox = new JLabel(text);
        textBox.setAlignmentX(0.5f);
        add(textBox);
        setBorder(new EmptyBorder(new Insets(10, 0, 0, 0)));
        addMouseListener(this);
    }

    public abstract void action();

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        action();
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        setAlpha(0.8f);
        repaint();
    }

    public void mouseExited(MouseEvent e) {
        setAlpha(1.0f);
        repaint();
    }
}
