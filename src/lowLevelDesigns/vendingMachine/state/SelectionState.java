package lowLevelDesigns.vendingMachine.state;

import lowLevelDesigns.vendingMachine.Coin;
import lowLevelDesigns.vendingMachine.Item;
import lowLevelDesigns.vendingMachine.VendingMachine;

import java.util.List;

public class SelectionState implements State {
    public SelectionState() {
        System.out.println("Vending Machine is in Selection State");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("you can not click on insert coin button in Selection state");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("you can not insert Coin in selection state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        Item item = vendingMachine.getInventory().getItem(codeNumber);

        int paidByUser = 0;
        for (Coin coin : vendingMachine.getCoinList()) {
            paidByUser += coin.value;
        }

        if (paidByUser < item.getPrice()) {
            System.out.println("Insufficient money, price of the product is " + item.getPrice() + " and you have paid " + paidByUser);
            refundFullMoney(vendingMachine);
            throw new Exception("Insufficient Money");
        } else if (paidByUser >= item.getPrice()) {
            if (paidByUser > item.getPrice()) {
                getChange(paidByUser - item.getPrice());
            }
            vendingMachine.setVendingMachineState(new DispenseState(vendingMachine,codeNumber));
        }
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Change returned is " + returnChangeMoney);
        return returnChangeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("product can not be dispensed Selection state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Refunding full money");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory can not be updated in Selection state");
    }
}
