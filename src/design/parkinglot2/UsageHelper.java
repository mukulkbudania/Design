package design.parkinglot2;

/**
 * Created by mukulbudania on 2/12/16.
 */
public class UsageHelper {
    public static String getUsage(Command c) {
        if(c==null) return "Valid Commands:\n" + Utils.print(c.getValues(),"\n",true);
        switch (c) {
            case CREATE_PARKING_LOT: return c.getValue() + " <No. Of Parking Spaces>";
            case PARK: return c.getValue() + " <Licence No. of car> <Color of car>";
            case LEAVE: return c.getValue() + " <Parking slot number>";
            case REGISTRATION_NUMBER_WITH_COLOR: return c.getValue()+ "<Color>";
            case SLOT_NUMBERS_WITH_COLOR: return c.getValue()+ "<Color>";
            case SLOT_NUMBER_WITH_REGISTRATION: return c.getValue()+ "<License No.>";
            default: return "Valid Commands:\n" + Utils.print(Command.getValues(),"\n",true);
        }
    }

    public static String getUsage(String main) {
        return "Usage: \n" +
                "1. MainClass\n" +
                "2. MainClass <Input File Name>";
    }
}
