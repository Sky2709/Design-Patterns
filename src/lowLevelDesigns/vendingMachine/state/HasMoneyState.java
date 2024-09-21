package lowLevelDesigns.vendingMachine.state;

import lowLevelDesigns.vendingMachine.Coin;
import lowLevelDesigns.vendingMachine.Item;
import lowLevelDesigns.vendingMachine.VendingMachine;

import java.util.List;

public class HasMoneyState implements State{
    public HasMoneyState() {
        System.out.println("Vending Machine is in Has Money State");
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        //do nothing
        return;
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        System.out.println("Coin inserted: " + coin);
        vendingMachine.getCoinList().add(coin);
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("you need to click on start product selection button first");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("you can not get change in hasMoney state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("product can not be dispensed in hasMoney state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Refunding full money");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("you can not update inventory in hasMoney  state");
    }
}
