
package design.elevator.singleElevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator{
	
	//State information
	int currentFloor;
	Direction direction;
	
	Queue<Request> upRequests;
	Queue<Request> downRequests;
	List<Button> buttons;

	void initialize(){
		this.currentFloor = 0;
		this.direction = Direction.STANDBY;
		upRequests = new LinkedList<Request>();
		downRequests = new LinkedList<Request>();
		buttons = new ArrayList<Button>(5);
	}
	
	Request getNextRequest(){
		return null;
	}

	boolean serveRequest(Request r){
		return false;
	}
}



