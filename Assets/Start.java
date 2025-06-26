package Assets;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class Start extends Sprite {
    
    private static final String FILE = "Images/start.png";

    private static final ImageIcon ICON = new ImageIcon(FILE);

    private List<Piece> pieces;

    public Start(int type) {
        super(ICON);
        setAlignmentX(0.5f);
        pieces = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Piece piece = new Piece(type);
            pieces.add(piece);
            setComponentZOrder(piece, 0);
        }
        setLayout(new FlowLayout());
    }

    public void removePiece(Piece piece) {
        pieces.remove(piece);

        remove(piece);
        revalidate();
        repaint();
    }

    public void addPieces(List<Piece> pieces) {
        
        YutMapTreeNode tempNode = pieces.get(0).getNode();
        for (Piece piece : pieces) {
            add(piece);
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
