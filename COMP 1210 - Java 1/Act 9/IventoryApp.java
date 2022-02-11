/**
* Creates a driver program to set the items respectively
* for the inventory items.
* 
* @author Jacob Howard
*/
public class IventoryApp {

   /**
   * Assigns information to each of the items.
   * @param args (not used).
   */
   public static void main(String[] args) {
   // sets the tax rate
   // item 1
      InventoryItem i = new InventoryItem("Oil change kit", 39.99);
      InventoryItem.setTaxRate(0.05);
      System.out.println(i);
   
   // item 2
      ElectronicsItem e = new ElectronicsItem("Cordless phone", 80.00, 1.8);
      System.out.println(e);
   
   // item 3
      OnlineArticle a = new OnlineArticle("Java News", 8.50);
      a.setWordCount(700);
      System.out.println(a);
   
   // item 4
      OnlineBook b = new OnlineBook("Java for Noobs", 13.37);
      b.setAuthor("L.G. Jones");
      System.out.println(b);
   }
}