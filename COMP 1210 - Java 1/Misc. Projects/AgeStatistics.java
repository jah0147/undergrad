/*********************************
* @author Jacob Howard
* Description : This code will ask
  for user name and age and display
  information.
*********************************/
import java.util.Scanner;
/**
*Recieves the imput from the user and will preform 
calculations.
*/
public class AgeStatistics {
 /**
* This will run and and ask the user questions
and siplay information about them.
* @param args (not used).
*/
   public static void main(String[] args) {
   /**
   *Lets the user imput their name, age, and gender
   so the code can preform calculations
   */
      Scanner userImput = new Scanner(System.in);
      String name = "";
      int ageInYears = 0;
      int gender = 0;
      double maxHeartRate = 0;
      //Promts the user for their name:
      System.out.print("Enter your name: ");
      name = userImput.nextLine();
      //Prompts the user for their age:
      System.out.print("Enter your age in years: ");
      ageInYears = userImput.nextInt();
      //Promts the user for their gender
      System.out.print("Enter your gender (1 for female and 0 for male): ");
      gender = userImput.nextInt();
      //Coverts age in minutes:
      System.out.println("\tYour age in minutes is "
         + ageInYears * 525600 + " minutes.");
      //Coverts age in centures:
      System.out.println("\tYour age in centuries is "
         + (double) ageInYears / 100 + " centuries.");
      //display max heart rate
      System.out.print("\tYour max heart rate is ");
      if (gender == 1) { //calculates female MHR on the next line
         maxHeartRate = 209 - (0.7 * ageInYears);
         System.out.println(maxHeartRate + " beats per minute.");
      }
      else { //calculates male MHR on the next line
         maxHeartRate = 214 - (0.8 * ageInYears);
         System.out.println(maxHeartRate + " beats per minute.");
       
      }
   }
}