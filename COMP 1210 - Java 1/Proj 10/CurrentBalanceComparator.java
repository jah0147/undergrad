import java.util.Comparator;
/**
* Creates a program for the comparison of the 
* current balance.
* 
* @author Katie Varady
* @version November 16, 2018
* Project 10
*/
public class CurrentBalanceComparator implements Comparator<Cardholder> {
  /**
  * Compares the balances and returns a value.
  * @return to return an integer of -1, 1, or 0 based on the balances compared.
  * @param c1 for cardholder 1
  * @param c2 for cardholder 2
  */
   public int compare(Cardholder c1, Cardholder c2) {
      if (c1.currentBalance() > c2.currentBalance()) {
         return -1;
      }
      else if (c2.currentBalance() > c1.currentBalance()) {
         return 1;
      }
      return 0;
   }
}

