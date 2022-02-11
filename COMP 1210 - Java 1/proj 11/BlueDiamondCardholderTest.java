import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* @author jacob Howard
*test for blue d card holder.
*/
public class BlueDiamondCardholderTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

 /**
  *Test for getAcctNumber.
  */
   @Test public void getAcctNumberTest() {
      BlueDiamondCardholder b = new BlueDiamondCardholder("12345", "Name");
      Assert.assertEquals("12345", b.getAcctNumber());
   }
   
   /**
  *Test for setAcctNumber.
  */
   @Test public void setAcctNumberTest() {
      BlueDiamondCardholder b = new BlueDiamondCardholder("12345", "Name");
      b.setAcctNumber("3");
      Assert.assertEquals("3", b.getAcctNumber());
   }
   
   /**
  *Test for getName.
  */
   @Test public void getNameTest() {
      BlueDiamondCardholder b = new BlueDiamondCardholder("12345", "Name");
      Assert.assertEquals("Name", b.getName());
   }
   
   /**
  *Test for setName.
  */
   @Test public void setNameTest() {
      BlueDiamondCardholder b = new BlueDiamondCardholder("12345", "Name");
      b.setName("John");
      Assert.assertEquals("John", b.getName());
   }
   
   /**
  *Test for getPurchases.
  */
   @Test public void getPurchasesTest() {
      BlueDiamondCardholder b = new BlueDiamondCardholder("12345", "Name");
      double[] purchases = {1, 2, 3, 4};
      b.addPurchases(purchases);
      Assert.assertArrayEquals(purchases, b.getPurchases(), 0.01);
   }
/**
  *Test for setPurchases.
  */
   @Test public void setPurchasesTest() {
      BlueDiamondCardholder b = new BlueDiamondCardholder("12345", "Name");
      double[] purchases;
      purchases = new double[1];
      b.setPurchases(purchases);
      Assert.assertEquals(purchases, b.getPurchases());
   }
/**
  *Test for addPurchases.
  */
   @Test public void addPurchasesTest() {
      BlueDiamondCardholder b = new BlueDiamondCardholder("12345", "Name");
      double[] purchases = {1, 2, 3, 4};
      b.addPurchases(purchases);
      Assert.assertArrayEquals(purchases, b.getPurchases(), 0.01);
   }
/**
  *Test for deletePurchases.
  */
   @Test public void deletePurchasesTest() {
      BlueDiamondCardholder b = new BlueDiamondCardholder("12345", "Name");
      double[] purchases = {1, 2, 3, 4};
      double[] purchasesIn = {1, 3};
      b.addPurchases(purchases);
      b.deletePurchases(purchasesIn);
      double[] result = {2, 4};
      Assert.assertArrayEquals(result, b.getPurchases(), 0.01);
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
      BlueDiamondCardholder b = new BlueDiamondCardholder("12345", 
         "Example Name");
      double[] purchases = {1, 2, 3, 4};
      b.addPurchases(purchases);
      double x = 1.0 + 2 + 3 + 4;
      Assert.assertEquals(x, b.getNewPurchase(), .01);
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
      BlueDiamondCardholder b = new BlueDiamondCardholder("10001", 
         "Smith, Sam");
      double[] result = {12.0, 67.0};
      b.setPurchases(result);
      int result1 = b.calcPurchasePoints();
      Assert.assertEquals(0, result1);     
   }



  //  /** A test that always fails. **/
//    @Test public void defaultTest() {
//       Assert.assertEquals("Default test added by jGRASP. Delete "
//             + "this test once you have added your own.", 0, 1);
//    }
}
