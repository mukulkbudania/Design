package design.elevator.singleElevator;

/**
 * Created by mukulbudania on 4/10/16.
 */
public class FloorButton implements Button {
    private Direction dir;
    Floor belongsToFloor;

    @Override
    public boolean pressed() {
        return RequestDispatcher.processRequest(dir,belongsToFloor);
    }
}
