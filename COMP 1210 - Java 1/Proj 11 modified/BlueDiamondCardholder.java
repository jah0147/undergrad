/**************************
* @author Jacob Howard
* this code is for blue diamond card members.
**************************/
public class BlueDiamondCardholder extends DiamondCardholder {
/**************************
* declared items.
**************************/
   private static final double DISCOUNT_RATE = 0.10;
   private static final int BONUS_PURCHASE_POINTS = 2500;

/**************************
* string for account number and name.
* @param acctNumberIn for acctNumber
* @param nameIn for name
**************************/
   public BlueDiamondCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Blue Diamond Cardholder";
   }
   
   /**************************
   * @return to return
   **************************/
   public double getDiscount() {
      double a = super.getTotalPurchases() * DISCOUNT_RATE;
      double b = super.getTotalPurchases() - a;
      return b;
   }
/**************************
* @return to return
**************************/
   public int calcPurchasePoints() {
      double a = super.getTotalPurchases() * getDiscount();
      int b = (int) a * 5;
      //test for bonus purchase points
      if (super.totalPurchases() > 2500.00) {
         b = b + BONUS_PURCHASE_POINTS;
      }
      else {
         b = b;
      }
      return b;
   }
}

