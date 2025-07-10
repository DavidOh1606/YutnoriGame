package Screen;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import GUI.Buttons.*;

public class Menu extends Card {
    
    public Menu() {


        JPanel panel = getPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Yutnori");
        Font font = new Font("Arial", Font.PLAIN, 44);
        title.setFont(font);
        title.setAlignmentX(0.5f);
        
        JPanel bottomPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        buttonPanel.add(new PlayAI());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 15)));
    
        buttonPanel.add(new Play());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        buttonPanel.add(new HelpButton());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        //buttonPanel.add(new SettingsButton(this));
        //buttonPanel.add(Box.createRigidArea(new Dimension(0, 15)));


        buttonPanel.add(new Quit());
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        
        buttonPanel.setAlignmentX(0.5f);
        buttonPanel.setOpaque(false);

        bottomPanel.add(buttonPanel);
        bottomPanel.setOpaque(false);

        panel.add(Box.createRigidArea(new Dimension(0, 200)));
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 140)));
        panel.add(bottomPanel);

    }
}
