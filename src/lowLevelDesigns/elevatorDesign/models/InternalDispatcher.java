package lowLevelDesigns.elevatorDesign.models;

import lowLevelDesigns.elevatorDesign.controllers.ElevatorController;

import java.util.List;

public class InternalDispatcher {
    List<ElevatorController> elevatorControllersList = ElevatorCreator.elevatorControllersList;
    public void submitInternalRequest(int destinationFloor, Elevator elevator) {
    }
}
