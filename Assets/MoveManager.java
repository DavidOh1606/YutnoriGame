package Assets;

import java.awt.*;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;

public class MoveManager extends Sprite {
    
    public static final String FILE = "Images/text.png";

    public static final ImageIcon ICON = new ImageIcon(FILE);


    private List<Move> moves;

    public MoveManager() {
        super(FILE);
        moves = new ArrayList<>();

        setRescaleFactor(0.8f);
        resetSize();
    }

    public void addMove(Move move) {
        add(move);
        moves.add(move);
        revalidate();
        repaint();

    }

    public void removeMove(Move move) {

        moves.remove(move);
        remove(move);
        GM.moveSelection = null;
        revalidate();
        repaint();

    }

    public boolean isEmpty() {
        return moves.size() == 0;
    }

    public List<Move> getMoves() {
        return moves;
    }
}
