package Assets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Option extends Sprite implements MouseListener{
    
    private static String FILE = "Images/option.png";
    
    private YutMapTreeNode node;

    public Option() {
        super(FILE);
        node = null;
        addMouseListener(this);
        
        setRescaleFactor(0.8f);
        resetSize();
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


        Piece piece = GM.selection;


        if (!node.pieces.isEmpty()) {
            if (node.pieces.get(0).getType() != piece.getType()) {
                if (node.pieces.get(0).getType() == 0) {
                    GM.blueStart.addPieces(node.pieces);
                }

                else {
                    GM.redStart.addPieces(node.pieces);
                }

                GM.textBox.addRoll();
                node.clear();
            }
        }


        if (piece.getNode() == null) {
            if (piece.getType() == 0) {
                GM.blueStart.removePiece(piece);
            }

            else {
                GM.redStart.removePiece(piece);
            }

            node.addPiece(piece);
        }
        
        else {

            YutMapTreeNode tempNode = piece.getNode();

            node.addPieces(piece.getNode().pieces);
            tempNode.clear();
        }

        GM.moveManager.removeMove(GM.moveSelection);

        GM.map.clearOptions();
        GM.map.update();

        GM.selection = null;
        GM.moveSelection = null;

        if (GM.textBox.getNumRolls() <= 0 && GM.moveManager.isEmpty()) {
            GM.textBox.changeTurn();

            for (Piece currPiece : node.pieces) {
                currPiece.setAlpha(1.0f);
                currPiece.repaint();
            }
        }


        if (GM.singleplayer && GM.textBox.getTurn() == GM.ai.getType()) {
            Timer timer = new Timer(GM.ai.TIME_PER_MOVE, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    GM.ai.rollYuts();
                }
            });

            timer.setRepeats(false);
            timer.start();
        }
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
