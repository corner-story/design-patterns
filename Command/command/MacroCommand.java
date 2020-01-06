package command;

import java.util.Stack;

public class MacroCommand implements Command {

    private Stack<Command> commands = new Stack<>();

    public void append(Command command){
        if(command != this){
            commands.push(command);
        }
    }

    public void undo(){
        if(!commands.empty()){
            commands.pop();
        }
    }

    public void clear(){
        commands.clear();
    }

    @Override
    public void execute() {
        var coms = commands.iterator();
        while(coms.hasNext()){
            ((Command)(coms.next())).execute();
        }
    }
}
