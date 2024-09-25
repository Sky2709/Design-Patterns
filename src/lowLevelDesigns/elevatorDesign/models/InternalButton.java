package lowLevelDesigns.elevatorDesign.models;

public class InternalButton {
    InternalDispatcher internalDispatcher= new InternalDispatcher();
    int[] internalButtonList={1,2,3,4,5,6,7,8,9,10};
    int buttonSelected;

    public void pressButton(int destinationFloor, Elevator elevator) {
        //1.check if destination is in the list of available floors

        //2.submit the request to the jobDispatcher
        internalDispatcher.submitInternalRequest(destinationFloor, elevator);
    }
}
