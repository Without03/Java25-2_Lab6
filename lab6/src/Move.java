public class Move implements ICommand {
    private final Player player = new Player();
    private final int dx = 0;

    @Override
    public void execute() {
        player.move(dx);
    }

    @Override
    public void undo() {
        player.move(-dx);
    }

    @Override
    public String name() {
        return "Move(" + dx + ")";
    }

}
