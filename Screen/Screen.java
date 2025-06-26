package Screen;

import java.awt.*;
import javax.swing.*;

public class Screen extends JFrame {
    

    private BGPanel panel;

    public Screen() {

        panel = new BGPanel(new ImageIcon("Images/bg.png"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        add(panel);
        setTitle("Yutnori");
        setResizable(false);
        setIconImage(new ImageIcon("Images/yut_icon.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public BGPanel getPanel() {
        return panel;
    }

    public void update() {
        pack();
        setLocationRelativeTo(null);
    }
}
