package Screen;

import java.awt.*;
import javax.swing.*;

import Assets.Sprite;

public class BGPanel extends Sprite {
    

    public BGPanel(String file) {
        super(file);
        setRescale(false);
        resetSize();
    }
}
