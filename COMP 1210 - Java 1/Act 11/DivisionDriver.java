import javax.swing.JOptionPane;
/*********************
* @author Jacob Howard
* diver for divison file.
*********************/
public class DivisionDriver
{

/*******************
* main arguement.
* @param args not used
*******************/
   public static void main(String[] args)
   {
   
      String numInput
         = JOptionPane.showInputDialog("Enter the numerator:");
      String denomInput
         = JOptionPane.showInputDialog("Enter the denominator:");
      try {
         int num = Integer.parseInt(numInput);
         int denom = Integer.parseInt(denomInput);
      
         String result = "Integer division: \r\n"
            + Division.intDivide(num, denom)
            + "\r\n\r\nFloating point division: \r\n"
            + Division.decimalDivide(num, denom);
      
         JOptionPane.showMessageDialog(null, result,
            "Result", JOptionPane.PLAIN_MESSAGE);
      }
      catch (NumberFormatException errorDetail) {
         JOptionPane.showMessageDialog(null,
               "Invalid input: enter numericalintegervalues only.",
               "Error", JOptionPane.ERROR_MESSAGE);
      }
      catch (IllegalArgumentException errorMessage) {
         JOptionPane.showMessageDialog(null,
               errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
      }
   }



}
