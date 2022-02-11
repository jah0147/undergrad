/**
* simple program for Diamond card members.
* @author Jacob Howard
*/



public class DiamondCardholder extends Cardholder {

   private static final double discountRate = 0.05;
/**
* string for account number and name.
* @param acctNumberIn for acctNumber
* @param nameIn for name
*/
   public DiamondCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Diamond Cardholder";
   }
   
   /**
   * @return to return
   */
   public double getDiscount() {
      double a = super.getTotalPurchases() * discountRate;
      double b = super.getTotalPurchases() - a;
      return b;
   }
/**
* @return to return
*/
   public int calcPurchasePoints() {
      double a = super.getTotalPurchases() * getDiscount();
      int b = (int) a * 3;
      return b;
   }
}
