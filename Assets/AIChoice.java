package Assets;

public class AIChoice {
    

    private Piece piece;
    private Move move;
    private Option option;
    private End end;

    public AIChoice(Piece piece, Move move, Option option, End end) {

        this.piece = piece;
        this.move = move;
        this.option = option;
        this.end = end;
    }

    public int getValue() {
        int value = 0;

        if (end != null) {
            return 4 + piece.getNode().pieces.size(); 
        }

        if (option.getNode().pieces.size() > 0) {
            
            if (option.getNode().pieces.get(0).getType() != piece.getType()) {
                value += 10;
            }
            
            else {
                value += 3;
            }
        }

        if (GM.mapTree.nodeIsShortcut(option.getNode())) {
            value += 3;
        }

        if (piece.getNode() == null) {
            value -= 2;
        }

        return value;
    }

    public void makeChoice() {
        piece.mousePressed(null);
        move.mousePressed(null);

        if (end != null) {
            end.mousePressed(null);
            return;
        }

        option.mousePressed(null);
    }

    public String toString() {

        return piece.toString() + " " + move.toString() + " " + getValue();

    }


}
