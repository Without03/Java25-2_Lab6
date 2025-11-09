public class Player {
    private Color baseColor;
    private int spriteW;
    private int spriteH;
    private int x;      // X position on screen (starts from left)
    private int vx;     // X velocity (instant movement) 
    private int y;      // Y position (height above ground, 0 is ground)
    private boolean onGround;    // True if player is on the ground
    private int attackCooldown;  // attack cooldown (frames)
    private Color auraColor;     // attack aura color
    private int auraTicks;       // aura remaining duration (frames)
    private String bubbleText;   // bubbleText near Player
    private int bubbleTicks;     // remaining display time (frames)

    public Player() {
        baseColor = new Color(60, 140, 255);
        spriteW = 50;
        spriteH = 60;
        x = 80;
        vx = 0;
        y = 0;
        onGround = true;
        attackCooldown = 0;
        auraColor = null;
        auraTicks = 0;
        bubbleText = null;
        bubbleTicks = 0;
    }
    
    public void move(int dx) {
        x += dx;
    }
}
