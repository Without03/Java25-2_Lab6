import java.awt.Color;


public class Player {
    int x = 80;     // X position on screen (starts from left)
    int y = 0;      // Y position (height above ground, 0 is ground)
    boolean onGround = true; // True if player is on the ground

    int vx = 0;     // X velocity (instant movement)
    int attackCooldown = 0; // ticks

    int spriteW = 50;
    int spriteH = 60;
    Color baseColor = new Color(60, 140, 255);

    Color auraColor = null;  // Aura
    int auraTicks = 0;       // Number of frames to maintain aura

    String bubbleText = null; // bubbleText nearby Player
    int bubbleTicks = 0;

    // For every frame: gravity/attack cool down
    void tickPhysics() {
        // simple gravity: If in the air, decrease y by 1 and move to the ground
        if (!onGround) {
            y = Math.max(0, y - 1);
            if (y == 0) onGround = true;
        }
        if (attackCooldown > 0) attackCooldown--;

        // Aura lifespan decrease
        if (auraTicks > 0 && --auraTicks == 0) {
            auraColor = null;
        }

        // bubbleText
        if (bubbleTicks > 0) bubbleTicks--;
    }


}
