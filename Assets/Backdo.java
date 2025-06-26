package Assets;

import java.awt.*;
import javax.swing.*;

public class Backdo extends Yut {
    private static final String FILE_UP = "Images/yut_up_small.png";
    private static final String FILE_DOWN = "Images/yut_down_small.png";
    private static final String FILE_BACK = "Images/back.png";

    private static final ImageIcon ICON_UP = new ImageIcon(FILE_UP);
    private static final ImageIcon ICON_DOWN = new ImageIcon(FILE_DOWN);
    private static final ImageIcon ICON_BACK = new ImageIcon(FILE_BACK);

    public Backdo() {
        super(ICON_UP, ICON_BACK);
    }

}
