import java.util.Scanner;
import java.util.ArrayList;

/**
 * Demonstrates the NumberOperations class.
 * @author Jacob Howard
 */
public class NumberOpsDriver {

   /**
    * Reads a set of positive numbers from the user until the user enters 0.
	 * Prints odds under and powers of 2 under for each number.
	 *
    * @param args - Standard commandline arguments
    */
   public static void main(String[] args) {
   	
      Scanner in = new Scanner(System.in);
      
      // declare and instantiate ArrayList with generic type <NumberOperations>
      ArrayList<NumberOperations> numOpsList 
            = new ArrayList<NumberOperations>();
      
      // prompt user for set of numbers
      System.out.println("Enter a list of positive integers separated "
                        + "with a space followed by 0:");
      
      
   // get first user input using in.nextInt()
      int x = in.nextInt();
      
      // add a while loop as described below: 
   	     // while the input is not equal to 0 
          // add a new NumberOperations object to numOpsList based on user input
         // get the next user input using in.nextInt()
      while (x != 0) {
         NumberOperations numOps = new NumberOperations(x);
         numOpsList.add(numOps);
         x = in.nextInt();
      }
     
      
      int index = 0;
      while (index < numOpsList.size()) {
         NumberOperations num = numOpsList.get(index);
         System.out.println("For: " + num);
      	// add print statement for odds under num and powers of 2 under
         System.out.println("\tOdds under:" + "\t" + num.oddsUnder()
            + "\n\tPowers of 2 under:" + "\t" + num.powersTwoUnder());
            
         index++;
      }
   }
}