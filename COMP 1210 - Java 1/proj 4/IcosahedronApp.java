/**
* Creates a simple program to print the shape
* based on the edge's value.
* @author Jacob Howard
*/
import java.util.Scanner;
/**
* Prints class for icosahedron shape.
*/
public class IcosahedronApp {
/**
* Prints appropriate message regarding value entered.
* @param args Command line arguments
*/
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      String label;
      String color;
      double edge;
      double area;
      double volume;
      System.out.print("Enter label, color, and"
         + " edge length for an icosahedron.");
      System.out.println();
      // Print label.
      System.out.print("\tlabel: ");
      label = userInput.nextLine();
      // Print color.
      System.out.print("\tcolor: ");
      color = userInput.nextLine();
      // Print edge.
      System.out.print("\tedge: ");
      edge = userInput.nextDouble();
      if (edge <= 0) {
         System.out.print("Error: edge must be greater than 0.");
         return;
      }
      else {
         Icosahedron userInput1 = new Icosahedron(label, color, edge);
         System.out.println("\n" + userInput1);
      }
   }
}