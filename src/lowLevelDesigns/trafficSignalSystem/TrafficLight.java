package lowLevelDesigns.trafficSignalSystem;

public class TrafficLight {
    private String trafficLightId;
    private Signal currentSignal;
    private int redDuration;
    private int greenDuration;
    private int yellowDuration;

    public TrafficLight(String trafficLightId, int redDuration, int greenDuration, int yellowDuration) {
        this.trafficLightId = trafficLightId;
        this.redDuration = redDuration;
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
        this.currentSignal=Signal.RED;
    }

    public synchronized void changeSignal(Signal newSignal){
        currentSignal=newSignal;
        notifyObservers();
    }

    public String getTrafficLightId() {
        return trafficLightId;
    }

    public void setTrafficLightId(String trafficLightId) {
        this.trafficLightId = trafficLightId;
    }

    public Signal getCurrentSignal() {
        return currentSignal;
    }

    public void setCurrentSignal(Signal currentSignal) {
        this.currentSignal = currentSignal;
    }

    public int getRedDuration() {
        return redDuration;
    }

    public void setRedDuration(int redDuration) {
        this.redDuration = redDuration;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public void setGreenDuration(int greenDuration) {
        this.greenDuration = greenDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public void setYellowDuration(int yellowDuration) {
        this.yellowDuration = yellowDuration;
    }

    private void notifyObservers() {
        //notify all the observers
        System.out.println("Signal changed to: "+currentSignal);
    }
}
