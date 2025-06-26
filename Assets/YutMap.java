package Assets;

import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.image.*;

public class YutMap extends Sprite {
    
    private static final int Y_OFFSET = 6;

    private static final String FILE = "Images/yut_map_new.png";
    private static final ImageIcon ICON = new ImageIcon(FILE);

    private YutMapTree map;
    private List<Option> options;


    public YutMap() {
        super(ICON);
        map = new YutMapTree();

        GM.mapTree = map;

        setLayout(null);
        options = new ArrayList<>();
    }

    public void update() {
        List<YutMapTreeNode> nodes = map.getNodes();

        for (YutMapTreeNode node : nodes) {
            for (int i = 0; i < node.pieces.size(); i++) {
                Piece piece = node.pieces.get(i);
                
                add(piece);
                int[] pos = node.position.calculatePosition();
                BufferedImage image = piece.getSpriteImage();

                piece.setBounds(pos[0], pos[1] + i * Y_OFFSET, 
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

        for (YutMapTreeNode node : nodes) {
            Option option = new Option();
            option.setNode(node);
            options.add(option);
            add(option);
            int[] pos = node.position.calculatePosition();

            BufferedImage image = option.getSpriteImage();
            option.setBounds(pos[0], pos[1], image.getWidth(), image.getHeight());
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
