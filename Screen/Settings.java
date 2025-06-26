package Screen;

import java.awt.*;
import javax.swing.*;
import GUI.Buttons.*;

public class Settings extends Screen {
    

    public Settings() {

        BGPanel panel = getPanel();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setOpaque(false);
        bottomPanel.setOpaque(false);


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new BackButton(this));
        buttonPanel.setOpaque(false);

        bottomPanel.add(buttonPanel);
        panel.add(bottomPanel);

        update();
    }
}
