import java.io.FileNotFoundException;
/*********************************
* program for running the cardholder files program. 
* @author Jacob Howard
*********************************/
public class CardholdersPart3App {
  /*********************************
  * String cardholders information for app.
  * @param args not used
  * @throws FileNotFoundException throws file not found
  *********************************/
   public static void main(String[] args) throws FileNotFoundException {
     /*********************************
     * Strings file name and generates report for it.
     *********************************/
      if (0 < args.length) {
         CardholderProcessor file = new CardholderProcessor();
         try {
            file.readCardholderFile(args[0]);
            System.out.println(file.generateReport());
            System.out.println(file.generateReportByName());
            System.out.println(file.generateReportByCurrentBalance());  
            System.out.println(file.generateInvalidRecordsReport());
         }
         catch (FileNotFoundException e) {
            System.out.println("***Attempted to read file: " + args[0]
                                + " " + "(No such file or directory)");
         }
      }
      
      else {
         System.out.println("File name expected as command line argument.\n"
                   + "Program ending.");
      }
   }
   
}