package GUI.Buttons;

import javax.swing.*;
import java.awt.event.*;
import Screen.*;

public class Play extends MenuButton {


    public Play() {
        super("Play 2P");


    }

    public void action() {

        Screen.setCard(new Game());
    }
}
