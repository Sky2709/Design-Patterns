package lowLevelDesigns._new.hotelManagementSystem;

public class Room {
    private String roomId;
    private RoomType roomType;
    private RoomStatus roomStatus;
    private double price;

    public Room(String roomId, RoomType roomType, double price) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.price = price;
        this.roomStatus=RoomStatus.AVAILABLE;
    }

    public synchronized void bookRoom(){
        if (roomStatus==RoomStatus.AVAILABLE){
            roomStatus=RoomStatus.BOOKED;
        }
        else {
            throw new IllegalStateException("Room not available");
        }
    }

    public synchronized void checkIn(){
        if (roomStatus==RoomStatus.BOOKED){
            roomStatus=RoomStatus.OCCUPIED;
        }
        else {
            throw new IllegalStateException("Room not booked");
        }
    }

    public synchronized void checkOut(){
        if (roomStatus==RoomStatus.OCCUPIED){
            roomStatus=RoomStatus.AVAILABLE;
        }
        else {
            throw new IllegalStateException("Room not occupied");
        }
    }

    public String getRoomId() {
        return roomId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public double getPrice() {
        return price;
    }
}
