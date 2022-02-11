import java.text.DecimalFormat;
/*****************************
* @author Jacob Howard
*Blue Diamond cardholder.
******************************/
public class BlueDiamondCardholder extends DiamondCardholder {
   private int bonusPurchasePoints = 2500;
   
   /*****************************
   *@param acctNumberIn for the account number.
   *@param nameIn for name.
   ******************************/
   public BlueDiamondCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Blue Diamond Cardholder";
      discountRate = .10;
   }

   /*****************************
   *@return bonusPurchasePoints.
   ******************************/
   public int getBonusPurchasePoints() {
      return bonusPurchasePoints;
   }
   
   /*****************************
   *@param bonusPurchasePointsIn to set bonus points.
   ******************************/
   public void setBonusPurchasePoints(int bonusPurchasePointsIn) {
      bonusPurchasePoints = bonusPurchasePointsIn;
   }
   
   /*****************************
   *@return purchase points.
   ******************************/
   public int purchasePoints() {
      if (totalPurchases() > 2500.00) {
         return ((int) (totalPurchases()) * 5) + getBonusPurchasePoints();
      }
      else {
         return (int) (totalPurchases()) * 5;
      }
   }
   
   /*****************************
   *@return output.
   ******************************/
   public String toString() {
      DecimalFormat df1 = new DecimalFormat("$#,##0.00");
      DecimalFormat df2 = new DecimalFormat("#,##0");
      DecimalFormat df3 = new DecimalFormat("0.0%");
      DecimalFormat df4 = new DecimalFormat("#,##0");
      
      String output = category + "\n";
      output += "AcctNo/Name: " + getAcctNumber() + " " + getName()  + "\n";
      output += "Previous Balance: " 
         + df1.format(getPrevBalance()) + "\n";
      output += "Payment: (" + df1.format(getPayment()) + ")\n";
      output += "Interest: " + df1.format(interest()) + "\n";
      output += "New Purchases: " + df1.format(totalPurchases()) + "\n";
      output += "Current Balance: " + df1.format(currentBalance()) + "\n";
      output += "Minimum Payment: " 
         + df1.format(minPayment()) + "\n";
      output += "Purchase Points: " 
         + df2.format(purchasePoints()) + "\n";
      output += "(includes 10.0% discount rate applied to New Purchases)";
      if (totalPurchases() > 2500.00) {
         output += "\n(includes 2,500 bonus points added to Purchase Points)";
      }
      return output;
   }
   
}