import java.util.Comparator;
/**************************
* Creates program for comparison of current balance.
* @author Jacob Howard
*********************************/
public class CurrentBalanceComparator implements Comparator<Cardholder> {
  /**************************
  * @return to return integer.
  * @param ch1 for cardholder 1
  * @param ch2 for cardholder 2
  *********************************/
   public int compare(Cardholder ch1, Cardholder ch2) {
      if (ch1.getCurrentBalance() > ch2.getCurrentBalance()) {
         return -1;
      }
      else if (ch2.getCurrentBalance() > ch1.getCurrentBalance()) {
         return 1;
      }
      return 0;
   }
}

