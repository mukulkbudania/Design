package design.elevator.singleElevator;

/**
 * Created by mukulbudania on 4/10/16.
 */
public class LiftButton implements Button {

    private int value;
    private Elevator belongsToElevator;

    @Override
    public boolean pressed() {
        return RequestDispatcher.processRequest(value,belongsToElevator);
        if(belongsToElevator.currentFloor < value){
            belongsToElevator.upRequests.add(new Request(value));
        } else {
            belongsToElevator.downRequests.add(new Request(value));
        }
    }
}
