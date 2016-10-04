package design.elevator.singleElevator;

/**
 * Created by mukulbudania on 4/10/16.
 */
public class Person{
    Elevator assignedElevator;

    boolean pressButton(Button b){
        if(b.isLiftButton){
            if(assignedElevator.currentFloor < b.getVal()){
                assignedElevator.upRequests.add(new Request(b.getVal()));
            } else {
                assignedElevator.downRequests.add(new Request(b.getVal()));
            }
        } else{

        }
    return true;
    }
}
