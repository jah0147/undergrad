import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
/***************************************
* @author Jacob Howard
* Description : card holder processor
***************************************/
public class CardholderProcessor {
   
   private Cardholder[] Cardholders;
   private String[] InvalidRecords;
   
   //Constructor
   public CardholderProcessor() {
      Cardholders = new Cardholder[0];
      InvalidRecords = new String[0];
   }
   
   
   //Methods
   public Cardholder[] getCardholdersArray() {
      return Cardholders;
   }
   
   public String[] getInvalidRecordsArray() {
      return InvalidRecords;
   }
   
   public void addCardholder(Cardholder CardholderIn) {
      Cardholders = Arrays.copyOf(Cardholders, Cardholders.length +1);
      Cardholders[Cardholders.length - 1] = CardholderIn;
   }
   
   
   public void addInvalidRecord(String s) {
      InvalidRecords = Arrays.copyOf(InvalidRecords, InvalidRecords.length +1);
      InvalidRecords[InvalidRecords.length - 1] = s;
   }
   
   //reads cardholder files 
   public void readCardholderFile(String fileNameIn)
                                                throws FileNotFoundException {  
      Scanner fileScan = new Scanner(new File(fileNameIn));
      while (fileScan.hasNext()) {
         String line = fileScan.nextLine();
         Scanner readLine = new Scanner(line);
         readLine.useDelimiter(";");
         try {
            char category = readLine.next().charAt(0);
            
            switch (category) {
            
               case '1': 
                  {
                     String acctNumber = readLine.next();
                     String name = readLine.next();
                     SapphireCardholder sc = 
                                       new SapphireCardholder(acctNumber, name);
                     sc.setPrevBalance(Double.parseDouble(readLine.next()));
                     sc.setPayment(Double.parseDouble(readLine.next()));
                     while (readLine.hasNext()) {
                        sc.addPurchases(Double.parseDouble(readLine.next()));
                     }
                     addCardholder(sc);
                     break;
                  }
               
               case '2': 
                  {
                     String acctNumber = readLine.next();
                     String name = readLine.next();
                     DiamondCardholder dc = 
                                    new DiamondCardholder(acctNumber, name);
                     dc.setPrevBalance(Double.parseDouble(readLine.next()));
                     dc.setPayment(Double.parseDouble(readLine.next()));
                     while (readLine.hasNext()) {
                        dc.addPurchases(Double.parseDouble(readLine.next()));
                     }
                     addCardholder(dc);
                     break;
                  }
               
               case '3': 
                  {
                     String acctNumber = readLine.next();
                     String name = readLine.next();
                     BlueDiamondCardholder bd = 
                                  new BlueDiamondCardholder(acctNumber, name);
                     bd.setPrevBalance(Double.parseDouble(readLine.next()));
                     bd.setPayment(Double.parseDouble(readLine.next()));
                     while (readLine.hasNext()) {
                        bd.addPurchases(Double.parseDouble(readLine.next()));
                     }
                     addCardholder(bd);
                     break;
                  }
               
        
         catch (NumberFormatException ex) {
            ex = new NumberFormatException("*** invalid numeric value ***");
            String exception = line + " " + ex.getMessage();
            addInvalidRecord(exception);
         }
      }
   }
   
 /**
* @return to return the report
*/
   public String generateReport() {
      String report = "";
   
      for (Cardholder card : cardholders) {
         report += "\n" + card.toString() + "\n";
      }
      return "----------------------------\n" 
         + "Monthly Cardholder Report\n"
         + "----------------------------"
         + report;
   }
/**
* @return to return the report by name
*/
   public String generateReportByName() {
      Arrays.sort(cardholders);
      String report = "";
   
      for (Cardholder card : cardholders) {
         report += "\n" + card.toString() + "\n";
      }
      return "--------------------------------------\n" 
         + "Monthly Cardholder Report (by Name)\n"
         + "--------------------------------------"
         + report;
   }
/**
* @return to return the report for the current balance
*/
   public String generateReportByCurrentBalance() {
      Arrays.sort(cardholders, new CurrentBalanceComparator());
      String report = "";
   
      for (Cardholder card : cardholders) {
         report += "\n" + card.toString() + "\n";
      }
      return "---------------------------------------\n" 
         + "Monthly Cardholder Report (by Current Balance)\n"
         + "---------------------------------------"
         + report;
   }
   /**
   * @return to return report
   */
   public String generateInvalidRecordsReport() {
      String report = "";
   
      for (String record : InvalidRecords) {
         report += "\n" + record + "\n";
      }
      return "-----------------------\n" 
         + "Invalid Records Report\n"
         + "-----------------------"
         + report;
   }
}