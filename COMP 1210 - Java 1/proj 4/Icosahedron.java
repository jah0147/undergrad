import java.text.DecimalFormat;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
/**
* Creates a program to display labels, color, edges, volume, 
surface area and ratios.
* @author Jacob Howard
*/
public class Icosahedron {
/**
* Stores the label, color, and edge length of the shape.
* @param args Command line arguments not used
*/
   private double edge;
   private String label = "";
   private String color = "";
   /**
   * Assign strings.
   * constructor
   * @param edgeIn the edge
   * @param labelIn the label
   * @param colorIn the color
   */
   public Icosahedron(String labelIn, String colorIn, double edgeIn) {
   
      setLabel(labelIn);
      setColor(colorIn);
      setEdge(edgeIn);
   }
   //methods
   /**
   * @return label of the Icosahedron object
   */
   public String getLabel() {
      return label;
   }
   /**
   * Boolean.
   * @return used to return label
   * @param labelIn the label
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
   * Boolean.
   *  @return used return color
   * @param colorIn color
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
    * @return edgeIn edge.
   * Get the edge.
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
   
      if (edgeIn < 0) {
         return false;
      }
      edge = edgeIn;
      return true;
   }
   /**
   * Calculate volume from formula.
   * @return used to return volume
   */
   public double volume() {
      double volume = (((5 * (3 + (sqrt(5)))) / 12) * (pow(edge, 3)));
      return volume;
   }
    /**
    * Calculate area from formula.
    * @return used to return the area
    */
   public double surfaceArea() {
      double surfaceArea = (5 * ((sqrt(3)) * (pow(edge, 2))));
      return surfaceArea;
   }
    /**.
    * Calculate the surface to volume ratio
    * @return used to return formula
    */
   public double surfaceToVolumeRatio() {
      double formula = surfaceArea() / volume();
      return formula;
   }
   /**
   * @return info for the string.
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