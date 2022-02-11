import org.junit.Assert;
import org.junit.Test;

/*****************************
* @author Jacob Howard
*BlueDiamondCardholder test.
*****************************/
public class BlueDiamondCardholderTest {
   /*****************************
   *bonusPurchasePoints test.
   *****************************/
   @Test public void bonusPurchasePointsTest() {
      BlueDiamondCardholder bd = 
         new BlueDiamondCardholder("10003", "King, Kelly");
      bd.addPurchases(34.5, 100.0, 63.50, 300.0, 100.0);
      bd.setPrevBalance(1200.0);
      bd.setBonusPurchasePoints(1212);
      Assert.assertEquals(1212, bd.getBonusPurchasePoints());
   }
   /*****************************
   *purchasePoints with the bonus test.
   *****************************/
   @Test public void purchasePointsBonus() {
      BlueDiamondCardholder bd2 = 
         new BlueDiamondCardholder("10004", "Jenkins, Jordan");
      bd2.addPurchases(5000.0, 1000.0, 4000.0);
      bd2.setPrevBalance(1200.0);
      int purchasePointsTest = 47500;
      Assert.assertEquals(purchasePointsTest, bd2.purchasePoints());
   }
   /*****************************
   *purchasePoints() w bonus added test.
   *****************************/
   @Test public void purchasePointNoBonus() {
      BlueDiamondCardholder bd = 
         new BlueDiamondCardholder("10003", "King, Kelly");
      bd.addPurchases(34.5, 100.0, 63.50, 300.0, 100.0);
      bd.setPrevBalance(1200.0);
      int purchasePointsTest = 2690;
      Assert.assertEquals(purchasePointsTest, bd.purchasePoints());
   }
   /*****************************
   *toString() w bonus test.
   *****************************/
   @Test public void toStringTestBonus() {
      BlueDiamondCardholder bd2 = 
         new BlueDiamondCardholder("10004", "Jenkins, Jordan");
      bd2.addPurchases(5000.0, 1000.0, 4000.0);
      bd2.setPrevBalance(1200.0);
      String output =  "Blue Diamond Cardholder\n";
      output += "AcctNo/Name: 10004 Jenkins, Jordan\n";
      output += "Previous Balance: $1,200.00\n";
      output += "Payment: ($0.00)\n";
      output += "Interest: $12.00\n";
      output += "New Purchases: $9,000.00\n";
      output += "Current Balance: $10,212.00\n";
      output += "Minimum Payment: $306.36\n";
      output += "Purchase Points: 47,500\n";
      output += "(includes 10.0% discount rate applied to New Purchases)";
      output += "\n(includes 2,500 bonus points added to Purchase Points)";
      Assert.assertEquals(output, bd2.toString());
   }
   /*****************************
   *toString() w no bonus test.
   *****************************/
   @Test public void toStringTestNoBonus() {
      BlueDiamondCardholder bd = 
         new BlueDiamondCardholder("10003", "King, Kelly");
      bd.addPurchases(34.5, 100.0, 63.50, 300.0, 100.0);
      bd.setPrevBalance(1200.0);
      String output =  "Blue Diamond Cardholder\n";
      output += "AcctNo/Name: 10003 King, Kelly\n";
      output += "Previous Balance: $1,200.00\n";
      output += "Payment: ($0.00)\n";
      output += "Interest: $12.00\n";
      output += "New Purchases: $538.20\n";
      output += "Current Balance: $1,750.20\n";
      output += "Minimum Payment: $52.51\n";
      output += "Purchase Points: 2,690\n";
      output += "(includes 10.0% discount rate applied to New Purchases)";
      Assert.assertEquals(output, bd.toString());
   }
   
}
