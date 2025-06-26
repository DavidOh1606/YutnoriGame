package Screen;

import java.awt.*;
import javax.swing.*;

public class BGPanel extends JPanel {
    
    private Image image;

    public BGPanel(ImageIcon image) {
        super();
        this.image = image.getImage();
        setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(image, 0, 0, null);
    } 

}
