package lowLevelDesigns.vendingMachine;

import lowLevelDesigns.vendingMachine.state.State;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        try {
            System.out.println("Filling the vending machine with items");
            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

//            System.out.println("clicking on insert coin button");
//            State state = vendingMachine.getVendingMachineState();
//            state.clickOnInsertCoinButton(vendingMachine);
//
//            state = vendingMachine.getVendingMachineState();
//
//            System.out.println("Inserting coin");
//            state.insertCoin(vendingMachine, Coin.QUARTER);
//            state.insertCoin(vendingMachine, Coin.DIME);
//
//            System.out.println("clicking on start product selection button");
//            state.clickOnStartProductSelectionButton(vendingMachine);
//
//            state = vendingMachine.getVendingMachineState();
//            state.chooseProduct(vendingMachine, 0);
//
//            state = vendingMachine.getVendingMachineState();
//            state.dispenseProduct(vendingMachine, 0);
//
//            state = vendingMachine.getVendingMachineState();
//            displayInventory(vendingMachine);
        } catch (Exception e) {
            displayInventory(vendingMachine);
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            Item item = getItem(i);
            slots[i].setItem(item);
            slots[i].setSoldOut(false);
        }

        //flow is like this in fillUpInventory method
        //1. Get the inventory from vending machine
        //2. Get the slots from the inventory
        //3. Loop through the slots
        //4. Create an item
        //5. Set the item type and price based on the slot number
        //6. Set the item in the slot
        //7. Set the soldOut flag to false
    }

    private static Item getItem(int i) {
        Item item = new Item();
        if (i >= 0 && i < 3) {
            item.setItemType(ItemType.COKE);
            item.setPrice(25);
        } else if (i >= 3 && i < 5) {
            item.setItemType(ItemType.PEPSI);
            item.setPrice(35);
        } else if (i >= 5 && i < 7) {
            item.setItemType(ItemType.SODA);
            item.setPrice(45);
        } else if (i >= 7 && i < 9) {
            item.setItemType(ItemType.JUICE);
            item.setPrice(20);
        }
        return item;
    }

    private static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            System.out.println("Code Number: " + slots[i].getCode() +
                    " Item Type: " + slots[i].getItem().getItemType().name() +
                    " Price: " + slots[i].getItem().getPrice() +
                    " isAvailable: " + !slots[i].isSoldOut());
        }
    }

}

