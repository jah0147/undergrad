import org.junit.Assert;
//import static org.junit.Assert.*;
//
import org.junit.Test;
import java.io.FileNotFoundException;


public class CardholderProcessorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
  // @Before public void setUp() {
   //}


  //  /** A test that always fails. **/
//    @Test public void defaultTest() {
//       Assert.assertEquals("Default test added by jGRASP. Delete "
//             + "this test once you have added your own.", 0, 1);
            
   @Test public void getchArray() {
      Cardholder[] ch = new Cardholder[0];
      CardholderProcessor cp = new CardholderProcessor();
      Assert.assertArrayEquals(ch, cp.getchArray());
   }
   /**
    *Test for getInvalidRecordsArray method.
    */
   @Test public void getInvalidRecordsArray() {
      String[] s = new String[0];
      CardholderProcessor cp = new CardholderProcessor();
      Assert.assertArrayEquals(s, cp.getinvalidRecordsArray());
   }
   /**
    *Test for addCustomer method.
    */
   @Test public void addCustomer() {
      CardholderProcessor cp = new CardholderProcessor();
      Cardholder ch = new SapphireCardholder("10001", "Smith, Sam");
      Cardholder[] ch1 = {ch};
      cp.addCardholder(ch);
      Assert.assertArrayEquals(ch1, cp.getchArray());
   }
   /**
    *Test for addInvalidRecord method.
    */
   @Test public void addInvalidRecord() {
      CardholderProcessor cp = new CardholderProcessor();
      Cardholder ch = new SapphireCardholder("12345", "Example Name");
      String[] s = {"Invalid Record"};
      String s1 = "Invalid Record";
      cp.addInvalidRecord(s1);
      Assert.assertArrayEquals(s, cp.getinvalidRecordsArray());
   }
   /**
    *Test for generateReport method.
    *@throws FileNotFoundException for exception
    */
   @Test public void generateReport() throws FileNotFoundException {
      CardholderProcessor cp = new CardholderProcessor();
      cp.readCardholderFile("cardholder_data_1.txt");
      String s = cp.generateReport();
      Assert.assertEquals(true, s.contains("Blue Diamond"));
   }
   /**
    *Test for generateReportFalse method.
    *@throws FileNotFoundException for exception
    */
   @Test public void generateReportFalse() throws FileNotFoundException {
      CardholderProcessor cp = new CardholderProcessor();
      cp.readCardholderFile("cardholder_data_1.txt");
      String s = cp.generateReport();
      Assert.assertEquals(false, s.contains("test"));
   }
   /**
    *Test for generateReportByName method.
    *@throws FileNotFoundException for exception
    */
   @Test public void generateReportByName() throws FileNotFoundException {
      CardholderProcessor cp = new CardholderProcessor();
      cp.readCardholderFile("cardholder_data_1.txt");
      String s = cp.generateReport();
      Assert.assertEquals(true, s.contains("Blue Diamond"));
   }
   /**
    *Test for generateReportByNameFalse method.
    *@throws FileNotFoundException for exception
    */
   @Test public void generateReportByNameFalse() throws FileNotFoundException {
      CardholderProcessor cp = new CardholderProcessor();
      cp.readCardholderFile("cardholder_data_1.txt");
      String s = cp.generateReport();
      Assert.assertEquals(false, s.contains("test"));
   }
   /**
    *Test for generateReportByTotal method.
    *@throws FileNotFoundException for exception
    */
   @Test public void generateReportByTotal() throws FileNotFoundException {
      CardholderProcessor cp = new CardholderProcessor();
      cp.readCardholderFile("cardholder_data_1.txt");
      String s = cp.generateReport();
      Assert.assertEquals(true, s.contains("Blue Diamond"));
   }
   /**
    *Test for generateReportByTotalFalse method.
    *@throws FileNotFoundException for exception
    */
   @Test public void generateReportByTotalFalse() throws FileNotFoundException {
      CardholderProcessor cp = new CardholderProcessor();
      cp.readCardholderFile("cardholder_data_1.txt");
      String s = cp.generateReport();
      Assert.assertEquals(false, s.contains("test"));
   }
}
            


