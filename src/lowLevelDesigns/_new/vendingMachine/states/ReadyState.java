package lowLevelDesigns._new.vendingMachine.states;

import lowLevelDesigns._new.vendingMachine.*;
import lowLevelDesigns._new.vendingMachine.coinAndNote.Coin;
import lowLevelDesigns._new.vendingMachine.coinAndNote.Note;
import lowLevelDesigns._new.vendingMachine.exceptions.DispenseProductException;
import lowLevelDesigns._new.vendingMachine.exceptions.InsufficientPaymentException;
import lowLevelDesigns._new.vendingMachine.exceptions.ReturnChangeException;
import lowLevelDesigns._new.vendingMachine.exceptions.SelectProductException;

public class ReadyState implements VendingMachineState {

    private VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        throw new SelectProductException("Product already selected");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Coin inserted: " + coin);
//        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        System.out.println("Note inserted: " + note);
//        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct() {
        throw new DispenseProductException("Please make payment first");
    }

    @Override
    public void returnChange() {
        throw new ReturnChangeException("Please make payment first");
    }

//    private void checkPaymentStatus() {
//        if (vendingMachine.getTotalPayment() < vendingMachine.getSelectedProduct().getPrice()) {
//            throw new InsufficientPaymentException("Insufficient payment. Please insert more coins or notes: "+ (vendingMachine.getSelectedProduct().getPrice() - vendingMachine.getTotalPayment()));
//        }
//        if (vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice()) {
//            vendingMachine.setCurrentState(vendingMachine.getDispenseState());
//        }
//    }
}
