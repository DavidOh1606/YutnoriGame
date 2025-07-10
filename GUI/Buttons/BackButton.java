package GUI.Buttons;

import java.awt.*;
import javax.swing.*;
import Screen.*;
import Screen.Menu;
import Assets.GM;

public class BackButton extends MenuButton {
    
    public BackButton() {
        super("Back");

    }

    public void action() {
        GM.restart();
        Screen.setCard(new Menu());
    }
}
