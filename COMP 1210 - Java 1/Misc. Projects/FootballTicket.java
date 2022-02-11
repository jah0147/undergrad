import java.util.Scanner;
import java.text.DecimalFormat;


/********************************
 * @author Jacob Howard
 * Description : This code will
 ask for user ticket information
 and siplay information about
 ticket code.
 *******************************/
public class FootballTicket {

   static final double STUDENT_DISCOUNT = .67;
   static final double STAFF_DISCOUNT = .20;
  /**
   * Accepts coded ticket information to football game
   and displays information.
   * @param args Command line arguments (not used).
   */
   public static void main(String[] args) {
   
      Scanner userInput = new Scanner(System.in);
      DecimalFormat fmt1 = new DecimalFormat("$#,##0.00;($#,##0.00)");
      DecimalFormat fmt2 = new DecimalFormat("0000");
      String ticketCode;
      char category;
      String priceS;
      double priceD;
      double cost;
      int prizeNumber = (int) (Math.random() * 999999) + 1;
      
     //prompt user for their ticket code
      System.out.print("Enter your ticket code: ");
      ticketCode = userInput.nextLine();   
      
      if (ticketCode.length() < 25) { // invalid code
         System.out.println("");
         System.out.println("Invalid Ticket Code.");
         System.out.println("Ticket code must have at least 25 characters.");
      }
      else { // valid code
         //get ticket info
         ticketCode = ticketCode.trim();
         category = ticketCode.charAt(0);
         priceS = ticketCode.substring(1, 4);
         priceD = Double.parseDouble(priceS);
         if (category == 's') {
            cost = priceD - priceD * STUDENT_DISCOUNT;
         }
         else if (category == 'f') {
            cost = priceD - priceD * STAFF_DISCOUNT;
         }
         else {
            cost = priceD;
         }
                  
         //display info
         System.out.println("");
         System.out.println("Game: " + ticketCode.substring(24)
            + "   Date: " + ticketCode.substring(10, 12)
            + "/" + ticketCode.substring(12, 14)
            + "/" + ticketCode.substring(14, 18)
            + "   Time: " + ticketCode.substring(6, 8)
            + ":" + ticketCode.substring(8, 10));
         System.out.println("Section: "
            + Integer.parseInt(ticketCode.substring(22, 24))
            + "   Row: " 
            + ticketCode.substring(20, 22)
            + "   Seat: " + ticketCode.substring(18, 20));
            
            
         System.out.println("Price: " + fmt1.format(priceD)
            + "   Category: " + ticketCode.charAt(0) 
            + "   Cost: " + fmt1.format(cost));         
         System.out.println("Prize Number: " + fmt2.format(prizeNumber));
      }
   }
}

