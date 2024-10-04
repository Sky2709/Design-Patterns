package lowLevelDesigns._new.vendingMachine.states;

import lowLevelDesigns._new.vendingMachine.Product;
import lowLevelDesigns._new.vendingMachine.VendingMachine;
import lowLevelDesigns._new.vendingMachine.coinAndNote.Coin;
import lowLevelDesigns._new.vendingMachine.coinAndNote.Note;
import lowLevelDesigns._new.vendingMachine.exceptions.DispenseProductException;
import lowLevelDesigns._new.vendingMachine.exceptions.InsertCoinOrNoteException;
import lowLevelDesigns._new.vendingMachine.exceptions.SelectProductException;

public class ReturnChangeState implements VendingMachineState{
    private VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        throw new SelectProductException("Product cannot be selected in ReturnChangeState");
    }

    @Override
    public void insertCoin(Coin coin) {
        throw new InsertCoinOrNoteException("Coin cannot be inserted in ReturnChangeState");
    }

    @Override
    public void insertNote(Note note) {
        throw new InsertCoinOrNoteException("Note cannot be inserted in ReturnChangeState");
    }

    @Override
    public void dispenseProduct() {
        throw new DispenseProductException("Product cannot be dispensed in ReturnChangeState");
    }

    @Override
    public void returnChange() {
        double change =vendingMachine.getTotalPayment()-vendingMachine.getSelectedProduct().getPrice();
        if (change>0){
            System.out.println("Returning Change: "+change);
            vendingMachine.resetTotalPayment();
        }
        else {
            System.out.println("No Change to return");
        }
        vendingMachine.resetSelectedProduct();
        vendingMachine.setCurrentState(vendingMachine.getIdleState());
    }
}
