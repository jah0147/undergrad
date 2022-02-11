/**
* Creates a simple program to show account shipping costs
* for inventory items.
* 
* @author Jacob Howard
*/
public class ElectronicsItem extends InventoryItem {
   
   /**
   * Assigns the shipping cost and the weight.
   */
   public static final double SHIPPING_COST = 1.5;
   protected double weight;

   /**
   * Electronics name, price, and weight string.
   * @param nameIn for name
   * @param priceIn for price
   * @param weightIn for weight
   */
   public ElectronicsItem(String nameIn, double priceIn, double weightIn) {
   
      super(nameIn, priceIn);
      weight = weightIn;
   }

   /**
   * Calculates the cost.
   * @return to return the calculated cost
   */
   public double calculateCost() {
      return super.calculateCost() + (SHIPPING_COST * weight);
   }
}
