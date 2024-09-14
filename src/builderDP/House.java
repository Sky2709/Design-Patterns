package builderDP;

public class House {
    // Required parameters
    private final String foundation;
    private final String structure;

    // Optional parameters
    private final int windows;
    private final boolean hasGarden;
    private final boolean hasSwimmingPool;

    // Private constructor to restrict instantiation
    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.windows = builder.windows;
        this.hasGarden = builder.hasGarden;
        this.hasSwimmingPool = builder.hasSwimmingPool;
    }

    // Static Builder Class
    public static class HouseBuilder {
        // Required parameters
        private final String foundation;
        private final String structure;

        // Optional parameters with default values
        private int windows = 0;
        private boolean hasGarden = false;
        private boolean hasSwimmingPool = false;

        // Constructor for mandatory parameters
        public HouseBuilder(String foundation, String structure) {
            this.foundation = foundation;
            this.structure = structure;
        }

        // Setter methods for optional parameters (fluent interface)
        public HouseBuilder setWindows(int windows) {
            this.windows = windows;
            return this;
        }

        public HouseBuilder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        // Method to create the House object
        public House build() {
            return new House(this);
        }
    }

    // Getters for fields (optional)
    public String getFoundation() {
        return foundation;
    }

    public String getStructure() {
        return structure;
    }

    public int getWindows() {
        return windows;
    }

    public boolean hasGarden() {
        return hasGarden;
    }

    public boolean hasSwimmingPool() {
        return hasSwimmingPool;
    }
}

class Main{
    public static void main(String[] args) {
        House houseWithPool= new House.HouseBuilder("Concrete", "Wood")
                .setWindows(4)
                .setGarden(true)
                .setSwimmingPool(true)
                .build();

        House houseWithoutPool= new House.HouseBuilder("Brick", "Wood")
                .setWindows(2)
                .build();


        System.out.println("House with pool: Foundation: "+houseWithPool.getFoundation());
        System.out.println("House without pool: Foundation: "+ houseWithoutPool.getFoundation());
    }
}

