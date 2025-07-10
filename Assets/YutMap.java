package Assets;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.image.*;

import Screen.Screen;

public class YutMap extends Sprite {
    
    private static final int Y_OFFSET = 6;

    private static final String FILE = "Images/yut_map_new.png";

    private YutMapTree map;
    private List<Option> options;


    public YutMap() {
        super(FILE);
        map = new YutMapTree();

        GM.mapTree = map;

        setLayout(null);
        options = new ArrayList<>();
        setRescaleFactor(0.8f);
        resetSize();

    }

    public void update() {
        List<YutMapTreeNode> nodes = map.getNodes();
        //float minScale = Math.min(Screen.scaleX, Screen.scaleY) * getRescaleFactor();
        float minScale = 0.8f;

        for (YutMapTreeNode node : nodes) {
            for (int i = 0; i < node.pieces.size(); i++) {
                Piece piece = node.pieces.get(i);
                
                add(piece);
                int[] pos = node.position.calculatePosition();
                BufferedImage image = piece.getSpriteImage();

                piece.setBounds((int) (pos[0] * minScale), (int) ((pos[1] + i * Y_OFFSET) * minScale), 
                                image.getWidth(), image.getHeight());
                setComponentZOrder(piece, 0);
            }
        }
    }

    public void displaySelections(int dist) {
        if (GM.selection == null) {
            return;
        }

        List<YutMapTreeNode> nodes = map.getNodeAtPosition(GM.selection.getNode(), dist);
        if (nodes.contains(GM.NULL_NODE)) {
            if (GM.selection.getType() == 0) {
                GM.blueEnd.setSelectable(true);
            }

            else {
                GM.redEnd.setSelectable(true);
            }

            nodes.remove(GM.NULL_NODE);
        }
        //float minScale = Math.min(Screen.scaleX, Screen.scaleY) * getRescaleFactor();
        float minScale = 0.8f;
        for (YutMapTreeNode node : nodes) {
            Option option = new Option();
            option.setNode(node);
            options.add(option);
            add(option);
            int[] pos = node.position.calculatePosition();

            BufferedImage image = option.getSpriteImage();
            option.setBounds((int) (pos[0] * minScale), (int) (pos[1] * minScale), image.getWidth(),
                image.getHeight());
            setComponentZOrder(option, 0);
        }
    }

    public List<Option> getOptions() {
        return options;
    }

    public void clearOptions() {
        for (Option option : options) {
            this.remove(option);
        }

        options.clear(); 
        GM.blueEnd.setSelectable(false);
        GM.redEnd.setSelectable(false);
        repaint();
    }
}
