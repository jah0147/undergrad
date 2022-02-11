/******************************************
* @author Jacob Howard
* Descritpion : 
******************************************/
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*********************************
* Class where the app will run.
*********************************/
public class IcosahedronListApp {

/***********************
* Main method for app.
* @param args (not used)
* @throws IOException
 to throw IO.
***********************/
   public static void main(String[] args) throws IOException {
      
      ArrayList<Icosahedron> iList = new ArrayList<Icosahedron>();
      
      //Variables
      String listName = "";
      String label = "";
      String color = "";
      double edge;
      
      Scanner scan = new Scanner(System.in);
      
      //Ask user for file name
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
      System.out.println();  
      Scanner scanFile = new Scanner(new File(fileName));
      listName = scanFile.nextLine();
      
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
         
         Icosahedron i = new Icosahedron(label, color, edge);
         iList.add(i);
      }
      
      IcosahedronList myList = new IcosahedronList(listName, iList);
      
      System.out.println(myList.toString());
      System.out.println(myList.summaryInfo());
   
   }
}