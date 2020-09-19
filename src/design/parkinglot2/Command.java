package design.parkinglot2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukulbudania on 2/12/16.
 */
public enum Command {
    CREATE_PARKING_LOT("create_parking_lot"),
    PARK("park"),
    LEAVE("leave"),
    STATUS("status"),
    REGISTRATION_NUMBER_WITH_COLOR("registration_numbers_for_cars_with_colour"),
    SLOT_NUMBERS_WITH_COLOR("slot_numbers_for_cars_with_colour"),
    SLOT_NUMBER_WITH_REGISTRATION("slot_number_for_registration_number");

    private String value;
    List<String> arguments;

    Command(String val){
        this(val,new ArrayList<String>());
    }

    Command (String val, List<String> arguments){
        this.value = val;
        this.arguments = arguments;
    }

    public String getValue() {
        return value;
    }

    public List<String> getArguments(){
        return this.arguments;
    }

    public void setArguments(List<String> args){
        this.arguments = args;
    }

    public static List<String> getValues(){
        Command[] commands = Command.values();
        List<String> commandStrings = new ArrayList<String>(commands.length);
        for(Command c: commands){
            commandStrings.add(c.getValue());
        }
        return commandStrings;
    }
    public static Command getCommand(String value){
        Command[] commands = Command.values();
        for(Command c: commands){
            if(c.getValue().equals(value))return c;
        }
        return null;
    }
}
