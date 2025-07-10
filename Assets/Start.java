package Assets;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class Start extends Sprite {
    
    private static final String FILE = "Images/start.png";

    private List<Piece> pieces;

    private JPanel piecePanel;


    public Start(int type) {
        super(FILE);


        piecePanel = new JPanel();
        piecePanel.setLayout(new BoxLayout(piecePanel, BoxLayout.X_AXIS));
        piecePanel.setAlignmentX(0.7f);
        add(piecePanel);


        pieces = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Piece piece = new Piece(type);
            pieces.add(piece);

            piecePanel.add(piece);
        }    

        piecePanel.setOpaque(false);
        setRescaleFactor(0.78f);
        resetSize();
    }

    public void removePiece(Piece piece) {
        pieces.remove(piece);

        piecePanel.remove(piece);
        revalidate();
        repaint();
    }

    public void addPieces(List<Piece> pieces) {
        
        YutMapTreeNode tempNode = pieces.get(0).getNode();
        for (Piece piece : pieces) {
            piecePanel.add(piece);
            this.pieces.add(piece);
            piece.setAlpha(1.0f);
            piece.setNode(null);
            piece.repaint();
        }
        tempNode.clear();
        revalidate();
        repaint();
    }


    public List<Piece> getPieces() {
        return pieces;
    }
}
