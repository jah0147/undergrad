import java.util.Arrays;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
/*********************************************
* @author Jacob Howard
* Description : Processor for cardholder.
**********************************************/
public class CardholderProcessor {
   
   private Cardholder[] ch;
   private String[] invalidRecords;
   
   /**
   * Constructor.
   */
   public CardholderProcessor() {
      ch = new Cardholder[0];
      invalidRecords = new String[0];
   }
   
   /**
    * Methods.
    * @return to return
    */
   public Cardholder[] getchArray() {
      return ch;
   }
   
   /**
   * @return to return
   */
   public String[] getinvalidRecordsArray() {
      return invalidRecords;
   }
   
   /**
   * @param chIn for initial ch
   */
   public void addCardholder(Cardholder chIn) {
      ch = Arrays.copyOf(ch, ch.length + 1);
      ch[ch.length - 1] = chIn;
   }
   
   /**
   * @param invalidRecordsIn for invalidRecordsIn
   */
   public void addInvalidRecord(String invalidRecordsIn) {
      invalidRecords = Arrays.copyOf(invalidRecords, invalidRecords.length + 1);
      invalidRecords [invalidRecords.length - 1] = invalidRecordsIn;
   }
   
/************************************************
* reads file.
* @param fileNameIn for file name.
* @throws FileNotFoundException for file not found
*************************************************/
   public void readCardholderFile(String fileNameIn)
                                                throws FileNotFoundException {
   
      Scanner fileScan = new Scanner(new File(fileNameIn));
      while (fileScan.hasNext()) {
         String line = fileScan.nextLine();
         Scanner readLine = new Scanner(line);
         readLine.useDelimiter(";");
         try {
            char category = line.charAt(0);
            
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
               
               default: 
                  {
                     throw new InvalidCategoryException();
                  }
            }
         }
         catch (InvalidCategoryException ex) {
            String exception = line + " " + ex.getMessage();
            addInvalidRecord(exception);
            
         }
         catch (NumberFormatException ex) {
            ex = new NumberFormatException("*** invalid numeric value ***");
            String exception = line + " " + ex.getMessage();
            addInvalidRecord(exception);
         }
      }
   }
/*********************************
* @return to return the report
*********************************/
   public String generateReport() {
      String report = "";
   
      for (Cardholder card : ch) {
         report += "\n" + card.toString() + "\n";
      }
      return "----------------------------\n" 
         + "Monthly Cardholder Report\n"
         + "----------------------------"
         + report;
   }
/*********************************
* @return to return the report by name
*********************************/
   public String generateReportByName() {
      Arrays.sort(ch);
      String report = "";
   
      for (Cardholder card : ch) {
         report += "\n" + card.toString() + "\n";
      }
      return "--------------------------------------\n" 
         + "Monthly Cardholder Report (by Name)\n"
         + "--------------------------------------"
         + report;
   }
/*********************************
* @return to return the report for the current balance
*********************************/
   public String generateReportByCurrentBalance() {
      Arrays.sort(ch, new CurrentBalanceComparator());
      String report = "";
   
      for (Cardholder card : ch) {
         report += "\n" + card.toString() + "\n";
      }
      return "---------------------------------------\n" 
         + "Monthly Cardholder Report (by Current Balance)\n"
         + "---------------------------------------"
         + report;
   }
   /*********************************
   * @return to return the report
   *********************************/
   public String generateInvalidRecordsReport() {
      String report = "";
   
      for (String record : invalidRecords) {
         report += "\n" + record + "\n";
      }
      return "-----------------------\n" 
         + "Invalid Records Report\n"
         + "-----------------------"
         + report;
   }
}