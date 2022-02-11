
/*****************************************
* @author Jacob Howard
* Description : A simple program for Items.
******************************************/

public class ItemsList {

   private InventoryItem[] inventory;
   private int count;
   
/**************************************
* Items list.
**************************************/ 
   public ItemsList() {
      inventory = new InventoryItem[20];
      count = 0;
   }
   
    /**************************************
   *@param itemIn for item
   **************************************/
   public void addItem(InventoryItem itemIn) {
      inventory[count] = itemIn;
      count++;
   }
   
   /**************************************
   *@return to return total price
   * @param electronicsSurcharge for Surcharge
   **************************************/
   public double calculateTotal(double electronicsSurcharge) {
      double total = 0;
      
      for (int i = 0; i < count; i++) {
         if (inventory[i] instanceof ElectronicsItem) {
            total += inventory[i].calculateCost() + electronicsSurcharge;
         } else {
            total += inventory[i].calculateCost();
         }
      }
      
      return total;
   }
/**************************************
* @return to return toString
**************************************/
   public String toString() {
      String result = "All inventory:\n\n";
      
      for (int i = 0; i < count; i++) {
         result += inventory[i] + "\n";
      }
      
      return result;
   }
}
   
   



