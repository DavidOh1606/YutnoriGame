package Assets;

import java.util.*;
import java.awt.event.*;

import javax.swing.Timer;

public class AIPlayer {
    
    public static final int TIME_PER_MOVE = 500;

    private int type;

    public AIPlayer() {
        type = 1;
    }

    // Create the AIPlayer loop

    public void rollYuts() {
        if (GM.mapTree == null || GM.rollButton == null) {
            throw new IllegalStateException("Not correctly setup for singleplayer");
        }


        GM.rollButton.actionPerformed(null);

    }

    public void takeTurn() {

        List<YutMapTreeNode> nodes = GM.mapTree.getNodes();
        List<Piece> aiPieces = new ArrayList<>();
        
        if (type == 0) {
            if (!GM.blueStart.getPieces().isEmpty()) {
                aiPieces.add(GM.blueStart.getPieces().get(0));
            }
        }
        else {
            if (!GM.redStart.getPieces().isEmpty()) {
                aiPieces.add(GM.redStart.getPieces().get(0));
            }
        }

        for (YutMapTreeNode node : nodes) {
            if (node.pieces.get(0).getType() == type) {
                aiPieces.add(node.pieces.get(0));
            }
        }
        
        if (!GM.moveManager.isEmpty()) {
            List<Move> moves = GM.moveManager.getMoves();
        
            AIChoice bestChoice = null;

            for (Piece piece : aiPieces) {
                for (Move move : moves) {   

                    AIChoice currChoice;
                    piece.mousePressed(null);
                    move.mousePressed(null);

                    List<Option> options = GM.map.getOptions();
                    
                    End end = null;
                    if (type == 0) {
                        if (GM.blueEnd.isSelectable()) {
                            end = GM.blueEnd;
                            currChoice = new AIChoice(piece, move, null, end);
                            if (bestChoice == null || currChoice.getValue() > bestChoice.getValue()) {
                                bestChoice = currChoice;
                            }
                        }
                    }

                    else {
                        if (GM.redEnd.isSelectable()) {
                            end = GM.redEnd;
                            currChoice = new AIChoice(piece, move, null, end);

                            if (bestChoice == null || currChoice.getValue() > bestChoice.getValue()) {
                                bestChoice = currChoice;
                            }
                        }
                    }


                    for (Option option : options) {
                        currChoice = new AIChoice(piece, move, option, end);

                        if (bestChoice == null || currChoice.getValue() > bestChoice.getValue()) {
                            bestChoice = currChoice;
                        }
                    }
                }
            }

            bestChoice.makeChoice();
        }

        if (!GM.moveManager.isEmpty()) {
            Timer timer = new Timer(TIME_PER_MOVE, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    takeTurn();
                }
            });

            timer.setRepeats(false);
            timer.start();
        }
    }


    public int getType() {
        return type;
    }

}
