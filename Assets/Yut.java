package Assets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Yut extends Sprite implements ActionListener {
    private static final String FILE_UP = "Images/yut_up_small.png";
    private static final String FILE_DOWN = "Images/yut_down_small.png";
    private static final String FILE_BACK = "Images/back.png";

    private static final ImageIcon ICON_UP = new ImageIcon(FILE_UP);
    private static final ImageIcon ICON_DOWN = new ImageIcon(FILE_DOWN);
    private static final ImageIcon ICON_BACK = new ImageIcon(FILE_BACK);

    private ImageIcon upIcon;
    private ImageIcon downIcon;

    private final int DEFAULT_FRAME_COUNT = 5;

    private boolean up; 
    private boolean animating;
    private int numFrames;

    public Yut() {
        super(ICON_UP);
        up = true;
        numFrames = DEFAULT_FRAME_COUNT;
        animating = false;
        upIcon = ICON_UP;
        downIcon = ICON_DOWN;
    }

    public Yut(ImageIcon upIcon, ImageIcon downIcon) {
        this();

        this.upIcon = upIcon;
        this.downIcon = downIcon;
    }

    public void roll() {
        actionPerformed(null);
    }

    public void endRoll() {
        int rand = (int) (Math.random() * 2);

        if (rand == 0) {
            up = true;
            setImage(upIcon);
        }

        else {
            up = false;
            setImage(downIcon);
        }
        numFrames = DEFAULT_FRAME_COUNT;
        animating = false;


        repaint();

        for (Yut yut : GM.rollButton.getYuts()) {
            if (yut.animating) {
                return;
            }
        }

        GM.rollButton.determineRoll();

        if (GM.singleplayer && GM.textBox.getTurn() == GM.ai.getType()) {

            Timer timer;
            if (GM.textBox.getNumRolls() > 0) {
                timer = new Timer(AIPlayer.TIME_PER_MOVE, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        GM.ai.rollYuts();
                    }
                });

            }


            else {

                timer = new Timer(AIPlayer.TIME_PER_MOVE, new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    GM.ai.takeTurn();
                }

                });
            }
            timer.setRepeats(false);
            timer.start();
        }

    }


    public boolean up() {
        return up;
    }

    public void actionPerformed(ActionEvent e) {
        animating = true;
        numFrames--;
        int delay = (int) (Math.random() * 200) + 100;

        if (numFrames == 0) {
            endRoll();
            return;
        }

        if (!up) {
            up = true;
            setImage(upIcon);
        }

        else {
            up = false;
            setImage(downIcon);
        }

        Timer timer = new Timer(delay, this);
        timer.setRepeats(false);
        timer.start();
        repaint();
    }
}