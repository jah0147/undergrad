import java.util.Arrays;
import java.text.DecimalFormat;
/*****************************
* @author Jacob Howard
* This is an abstract code for card holders.
******************************/

public abstract class Cardholder {
   protected String name;
   protected String category = "Cardholder";
   protected String acctNumber;
   protected double prevBalance;
   protected double payment;
   protected double[] purchases;
   /*****************************
   * Sets the interest rate.
   *****************************/
   public static final double INTEREST_RATE = 0.01;

   /*****************************
   * Constructor
   * Cardholder strings information.
   * @param acctNumberIn for acctNumber
   * @param nameIn for name
   *****************************/
   public Cardholder(String acctNumberIn, String nameIn) {
      acctNumber = acctNumberIn;
      name = nameIn;
      purchases = new double[0];
   }

   
   //Methods
   /*****************************
    * Creates a string to get name.
    * @return returns the name of the object
    *****************************/
   public String getName() {
      return name;
   }
   
    /*****************************
    * Sets the name.
    * @param nameIn sets the name of the object
    *****************************/
   public void setName(String nameIn) {
      name = nameIn;
   }
   
   /*****************************
    * Get the category.
    * @return to return.
    *****************************/
   // public String getCategory() {
      // return category;
   // }
//    /*****************************
//     * Sets the category.
//     * @param categoryIn for category
//     *****************************/
   // public void setcategory(String categoryIn) {
      // category = categoryIn;
   // }
   /*****************************
    * Gets the accounts number.
    * @return to return.
    *****************************/
   public String getAcctNumber() {
      return acctNumber;
   }
   /*****************************
    * Sets the account number.
    * @param acctNumberIn for acctNumber.
    *****************************/
   public void setAcctNumber(String acctNumberIn) {
      acctNumber = acctNumberIn;
   }
   /*****************************
   * Gets the previous balance.
   * @return to return
   *****************************/
   public double getPrevBalance() {
      return prevBalance;
   }
   /*****************************
   * Sets the previous balance.
   * @param prevBalanceIn for prevBalance
   *****************************/
   public void setPrevBalance(double prevBalanceIn) {
      prevBalance = prevBalanceIn;
   }
   /*****************************
   * Gets the payment.
   * @return to return
   *****************************/
   public double getPayment() {
      return payment;
   }
   /*****************************
   * Sets the payment.
   * @param paymentIn for payment
   *****************************/
   public void setPayment(double paymentIn) {
      payment = paymentIn;
   }
    /*****************************
    * Gets the purchases.
    * @return return to return purchases.
    *****************************/
   public double[] getPurchases() {
      return purchases;
   }
   /*****************************
   * Sets the purchases.
   * @param purchasesIn for purchases
   *****************************/
   public void setPurchases(double... purchasesIn) {
      purchases = purchasesIn;
   }
   /*****************************
   * Adds the purchases.
   * @param purchasesIn for pruchases
   *****************************/
   public void addPurchases(double...purchasesIn) {
      for (int i = 0; i < purchasesIn.length; i++) {
         purchases = Arrays.copyOf(purchases, purchases.length + 1);
         purchases[purchases.length - 1] = purchasesIn[i];
      }
   }
   /*****************************
   * Deletes the purchases.
   * @param purchasesIn for purchases
   *****************************/
   public void deletePurchases(double...purchasesIn) {
      for (double purchase : purchasesIn) {
         for (int x = 0; x < purchases.length; x++) {
            if (purchase == purchases[x]) {
               for (int y = x; y < purchases.length - 1; y++) {
                  purchases[y] = purchases[y + 1];
               }
               purchases = Arrays.copyOf(purchases, purchases.length - 1);
            }
            //Arrays.copyOf(purchases, purchases.length - 1);
         }
      }
   }
   
   /*****************************
  *calcSubtotal method.
  *@return newPurchase
  *****************************/
   // public double getNewPurchase() {
      // double newPurchase = 0.0;
      // for (int i = 0; i < purchases.length; i++) {
         // newPurchase = newPurchase + purchases[i];
      // }
      // return newPurchase;
   // }
   /*****************************
   * Sets the interests.
   * @return to return
   *****************************/
   public double interest() {
      return (prevBalance - payment) * INTEREST_RATE;
   }
   /*****************************
   * The total for the purchases.
   * @return to return
   *****************************/
   public double totalPurchases() {
      double total = 0;
      for (int i = 0; i < getPurchases().length; i++) {
         total += purchases[i];
      }
      return total;
   }
   /*****************************
   * Sets the balance.
   * @return to return
   *****************************/
   public double balance() {
      return (prevBalance * interest()) + totalPurchases();
   }
   /*****************************
   * Sets the current balance. 
   * @return to return
   *****************************/
   public double currentBalance() {
      return prevBalance - payment + interest() + totalPurchases();
   } 
   /*****************************
   * Sets the minimum payment.
   * @return to return
   *****************************/
   public double minPayment() {
      return 0.03 * currentBalance();
   }
   
     /*****************************
    *calcAwardPoints method.
    *@return abstract
    *****************************/
   public abstract int purchasePoints();
   
      /*****************************
   * Strings the cardholders information.
   * @return to return
   *****************************/
   public String toString() {
      DecimalFormat df1 = new DecimalFormat("$#,##0.00");
      DecimalFormat df2 = new DecimalFormat("#,##0");
      
      String output = category + "\n";
      output += "AcctNo/Name: " + getAcctNumber() + " " + getName() + "\n";
      output += "Previous Balance: " 
         + df1.format(getPrevBalance()) + "\n";
      output += "Payment: (" + df1.format(getPayment()) + ")\n";
      output += "Interest: " + df1.format(interest()) + "\n";
      output += "New Purchases: " + df1.format(totalPurchases()) + "\n";
      output += "Current Balance: " + df1.format(currentBalance()) + "\n";
      output += "Minimum Payment: " + df1.format(minPayment()) + "\n";
      output += "Purchase Points: " + df2.format(purchasePoints()) + "\n";
      return output;
   }
   
   /*****************************
  *@param object2 this is the parameter.
  *@return compareTo.
  *****************************/
   public int compareTo(Cardholder object2) {
      if (this.name.compareToIgnoreCase(object2.getName()) == 0) {
         return 0;
      }
      else {
         return 1;
      }
   }
}