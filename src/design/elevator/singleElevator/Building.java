package design.elevator.singleElevator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukulbudania on 4/10/16.
 */
public class Building{
    List<Floor> floors;
    void initialize(int totalFloors){
        floors = new ArrayList<Floor>();
        for(int i=0;i<totalFloors;i++){
            floors.add(new Floor());
        }
    }

    public static List<Floor> getFloors() {
        return floors;
    }
}
