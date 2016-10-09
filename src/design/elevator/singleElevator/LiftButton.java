package design.elevator.singleElevator;

/**
 * Created by mukulbudania on 4/10/16.
 */
public class LiftButton implements Button {

    private int value;
    private Elevator belongsToElevator;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Elevator getBelongsToElevator() {
        return belongsToElevator;
    }

    public void setBelongsToElevator(Elevator belongsToElevator) {
        this.belongsToElevator = belongsToElevator;
    }

    @Override
    public boolean pressed(Person p) {
        return RequestDispatcher.queueRequest(value,belongsToElevator);
    }
}
