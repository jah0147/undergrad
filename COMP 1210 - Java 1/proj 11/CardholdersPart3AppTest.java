import org.junit.Assert;
// import static org.junit.Assert.*;
// import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;


public class CardholdersPart3AppTest {


   /** Fixture initialization (common initialization
  //   *  for all tests). **/
//    @Before public void setUp() {
//    }
// 
// 
//    /** A test that always fails. **/
//    @Test public void defaultTest() {
//       Assert.assertEquals("Default test added by jGRASP. Delete "
//             + "this test once you have added your own.", 0, 1);
//    }



 /**
   *test for main method
   *@throws IOException e
   *
   */
   @Test public void mainWFileTest() throws FileNotFoundException {
      CardholdersPart3App chA = new CardholdersPart3App();
      String[] args = {"customers.txt"};
      CardholdersPart3App.main(args);
      Assert.assertEquals(Cardholder.INTEREST_RATE, 0.01);
   }
   /**
   *test for main method
   *@throws FileNotFoundExceptiono e
   */
   @Test public void mainWithoutFileNameTest() throws FileNotFoundException {
      CardholdersPart3App chA = new CardholdersPart3App();
      String[] args = {};
      CardholdersPart3App.main(args);
      Assert.assertEquals(Cardholder.INTEREST_RATE, 0.01);
   }
}

