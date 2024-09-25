package lowLevelDesigns.elevatorDesign.models;

public class Elevator {
    int id;
    ElevatorDisplay elevatorDisplay;
    InternalButton internalButtons;
    ElevatorState elevatorState;
    int currentFloor;
    Direction elevatorDirection;
    ElevatorDoor elevatorDoor;

    public Elevator(int id) {
        this.id = id;
        this.elevatorDisplay = new ElevatorDisplay();
        this.internalButtons = new InternalButton();
        this.elevatorState = ElevatorState.IDLE;
        this.currentFloor = 0;
        this.elevatorDirection = Direction.UP;
        this.elevatorDoor = new ElevatorDoor();
    }

    public void showElevatorDisplay(){
        elevatorDisplay.showDisplay();
    }

    public void pressButton(int destinationFloor){
        internalButtons.pressButton(destinationFloor, this);
    }

    public void setElevatorDisplay(){
        this.elevatorDisplay.setDisplay(currentFloor, elevatorDirection); // set the current floor and direction of the elevator
    }

    boolean moveElevator(Direction direction, int destinationFloor){
        int startFloor = currentFloor;
        if (direction==Direction.UP){
            for (int i=startFloor; i<=destinationFloor; i++){
                this.currentFloor=startFloor;
                setElevatorDisplay();
                showElevatorDisplay();
                if (i==destinationFloor){
                    return true;
                }
            }
        }

        if (direction==Direction.DOWN){
            for (int i=startFloor; i>=destinationFloor; i--){
                this.currentFloor=startFloor;
                setElevatorDisplay();
                showElevatorDisplay();
                if (i==destinationFloor){
                    return true;
                }
            }
        }
        return false;
    }
}
