package lowLevelDesigns._new.vendingMachine.states;

import lowLevelDesigns._new.vendingMachine.Product;
import lowLevelDesigns._new.vendingMachine.VendingMachine;
import lowLevelDesigns._new.vendingMachine.coinAndNote.Coin;
import lowLevelDesigns._new.vendingMachine.coinAndNote.Note;
import lowLevelDesigns._new.vendingMachine.exceptions.InsertCoinOrNoteException;
import lowLevelDesigns._new.vendingMachine.exceptions.ReturnChangeException;
import lowLevelDesigns._new.vendingMachine.exceptions.SelectProductException;

public class DispenseState implements VendingMachineState{
    private VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        throw new SelectProductException("Product already selected. Payment Done. Collect your product");
    }

    @Override
    public void insertCoin(Coin coin) {
        throw new InsertCoinOrNoteException("Payment already done. Collect your product");
    }

    @Override
    public void insertNote(Note note) {
        throw new InsertCoinOrNoteException("Payment already done. Collect your product");
    }

    @Override
    public void dispenseProduct() {
        vendingMachine.setCurrentState(vendingMachine.getReadyState()); //ready state after dispensing product because we need to select product again

        Product product = vendingMachine.getSelectedProduct();
        vendingMachine.inventory.removeOrDeductProduct(product, 1);
        System.out.println("Product dispensed: " + product.getName());
        if (vendingMachine.getTotalPayment()>product.getPrice()) {
            System.out.println("Setting to return change state");
            vendingMachine.setCurrentState(vendingMachine.getReturnChangeState());
        }
        else {
            System.out.println("Setting to idle state");
            vendingMachine.setCurrentState(vendingMachine.getIdleState());
        }
    }

    @Override
    public void returnChange() {
        throw new ReturnChangeException("Please collect your product first, Your change is being returned");
    }
}
