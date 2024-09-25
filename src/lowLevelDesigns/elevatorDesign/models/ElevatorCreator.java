package lowLevelDesigns.elevatorDesign.models;

import lowLevelDesigns.elevatorDesign.controllers.ElevatorController;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {
    public static List<ElevatorController> elevatorControllersList=new ArrayList<>();

    static {
        Elevator elevator1= new Elevator(1);
        ElevatorController elevatorController1= new ElevatorController(elevator1);

        Elevator elevator2= new Elevator(2);
        ElevatorController elevatorController2= new ElevatorController(elevator2);

        elevatorControllersList.add(elevatorController1);
        elevatorControllersList.add(elevatorController2);

    }

}
