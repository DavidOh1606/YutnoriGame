package GUI.Buttons;

import javax.swing.*;
import java.awt.event.*;
import Screen.*;

public class Play extends MenuButton {
    private Screen screen;

    public Play(Screen screen) {
        super("Play 2P");
        this.screen = screen;

    }

    public void action() {

        new Game();
        screen.dispose();
    }
}
