import org.junit.Assert;
// import org.junit.Before;
import org.junit.Test;
/*****************************
* @author Jacob Howard
*This is a code for diamond cardholder.
*****************************/
public class DiamondCardholderTest {

  /*****************************
   *discountRate test.
   *****************************/
   @Test public void discountRateTest() {
      DiamondCardholder d = new DiamondCardholder("10002", "Jones, Pat");
      d.setDiscountRate(.15);
      Assert.assertEquals(.15, d.getDiscountRate(), .000001);
   }

   /*****************************
   *purchasePoints test.
   *****************************/
   @Test public void purchasePointsTest() {
      DiamondCardholder d = new DiamondCardholder("10002", "Jones, Pat");
      d.addPurchases(34.5, 100.0, 63.50, 300.0);
      d.setPrevBalance(1200.0);
      int purchasePointsTest = 1419;
      Assert.assertEquals(purchasePointsTest, d.purchasePoints());
   }
   
   /*****************************
   *totalPurchases test.
   *****************************/
   @Test public void totalPurchasesTest() {
      DiamondCardholder d = new DiamondCardholder("10002", "Jones, Pat");
      d.addPurchases(34.5, 100.0, 63.50, 300.0);
      d.setPrevBalance(1200.0);
      double totalPurchasesTest = 473.10;
      Assert.assertEquals(totalPurchasesTest, d.totalPurchases(), .000001);
   }
   
   /*****************************
   *toString test.
   *****************************/
   @Test public void toStringTest() {
      DiamondCardholder d = new DiamondCardholder("10002", "Jones, Pat");
      d.addPurchases(34.5, 100.0, 63.50, 300.0);
      d.setPrevBalance(1200.0);
      String output =  "Diamond Cardholder\n";
      output += "AcctNo/Name: 10002 Jones, Pat\n";
      output += "Previous Balance: $1,200.00\n";
      output += "Payment: ($0.00)\n";
      output += "Interest: $12.00\n";
      output += "New Purchases: $473.10\n";
      output += "Current Balance: $1,685.10\n";
      output += "Minimum Payment: $50.55\n";
      output += "Purchase Points: 1,419\n";
      output += "(includes 5.0% discount rate applied to New Purchases)";
      Assert.assertEquals(output, d.toString());
   }
   
  //  /***************************** A test that always fails.
//    @Test public void defaultTest() {
//       Assert.assertEquals("Default test added by jGRASP. Delete "
//             + "this test once you have added your own.", 0, 1);
//    }
}

// 
//    /***************************** A test that always fails.
//    @Test public void defaultTest() {
//       Assert.assertEquals("Default test added by jGRASP. Delete "
//             + "this test once you have added your own.", 0, 1);
//    }
// }
