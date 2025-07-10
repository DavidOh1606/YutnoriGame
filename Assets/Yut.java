package Assets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

public class Yut extends Sprite implements ActionListener {
    private static final String FILE_UP = "Images/yut_up_small.png";
    private static final String FILE_DOWN = "Images/yut_down_small.png";
    private static final String FILE_BACK = "Images/back.png";


    private BufferedImage upIcon;
    private BufferedImage downIcon;

    private final int DEFAULT_FRAME_COUNT = 5;

    private boolean up; 
    private boolean animating;
    private int numFrames;

    public Yut() {
        super(FILE_UP);
        up = true;
        numFrames = DEFAULT_FRAME_COUNT;
        animating = false;
        upIcon = Sprite.getBufferedImage(FILE_UP);
        downIcon = Sprite.getBufferedImage(FILE_DOWN);

        setRescaleFactor(0.9f);
        resetSize();
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