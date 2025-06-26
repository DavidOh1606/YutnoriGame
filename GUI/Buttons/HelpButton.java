package GUI.Buttons;

import java.awt.event.*;
import javax.swing.*;
import Screen.*;

public class HelpButton extends MenuButton {
    
    private Screen screen;
    public HelpButton(Screen screen) {
        super("How to Play");
        this.screen = screen;

    }

    public void action() {
        new Help();
        screen.dispose();
    }
}
