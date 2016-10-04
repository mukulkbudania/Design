package design.elevator.singleElevator;

/**
 * Created by mukulbudania on 4/10/16.
 */
public class RequestDispatcher {

    public static Elevator getOptimizedElevator() {
        return null;
    }

    public static boolean processRequest(Direction dir, Floor belongsToFloor) {
        return processRequest(dir,belongsToFloor,null);
    }

    public static boolean processRequest(Direction dir, Floor belongsToFloor, Elevator assignedElevator) {
        if(assignedElevator==null){
            assignedElevator = getOptimizedElevator();
        }
        if(assignedElevator.currentFloor < belongsToFloor.getNumber()){
            assignedElevator.upRequests.add(new Request(belongsToFloor.getNumber()));
        } else {
            assignedElevator.downRequests.add(new Request(belongsToFloor.getNumber()));
        }
    }

    public static boolean processRequest(int value, Elevator belongsToElevator) {
        Floor floor = Building.getFloors().get(value);
        
    }
}
