package design.parkinglot2;

import java.util.List;

/**
 * Created by mukulbudania on 2/12/16.
 */
public class CommandExecutor {
    private ParkingLot parkingLot;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public CommandExecutor(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public String execute(Command c) {
        if(c==null) return UsageHelper.getUsage(c);
        boolean b = CommandAndArgsValidator.validateArgs(c);
        if(!b) return "";
        List<String> args = c.getArguments();
        String NOT_INITIALIZED = "Create Parking lot first.\n Use command: " + Command.CREATE_PARKING_LOT + " <Parking spaces>";
        switch (c) {
            case CREATE_PARKING_LOT:
                if(getParkingLot().isInitialized()) return "Already Initialized";
                int spaces = Integer.parseInt(args.get(0));
                if (getParkingLot().initialize(spaces)) return "Created a parking lot with " + spaces + " slots\n";
                else return "Problem initializing parking lot with " + spaces + "spaces";

            case PARK:
                if(getParkingLot().isInitialized()){
                    String licenceNumber = args.get(0);
                    String color = args.get(1);
                    int parkSpot = getParkingLot().reserve(new Car(licenceNumber, color));
                    if (parkSpot == -1) return "Sorry Parking lot is full\n";
                    return "Allocated slot number " + parkSpot + "\n";
                } else {
                    return NOT_INITIALIZED;
                }


            case LEAVE:
                if(getParkingLot().isInitialized()){
                    int parkingSpot = Integer.parseInt(args.get(0));
                    Car car = getParkingLot().remove(parkingSpot);
                    if (car == null) return "Not Found\n";
                    return "Slot number " + parkingSpot + " is free\n";
                } else {
                    return NOT_INITIALIZED;
                }

            case STATUS:
                if(getParkingLot().isInitialized()){
                    return getParkingLot().printStatus();
                } else {
                    return NOT_INITIALIZED;
                }

            case REGISTRATION_NUMBER_WITH_COLOR:
                if(getParkingLot().isInitialized()){
                    String color = args.get(0);
                    List<String> registrationNumbers = getParkingLot().getRegistrationNumberFromColor(color);
                    if (Utils.isEmpty(registrationNumbers)) return "No Cars of Color " + color + "\n";
                    else return Utils.print(registrationNumbers);
                } else {
                    return NOT_INITIALIZED;
                }

            case SLOT_NUMBERS_WITH_COLOR:
                if(getParkingLot().isInitialized()){
                    String color = args.get(0);
                    List<Integer> slotNumbers = getParkingLot().getSlotNumbersFromColor(color);
                    if (Utils.isEmpty(slotNumbers)) return "No Cars of Color " + color + "\n";
                    else return Utils.print(slotNumbers);
                } else {
                    return NOT_INITIALIZED;
                }

            case SLOT_NUMBER_WITH_REGISTRATION:
                if(getParkingLot().isInitialized()){
                    String licenceNumber = args.get(0);
                    int slotNumber = getParkingLot().getSlotNumberFromRegistrationNumber(licenceNumber);
                    if (slotNumber == -1) return "Not found\n";
                    return slotNumber + "\n";
                } else {
                    return NOT_INITIALIZED;
                }

            default:
                return "No such command: " + c.getValue();
        }
    }
}
