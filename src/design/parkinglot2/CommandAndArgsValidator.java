package design.parkinglot2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukulbudania on 2/12/16.
 */
public class CommandAndArgsValidator {

    public static boolean validateArgs(Command c) {
        List<String> errors = new ArrayList<String>();
        List<String> args = c.getArguments();
        String checkSize;String checkInt;
        switch (c) {
            case CREATE_PARKING_LOT: checkSize = checkSize(args,1);if(checkSize!=null)errors.add(checkSize);
                                     checkInt = checkInt(args,0);if(checkInt!=null)errors.add(checkInt);
                                     break;
            case PARK: checkSize = checkSize(args,2);if(checkSize!=null)errors.add(checkSize);
                       break;

            case LEAVE: checkSize = checkSize(args,1);if(checkSize!=null)errors.add(checkSize);
                        checkInt = checkInt(args,0);if(checkInt!=null)errors.add(checkInt);
                        break;

            case STATUS: break;
            case REGISTRATION_NUMBER_WITH_COLOR:
                checkSize = checkSize(args,1);if(checkSize!=null)errors.add(checkSize);
                break;

            case SLOT_NUMBERS_WITH_COLOR:
                checkSize = checkSize(args,1);if(checkSize!=null)errors.add(checkSize);
                break;

            case SLOT_NUMBER_WITH_REGISTRATION:
                checkSize = checkSize(args,1);if(checkSize!=null)errors.add(checkSize);
                break;

            default:
                errors.add("No such command");
                break;
        }
        if(!Utils.isEmpty(errors)){
            StringBuilder outputBuilder = new StringBuilder();
            outputBuilder.append("Errors: \n");
            outputBuilder.append(Utils.print(errors));
            outputBuilder.append("Usage: \n");
            outputBuilder.append(UsageHelper.getUsage(c));
            System.out.println(outputBuilder.toString());
            return false;
        }
        return true;
    }

    private static String checkInt(List<String> args, int i) {
        if(args!=null && args.size()>i){
            try{
                Integer.parseInt(args.get(i));
            } catch(NumberFormatException e){
                return "Argument "+(i+1)+ " should be an integer\n";
            }
        }
        return null;
    }

    private static String checkSize(List<String> args, int i) {
        if((args==null&& args.size()==0) || args.size()!=i)
            return "Invalid number of Arguments. Expected: "+i + " Actual: " + ((args==null)?0:args.size()) + "\n";
        return null;
    }
}
