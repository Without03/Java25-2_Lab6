public class Jump implements ICommand {
    private final Player player = new Player();
    private final int prevY = 0;
    private final boolean prevOnGround = true;
    private final boolean executed = false;

    
    @Override
    public void execute() {
        
    }
    @Override
    public void undo() {

    }
        
    @Override
    public String name() {
        return null;
       
    }

}