package lowLevelDesigns.vendingMachine.state;

import lowLevelDesigns.vendingMachine.Coin;
import lowLevelDesigns.vendingMachine.Item;
import lowLevelDesigns.vendingMachine.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState() {
        System.out.println("Vending Machine is in Idle State");
    }

    public IdleState(VendingMachine vendingMachine) {
        System.out.println("Vending Machine is in Idle State");
        vendingMachine.setCoinList(new ArrayList<>()); //resetting the coin list when vending machine is in idle state
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("You need to click on insert coin button first, machine is in idle state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You need to insert coin first, machine is in idle state");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You need to insert coin first, machine is in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("you can not get change in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("product can not be dispensed idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("you can not get refunded in idle state");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        vendingMachine.getInventory().addItem(item, codeNumber);
    }
}
