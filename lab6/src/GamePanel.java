import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private static final double SCALE = 2.0;
    private final Player player;
    private final int groundY;
    private final Image sprite;

    public GamePanel(Player p, int width, int height, Image sprite) {
        this.player = p;
        this.groundY = 0;
        this.sprite = sprite;
       
        setPreferredSize(new Dimension(width, height));
        
    }
}
