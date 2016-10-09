package design.elevator.singleElevator;

/**
 * Created by mukulbudania on 4/10/16.
 */
public class RequestDispatcher {

    public static Elevator getOptimizedElevator(Direction dir, Floor belongsToFloor) {
        //TODO add this logic
        return null;
    }

    public static boolean queueRequest(Direction dir, Floor belongsToFloor,Person p) {
        return queueRequest(dir,belongsToFloor,null,p);
    }

    public static boolean queueRequest(Direction dir, Floor belongsToFloor, Elevator assignedElevator, Person person) {
        if(dir!=null){
            if(assignedElevator==null){
                assignedElevator = getOptimizedElevator(dir,belongsToFloor);
            }
            if(assignedElevator.getCurrentFloor() < belongsToFloor.getNumber()){
                assignedElevator.getUpRequests().add(new Request(belongsToFloor.getNumber(),person));
            } else {
                assignedElevator.getDownRequests().add(new Request(belongsToFloor.getNumber(),person));
            }
        } else {
            if(dir.equals(Direction.DOWN)){
                assignedElevator.getDownRequests().add(new Request(belongsToFloor.getNumber(),person));
            } else {
                assignedElevator.getUpRequests().add(new Request(belongsToFloor.getNumber(),person));
            }
        }
        return true;
    }

    public static boolean queueRequest(int value, Elevator belongsToElevator,Person p) {
        Floor floor = Building.getFloors().get(value);
        return queueRequest(null,floor,belongsToElevator,p);
    }
}
