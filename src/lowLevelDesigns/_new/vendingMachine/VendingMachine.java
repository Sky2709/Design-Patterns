package lowLevelDesigns._new.vendingMachine;

import lowLevelDesigns._new.vendingMachine.coinAndNote.Coin;
import lowLevelDesigns._new.vendingMachine.coinAndNote.Note;
import lowLevelDesigns._new.vendingMachine.exceptions.InsufficientPaymentException;
import lowLevelDesigns._new.vendingMachine.states.*;

public class VendingMachine {
    private static VendingMachine vendingMachineInstance;
    public Inventory inventory;
    private VendingMachineState idleState;
    private VendingMachineState readyState;
    private VendingMachineState dispenseState;
    private VendingMachineState returnChangeState;
    private VendingMachineState currentState;
    private Product selectedProduct;
    private double totalPayment;

    private VendingMachine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        currentState = idleState;
    }

    public static synchronized VendingMachine getInstance() {
        if (vendingMachineInstance == null) {
            vendingMachineInstance = new VendingMachine();
        }
        return vendingMachineInstance;
    }

    public void selectProduct(Product product) {
//        System.out.println("Selected product: " + product.getName());
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void displayTotalPayment() {
        System.out.println("Total payment: " + totalPayment);
    }

    public void insertNote(Note note) {
        currentState.insertNote(note);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange() {
        currentState.returnChange();
    }

    public VendingMachineState getCurrentState() {
        System.out.println("Current state: " + currentState.getClass().getSimpleName());
        return currentState;
    }

    public void setCurrentState(VendingMachineState currentState) {

        this.currentState = currentState;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getReadyState() {
        return readyState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public VendingMachineState getReturnChangeState() {
        return returnChangeState;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public void resetSelectedProduct() {
        selectedProduct = null;
    }

    public double getTotalPayment() {
//        System.out.println("Total payment: " + totalPayment);
        return totalPayment;
    }

    public void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }

    public void addNote(Note note) {
        totalPayment += note.getValue();
    }

    public void resetTotalPayment() {
        totalPayment = 0;
    }

    public void checkPaymentStatus() {
        if (this.getTotalPayment() < this.getSelectedProduct().getPrice()) {
            throw new InsufficientPaymentException("Insufficient payment. Please insert more coins or notes: "+ (this.getSelectedProduct().getPrice() - this.getTotalPayment()));
        }
        if (this.getTotalPayment() >= this.getSelectedProduct().getPrice()) {
            this.setCurrentState(this.getDispenseState());
        }
    }
}
