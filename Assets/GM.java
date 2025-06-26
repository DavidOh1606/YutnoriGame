package Assets;

import GUI.Buttons.RollButton;

public class GM {
    
    public static final YutMapTreeNode NULL_NODE = new YutMapTreeNode(null);



    public static YutMapTree mapTree = null;
    public static YutMap map = new YutMap();
    public static Piece selection = null;
    public static Move moveSelection = null;


    public static Start redStart = new Start(1);
    public static Start blueStart = new Start(0);

    public static End blueEnd = new End();
    public static End redEnd = new End();

    public static MoveManager moveManager = new MoveManager();

    public static TextBox textBox = new TextBox();


    public static RollButton rollButton = null; 
    public static boolean singleplayer = false;
    public static AIPlayer ai = new AIPlayer();


    public static boolean gameOver = false;

    private GM() {

    }


    public static void restart() {
        mapTree = null;
        map = new YutMap();
        selection = null;
        moveSelection = null;


        redStart = new Start(1);
        blueStart = new Start(0);

        blueEnd = new End();
        redEnd = new End();

        moveManager = new MoveManager();

        textBox = new TextBox();


        rollButton = null; 
        singleplayer = false;


        gameOver = false;
    }

    

}
