package lowLevelDesigns.vendingMachine.state;

import lowLevelDesigns.vendingMachine.Coin;
import lowLevelDesigns.vendingMachine.Item;
import lowLevelDesigns.vendingMachine.VendingMachine;

import java.util.List;

public interface State {
    void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception;
    void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;
    void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception;
    void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;
    int getChange(int returnChangeMoney) throws Exception; //input is the money that needs to be returned because of insufficient change
    Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;
    List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception;
    void updateInventory(VendingMachine vendingMachine,Item item, int codeNumber) throws Exception;


}
