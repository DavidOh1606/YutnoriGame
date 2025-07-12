package GUI.Buttons;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Assets.*;
import java.util.List;
import java.util.ArrayList;

public class RollButton extends JButton implements ActionListener {
    
    private List<Yut> yuts;

    public RollButton(List<Yut> yuts) {
        this.yuts = yuts;
        setText("Roll");
        addActionListener(this);
        setAlignmentX(0.5f);
    }

    public void actionPerformed(ActionEvent event) {

        if (GM.textBox.getNumRolls() <= 0 || GM.gameOver) {
            return;
        }

        if (GM.singleplayer && GM.ai.getType() == GM.textBox.getTurn() && event != null) {
            return;
        }

        GM.textBox.reduceRoll();

        for (Yut yut : yuts) {
            yut.roll();
        }
    }

    public List<Yut> getYuts() {
        return yuts;
    }


    public void determineRoll() {

        int countUp = 0;
        for (Yut yut : yuts) {
            if (yut.up()) {
                countUp++;
            }
        }

        if (countUp == 0) {
            GM.moveManager.addMove(new Move(4, "Yut (4)"));
            GM.textBox.addRoll();
        }

        else if (countUp == 1) {
            GM.moveManager.addMove(new Move(3, "Geol (3)"));
        }
        
        else if (countUp == 2) {
            GM.moveManager.addMove(new Move(2, "Gae (2)"));
        }

        else if (countUp == 3) {
            GM.moveManager.addMove(new Move(1, "Do (1)"));
        }

        else if (countUp == 4) {
            GM.moveManager.addMove(new Move(5, "Mo (5)"));
            GM.textBox.addRoll();
        }
    }
}
