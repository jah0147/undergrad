import org.junit.Assert;
//import org.junit.Before;
import org.junit.Test;

/*****************************
* @author Jacob howard
* code for sapphire card holder.
*****************************/
public class SapphireCardholderTest {

    /*****************************
   * test for purchase points.
   *****************************/
   @Test public void purchasePointsTest() {
      SapphireCardholder s = new SapphireCardholder("10001", "Smith, Sam");
      s.addPurchases(34.5, 100.0, 63.50, 350.0);
      s.setPrevBalance(1200.0);
      s.setPayment(200);
      int purchasePointsTest = 548;
      Assert.assertEquals(purchasePointsTest, s.purchasePoints());
   }
}
