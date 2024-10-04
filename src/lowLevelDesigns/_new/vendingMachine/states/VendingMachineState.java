package lowLevelDesigns._new.vendingMachine.states;

import lowLevelDesigns._new.vendingMachine.Product;
import lowLevelDesigns._new.vendingMachine.coinAndNote.Coin;
import lowLevelDesigns._new.vendingMachine.coinAndNote.Note;

public interface VendingMachineState {
    void selectProduct(Product product);
    void insertCoin(Coin coin);
    void insertNote(Note note);
    void dispenseProduct();
    void returnChange();
}
