package GUI.Buttons;

import java.awt.event.*;
import javax.swing.*;
import Screen.*;

public class HelpButton extends MenuButton {
    
    public HelpButton() {
        super("How to Play");

    }

    public void action() {
        Screen.setCard(new Help());
    }
}
