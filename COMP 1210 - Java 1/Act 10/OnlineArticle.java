/**
* Creates a program to show account shipping costs
* for inventory items.
* 
* @author Jacob Howard
*/
public class OnlineArticle extends OnlineTextItem {
   private int wordCount;

   /**
   * Strings the online articles name and price.
   * @param nameIn for name
   * @param priceIn for price
   */
   public OnlineArticle(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      wordCount = 0;
   }

   /**
   * Sets the word count for the online articles.
   * @param wordCountIn for word count
   */
   public void setWordCount(int wordCountIn) {
      wordCount = wordCountIn;
   }
}