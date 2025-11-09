public interface ICommand {
    void execute(); 
    void undo();
    String name();
}
