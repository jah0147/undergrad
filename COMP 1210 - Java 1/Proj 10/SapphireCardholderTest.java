import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* @author Jacob Howard
* code for sapphire card holder.
*/
public class SapphireCardholderTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
 /**
  *Test for getAcctNumber.
  */
   @Test public void getAcctNumberTest() {
      SapphireCardholder s = new SapphireCardholder("12345", "Name");
      Assert.assertEquals("12345", s.getAcctNumber());
   }
   
   /**
  *Test for setAcctNumber.
  */
   @Test public void setAcctNumberTest() {
      SapphireCardholder s = new SapphireCardholder("12345", "Name");
      s.setAcctNumber("3");
      Assert.assertEquals("3", s.getAcctNumber());
   }
   
   /**
  *Test for getName.
  */
   @Test public void getNameTest() {
      SapphireCardholder s = new SapphireCardholder("12345", "Name");
      Assert.assertEquals("Name", s.getName());
   }
   
   /**
  *Test for setName.
  */
   @Test public void setNameTest() {
      SapphireCardholder s = new SapphireCardholder("12345", "Name");
      s.setName("John");
      Assert.assertEquals("John", s.getName());
   }
   
   /**
  *Test for category.
  */
   @Test public void getCategoryTest() {
      SapphireCardholder s = new SapphireCardholder("12345", "Name");
      Assert.assertEquals("Sapphire Cardholder", s.getCategory());
   }
   
   /**
  *Test for getPurchases.
  */
   @Test public void getPurchasesTest() {
      SapphireCardholder s = new SapphireCardholder("12345", "Name");
      double[] purchases = {1, 2, 3, 4};
      s.addPurchases(purchases);
      Assert.assertArrayEquals(purchases, s.getPurchases(), 0.01);
   }
/**
  *Test for setPurchases.
  */
   @Test public void setPurchasesTest() {
      SapphireCardholder s = new SapphireCardholder("12345", "Name");
      double[] purchases;
      purchases = new double[1];
      s.setPurchases(purchases);
      Assert.assertEquals(purchases, s.getPurchases());
   }
/**
  *Test for addPurchases.
  */
   @Test public void addPurchasesTest() {
      SapphireCardholder s = new SapphireCardholder("12345", "Name");
      double[] purchases = {1, 2, 3, 4};
      s.addPurchases(purchases);
      Assert.assertArrayEquals(purchases, s.getPurchases(), 0.01);
   }
/**
  *Test for deletePurchases.
  */
   @Test public void deletePurchasesTest() {
      SapphireCardholder s = new SapphireCardholder("12345", "Name");
      double[] purchases = {1, 2, 3, 4};
      double[] purchasesIn = {1, 3};
      s.addPurchases(purchases);
      s.deletePurchases(purchasesIn);
      double[] result = {2, 4};
      Assert.assertArrayEquals(result, s.getPurchases(), 0.01);
   }
/**
  *Test for calcTotal.
  */
   @Test public void getCurrentBalanceTest() {
      SapphireCardholder s = new SapphireCardholder("12345", "Name");
      double[] purchases = {1, 2, 3, 4};
      s.addPurchases(purchases);
      double x = 1.0 + 2 + 3 + 4;
      x = x * .01 + x;
      Assert.assertEquals(x, s.getCurrentBalance(), .01);
   }
/**
  *Test for calcSubtotal.
  */
   @Test public void getNewPurchase() {
      SapphireCardholder s = new SapphireCardholder("12345", "Example Name");
      double[] purchases = {1, 2, 3, 4};
      s.addPurchases(purchases);
      double x = 1.0 + 2 + 3 + 4;
      Assert.assertEquals(x, s.getNewPurchase(), .01);
   }
// /**
//   *Test for toString.
//   */
//    @Test public void toStringTest() {
//       SapphireCardholder s = new SapphireCardholder("12345", "Name");
//       String variable = s.toString();
//       Assert.assertEquals(true, variable.contains("Interest: "));
//    }
      
   /**
   * test for purchase points.
   */
   @Test public void calcPurchasePointsTest() {
      SapphireCardholder s = new SapphireCardholder("10001", "Smith, Sam");
      double[] result = {12.0, 67.0};
      s.setPurchases(result);
      int result1 = s.calcPurchasePoints();
      Assert.assertEquals(1, result1);     
   }


   


  //  /** A test that always fails. **/
//    @Test public void defaultTest() {
//       Assert.assertEquals("Default test added by jGRASP. Delete "
//             + "this test once you have added your own.", 0, 1);
//    }
}
