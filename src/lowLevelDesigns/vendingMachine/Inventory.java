package lowLevelDesigns.vendingMachine;

public class Inventory {
    ItemShelf[] inventory=null; // null because we don't know the size of the inventory

    public Inventory(int size) {
        inventory = new ItemShelf[size];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    // This method will initialize the inventory with empty spaces
    // Initially all the items are sold out
    // So, we will set the soldOut flag to true
    // We will also set the code for each item
    public void initialEmptyInventory() {
        int startCode=101;
        for (int i=0; i<inventory.length; i++){
            ItemShelf space=new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true); // true because initially all the items are sold out
            inventory[i]=space;
            startCode++;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for (ItemShelf itemShelf:inventory){
            if (itemShelf.getCode()==codeNumber){
                if (itemShelf.isSoldOut()) {
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                }
                else {
                    throw new Exception("Item is already present in the inventory");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        for (ItemShelf itemShelf:inventory){
            if (itemShelf.code==codeNumber){
                if (!itemShelf.isSoldOut()){
                    return itemShelf.getItem();
                }
                else {
                    throw new Exception("Item is sold out");
                }
            }
        }
        throw new Exception("Invalid code number");
    }

    public void updateSoldOutItem(int codeNumber){
        for (ItemShelf itemShelf:inventory){
            if (itemShelf.code==codeNumber){
                itemShelf.setSoldOut(true);
            }
        }
    }

}
