package GUI.Buttons;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import Screen.*;

public class SettingsButton extends MenuButton {
    
    private Screen screen;

    public SettingsButton(Screen screen) {
        super("Options");

        this.screen = screen;
    }

    public void action() {
        new Settings();
        screen.dispose();
    }
}
