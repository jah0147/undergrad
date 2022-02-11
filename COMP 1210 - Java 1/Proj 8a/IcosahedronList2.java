/************************************
* @author Jacob Howard
* Description : List for Icosahedreon
file and Icosahedron app file.
************************************/
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/*********************************
* Class for Icosahedron list.
*********************************/
public class IcosahedronList2 {

//Fields (instance Variables)
   private String listName;
   private Icosahedron[] iList;
   private int arrSize = 0;
   
   //Constructor
   /*********************************
   * public list for strings.
   * @param listNameIn for list
   * @param iListIn for iList
   * @param arrSizeIn for array size
   *********************************/
   public IcosahedronList2(String listNameIn, Icosahedron[] iListIn, 
      int arrSizeIn) {
      listName = listNameIn;
      iList = iListIn;
      arrSize = arrSizeIn;
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
      for (int i = 0; i < arrSize; i++) {
         if (iList[i] == null) {
            arrSize--;
         }
      }
      return arrSize;
   }
   /*********************************
   * String to return total surface area.
   * @return to return total
   *********************************/
   public double totalSurfaceArea() { //Returns total surface area
      double total = 0;
      for (int i = 0; i < arrSize; i++) {
         total += iList[i].surfaceArea();
      }
      return total;
   }
   /************************
   * String to return total valume.
   * @return to return total
   ************************/
   public double totalVolume() { //Returns total volume
      double total = 0;
      for (int i = 0; i < arrSize; i++) {
         total += iList[i].volume();
      }
      return total;
   }
   /***************************
   * String to return av surface area.
   * @return to return total
   ***************************/
   public double averageSurfaceArea() { //returns average surface area
      double total = 0;
      for (int i = 0; i < arrSize; i++) {
         total += (iList[i].surfaceArea()) / arrSize;
      }
      return total;
   }
   /***************************
   * String to return av volume.
   * @return to return total
   ***************************/
   public double averageVolume() { //returns average volume
      double total = 0;
      for (int i = 0; i < arrSize; i++) {
         total += (iList[i].volume()) / arrSize;
      }
      return total;
   }
   /***************************
   * String to return av surface area.
   * @return to return total
   ***************************/
   public double averageSurfaceToVolumeRatio() { 
      double total = 0;
      for (int i = 0; i < arrSize; i++) {
         total += iList[i].surfaceToVolumeRatio() 
                                          / arrSize;
      }
      return total;
   }
   
   /***************************
   * String to return String.
   * @return to return result
   ***************************/
   public String toString() {
      String result = listName + "\n";
      for (int i = 0; i < arrSize; i++) {
         result += "\n" + iList[i].toString() + "\n";
      }
      return result;
   }
   
   /*********************************
   @return returns summary of array
   *********************************/
   public String summaryInfo() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      return "----- Summary for " + listName + " -----\n"
            + "Number of Icosahedrons: " + iList.length + "\n"
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
   public Icosahedron[] getList() {
      return iList;
   }

   /**
    *
    * @param fileNameIn takes a file name in to look for
    * @return returns the list generated from the file
    * @throws FileNotFoundException incase the file is not found
    */
   public IcosahedronList2 readFile(String fileNameIn) throws 
      FileNotFoundException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
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
         iList[arrSize] = i;
         arrSize++;
      }
      
      IcosahedronList2 icosaList = new IcosahedronList2(iListName,
                                                          iList, arrSize);
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
      iList[arrSize] = i;
      arrSize++;
   }

   /**
    *
    * @param labelIn takes the label to find in the arraylist
    * @return returns the object found in the arraylist
    */
   public Icosahedron findIcosahedron(String labelIn) {
      numberOfIcosahedrons();
      
      if (arrSize > 0) {
      
         for (int i = 0; i < arrSize; i++) {
            if (iList[i].getLabel().equalsIgnoreCase(labelIn)) {
               return iList[i];
            }
         }
         return null;
         
      } else {
         return null;
      }
   }

   /**
    *
    * @param labelIn takes the label to delete from the arraylist
    * @return returns the object deleted
    */
   public Icosahedron deleteIcosahedron(String labelIn) {
      Icosahedron[] iCopy = new Icosahedron[1];
      for (int i = 0; i < arrSize; i++) {
         if (iList[i].getLabel().equals(labelIn)) {
            iCopy[0] = findIcosahedron(labelIn);
            for (int j = i; j < arrSize - 1; j++) {
               iList[j] = iList[j + 1];
            }
            iList[arrSize - 1] = null;
            arrSize--;
         }
      }
      return iCopy[0];
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
      //Icosahedron icos= new Icosahedron();
      // // for (Icosahedron i : iList) {
      if (findIcosahedron(labelIn) != null) {
         findIcosahedron(labelIn).setColor(colorIn);
         findIcosahedron(labelIn).setEdge(edgeIn);
         result = true;
            //break;
      }
      
      return result;
   }


/***************** Proj added in ****************/

   /****************************************************
    *
    * @return returns the object with the shortest edge
    ***************************************************/
   public Icosahedron findIcosahedronWithShortestEdge() {
      Icosahedron[] iTest = new Icosahedron[1];
      iTest[0] = iList[0];
      for (int i = 0; i < arrSize; i++) {
         if (iList[i].getEdge() < iTest[0].getEdge()) {
            iTest[0] = iList[i];
         }
      }
      return iTest[0];
   }

   /**************************************************
    *
    * @return returns the object with the longest edge
    *************************************************/
   public Icosahedron findIcosahedronWithLongestEdge() {
      Icosahedron[] iTest = new Icosahedron[1];
      iTest[0] = iList[0];
      for (int i = 0; i < arrSize; i++) {
         if (iList[i].getEdge() > iTest[0].getEdge()) {
            iTest[0] = iList[i];
         }
      }
      return iTest[0];
   }

   /*****************************************************
    *
    * @return returns the object with the smallest volume
    ****************************************************/
   public Icosahedron findIcosahedronWithSmallestVolume() {
      Icosahedron[] iTest = new Icosahedron[1];
      iTest[0] = iList[0];
      for (int i = 0; i < arrSize; i++) {
         if (iList[i].volume() < iTest[0].volume()) {
            iTest[0] = iList[i];
         }
      }
      return iTest[0];
   }

   /****************************************************
    *
    * @return returns the object with the largest volume
    ****************************************************/
   public Icosahedron findIcosahedronWithLargestVolume() {
      Icosahedron[] iTest = new Icosahedron[1];
      iTest[0] = iList[0];
      for (int i = 0; i < arrSize; i++) {
         if (iList[i].volume() > iTest[0].volume()) {
            iTest[0] = iList[i];
         }
      }
      return iTest[0];
   }

}