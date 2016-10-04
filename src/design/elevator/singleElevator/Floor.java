package design.elevator.singleElevator;

/**
 * Created by mukulbudania on 4/10/16.
 */
public class Floor{

    private int number;
    private Button upButton;
    private Button downButton;

    public Floor(int number){
        this.number = number;
    }
    void initialize(){
        upButton = new FloorButton();
        downButton = new FloorButton();
    }

    public int getNumber() {
        return number;
    }

}
