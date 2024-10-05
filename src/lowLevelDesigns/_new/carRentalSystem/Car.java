package lowLevelDesigns._new.carRentalSystem;

public class Car {
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private double rentalPricePerDay;
    private boolean available;

    public Car(String make, String model, int year, String licensePlate, double rentalPricePerDay) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.rentalPricePerDay = rentalPricePerDay;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
