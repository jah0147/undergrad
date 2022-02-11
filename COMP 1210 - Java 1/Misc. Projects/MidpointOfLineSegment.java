/***********************************************************
* @author Jacob Howard
* Description : This code will take
endpoints from the user and calculate the midpoint.
***********************************************************/
import java.util.Scanner;
/**
*Recieves the imput from the user and will preform 
calculations.
*/
public class MidpointOfLineSegment {
/**
* This code will run and calculate the midpoint of a line.
* It takes user imputs and calculates them
* @param args (not used).
*/
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      double x1 = 0;
      double y1 = 0;
      double x2 = 0;
      double y2 = 0;
      double midpointX = 0;
      double midpointY = 0;
      //Asks to enter midpoints
      System.out.println("Enter the coordinates for endpoint 1: ");
      //Asks for x1
      System.out.print("\tx1 = ");
      x1 = userInput.nextDouble();
      //Asks for y1
      System.out.print("\ty1 = ");
      y1 = userInput.nextDouble();
      //Asks for coordinates for endpoint 2
      System.out.println("Enter the coordinates for endpoint 2: ");
      //Asks for x2
      System.out.print("\tx2 = ");
      x2 = userInput.nextDouble();
      //Asks for y2
      System.out.print("\ty2 = ");
      y2 = userInput.nextDouble();
      //calculates midpoints
      midpointX = (x1 + x2) / 2;
      midpointY = (y1 + y2) / 2;
      //Tells user imputs and displays midpoint calculation
      System.out.print("For endpoints (" + x1 + ", " + y1
         + ") and (" + x2 + ", " + y2 + "), the midpoint is "
         + "(" + midpointX + ", " + midpointY + ")."); 
   }
}
