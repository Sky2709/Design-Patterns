package lowLevelDesigns.trafficSignalSystem;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        TrafficController trafficController= TrafficController.getInstance();
        Road road1= new Road("R001", "Main Street");
        Road road2= new Road("R002", "BroadWay");
        Road road3= new Road("R003", "Wall Street");
        Road road4= new Road("R004", "Fleet Street");

        TrafficLight trafficLight1= new TrafficLight("TL01", 6000, 3000,9000);
        TrafficLight trafficLight2= new TrafficLight("TL02", 5000, 2000,8000);
        TrafficLight trafficLight3= new TrafficLight("TL03", 4000, 1000,7000);
        TrafficLight trafficLight4= new TrafficLight("TL04", 3000, 500,6000);

        road1.setTrafficLight(trafficLight1);
        road2.setTrafficLight(trafficLight2);
        road3.setTrafficLight(trafficLight3);
        road4.setTrafficLight(trafficLight4);

        trafficController.addRoad(road1);
        trafficController.addRoad(road2);
        trafficController.addRoad(road3);
        trafficController.addRoad(road4);

        trafficController.startTrafficSignal();
    }
}
