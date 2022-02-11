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
   
   //added
   private static int count = 0;
   
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
      count++;
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
   public boolean setLabel(String labelIn)
   {
      if (labelIn == null)
      {
         return false;
      }
      else
      {
         label = labelIn.trim();
         return true;
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
      if (colorIn == null) {
         return false;
      }
      else {
         color = colorIn.trim();
         return true;
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
   
      if (edgeIn > 0) {
         edge = edgeIn;
         return true;
      }
      else {
         return true;
      }
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
      DecimalFormat df = new DecimalFormat("#,##0.0#####");
      String aF;
      String vF;
      String sVF;
      aF = df.format(surfaceArea());
      vF = df.format(volume());
      sVF = df.format(surfaceToVolumeRatio());
      String output = "Icosahedron \"" + label + "\" is \""
         + color + "\" with 30 edges of length " + edge + " units.\n"
         + "\tsurface area = " + aF + " square units\n\tvolume = " + vF 
         + " cubic units\n\tsurface/volume ratio = " + sVF;
      
      return output;
   }
   
   //added
    /**
   * This method gets the static field count.
   * @return int representing count.
   */
   public static int getCount()
   {
      return count;
   }
   
   //added
    /**
    * Resets count.
    */
   public static void resetCount() {
      count = 0;
   }

   /**
    *
    * @param obj input for an object
    * @return if he object is equal
    */
   public boolean equals(Object obj) {
      if (!(obj instanceof Icosahedron)) {
         return false;
      } else {
         Icosahedron d = (Icosahedron) obj;
         return (label.equalsIgnoreCase(d.getLabel())
                  && color.equalsIgnoreCase(d.getColor())
                  && Math.abs(edge - d.getEdge()) < .000001);
      }
   }

   /**
    *
    * @return returns 0
    */
   public int hashCode() {
      return 0;
   }
}