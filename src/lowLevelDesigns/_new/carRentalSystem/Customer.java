package lowLevelDesigns._new.carRentalSystem;

public class Customer {
    private String customerId;
    private String customerName;
    private String contactNumber;
    private String licenseNumber;

    public Customer(String customerId, String customerName, String contactNumber, String licenseNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.licenseNumber = licenseNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
}
