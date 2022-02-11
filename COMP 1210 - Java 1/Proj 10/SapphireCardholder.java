import java.text.DecimalFormat;/**
* simple program for Saphire card members.
* @author Jacob Howard
*/



public class SapphireCardholder extends Cardholder {

/**
* Sapphire string for account number and name.
* @param acctNumberIn for acctNumber
* @param nameIn for name
*/
   public SapphireCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Sapphire Cardholder";
   }
   
/**
* @return to return
*/
   public int calcPurchasePoints() {
      double a = super.getTotalPurchases();
      int b = (int) a;
      return b;
   }
   
   public String toString()
   {
      DecimalFormat df1 = new DecimalFormat("$#,##0.00");
      DecimalFormat df2 = new DecimalFormat("#,##0");
      String output;
      output = super.toString()
         + "\n" + "Purchase Points: " + df2.format(calcPurchasePoints());
      
      return output;
   }
}
