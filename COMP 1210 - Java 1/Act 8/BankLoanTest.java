import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* @author Jacob Howard
* Test for bank loan.
*/
public class BankLoanTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /**
   * Added test.
   */
   @Test public void chargeIntrestTest() {
      BankLoan loan1 = new BankLoan("jane", .10);
      loan1.borrowFromBank(1000.00);
      loan1.chargeInterest();
      Assert.assertEquals(" ", 1100, loan1.getBalance(), .000001);
   }


   /** A test that always fails.  
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   } */

   
}
