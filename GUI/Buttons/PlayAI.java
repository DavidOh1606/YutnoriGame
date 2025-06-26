package GUI.Buttons;

import java.awt.*;
import javax.swing.*;
import Screen.*;

import Assets.*;

public class PlayAI extends MenuButton {
    
    private JFrame frame;


    public PlayAI(JFrame frame) {
        super("Play 1P");
        this.frame = frame;
    }

    public void action() {
        GM.singleplayer = true;
        new Game();
        frame.dispose();
    }

}
