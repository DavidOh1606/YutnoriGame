package Assets;

import Screen.*;

public class MapPosition {
    private static final float RESCALE = 0.8f;

    private static final int EDGE = (int) (60 * RESCALE);
    private static final int LENGTH = (int) (120 * RESCALE);
    private static final int DIAGONAL_LENGTH = (int) (99 * RESCALE);

    private int row;
    private int column;
    private boolean diagonal;

    public MapPosition(int row, int column, boolean diagonal) {
        this.row = row;
        this.column = column;
        this.diagonal = diagonal;
    }

    public int[] calculatePosition() {
        
        //float minScale = Math.min(Screen.scaleX, Screen.scaleY);
        float minScale = 1.0f;

        int[] position = new int[2];

        position[0] = EDGE;
        position[1] = EDGE;

        if (diagonal) {
            if (row == 0) {
                position[0] += (int) ((column + 1) * DIAGONAL_LENGTH * minScale); 
                position[1] += (int) ((column + 1) * DIAGONAL_LENGTH * minScale);

                if (column == 2) {
                    position[0] += 3;
                    position[1] += 3;
                }

                else if (column > 2) {
                    position[0] += 6;
                    position[1] += 6;
                }
            }

            else {
                position[1] += 5 * LENGTH;

                position[0] += (int) ((column + 1) * DIAGONAL_LENGTH * minScale);
                position[1] -= (int) ((column + 1) * DIAGONAL_LENGTH * minScale);

                if (column == 2) {
                    position[0] += 3;
                    position[1] -= 3;
                }

                else if (column > 2) {
                    position[0] += 6;
                    position[1] -= 6;
                }
            }
        }

        else {
            position[0] += (int) (column * LENGTH * minScale);
            position[1] += (int) (row * LENGTH * minScale);
        }

        return position;
    }
}
