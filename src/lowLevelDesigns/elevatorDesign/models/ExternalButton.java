package lowLevelDesigns.elevatorDesign.models;

public class ExternalButton {
    private ExternalDispatcher externalDispatcher= new ExternalDispatcher();
    private int floorNumber;

    public ExternalButton(int floorNumber) {
        this.floorNumber = floorNumber;
    }

//    public void pressButton(int destinationFloor, Elevator elevator) {
//        //1.check if destination is in the list of available floors
//
//        //2.submit the request to the jobDispatcher
//        externalDispatcher.submitExternalRequest(destinationFloor, elevator);
//    }


}
