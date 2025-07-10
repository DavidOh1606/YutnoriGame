package Assets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Assets.*;

public class Piece extends Sprite implements MouseListener {
    
    private static final String FILE_BLUE = "Images/piece.png";
    private static final String FILE_RED = "Images/piece-2.png";

    // Blue is first and equal to 0;
    private int type;

    private YutMapTreeNode node;
    private boolean selectable;

    private boolean mouseOver;

    public Piece() {
        super(FILE_BLUE);
        // Defaults to blue;
        selectable = true;
        type = 0;
        mouseOver = false;
        addMouseListener(this);
        node = null;

        setRescaleFactor(0.8f);
        resetSize();
    }

    public Piece(int type) {
        this();

        if (type != 0) {
            this.type = 1;
            this.setImage(FILE_RED);
        }
    }

    public int getType() {
        return type;
    }

    public boolean mouseOver() {
        return mouseOver;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public void setNode(YutMapTreeNode node) {
        this.node = node;
    }

    public YutMapTreeNode getNode() {
        return node;
    }

    public void mouseClicked(MouseEvent e) {
        
    }

    public void mousePressed(MouseEvent e) {

        if (e != null && GM.textBox.getTurn() == 1) {
            return;
        }

        if (!selectable || GM.textBox.getTurn() != type || GM.gameOver) {
            return;
        }

        if (GM.selection != null && GM.selection != this) {

            if (GM.selection.getNode() == null) {
                GM.selection.setAlpha(1.0f);
                GM.selection.repaint();
            }

            else {
                for (Piece piece : GM.selection.getNode().pieces) {
                    piece.setAlpha(1.0f);
                    piece.repaint();
                }
            }
        }

        GM.map.clearOptions();

        GM.selection = this; 

        if (GM.moveSelection != null) {
            GM.map.displaySelections(GM.moveSelection.getDistance());
        }


        setAlpha(0.8f);
        repaint();
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        if (e != null && GM.textBox.getTurn() == 1) {
            return;
        }

        if (!selectable || GM.textBox.getTurn() != type || GM.gameOver) {
            return;
        }

        mouseOver = true;

        if (node != null && node.pieces.size() > 1) {
            for (Piece piece : node.pieces) {
                piece.setAlpha(0.8f);
                piece.repaint();

            }

            return;
        }
        
        setAlpha(0.8f);
        repaint();
    }
    
    public void mouseExited(MouseEvent e) {
        if (e != null && GM.textBox.getTurn() == 1) {
            return;
        }

        if (!selectable || GM.textBox.getTurn() != type || GM.gameOver) {
            return;
        }
        
        mouseOver = false;
        // Checks the other pieces to see if the mouse is over any of
        // the other pieces
        // If not, then resets alpha

        if (node != null && GM.selection != null && GM.selection.node == node) {
            return;
        }

        if (node == null && GM.selection == this) {
            return;
        }

        
        if (node != null && node.pieces.size() > 1) {
            for (Piece piece : node.pieces) {
                if (piece.mouseOver) {
                    return;
                }
            }

            for (Piece piece : node.pieces) {
                piece.setAlpha(1.0f);
                piece.repaint();
            }

            return;
        }

    
        setAlpha(1.0f);
        repaint();
        
    }

    public String toString() {

        return "Piece: " + type;

    }

}
