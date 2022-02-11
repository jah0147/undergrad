import java.text.DecimalFormat;
/*****************************
* simple program for Diamond card members.
* @author Jacob Howard
*****************************/



public class DiamondCardholder extends Cardholder {

   protected double discountRate = 0.05;
/*****************************
* string for account number and name.
* @param acctNumberIn for acctNumber
* @param nameIn for name
*****************************/
   public DiamondCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Diamond Cardholder";
   }
   
   /*****************************
   * @return to return discount
   *****************************/
   public double getDiscountRate() {
      return discountRate;
   }
   
   /*****************************
   * @param discountRateIn for discountRate
   *****************************/
   public void setDiscountRate(double discountRateIn) {
      discountRate = discountRateIn;
   }
/*****************************
* @return to return
*****************************/
   public int purchasePoints() {
      return (int) (totalPurchases()) * 3;
   }
   
   /*****************************
   * returns total purchases.
   * @return to return
   *****************************/
   public double totalPurchases() {
      double total = 0;
      for (int i = 0; i < getPurchases().length; i++) {
         total += purchases[i] - (purchases[i] * getDiscountRate());
      }
      return total;
   }
   
   /*****************************
   * to string method.
   * @return to return toString
   *****************************/
   public String toString() {
      DecimalFormat df1 = new DecimalFormat("$#,##0.00");
      DecimalFormat df2 = new DecimalFormat("#,##0");
      DecimalFormat df3 = new DecimalFormat("0.0%");
      
      String output = category + "\n";
      output += "AcctNo/Name: " + getAcctNumber() + " " + getName()  + "\n";
      output += "Previous Balance: " 
         + df1.format(getPrevBalance()) + "\n";
      output += "Payment: (" + df1.format(getPayment()) + ")\n";
      output += "Interest: " + df1.format(interest()) + "\n";
      output += "New Purchases: " + df1.format(totalPurchases()) + "\n";
      output += "Current Balance: " + df1.format(currentBalance()) + "\n";
      output += "Minimum Payment: " + df1.format(minPayment()) + "\n";
      output += "Purchase Points: " + df2.format(purchasePoints()) + "\n";
      output += "(includes 5.0% discount rate applied to New Purchases)";
      return output;
   }
}
