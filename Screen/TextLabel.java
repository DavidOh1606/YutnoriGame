package Screen;

import java.awt.*;
import javax.swing.*;

public class TextLabel extends JLabel {



    public TextLabel(String text) {
        setText("<html>" + text + "</html>");

        setFont(new Font("Arial", Font.PLAIN, 24));

    }
    
}
