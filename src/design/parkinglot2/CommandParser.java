package design.parkinglot2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukulbudania on 2/12/16.
 */
public class CommandParser {

    public static Command parse(String s) {
        List<String> args = new ArrayList<String>();
        String[] commandAndArgs = s.split(" ");
        Command c = Command.getCommand(commandAndArgs[0]);
        if(c!=null){
            for(int i=1;i<commandAndArgs.length;i++){
                args.add(commandAndArgs[i]);
            }
            c.setArguments(args);
            return c;
        }
        return null;
    }
}
