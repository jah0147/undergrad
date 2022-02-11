/********************************
* @author Jacob Howard
* This will calculate
userInput x using given formula.
********************************/

//Scanner used to calculate.
import java.util.Scanner; 
//adds power function
import static java.lang.Math.pow;
//adds absolute value 
import static java.lang.Math.abs;
 // adds square root
import static java.lang.Math.sqrt; 
// adds decimal format
import java.text.DecimalFormat; 
/**
* Prints ticket info.
*/
public class FormulaEval {
/**
* This code will take the user-input
x and calculate that x using a 
given formula.
* @param args (not used)
*/
   public static void main(String[] args) {
   
   //Adding variables and scanners
      Scanner userInput = new Scanner(System.in);
      DecimalFormat fmt = new DecimalFormat("#,##0.0####");
      double x = 0;
      String resultS;
      int decL = 0;
      int decR = 0;
      
      //Prompts user to enter a value for x
      System.out.print("Enter a value for x: "); 
      x = userInput.nextDouble();
      
      //Calculates with user input x
      double formula = (1000 * x + sqrt(abs(3.9 * pow(x, 5) - pow(x, 3) + 1)))
          / (1.6 * pow(x, 2) + 2.7 * x + 3.8);
      System.out.println("Result: " + formula); //Prints result
      
   
      
      
      //Will count from left and right of decimal
      double resultD = formula;
      resultS = Double.toString(resultD);
      decL = resultS.indexOf(".");
      decR = resultS.length() - resultS.indexOf(".") - 1;
      
      //Prints # to left and right of decimal and result
      System.out.println("# of characters to left of decimal point: " + decL);
      System.out.println("# of characters to right of decimal point: " + decR);
      System.out.println("Formatted Result: " + fmt.format(resultD));
   }
      
}

