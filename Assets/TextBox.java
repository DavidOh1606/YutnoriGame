package Assets;

import java.awt.*;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class TextBox extends Sprite {

    private static final String FILE = "Images/textBox.png";

    private static final ImageIcon ICON = new ImageIcon(FILE);


    private JLabel rollText;
    private JLabel turnText;
    private JLabel winText;

    private int numRolls;
    private int turn;

    public TextBox() {
        super(ICON);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(new EmptyBorder(new Insets(10, 0, 0, 0)));
        turn = 0;
        numRolls = 1;

        
        rollText = new JLabel("Rolls left: " + numRolls);
        winText = new JLabel();
        turnText = new JLabel("Blue turn");

        rollText.setForeground(new Color(160, 190, 180));
        winText.setForeground(new Color(160, 190, 180));
        turnText.setForeground(new Color(160, 190, 180));


        JPanel leftPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel rightPanel = new JPanel();

        leftPanel.setOpaque(false);
        middlePanel.setOpaque(false);
        rightPanel.setOpaque(false);

        


        leftPanel.add(rollText);
        middlePanel.add(winText);
        rightPanel.add(turnText);

        add(leftPanel);
        add(middlePanel);
        add(rightPanel);

    }


    public void addRoll() {
        numRolls++;
        updateRollText();

    }

    public void reduceRoll() {
        numRolls--;
        updateRollText();
    }

    private void updateRollText() {
        rollText.setText("Rolls left: " + numRolls);
    }

    public int getNumRolls() {
        return numRolls;
    }

    public int getTurn() {
        return turn;
    }

    public void changeTurn() {
        if (turn == 0) {
            turn = 1;
            turnText.setText("Red turn");
        
        }

        else {
            turn = 0;
            turnText.setText("Blue turn");
        }

        addRoll();

        if (!GM.singleplayer || turn != GM.ai.getType()) {
            return;
        }
        // AI makes its move mwahaha
        GM.ai.rollYuts();

    }

    public void setWinner(int winType) {
        if (winType == 0) { 
            winText.setText("Blue won!!");
        }

        else {
            winText.setText("Red won!!");
        }

        GM.gameOver = true;
    }

}
