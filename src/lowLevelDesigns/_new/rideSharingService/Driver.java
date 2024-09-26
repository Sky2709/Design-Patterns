package lowLevelDesigns._new.rideSharingService;

public class Driver {
    private String driverId;
    private String driverName;
    private String driverContact;
    private String licenseNumber;
    private Location driverLocation;
    private DriverStatus driverStatus;

    public Driver(String driverId, String driverName, String driverContact, String licenseNumber, Location driverLocation, DriverStatus driverStatus) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverContact = driverContact;
        this.licenseNumber = licenseNumber;
        this.driverLocation = driverLocation;
        this.driverStatus = driverStatus;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverContact() {
        return driverContact;
    }

    public void setDriverContact(String driverContact) {
        this.driverContact = driverContact;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Location getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(Location driverLocation) {
        this.driverLocation = driverLocation;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }
}
