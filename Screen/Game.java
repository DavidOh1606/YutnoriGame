package Screen;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Assets.*;
import java.util.List;
import java.util.ArrayList;
import GUI.Buttons.*;
import java.awt.event.*;

public class Game extends Screen implements MouseListener {
    

    public Game() {
        super();

        BGPanel panel = new BGPanel(new ImageIcon("Images/bg.png"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();

        // Left Panel setup

        // YutPanel setup
        JPanel yutPanel = new JPanel();
        Yut yut1 = new Yut();
        Yut yut2 = new Yut();
        Yut yut3 = new Yut();
        Yut yut4 = new Yut();
        
        //Backdo backdo = new Backdo();

        yutPanel.setLayout(new FlowLayout());
        List<Yut> yutList = new ArrayList<>();
        yutList.add(yut1);
        yutList.add(yut2);
        yutList.add(yut3);
        yutList.add(yut4);

        for (Yut yut : yutList) {
            yutPanel.add(yut);
        }


        yutPanel.setOpaque(false);
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.add(yutPanel);
        panelLeft.setAlignmentX(0.5f);

        JPanel textPanel = new JPanel();
        textPanel.add(GM.textBox);
        textPanel.setOpaque(false);

        panelLeft.add(textPanel);

        GM.rollButton = new RollButton(yutList);
        panelLeft.add(GM.rollButton);

        JPanel moveManagerPanel = new JPanel();
        moveManagerPanel.add(GM.moveManager);
        moveManagerPanel.setOpaque(false);
        panelLeft.add(moveManagerPanel);


        JPanel startPanel = new JPanel();
        startPanel.setOpaque(false);
        startPanel.setBorder(new EmptyBorder(new Insets(0, 28, 0, 0)));
        startPanel.setLayout(new GridLayout(2, 2));
        startPanel.add(GM.blueStart);
        startPanel.add(GM.blueEnd);
        startPanel.add(GM.redStart);
        startPanel.add(GM.redEnd);

        panelLeft.add(startPanel);

        // Right Panel setup
        JPanel mapPanel = new JPanel();
        mapPanel.setOpaque(false);

        mapPanel.add(GM.map);

        panelRight.add(mapPanel);
        panelLeft.setOpaque(false);
        panelRight.setOpaque(false);

        JPanel backPanel = new JPanel();
        backPanel.setOpaque(false);

        panelRight.add(backPanel);
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));


        backPanel.add(new BackButton(this));

        panel.add(panelLeft);
        panel.add(panelRight);
        
        add(panel);

        GM.map.update();
        update();

        addMouseListener(this);
    }


    public void mouseClicked(MouseEvent e) {
        
    }

    public void mousePressed(MouseEvent e) {
        if (GM.selection != null) {
            pieceReset();
        }

        if (GM.moveSelection != null) {
            moveReset();
        }
        
    }

    private void pieceReset() {
        if (GM.selection.getNode() != null) {
            for (Piece piece : GM.selection.getNode().pieces) {
                if (piece.mouseOver()) {
                    return;
                }
            }

            for (Piece piece : GM.selection.getNode().pieces) {
                piece.setAlpha(1.0f);
                piece.repaint();
            }

            GM.map.clearOptions();
            GM.selection = null;
            return;
        }

        if (!GM.selection.mouseOver()) {
            GM.selection.setAlpha(1.0f);
            GM.selection.repaint();
            GM.map.clearOptions();
            GM.selection = null; 
        }
    }

    private void moveReset() {
        
        if (!GM.moveSelection.mouseOver()) {
            GM.moveSelection.setAlpha(1.0f);
            GM.moveSelection.repaint();
        }

        GM.moveSelection = null;
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
       
    }
    
    public void mouseExited(MouseEvent e) {
        
    }
}
