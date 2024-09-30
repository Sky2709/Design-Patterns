package lowLevelDesigns._new.airLineManagementSystem;

public class Passenger {
    private String passengerId;
    private String passengerName;
    private String eMail;
    private String phone;

    public Passenger(String passengerId, String passengerName, String eMail, String phone) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.eMail = eMail;
        this.phone = phone;
    }
}
