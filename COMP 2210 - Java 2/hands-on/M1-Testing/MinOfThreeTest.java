import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MinOfThreeTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
  
   
   @Test
   public void min1Test() {
      int a = 1;
      int b = 2;
      int c = 3;
      int expected = 1;
      int actual =MinOfThree.min1(a, b, c);
      assertEquals(expected, actual);
   }
   
   @Test
   public void min2Test() {
      int a = 1;
      int b = 2;
      int c = 3;
      int expected = 1;
      int actual =MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }
   
   @Test
   public void min1TestNeg() {
      int a = -1;
      int b = 2;
      int c = 3;
      int expected = -1;
      int actual =MinOfThree.min1(a, b, c);
      assertEquals(expected, actual);
   }
   
   @Test
   public void min2TestNeg() {
      int a = -1;
      int b = 2;
      int c = 3;
      int expected = -1;
      int actual =MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }
}
