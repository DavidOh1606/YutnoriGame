package Assets;

import java.util.*;

public class YutMapTreeNode {
    
    public final MapPosition position; 
    public YutMapTreeNode left;
    public YutMapTreeNode right;
    public List<Piece> pieces;

    public YutMapTreeNode(MapPosition position) {
        this.position = position;
        left = null;
        right = null;
        pieces = new ArrayList<>();
    }

    public YutMapTreeNode(YutMapTreeNode left, YutMapTreeNode right, MapPosition position) {
        this(position);
        this.left = left;
        this.right = right;
    }

    public void addPieces(List<Piece> newPieces) {
        for (Piece piece : newPieces) {
            addPiece(piece);
        }
    }
    public void addPiece(Piece piece) {
        piece.setNode(this);
        pieces.add(piece);

    }

    public void clear() {
        pieces.clear();
    }

}
