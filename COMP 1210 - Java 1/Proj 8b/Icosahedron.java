import java.text.DecimalFormat;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
/**
* Creates a simple program to display an icosahedron shape based on 
* labels, color, edges, volume, surface area and ratios.
* 
* @author Jacob Howard
*/
public class Icosahedron {
/**
* Stores the label, color, and edge length of the shape.
* @param args Command line arguments
*/
   private double edge;
   private String label = "";
   private String color = "";
   private static int count = 0;
   /**
   //Assign the strings.
   //constructor
   * @param edgeIn the edge
   * @param labelIn the label
   * @param colorIn the color
   */
   public Icosahedron(String labelIn, String colorIn, double edgeIn) {
   
      setLabel(labelIn);
      setColor(colorIn);
      setEdge(edgeIn);
      count++;
   }
 
   //methods
   /**
   * @return label of Icosahedron object
   */
   public String getLabel() {
      return label;
   }
   /**
   //Boolean to see if it will work or not.
   // @return used to return label
   // @param labelIn the label
   */
   public boolean setLabel(String labelIn) {
      if (labelIn != null) {
         label = labelIn.trim();
         return true;
      }
      else {
         return false;
      }
   }
    /**
    * @return color.
    */
   public String getColor() {
   
      return color;
   }
   /**
   //Boolean to see if it will work or not.
   // @return used to return color
   // @param colorIn the color
   */
   public boolean setColor(String colorIn) {
      if (colorIn != null) {
         color = colorIn.trim();
         return true;
      }
      else {
         return false;
      }
   }
    /**
    * @param edgeIn the edge.
    * @return edgeIn the edge.
    */
    /**
   * Get the edge.
   * @return the edge
   */
   public double getEdge() {
      return edge;
   }
   /**
   * Creates a boolean statement for true and false statement.
   * @param edgeIn the edge.
   * @return edgeIn
   */
   public boolean setEdge(double edgeIn) {
   
      if (edgeIn > 0) {
         edge = edgeIn;
         return true;
      }
      else {
         return false;
      }
   }
   
   
   ///////////////////////////////////////////
   //New for project 08A
   /**
   * Get the count.
   * @return to return the count
   */
   public static int getCount() {
      return count;
   }
   /**
   * Reset the count.
   */
   public static void resetCount() {
      count = 0;
   }
   /**
   * Equals method for type of object.
   * @param obj the object
   * @return to return false or information
   */
   public boolean equals(Object obj) {
      if (!(obj instanceof Icosahedron)) {
         return false;
      }
      else {
         Icosahedron d = (Icosahedron) obj;
         return (label.equalsIgnoreCase(d.getLabel())
                  && color.equalsIgnoreCase(d.getColor())
                  && Math.abs(edge - d.getEdge()) < .000001);
      }
   }
   /**
   * Creates a hash code for the equals method.
   * @return to return 0
   */
   public int hashCode() {
      return 0;
   }
   ///////////////////////////////////////////
   
   
   
   /**
   //Calculate the volume from the formula.
   // @return used to return volume
   */
   public double volume() {
      double volume = (((5 * (3 + (sqrt(5)))) / 12) * (pow(edge, 3)));
      return volume;
   }
    /**
    //Calculate the area from the formula.
    // @return used to return area
    */
   public double surfaceArea() {
      double surfaceArea = (5 * ((sqrt(3)) * (pow(edge, 2))));
      return surfaceArea;
   }
    /**.
    //Calculate the surface to volume ratio
    // @return used to return formula
    */
   public double surfaceToVolumeRatio() {
      double formula = surfaceArea() / volume();
      return formula;
   }
   /**
   // @return info for the string.
   */
   public String toString() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0#####");
      String output = "Icosahedron \"" + label + "\" is \""
         + color + "\" with 30 edges of length " + edge + " units.";
      output += "\n\tsurface area = " + fmt.format(surfaceArea()) 
         + " square units";
      output += "\n\tvolume = " + fmt.format(volume()) + " cubic units";
      output += "\n\tsurface/volume ratio = " 
         + fmt.format(surfaceToVolumeRatio());
      return output;
   }
}