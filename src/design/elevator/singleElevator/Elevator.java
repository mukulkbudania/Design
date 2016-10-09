
package design.elevator.singleElevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator{
	
	//State information
	private int currentFloor;
	private Direction direction;
	
	private Queue<Request> upRequests;
	private Queue<Request> downRequests;
	private List<Button> buttons;

	void initialize(){

		this.currentFloor = 0;
		this.direction = Direction.STANDBY;
		upRequests = new LinkedList<Request>();
		downRequests = new LinkedList<Request>();
		buttons = new ArrayList<Button>(5);
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Queue<Request> getUpRequests() {
		return upRequests;
	}

	public void setUpRequests(Queue<Request> upRequests) {
		this.upRequests = upRequests;
	}

	public Queue<Request> getDownRequests() {
		return downRequests;
	}

	public void setDownRequests(Queue<Request> downRequests) {
		this.downRequests = downRequests;
	}

	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}
	
	Request getNextRequest(){
		return null;
	}

	boolean serveRequest(Request r){
		return false;
	}
}



