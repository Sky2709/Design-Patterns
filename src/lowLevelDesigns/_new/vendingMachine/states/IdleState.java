package lowLevelDesigns._new.vendingMachine.states;

import lowLevelDesigns._new.vendingMachine.*;
import lowLevelDesigns._new.vendingMachine.coinAndNote.Coin;
import lowLevelDesigns._new.vendingMachine.coinAndNote.Note;
import lowLevelDesigns._new.vendingMachine.exceptions.DispenseProductException;
import lowLevelDesigns._new.vendingMachine.exceptions.InsertCoinOrNoteException;
import lowLevelDesigns._new.vendingMachine.exceptions.ProductNotAvailableException;
import lowLevelDesigns._new.vendingMachine.exceptions.ReturnChangeException;

public class IdleState implements VendingMachineState {

    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }


    @Override
    public void selectProduct(Product product) {
        if (vendingMachine.inventory.hasProduct(product)) {
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setCurrentState(vendingMachine.getReadyState());
            System.out.println("Product selected: " + product.getName());
            System.out.println("Please insert coin or note: " + product.getPrice());
        } else {
            throw new ProductNotAvailableException("Product: " + product.getName() + " is out of stock");
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        throw new InsertCoinOrNoteException("Please select a product first");
    }

    @Override
    public void insertNote(Note note) {
        throw new InsertCoinOrNoteException("Please select a product first");
    }

    @Override
    public void dispenseProduct() {
        throw new DispenseProductException("Please select a product first");
    }

    @Override
    public void returnChange() {
        throw new ReturnChangeException("Please select a product first");
    }
}
