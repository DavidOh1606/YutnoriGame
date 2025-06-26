package GUI.Buttons;

import java.awt.event.*;
import javax.swing.*;

public class Quit extends MenuButton {
    
    public Quit() {
        super("Quit");
    }

    public void action() {
        System.exit(0);
    }
}
