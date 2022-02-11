/**
* Creates a program that represents the inventory
* items in a store.
* 
* @author Jacob Howard
*/
public class InventoryItem {
   // variables
   protected String name;
   protected double price;
   private static double taxRate = 0;
   
   /**
   * Sets inventory items labels.
   * constructor
   * @param nameIn for name
   * @param priceIn for price
   */
   public InventoryItem(String nameIn, double priceIn) {
      name = nameIn;
      price = priceIn;
   }
   /**
   * Gets the name.
   * methods
   * @return to return the name
   */
   public String getName() {
      return name;
   }
   
   /**
   * Calculates the cost with tax.
   * @return to return the price
   */
   public double calculateCost() {
      return price * (1 + taxRate);
   }
   
   /**
   * Sets the tax rate for the items.
   * @param taxRateIn for the tax rate
   */
   public static void setTaxRate(double taxRateIn) {
      taxRate = taxRateIn;
   }
   
   /**
   * Creates a string for the name and cost to be printed.
   * @return to return the name and cost 
   */
   public String toString() {
      return name + ": $" + calculateCost();
   }
}