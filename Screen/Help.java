package Screen;

import java.awt.*;
import javax.swing.*;
import GUI.Buttons.*;

public class Help extends Screen {
    

    public Help() {

        BGPanel panel = getPanel();

    
        JPanel topPanel = new JPanel();
        JPanel textPanel = new JPanel();

        panel.add(topPanel);
        topPanel.add(textPanel);


        topPanel.setOpaque(false);
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        textPanel.add(new TextLabel("How to Play <br> <br>"));
        
        textPanel.add(new TextLabel("""
                            On your turn, roll the sticks to determine how 
                            far you can move one of your pieces. <br> <br>"""));
        textPanel.add(new TextLabel("""
                            Yut none up - 4 spaces, extra roll <br>
                            Geol 1 up - 3 spaces <br>
                            Gae 2 up - 2 spaces <br>
                            Do 3 up - 1 space <br>
                            Mo all up - 5 spaces, extra roll <br> <br>
                """));
        textPanel.add(new TextLabel("""
                            If you land on the same square as enemy pieces
                            you get an extra roll and all enemy pieces return
                            back to the start.
                            """));
        textPanel.add(new TextLabel("""
                            If you have multiple pieces on the same square,
                            they can move together with a single move. <br>
                            There are shortcuts on the board you can take
                            if a piece lands on the space leading to the shortcut.
                            """));
        textPanel.add(new TextLabel("""
                            <br> 
                            Get all your pieces to end first in order to win!
                            Have fun!!
                            """));

        JPanel bottomPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        panel.add(bottomPanel);
        bottomPanel.add(buttonPanel);
        bottomPanel.setOpaque(false);

        buttonPanel.add(new BackButton(this));
        buttonPanel.setOpaque(false);
        update();
    }
}
