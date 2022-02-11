import java.util.Arrays;
import java.text.DecimalFormat;
/**
* @author Jacob Howard
* This is an abstract code for card holders.
**/

public abstract class Cardholder {
   protected String name;
   protected String category;
   protected String acctNumber;
   protected double prevBalance;
   protected double payment;
   protected double[] purchases;
   /**
   * Sets the interest rate.
   */
   public static final double INTEREST_RATE = 0.01;

   /**
   * Constructor
   * Cardholder strings information.
   * @param acctNumberIn for acctNumber
   * @param nameIn for name
   */
   public Cardholder(String acctNumberIn, String nameIn) {
      acctNumber = acctNumberIn;
      name = nameIn;
      purchases = new double[0];
   }

   
   //Methods
   /**
    * Creates a string to get name.
    * @return returns the name of the object
    */
   public String getName() {
      return name;
   }
   
    /**
    * Sets the name.
    * @param nameIn sets the name of the object
    */
   public void setName(String nameIn) {
      name = nameIn;
   }
   
   /**
    * Get the category.
    * @return to return.
    */
   public String getCategory() {
      return category;
   }
   /**
    * Sets the category.
    * @param categoryIn for category
    */
   public void setcategory(String categoryIn) {
      category = categoryIn;
   }
   /**
    * Gets the accounts number.
    * @return to return.
    */
   public String getAcctNumber() {
      return acctNumber;
   }
   /**
    * Sets the account number.
    * @param acctNumberIn for acctNumber.
    */
   public void setAcctNumber(String acctNumberIn) {
      acctNumber = acctNumberIn;
   }
   /**
   * Gets the previous balance.
   * @return to return
   */
   public double getPrevBalance() {
      return prevBalance;
   }
   /**
   * Sets the previous balance.
   * @param prevBalanceIn for prevBalance
   */
   public void setPrevBalance(double prevBalanceIn) {
      prevBalance = prevBalanceIn;
   }
   /**
   * Gets the payment.
   * @return to return
   */
   public double getPayment() {
      return payment;
   }
   /**
   * Sets the payment.
   * @param paymentIn for payment
   */
   public void setPayment(double paymentIn) {
      payment = paymentIn;
   }
    /**
    * Gets the purchases.
    * @return return to return purchases.
    */
   public double[] getPurchases() {
      return purchases;
   }
   /**
   * Sets the purchases.
   * @param purchasesIn for purchases
   */
   public void setPurchases(double... purchasesIn) {
      purchases = purchasesIn;
   }
   /**
   * Adds the purchases.
   * @param purchasesIn for pruchases
   */
   public void addPurchases(double...purchasesIn) {
      for (int i = 0; i < purchasesIn.length; i++) {
         purchases = Arrays.copyOf(purchases, purchases.length + 1);
         purchases[purchases.length - 1] = purchasesIn[i];
      }
   }
   /**
   * Deletes the purchases.
   * @param purchasesIn for purchases
   */
   public void deletePurchases(double...purchasesIn) {
      for (int i = 0; i < purchasesIn.length; i++) {
         for (int x = 0; x < purchasesIn.length; x++) {
            if (purchasesIn[i] == purchasesIn[x]) {
               for (int y = x; y < purchases.length - 1; y++) {
                  purchases[y] = purchases[y + 1];
               }
               purchases = Arrays.copyOf(purchases, purchases.length - 1);
            }
            //Arrays.copyOf(purchases, purchases.length - 1);
         }
      }
   }
   
   /**
  *calcSubtotal method.
  *@return newPurchase
  */
   public double getNewPurchase() {
      double newPurchase = 0.0;
      for (int i = 0; i < purchases.length; i++) {
         newPurchase = newPurchase + purchases[i];
      }
      return newPurchase;
   }
   /**
   * Sets the interests.
   * @return to return
   */
   public double getInterest() {
      double interest = (prevBalance - payment) * INTEREST_RATE;
      return interest;
   }
   /**
   * The total for the purchases.
   * @return to return
   */
   public double getTotalPurchases() {
      double totalPurchases = (purchases.length - 1);
      return totalPurchases;
   }
   /**
   * Sets the balance.
   * @return to return
   */
   public double getBalance() {
      double balance = (getPrevBalance() + getInterest() + getTotalPurchases());
      return balance;
   }
   /**
   * Sets the current balance.
   * @return to return
   */
   public double getCurrentBalance() {
      double currentBalance = (getPrevBalance() 
         - getPayment() + getInterest() + getTotalPurchases());
      return currentBalance;
   } 
   /**
   * Sets the minimum payment.
   * @return to return
   */
   public double getMinPayment() {
      double minPayment = (0.03 * getCurrentBalance());
      return minPayment;
   }
      /**
   * Strings the cardholders information.
   * @return to return
   */
   public String toString() {
      DecimalFormat df1 = new DecimalFormat("$#,##0.00");
      DecimalFormat df2 = new DecimalFormat("#,##0");
      String output = getCategory() 
         + "\n" + "AcctNo/Name: " + acctNumber + name
         +  "\n" + "Previous Balance: " + df1.format(getPrevBalance())
         +  "\n" + "Interest: " + df1.format(getInterest())
         +  "\n" + "New Purchases: " + df1.format(getPurchases())  
         +  "\n" + "Current Balance: " + df1.format(getCurrentBalance()) 
         +  "\n" + "Minimum Payment: " + df1.format(getMinPayment())
         +  "\n" + "Purchase Points: " + df2.format(calcPurchasePoints());
                   
      return output;
   }
   
   /**
    *calcAwardPoints method.
    *@return abstract
    */
   public abstract int calcPurchasePoints();
   
   /**
  *@param object this is the parameter.
  *@return compareTo.
  */
   public int compareTo(Cardholder object) {
      return name.toLowerCase()
         .compareTo(object.getName().toLowerCase());
   }
}