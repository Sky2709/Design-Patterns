package lowLevelDesigns._new.hotelManagementSystem;

public class Guest {
    private String guestId;
    private String guestName;
    private String email;
    private String phone;

    public Guest(String guestId, String guestName, String email, String phone) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.email = email;
        this.phone = phone;
    }

    public String getGuestId() {
        return guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
