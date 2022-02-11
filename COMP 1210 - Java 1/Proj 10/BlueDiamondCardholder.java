/**
* @author Jacob Howard
* this code is for blue diamond card members.
*/
public class BlueDiamondCardholder extends Cardholder {
/**
* declared items.
*/
   private static final double discountRate = 0.10;
   private static final int bonusPurchasePoints = 2500;

/**
* string for account number and name.
* @param acctNumberIn for acctNumber
* @param nameIn for name
*/
   public BlueDiamondCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Blue Diamond Cardholder";
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
      int b = (int) a * 5;
      //test for bonus purchase points
      if (super.getNewPurchase() > 2500.00) {
         b = b + bonusPurchasePoints;
      }
      else {
         b = b;
      }
      return b;
   }
}

