package GUI.Buttons;

import java.awt.*;
import javax.swing.*;
import Screen.*;

import Assets.*;

public class PlayAI extends MenuButton {
    



    public PlayAI() {
        super("Play 1P");

    }

    public void action() {
        GM.singleplayer = true;
        Screen.setCard(new Game());
    }

}
