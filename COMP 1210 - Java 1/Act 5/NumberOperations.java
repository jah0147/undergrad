/**************************************
* @author Jacob Howard
* Description : Code usued for Number
Ops Driver
**************************************/

public class NumberOperations {
   
   private int number;
   
  //Constructor
  /****************************************
  * Created new object.
  * @param numberIn for number
  ****************************************/ 
   public NumberOperations(int numberIn) {
      number = numberIn;
   }
   
   //Gets Value
   /***********************************
   * Grabs value and returns a number.
   * @return number to return a number.
   ***********************************/
   public int getValue() {
      return number;
   }
   
   // String odds under
   /************************************
   * Created string for odds.
   * @return output returns the output.
   ************************************/
   public String oddsUnder() {
      String output = "";
      int i = 0;
      while (i < number) {
         if (i % 2 != 0) {
            output += i + "\t";
         }
         i++;
      }
      return output;
   }
   
   // String Powers two under
   /**************************************
   * String Powers two under for string 
   power 2 and under.
   * @return output returns the output.
   **************************************/
   public String powersTwoUnder() {
      String output = "";
      int powers = 1;
      while (powers < number) {
         output += powers + "\t"; // concatenate to output
         powers = powers * 2; // get next power of two
      }
      return output;
   }
   
   //Compare Number is Greater
   /*****************************************
   * integer added and is compared to see if 
   number is greater or less than numbers.
   * @return to return.
   * @param compareNumber to compare the number
   *****************************************/
   public int isGreater(int compareNumber) {
      if (number > compareNumber) {
         return 1;
      }
      else if (number < compareNumber) {
         return -1;
      }
      else {
         return 0;
      }
   }
   
   // String to string
   /*********************************
   * Added string toString to get
   string.
   * @return number to return number 
   followed by a space.
   *********************************/
   public String toString() {
      return number + "";
   }
   
}