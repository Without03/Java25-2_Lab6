public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
/*
ICommandinterface has execute() and undo() and default String name()which returns getClass().getSimpleName().
Move, Jump, Attack, and MacroCommandimplementsICommandto make the playerto move, jump, attack.
Player class move, jump, attack, and tickPhysics.
CommandInvokeris the invoker class, and uses Deque<ICommand> undoStackand Deque<ICommand> redoStack.
GamePanelclass extends JPaneland override paintComponents(Graphics g).
GameFrameclass extends JFrameloads a sprite image from a file (e.g. haechi.png) and uses Player, GamePanel, CommandInvokerto set commands.
App callsGameFrame(extendsJFrame) to create a Swing app.
 
The App client callGameFramewhich uses Commandlnvokerto setcommand andthen, executethe command.

Commandlnvokerexecute/undo/redothe command.
Execute(ICommand c): c.execute()-> push undo & clear redo
undo(): pop undoStack -> c.undo(); push to redo
redo(): pop redoStack-> c.execute(); push to undo

*/