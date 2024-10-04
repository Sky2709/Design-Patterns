package lowLevelDesigns._new.vendingMachine.coinAndNote;

public enum Coin {
    PENNY(1),
    NICKLE(5),
    DIME(10),
    QUARTER(25);

    private double value;
    Coin(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
