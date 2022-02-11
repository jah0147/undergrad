/**
* Creates a simple program for online test that allows a user
* to buy items.
* 
* @author Jacob Howard
*/
public abstract class OnlineTextItem extends InventoryItem {
   
   /**
   * Strings the online text items name and price.
   * @param nameIn for name
   * @param priceIn for price
   */
   public OnlineTextItem(String nameIn, double priceIn) {
      super(nameIn, priceIn);
   }
   
   /**
   * Calculates the cost.
   * @return to return the price
   */
   public double calculateCost() {
      return price;
   }
}