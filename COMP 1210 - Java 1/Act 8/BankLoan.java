/********************************
* @author Jacob Howard
* Description : Bank loan progam
to calculate bank loan and interest.
********************************/
public class BankLoan {
	// constant fields
   private static final int MAX_LOAN_AMOUNT = 100000;

   // instance variables (can be used within the class)
   private String customerName;
   private double balance, interestRate;
   
   //Added
   private static int loansCreated = 0;
/**
* Creates in name and interest rate.
* @param customerNameIn for name
* @param interestRateIn for interest
*/
   public BankLoan(String customerNameIn, double interestRateIn) { 
      customerName = customerNameIn;
      interestRate = interestRateIn;
      balance = 0;
      loansCreated++; //Added
   }
/**
* @return wasLoanMade to return if loan was made
* @param amount for amount
*/
   public boolean borrowFromBank(double amount) {
      
      boolean wasLoanMade = false;
      
      if (balance + amount < MAX_LOAN_AMOUNT) {
         wasLoanMade = true;
         balance += amount;
      }
   
      return wasLoanMade;
   }
/**
* @return to return 0
* @param amountPaid for amount paid
*/
   public double payBank(double amountPaid) {
      double newBalance = balance - amountPaid;
      if (newBalance < 0) {
         balance = 0;
         // paid too much, return the overcharge
         return Math.abs(newBalance);
      }
      else {
         balance = newBalance;
         return 0;
      }
   }
  /**
  * @return to return false
  */ 
   public double getBalance() {
      return balance;
   }
   /**
   * @return to return false
   * @param interestRateIn for interest rate
   */
   public boolean setInterestRate(double interestRateIn) {
   
      if (interestRateIn >= 0 && interestRateIn <= 1) {
         interestRate = interestRateIn;
         return true;
      }
      else {
         return false;
      }
   }
   /**
   * @return to return interest
   */
   public double getInterestRate() {
      return interestRate;
   }
   /**
   *
   */
   public void chargeInterest() {
      balance = balance * (1 + interestRate);
   }
   /**
   * @return to return output
   */
   public String toString() {
      String output = "Name: " + customerName + "\r\n" 
         + "Interest rate: " + interestRate + "%\r\n" 
         + "Balance: $" + balance + "\r\n";
      return output;
   }
   
   /*********************************
   *************ADDED****************
   **|***|***|***|***|***|***|***|***
   **v***v***v***v***v***v***v***v***
   ************BELOW*****************
   *********************************/
   
   /**
    * @param amount input for amout
    * @return retuns if greater than 0
    */
   public static boolean isAmountValid(double amount) {
      return amount >= 0;
   }

   /**
    * @param loan input for an object
    * @return retuns if you are in debt
    */
   public static boolean isInDebt(BankLoan loan) {
      if (loan.getBalance() > 0) {
         return true;
      }
      return false;
   }

   /**
    * @return returns the amount of loans created
    */
   public static int getLoansCreated() {
      return loansCreated;
   }

   /**
    *
    */
   public static void resetLoansCreated() {
      loansCreated = 0;
   }

}
