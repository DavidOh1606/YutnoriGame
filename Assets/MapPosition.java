package Assets;

public class MapPosition {

    private static final int EDGE = 60;
    private static final int LENGTH = 120;
    private static final int DIAGONAL_LENGTH = 99;

    private int row;
    private int column;
    private boolean diagonal;

    public MapPosition(int row, int column, boolean diagonal) {
        this.row = row;
        this.column = column;
        this.diagonal = diagonal;
    }

    public int[] calculatePosition() {
        int[] position = new int[2];

        position[0] = EDGE;
        position[1] = EDGE;

        if (diagonal) {
            if (row == 0) {
                position[0] += (column + 1) * DIAGONAL_LENGTH;
                position[1] += (column + 1) * DIAGONAL_LENGTH;

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

                position[0] += (column + 1) * DIAGONAL_LENGTH;
                position[1] -= (column + 1) * DIAGONAL_LENGTH;

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
            position[0] += column * LENGTH;
            position[1] += row * LENGTH;
        }

        return position;
    }
}
