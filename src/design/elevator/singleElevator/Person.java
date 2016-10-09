package design.elevator.singleElevator;

/**
 * Created by mukulbudania on 4/10/16.
 */
public class Person{
    int weight;
    private Elevator assignedElevator;
    private Floor assignedFloor;

    public Elevator getAssignedElevator() {
        return assignedElevator;
    }

    public void setAssignedElevator(Elevator assignedElevator) {
        this.assignedElevator = assignedElevator;
    }

    public Floor getAssignedFloor() {
        return assignedFloor;
    }

    public void setAssignedFloor(Floor assignedFloor) {
        this.assignedFloor = assignedFloor;
    }

    boolean pressButton(Button b){
        if(b instanceof LiftButton){
            LiftButton lB = (LiftButton)b;
            return lB.pressed(this);
        } else if(b instanceof FloorButton) {
            FloorButton fB = (FloorButton)b;
            return fB.pressed(this);
        }
    return false;
    }
}
