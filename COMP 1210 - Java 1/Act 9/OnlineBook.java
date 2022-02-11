/**
* Creates a program to show the account shipping costs
* for inventory items.
* 
* @author Jacob Howard
*/
public class OnlineBook extends OnlineTextItem {
   protected String author;
   
   /**
   * Strings online books name and price.
   * @param nameIn for name
   * @param priceIn for price
   */
   public OnlineBook(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      author = "Author Not Listed";
   }

   /**
   * Sets the author.
   * @param authorIn for the author
   */
   public void setAuthor(String authorIn) {
      author = authorIn;
   }

   /**
   * Strings the information for the online book based on name,
   * author, and cost calculated.
   * @return to return the online books information
   */
   public String toString() {
      return name + " - " + author + ": $" + super.calculateCost();
   }
}