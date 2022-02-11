/************************************
* @author Jacob Howard
* Description : List for Icosahedreon
file and Icosahedron app file.
************************************/
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/*********************************
* Class for Icosahedron list.
*********************************/
public class IcosahedronList {

//Fields (instance Variables)
   private String listName;
   private ArrayList<Icosahedron> iList;
   
   //Constructor
   /*********************************
   * public list for strings.
   * @param listNameIn for list
   * @param iListIn for iList
   *********************************/
   public IcosahedronList(String listNameIn, ArrayList<Icosahedron> iListIn) {
      listName = listNameIn;
      iList = iListIn;
   }
   
   //Methods
   /********************************
   * Method of Strings to call strings.
   * @return to return listName
   ********************************/
   public String getName() { //Returns list
      return listName;
   }
   /******************************
   * To return int for number of Icosa.
   * @return to return number
   *******************************/
   public int numberOfIcosahedrons() { //Returns number of icosahedrons in list
      return iList.size();
   }
   /*********************************
   * String to return total surface area.
   * @return to return total
   *********************************/
   public double totalSurfaceArea() { //Returns total surface area
      double total = 0;
      int index = 0;
      while (index < iList.size()) {
         total += iList.get(index).surfaceArea();
         index++;
      }
      return total;
   }
   /************************
   * String to return total valume.
   * @return to return total
   ************************/
   public double totalVolume() { //Returns total volume
      double total = 0;
      int index = 0;
      while (index < iList.size()) {
         total += iList.get(index).volume();
         index++;
      }
      return total;
   }
   /***************************
   * String to return av surface area.
   * @return to return total
   ***************************/
   public double averageSurfaceArea() { //returns average surface area
      double total = 0;
      int index = 0;
      while (index < iList.size()) {
         total += (iList.get(index).surfaceArea()) / iList.size();
         index++;
      }
      return total;
   }
   /***************************
   * String to return av volume.
   * @return to return total
   ***************************/
   public double averageVolume() { //returns average volume
      double total = 0;
      int index = 0;
      while (index < iList.size()) {
         total += (iList.get(index).volume()) / iList.size();
         index++;
      }
      return total;
   }
   /***************************
   * String to return av surface area.
   * @return to return total
   ***************************/
   public double averageSurfaceToVolumeRatio() { 
      double total = 0;
      int index = 0;
      while (index < iList.size()) {
         total += iList.get(index).surfaceToVolumeRatio() / iList.size();
         index++;
      }
      return total;
   }
   
   /***************************
   * String to return String.
   * @return to return result
   ***************************/
   public String toString() {
      String result = listName + "\n";
      int index = 0;
      while (index < iList.size()) {
         result += "\n" + iList.get(index).toString() + "\n";
         index++;
      }
      return result;
   }
   
   /*********************************
   @return returns summary of array
   *********************************/
   public String summaryInfo() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      return "----- Summary for " + listName + " -----\n"
            + "Number of Icosahedrons: " + iList.size() + "\n"
            + "Total Surface Area: " + fmt.format(totalSurfaceArea()) + "\n"
            + "Total Volume: " + fmt.format(totalVolume()) + "\n"
            + "Average Surface Area: " + fmt.format(averageSurfaceArea()) + "\n"
            + "Average Volume: " + fmt.format(averageVolume()) + "\n" 
            + "Average Surface/Volume Ratio: "
            + fmt.format(averageSurfaceToVolumeRatio());
   }
   
//-------------------------//
   // Project 6 below
   //---------------------//

   /**
    *
    * @return returns the Icosahedron list
    */
   public ArrayList<Icosahedron> getList() {
      return iList;
   }

   /**
    *
    * @param fileNameIn takes a file name in to look for
    * @return returns the list generated from the file
    * @throws FileNotFoundException incase the file is not found
    */
   public IcosahedronList readFile(String fileNameIn) throws 
      FileNotFoundException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      ArrayList<Icosahedron> iList2 = new ArrayList<Icosahedron>();
      String iListName = "";
      String label = "";
      String color = "";
      double edge = 0;
      
      iListName = scanFile.nextLine();
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
         
         Icosahedron i = new Icosahedron(label, color, edge);
         iList.add(i);
      }
      
      IcosahedronList icosaList = new IcosahedronList(iListName,
                                                          iList);
      return icosaList;
   }

   /******************************************************
    *
    * @param labelIn takes input for label in constructor.
    * @param colorIn takes input for color in constructor.
    * @param edgeIn takes input for the edge in constructor.
    ******************************************************/
   public void addIcosahedron(String labelIn, String colorIn, double edgeIn) {
      Icosahedron i = new Icosahedron(labelIn, colorIn, edgeIn);
      iList.add(i);
   }

   /**
    *
    * @param labelIn takes the label to find in the arraylist
    * @return returns the object found in the arraylist
    */
   public Icosahedron findIcosahedron(String labelIn) {
      for (Icosahedron i : iList) {
         if (i.getLabel().equalsIgnoreCase(labelIn)) {
            return i;
         }
      }
      return null;
   }

   /**
    *
    * @param labelIn takes the label to delete from the arraylist
    * @return returns the object deleted
    */
   public Icosahedron deleteIcosahedron(String labelIn) {
      int index = iList.indexOf(findIcosahedron(labelIn));
      
      if (index >= 0) {
         return iList.remove(index);
      } else {
         return null;
      }
   }

   /*********************************************
    *
    *
    * @param labelIn takes input for label to find in arraylist.
    * @param colorIn takes input for color in constructor.
    * @param edgeIn takes input for the edge in constructor.
    * @return returns if the edit was successful
    ********************************************/
   public boolean editIcosahedron(String labelIn, String colorIn, 
                                                   double edgeIn) {
      boolean result = false;
      for (Icosahedron i : iList) {
         if (i.getLabel().equals(labelIn)) {
            i.setColor(colorIn);
            i.setEdge(edgeIn);
            result = true;
            break;
         }
      }
      return result;
   }
}