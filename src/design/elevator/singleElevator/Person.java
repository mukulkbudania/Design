package design.elevator.singleElevator;

/**
 * Created by mukulbudania on 4/10/16.
 */
public class Person{
    Elevator assignedElevator;
    Floor assignedFloor;

    boolean pressButton(Button b){
        if(b instanceof LiftButton){
            LiftButton lB = (LiftButton)b;
            return lB.pressed();
        } else if(b instanceof FloorButton) {
            FloorButton fB = (FloorButton)b;
            return fB.pressed();
        }
    return false;
    }
}
