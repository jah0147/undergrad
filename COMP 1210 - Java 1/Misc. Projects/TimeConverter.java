/**********************************************
* @author Jacob Howard
* Description : This code will cover time from
secconds to days.
**********************************************/
import java.util.Scanner;
/**
*Recieves the imput from the user and will preform 
calculations.
*/
public class TimeConverter {
/**
* This will run and covert user imputs of time.
* @param args (not used).
*/
   public static void main(String[] args) {
      int n = 0;
      
      Scanner userInput = new Scanner(System.in);
      //Aks for time in secconds
      System.out.print("Enter the raw time measurement in seconds: ");
      //Allows user to input seconds
      n = userInput.nextInt();
      if (n < 0) { //Tells the user that numbers cannot be negative
         System.out.println("Measurement must be non-negative!");
      }
      else { //Runs the converter
      //Total raw seconds from user input
         int totalRawSeconds = n;
      //converts days
         int days = n / (24 * 3600);
      //converts hours
         n = n % (24 * 3600);
         int hours = n / 3600;
      //converts minutes
         n %= 3600;
         int minutes = n / 60;
      //converts secconds
         n %= 60;
         int seconds = n;
         System.out.println(""); //Blank line
      //Displays time conversion message
         System.out.println("Measurement by combined days, hours, "
            + "minutes, seconds: ");
         System.out.println("\tdays: " + days);
         System.out.println("\thours: " + hours);
         System.out.println("\tminutes: " + minutes);
         System.out.println("\tseconds: " + seconds);
         System.out.println("");
         System.out.println(totalRawSeconds + " seconds = " + days + " days, "
            + hours + " hours, " + minutes + " minutes, " + seconds 
            + " seconds");
      }
   }
   
}