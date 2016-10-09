package design.elevator.singleElevator;

/**
 * Created by mukulbudania on 4/10/16.
 */
public class FloorButton implements Button {
    private Direction direction;
    private Floor belongsToFloor;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Floor getBelongsToFloor() {
        return belongsToFloor;
    }

    public void setBelongsToFloor(Floor belongsToFloor) {
        this.belongsToFloor = belongsToFloor;
    }

    @Override
    public boolean pressed() {
        return RequestDispatcher.queueRequest(direction,belongsToFloor);
    }
}
