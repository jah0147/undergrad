/**
 * @author Jacob Howard
 */

public class Division
{

/****************
* public int for divide.
* @return to return zero
* @param numerator for numerator
* @param denominator for denominator
****************/
   public static int intDivide(int numerator, int denominator)
   {
      try {
         return numerator / denominator;
      }
      catch (ArithmeticException error) {
         return 0;
      }
   }
   
   
  /*********************
  *double for decimal devide.
  * @param numerator for numerator
  * @param denom for denominator
  * @return to return division
  *********************/ 
   public static double decimalDivide(int numerator, int denom)
   {
      if (denom == 0)
      {
         throw new IllegalArgumentException("The denominator "
            + "cannot be zero.");
      }
      return ((double) numerator / denom);  
   }
}
