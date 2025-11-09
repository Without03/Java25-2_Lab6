import java.util.ArrayDeque;
import java.util.Deque;

public class CommandInvoker implements ICommand {
    private Deque<ICommand> undoStack = new ArrayDeque<>();
    private Deque<ICommand> redoStack = new ArrayDeque<>();

    @Override
    public void execute() {
        
    }

    @Override
    public void undo() {
        if (!undoStack.isEmpty()) {
            ICommand command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            ICommand command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

    public void execute(ICommand command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    @Override
    public String name() {
        return "CommandInvoker";
    
    }

}
