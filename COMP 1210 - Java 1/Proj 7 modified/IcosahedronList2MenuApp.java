import java.io.FileNotFoundException;
import java.util.Scanner;
/**********************************
* @author Jacob Howard 
* Decritpion : System menu for 
Icosahedron app.
**********************************/
public class IcosahedronList2MenuApp {

   /**********************************
    *
    * @param args not used
    * @throws FileNotFoundException in case a file is not found
    **********************************/
   public static void main(String[] args) throws FileNotFoundException {
      
      String listName = "*** no list name assigned ***";
      Icosahedron[] icosArray = new Icosahedron[3];
      IcosahedronList2 iList = new IcosahedronList2(listName, icosArray, 0);
      String fileName = "no file Name";
      
      String userInput = "";
      Scanner scanInput = new Scanner(System.in);
      
      System.out.println("Icosahedron List System Menu\n"
                       + "R - Read File and Create Icosahedron List\n"
                       + "P - Print Icosahedron List\n" 
                       + "S - Print Summary\n"
                       + "A - Add Icosahedron\n"   
                       + "D - Delete Icosahedron\n"   
                       + "F - Find Icosahedron\n"
                       + "E - Edit Icosahedron\n"
                       + "Q - Quit");
      
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         
         String label = "";
         String color = "";
         double edge = 0;
         int index;
         
         userInput = scanInput.nextLine();
         if (userInput.length() == 0) {
            continue;
         }
         userInput = userInput.toUpperCase();
         char userChar = userInput.charAt(0);
         
         
         switch (userChar) {
            case 'R':
               System.out.print("\tFile name: ");
               fileName = scanInput.nextLine();
               
               iList = iList.readFile(fileName);
               System.out.println("\tFile read in and Icosahedron "
                                                   + "List created\n");
               
               break;
               
            case 'P':
               System.out.println(iList.toString());
               break;
               
            case 'S':
               System.out.println("\n" + iList.summaryInfo() + "\n");
               break;
               
            case 'A':
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               System.out.print("\tColor: ");
               color = scanInput.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(scanInput.nextLine());
               
               iList.addIcosahedron(label, color, edge);
               
               System.out.println("\t*** Icosahedron added ***\n");
               break;
               
            case 'D':
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               Icosahedron icos = iList.deleteIcosahedron(label);
               if (icos != null) {
                  
                  System.out.println("\t\"" + icos.getLabel() + "\" deleted\n");
               } else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'F':
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               
               if (iList.findIcosahedron(label) != null) {
                  System.out.println(iList.findIcosahedron(label)
                                                      .toString() + "\n");
               } else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
            
            case 'E':
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               System.out.print("\tColor: ");
               color = scanInput.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(scanInput.nextLine());
               
               if (iList.findIcosahedron(label) != null) {
               
                  if(iList.editIcosahedron(label, color, edge))
                  {
                     System.out.println("\"" + label + "\" successfully edited\n");
                  }
               } else {
                  System.out.println("\"" + label + "\" not found\n");
               }
               break;
               
            case 'Q': case 'q':
               break;
            
            default:
               System.out.println("\t*** invalid code ***\n");
         }
      } while (!userInput.equalsIgnoreCase("Q"));
   }
}