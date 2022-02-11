/*****************************
* @author Jacob Howard
* Decription : finds even, odd
and average scores. 
*****************************/
public class Scores {

//instance variables
   private int[] numbers;

/*****************
//constructor
* constructor for the code.
* @param numbersIn for numbers
*****************/
   public Scores(int[] numbersIn) {
      numbers = numbersIn;
   }

/************************************
* methods for the code.
* evens to find even numbers.
* @return to return evens
************************************/
   public int[] findEvens() {
      int numberEvens = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            numberEvens++;
         }
      }
      int[] evens = new int[numberEvens];
      int count = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            evens[count] = numbers[i];
            count++;
         }
      }
      return evens;
   }
   
   /****************************
   * part of code to find odds.
   * @return to return odds
   ****************************/
   public int[] findOdds() {
      int numberOdds = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 1) {
            numberOdds++;
         }
      }
      int[] odds = new int[numberOdds];
      int count = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 1) {
            odds[count] = numbers[i];
            count++;
         }
      }
      return odds;
   }
   
   /********************************
   * code to calculate avg.
   * @return to return avg
   ********************************/
   public double calculateAverage() {
      int sum = 0;
      for (int i = 0; i < numbers.length; i++) {
         sum += numbers[i];
      }
      double d1 = sum;
      double d2 = numbers.length;
      return d1 / d2;
   }
   /**************************************
   * to string to return string method.
   * @return result
   ***************************************/
   public String toString() {
      String result = "";
      for (int i = 0; i < numbers.length; i++) {
         result += numbers[i] + "\t";
      }
      return result; 
   }
   /************************
   * reverse the string.
   * @return to return result
   *************************/
   public String toStringInReverse() {
      String result = "";
      for (int i = numbers.length - 1; i >= 0; i--) {
         result += numbers[i] + "\t";
      }
      return result;
   }
}