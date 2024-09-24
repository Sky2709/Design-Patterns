package lowLevelDesigns.vehicleRentalSystem;

public class Location {
    String address;
    String city;
    String state;
    String zipCode;
    String country;

    public Location(String city, String state, String zipCode, String country) {
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }
}
