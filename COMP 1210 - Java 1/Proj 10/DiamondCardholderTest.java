import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
* @author Jacob Howard
*This is a code for diamond cardholder.
*/
public class DiamondCardholderTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
 /**
  *Test for getAcctNumber.
  */
   @Test public void getAcctNumberTest() {
      DiamondCardholder d = new DiamondCardholder("12345", "Name");
      Assert.assertEquals("12345", d.getAcctNumber());
   }
   
   /**
  *Test for setAcctNumber.
  */
   @Test public void setAcctNumberTest() {
      DiamondCardholder d = new DiamondCardholder("12345", "Name");
      d.setAcctNumber("3");
      Assert.assertEquals("3", d.getAcctNumber());
   }
   
   /**
  *Test for getName.
  */
   @Test public void getNameTest() {
      DiamondCardholder d = new DiamondCardholder("12345", "Name");
      Assert.assertEquals("Name", d.getName());
   }
   
   /**
  *Test for setName.
  */
   @Test public void setNameTest() {
      DiamondCardholder d = new DiamondCardholder("12345", "Name");
      d.setName("John");
      Assert.assertEquals("John", d.getName());
   }
   
   /**
  *Test for getPurchases.
  */
   @Test public void getPurchasesTest() {
      DiamondCardholder d = new DiamondCardholder("12345", "Name");
      double[] purchases = {1, 2, 3, 4};
      d.addPurchases(purchases);
      Assert.assertArrayEquals(purchases, d.getPurchases(), 0.01);
   }
/**
  *Test for setPurchases.
  */
   @Test public void setPurchasesTest() {
      DiamondCardholder d = new DiamondCardholder("12345", "Name");
      double[] purchases;
      purchases = new double[1];
      d.setPurchases(purchases);
      Assert.assertEquals(purchases, d.getPurchases());
   }
/**
  *Test for addPurchases.
  */
   @Test public void addPurchasesTest() {
      DiamondCardholder d = new DiamondCardholder("12345", "Name");
      double[] purchases = {1, 2, 3, 4};
      d.addPurchases(purchases);
      Assert.assertArrayEquals(purchases, d.getPurchases(), 0.01);
   }
/**
  *Test for deletePurchases.
  */
   @Test public void deletePurchasesTest() {
      DiamondCardholder d = new DiamondCardholder("12345", "Name");
      double[] purchases = {1, 2, 3, 4};
      double[] purchasesIn = {1, 3};
      d.addPurchases(purchases);
      d.deletePurchases(purchasesIn);
      double[] result = {2, 4};
      Assert.assertArrayEquals(result, d.getPurchases(), 0.01);
   }
/**
  *Test for calcTotal.
  */
   // @Test public void getCurrentBalanceTest() {
      // DiamondCardholder d = new DiamondCardholder("12345", "Name");
      // double[] purchases = {1, 2, 3, 4};
      // d.addPurchases(purchases);
      // double x = 1.0 + 2 + 3 + 4;
      // x = x * .01 + x;
      // Assert.assertEquals(x, d.getCurrentBalance(), .01);
   // }
/**
  *Test for calcSubtotal.
  */
   @Test public void getNewPurchase() {
      DiamondCardholder d = new DiamondCardholder("12345", "Example Name");
      double[] purchases = {1, 2, 3, 4};
      d.addPurchases(purchases);
      double x = 1.0 + 2 + 3 + 4;
      Assert.assertEquals(x, d.getNewPurchase(), .01);
   }
/**
  *Test for toString.
  */
   // @Test public void toStringTest() {
      // DiamondCardholder d = new DiamondCardholder("12345", "Name");
      // String variable = d.toString();
      // Assert.assertEquals(true, variable.contains("Interest: "));
   // }
      
   /**
   * test for purchase points.
   */
   @Test public void calcPurchasePointsTest() {
      DiamondCardholder d = new DiamondCardholder("10001", "Smith, Sam");
      double[] result = {12.0, 67.0};
      d.setPurchases(result);
      int result1 = d.calcPurchasePoints();
      Assert.assertEquals(0, result1);     
   }


   


  //  /** A test that always fails. **/
//    @Test public void defaultTest() {
//       Assert.assertEquals("Default test added by jGRASP. Delete "
//             + "this test once you have added your own.", 0, 1);
//    }
}

// 
//    /** A test that always fails. **/
//    @Test public void defaultTest() {
//       Assert.assertEquals("Default test added by jGRASP. Delete "
//             + "this test once you have added your own.", 0, 1);
//    }
// }
