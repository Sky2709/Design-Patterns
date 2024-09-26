package lowLevelDesigns._new.foodDeliveryService;

public class DeliveryAgent {
    private String deliveryAgentId;
    private String name;
    private String phone;
    private boolean available;

    public DeliveryAgent(String deliveryAgentId, String name, String phone) {
        this.deliveryAgentId = deliveryAgentId;
        this.name = name;
        this.phone = phone;
        this.available = true;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getDeliveryAgentId() {
        return deliveryAgentId;
    }
}
