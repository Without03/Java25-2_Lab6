import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import java.awt.Image;


public class GameFrame extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 480;

    private final Player player = new Player();
    private final CommandInvoker invoker = new CommandInvoker();
    private final GamePanel gamePanel;

    public GameFrame() {
        super("Command Pattern + Swing Sprite Demo");
        
        Image sprite = new ImageIcon("haechi.png").getImage();
        this.gamePanel = new GamePanel(player, WIDTH, HEIGHT, sprite);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(gamePanel); // attach GamePanel
        pack();
        setLocationRelativeTo(null);
        setResizable(false); // fixed size
        
        // set Game Loop Timer (60 FPS)
        new Timer(1000/60, _ -> {
            player.tickPhysics();
            gamePanel.repaint();
        }).start();

        // set KeyBindings
        setupKeyBindings();

        setVisible(true);
    }


    // Repaint immediately after executing the command
    private void exec(ICommand c) {
        invoker.execute(c);
        gamePanel.repaint();
    }

    // KeyStroke binding helper
    private void bind(InputMap im, ActionMap am, String keyStroke, Runnable r) {
        // Register in ActionMap with KeyStroke name
        im.put(KeyStroke.getKeyStroke(keyStroke), keyStroke);
        
        // Define the actual action for a KeyStroke
        am.put(keyStroke, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r.run();
            }
        });
    }

    // Set key bindings for game actions
    private void setupKeyBindings() {
        final InputMap im = gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        final ActionMap am = gamePanel.getActionMap();
        
        // Move Command
        bind(im, am, "LEFT",  () -> exec(new Move(player, -10)));
        bind(im, am, "RIGHT", () -> exec(new Move(player, +10)));
        
        // Jump Command
        bind(im, am, "SPACE", () -> exec(new Jump(player, 100)));

        // Attack Command
        bind(im, am, "A",     () -> exec(new Attack(player)));
        
        // Undo Command
        bind(im, am, "U",     () -> { invoker.undo(); gamePanel.repaint(); });
        
        // Redo Command
        bind(im, am, "R",     () -> { invoker.redo(); gamePanel.repaint(); });
        
        System.out.println("Key Bindings setup complete.");
    }
}
