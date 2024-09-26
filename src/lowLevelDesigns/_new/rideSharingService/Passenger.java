package lowLevelDesigns._new.rideSharingService;

public class Passenger {
    private String passengerId;
    private String passengerName;
    private String passengerContact;
    private Location passengerLocation;

    public Passenger(String passengerId, String passengerName, String passengerContact, Location passengerLocation) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerContact = passengerContact;
        this.passengerLocation = passengerLocation;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPassengerContact() {
        return passengerContact;
    }

    public Location getPassengerLocation() {
        return passengerLocation;
    }
}
