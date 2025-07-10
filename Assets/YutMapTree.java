package Assets;

import java.util.*;

public class YutMapTree {
    public YutMapTreeNode root;

    private YutMapTreeNode diag1;
    private YutMapTreeNode diag2;
    private YutMapTreeNode rightCorner;
    private YutMapTreeNode center;
    private YutMapTreeNode end;

    private YutMapTreeNode shortcut1;

    public YutMapTree() {
        root = new YutMapTreeNode(new MapPosition(5, 1, false));
        root.left = bottom(2);
    
    }
    
    public List<YutMapTreeNode> getNodes() {
        List<YutMapTreeNode> nodes = new ArrayList<>();

        getNodes(root, nodes);
        return nodes;
    }

    public List<YutMapTreeNode> getNodeAtPosition(YutMapTreeNode node, int dist) {
        List<YutMapTreeNode> list = new ArrayList<>();

        if (node == null) {
            getNodeAtPosition(root, dist - 1, list, node);
            return list;
        }

        if (node.left == null) {

            // Check if right at the exit
            list.add(GM.NULL_NODE);
            return list;
        }


        if (node.right != null) {
            // Chekc if at intersection
            getNodeAtPosition(node.right, dist - 1, list, node);
        }

        getNodeAtPosition(node.left, dist - 1, list, node);

        return list;

    }

    private void getNodeAtPosition(YutMapTreeNode node, int dist,
                            List<YutMapTreeNode> list, YutMapTreeNode initNode) {
        if (node == center) {
            if (initNode == rightCorner || initNode == rightCorner.right 
                        || initNode == rightCorner.right.left) {

                if (dist == 0) {
                    list.add(center);
                    return;
                }

                getNodeAtPosition(node.right, dist - 1, list, initNode);
                return;
            }
        }


        if (node == null) {
            list.add(GM.NULL_NODE);
            return;
        }
        if (dist == 0) {
            list.add(node);
            return;
        }

        getNodeAtPosition(node.left, dist - 1, list, initNode);
    }

    private void getNodes(YutMapTreeNode curr, List<YutMapTreeNode> nodes) {
        if (curr == null) {
            return;
        }
        
        if (!curr.pieces.isEmpty()) {
            if (!nodes.contains(curr)) {
                nodes.add(curr);
            }
        }

        if (curr != diag1 && curr != diag2 && curr != end) {
            getNodes(curr.left, nodes);
            getNodes(curr.right, nodes);
        }

    }

    public boolean nodeIsShortcut(YutMapTreeNode node, YutMapTreeNode endNode) {
        if (node == null || node.right == null) {
            return false;
        }

        YutMapTreeNode curr = node.right;
        for (int i = 0; i < 5; i++) {
            if (curr == endNode) {
                return true;
            }
            curr = curr.left;
        }

        return false;
    }

    private YutMapTreeNode bottom(int col) {
        if (col == 5) {
            YutMapTreeNode root = new YutMapTreeNode(new MapPosition(5, col, false));

            shortcut1 = root;
            root.right = downDiagonal(4);
            root.left = right(4);
            return root;
        }

        YutMapTreeNode root = new YutMapTreeNode(new MapPosition(5, col, false));
        root.left = bottom(col + 1);
        return root;
    }

    private YutMapTreeNode downDiagonal(int col) {
        YutMapTreeNode root = new YutMapTreeNode(new MapPosition(0, col, true));
        if (col == 2) {
            this.center = root;
            this.center.left = downDiagonal(col - 1);
            return this.center;
        }

        else if (col == 0) {
            diag1 = root;
            return root;
        }

        root.left = downDiagonal(col - 1);
        return root;
    }
    
    private YutMapTreeNode right(int row) {
        YutMapTreeNode root = new YutMapTreeNode(new MapPosition(row, 5, false));
        
        if (row == 0) {

            rightCorner = root;
            root.right = upDiagonal(4);
            root.left = top(4);
            return root;
        }

        root.left = right(row - 1);
        return root;
    }

    private YutMapTreeNode upDiagonal(int col) {
        YutMapTreeNode root = new YutMapTreeNode(new MapPosition(1, col, true));        
        
        if (col == 2) {
            center.right = upDiagonal(col - 1);
            return center;
        }

        else if (col == 0) {
            diag2 = root;
            return root;
        }

        root.left = upDiagonal(col - 1);
        return root;
    }

    private YutMapTreeNode top(int col) {
        YutMapTreeNode root = new YutMapTreeNode(new MapPosition(0, col, false));

        if (col == 0) {

            root.left = left(1);
            diag1.left = root;
            return root;
        }

        root.left = top(col - 1);
        return root;
    }

    private YutMapTreeNode left(int row) {
        YutMapTreeNode root = new YutMapTreeNode(new MapPosition(row, 0, false));

        if (row == 5) {
            root.left = null;
            root.right = this.root;
            diag2.left = root;
            end = root;
            return root;
        }

        root.left = left(row + 1);
        root.right = null;
        return root;
    }
}
