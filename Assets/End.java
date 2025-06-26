package Assets;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.*;


public class End extends Sprite implements MouseListener {
    
    public final static float DEFAULT_ALPHA = 0.7f;

    private final static String FILE = "Images/start.png";

    private final static ImageIcon ICON = new ImageIcon(FILE);

    private List<Piece> pieces;

    private boolean selectable;

    public End() {
        super(ICON);

        pieces = new ArrayList<>();
        selectable = false;
        setAlpha(DEFAULT_ALPHA);
        addMouseListener(this);
        setLayout(new FlowLayout());
    }



    public void addPieces(List<Piece> pieces) {
        
        YutMapTreeNode tempNode = pieces.get(0).getNode();
        for (Piece piece : pieces) {
            add(piece);
            this.pieces.add(piece);
            piece.setSelectable(false);
            piece.setAlpha(1.0f);
            piece.setNode(null);
            piece.repaint();
        }
        tempNode.clear();
        revalidate();
        repaint();

    }

    public void addPiece(Piece piece) {
        add(piece);
        pieces.add(piece);

        piece.getNode().clear();
        piece.setSelectable(false);
        piece.setAlpha(1.0f);
        piece.setNode(null);
        revalidate();
        repaint();
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;

        if (selectable) {
            setAlpha(1.0f);
        }

        else {
            setAlpha(DEFAULT_ALPHA);
        }
        repaint();

    }

    public boolean isSelectable() {
        return selectable;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if (GM.selection == null || !selectable || GM.gameOver) {
            return;
        }

        Piece piece = GM.selection;
        setSelectable(false);


        addPieces(piece.getNode().pieces);
        GM.map.clearOptions();
        GM.map.update();

        GM.moveManager.removeMove(GM.moveSelection);

        GM.moveManager.revalidate();
        GM.moveManager.repaint();


        // Check for win
        if (GM.blueEnd.pieces.size() == 4) {
            GM.textBox.setWinner(0); 
        }

        else if (GM.redEnd.pieces.size() == 4) {
            GM.textBox.setWinner(1);
        }

        if (GM.textBox.getNumRolls() <= 0 && GM.moveManager.isEmpty()) {
            GM.textBox.changeTurn();
        }


        GM.selection = null;
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        if (GM.gameOver) {
            return;
        }


        if (selectable) {
            setAlpha(DEFAULT_ALPHA);
            repaint();
        }

    }

    public void mouseExited(MouseEvent e) {
        if (GM.gameOver) {
            return;
        }

        if (selectable) {
            setAlpha(1.0f);
            repaint();
        }
    }



}
