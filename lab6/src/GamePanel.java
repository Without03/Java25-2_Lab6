import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private static final double SCALE = 2.0; 
    private final Player player;
    private final int groundY;
    private final Image sprite;

    public GamePanel(Player p, int width, int height, Image sprite) {
        this.player = p;
        this.sprite = sprite;
         // 이미지 불러오기
        
        setPreferredSize(new Dimension(width, height));
        setBackground(new Color(250, 250, 250));
        groundY = height - 60;
        setDoubleBuffered(true);
        setFocusable(true);
    }

    @Override 
    protected void paintComponent(Graphics g) {


        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // background/ground
        g2.setColor(new Color(230,230,230));
        for (int x=0; x<getWidth(); x+=50) g2.drawLine(x, 0, x, getHeight());
        g2.setColor(new Color(200,190,170));
        g2.fillRect(0, groundY, getWidth(), getHeight()-groundY);

        // grid 
        int drawW = (int)Math.round(player.spriteW * SCALE);
        int drawH = (int)Math.round(player.spriteH * SCALE);

        // player location (player's foot is on the ground)
        int sx = player.x;
        int sy = groundY - player.y - drawH;

        // attack aura


        // draw sprite image
        if (sprite != null) {
            g2.drawImage(sprite, sx, sy, drawW, drawH, null);
            g2.setColor(new Color(0,0,0,60));
            g2.drawRect(sx, sy, drawW, drawH);
        } else {
            int arc = (int)Math.round(8 * SCALE);
            g2.setColor(player.baseColor);
            g2.fillRoundRect(sx, sy, drawW, drawH, arc, arc);
            g2.setColor(Color.DARK_GRAY);
            g2.drawRoundRect(sx, sy, drawW, drawH, arc, arc);
        }

        // BubbleText nearby Player to show Undo Jump
        if (player.bubbleTicks > 0 && player.bubbleText != null) {
        }
        
        // HUD
 
        g2.dispose();
    }
}
