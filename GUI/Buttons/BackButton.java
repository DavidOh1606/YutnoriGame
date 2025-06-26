package GUI.Buttons;

import java.awt.*;
import javax.swing.*;
import Screen.Menu;
import Assets.GM;

public class BackButton extends MenuButton {
    
    private JFrame frame;

    public BackButton(JFrame frame) {
        super("Back");

        this.frame = frame;
    }

    public void action() {
        GM.restart();
        new Menu();
        frame.dispose();
    }
}
