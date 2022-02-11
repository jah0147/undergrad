import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
  *Lists properties of icosahedron.
  *
  *@author Jacob Howard
  *@version 11-2-2018
  */
public class IcosahedronList2 {
   // Fields
   private String name = "";
   private Icosahedron[] icosList = new Icosahedron[100];
   private int numOfIcos = 0;
   
   // Constructor 
   /**
     *Constructs IcosahedronList for use.
     *
     *@param nameIn assigns name.
     *@param icosListIn assigns array.
     *@param numOfIcosIn assigns the number of icos.
     */
   public IcosahedronList2(String nameIn, 
               Icosahedron[] icosListIn, int numOfIcosIn) {
      name = nameIn;
      icosList = icosListIn;
      numOfIcos = numOfIcosIn;
   }
   
   // Methods 
   /**
     *Returns the name of icosahedron.
     *
     *@return name of icosahedron.
     */
   public String getName() {
      return name;
   }
   
   /**
     *Returns the number of icosahedron.
     *
     *@return number of icosahedron.
     */
   public int numberOfIcosahedrons() {
      return numOfIcos;
   }
   
   /**
     *Returns the surface area of the icosahedron.
     *
     *@return the surface area.
     */
   public double totalSurfaceArea() {
      double tSA = 0;
      int sA = 0;
      while (sA < numOfIcos) {
         tSA += icosList[sA].surfaceArea();
         sA++;
      }
      return tSA;
   }
   
   /**
     *Returns the total volume.
     *
     *@return volume
     */
   public double totalVolume() {
      double tV = 0;
      int v = 0;
      while (v < numOfIcos) {
         tV += icosList[v].volume();
         v++;
      }
      return tV;
   }
   
   /**
     *Returns the average average surface of all icosahedron listed.
     *
     *@return average surface area.
     */
   public double averageSurfaceArea() {
      double aSA = 0;
      if (numOfIcos != 0) {
         int sA = 0;
         while (sA < numOfIcos) {
            aSA += icosList[sA].surfaceArea();
            sA++;
         }
         aSA = aSA / sA;
      }
      return aSA;
   }
   
   /**
     *Returns the average volume of all icosahedron listed.
     *
     *@return average volume.
     */
   public double averageVolume() {
      double aV = 0;
      if (numOfIcos != 0) {
         int v = 0;
         while (v < numOfIcos) {
            aV += icosList[v].volume();
            v++;
         }
         aV = aV / v;
      }
      return aV;
   }
   
   /**
     *Returns average surface to volume ratio for all icosahedron listed.
     *
     *@return average surface to volume ratio.
     */
   public double averageSurfaceToVolumeRatio() {
      double aSTVR = 0;
      if (numOfIcos != 0) {
         int sTVR = 0;
         while (sTVR < numOfIcos) {
            aSTVR += icosList[sTVR].surfaceToVolumeRatio();
            sTVR++;
         }
         aSTVR = aSTVR / sTVR;
      }
      return aSTVR;
   }
   
   /**
     *Returns the name and array list of all icosahedron listed.
     *
     *@return name and array list.
     */
   public String toString() {
      String output = name;
      if (numOfIcos != 0) {
         int tS = 0;
         while (tS < numOfIcos) {
            output += "\n\n" + icosList[tS];
            tS++;
         }
      }
      return output;
   }
   
   /**
     *Return the name of the list and summary items.
     *
     *@return name and items.
     */
   public String summaryInfo() {
      DecimalFormat format = new DecimalFormat("#,##0.0##");
      String output = "----- Summary for " + getName() + " -----" + "\nNumber "
         + "of Icosahedrons: " + numberOfIcosahedrons() + "\nTotal Surface Area"
         + ": " + format.format(totalSurfaceArea()) + "\nTotal Volume: " 
         + format.format(totalVolume()) + "\nAverage Surface Area: " 
         + format.format(averageSurfaceArea()) + "\nAverage Volume: "
         + format.format(averageVolume()) + "\nAverage Surface/Volume Ratio: "
         + format.format(averageSurfaceToVolumeRatio());
      return output;
   }
   
   /**
     *Returns the array list.
     *
     *@return the array list.
     */
   public Icosahedron[] getList() {
      return icosList;
   }
   
   /**
     *Returns the size of icosList.
     *
     *@return the size of icosList.
     @param fileNameIn the file used.
     @throws FileNotFoundException cannot find file.
     */
   public IcosahedronList2 readFile(String fileNameIn) 
                                 throws FileNotFoundException {
      Icosahedron[] newIcosList = new Icosahedron[100];
      int count = 0;
      Scanner fileName = new Scanner(new File(fileNameIn));
      name = fileNameIn;
      name = fileName.nextLine();
      while (fileName.hasNext()) {
         String labelIn = fileName.nextLine();
         String colorIn = fileName.nextLine();
         double edgeIn = Double.parseDouble(fileName.nextLine());
         Icosahedron icos = new Icosahedron(labelIn, colorIn, edgeIn);
         newIcosList[count] = icos;
         numOfIcos++;
         count++;
      }
      fileName.close();
      IcosahedronList2 newIcosList2 = 
         new IcosahedronList2(name, icosList, count);
      icosList = newIcosList;
      return newIcosList2;
   }
   
   /**
     *Adds and icosahedron to the list.
     *
     *@param label the label.
     *@param color the color.
     *@param edge the edge.
     */
   public void addIcosahedron(String label, String color, double edge) {
      Icosahedron icos = new Icosahedron(label, color, edge);
      icosList[numOfIcos] = icos;
      numOfIcos = numOfIcos + 1;
   }
   
   /**
     *Finds an icosahedron.
     *
     *@param labelIn the icos to be found.
     *@return found icosahedron.
     */
   public Icosahedron findIcosahedron(String labelIn) {
      Icosahedron result = null;
      for (int i = 0; i < numOfIcos; i++) {
         if (icosList[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = icosList[i];
            return result;
         } 
      }
      return result;
   }
   
   /**
     *Deletes the icosahedron from the list.
     *
     *@return the icosahedron.
     *@param labelIn the icos to be deleted.
     */
   public Icosahedron deleteIcosahedron(String labelIn) {
      Icosahedron result = null;
      for (int i = 0; i < numOfIcos; i++) {
         if (icosList[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = icosList[i];
            for (int j = i; j < numOfIcos - 1; j++) {
               icosList[j] = icosList[j + 1];
            }
            icosList[numOfIcos - 1] = null;
            numOfIcos--;
            break;
         }
      }
      return result;
   }
   
   /**
     *Edits a icos in the list.
     *
     *@param label the label.
     *@param color the color.
     *@param edge the edge.
     *@return true or false.
     */
   public boolean editIcosahedron(String label, String color, double edge) {
      label = label.trim();
      color = color.trim();
      Icosahedron icos = findIcosahedron(label);
      if (icos != null) {
         icos.setColor(color);
         icos.setEdge(edge);
         return true;
      }
      return false;
   }
   
   /**
     *Finds the icoshedron with the shortest edge.
     *
     *@return the icosahedron.
     */
   public Icosahedron findIcosahedronWithShortestEdge() {
      if (this.numOfIcos > 0) {
         Icosahedron smallest = icosList[0];
         int x = 0;
         for (int i = 0; i < icosList.length; i++) {
            if (icosList[x].getEdge() < 0.02) {
               smallest = icosList[x];
            }
            if (icosList[x + 1] != null) {
               x++;
            }
         }
         
         return smallest;
      }
      return null;
   }
   
   /**
     *Finds the icosahedron with the longest edge.
     *
     *@return the icosahedron.
     */
   public Icosahedron findIcosahedronWithLongestEdge() {
      int x = 0;
      if (this.numOfIcos > 0) {
         Icosahedron largest = icosList[0];
         for (int i = 0; i < icosList.length; i++) {
            if (icosList[x].getEdge() > 122.0) {
               largest = icosList[x];
            }
            if (icosList[x + 1] != null) {
               x++;
            }
         }
         
         return largest;
      }
      return null;
   }
   
   /**
     *Finds the icoshedron with the smallest volume.
     *
     *@return the icosahedron.
     */
   public Icosahedron findIcosahedronWithSmallestVolume() {
      if (this.numOfIcos > 0) {
         Icosahedron smallest = icosList[0];
         int x = 0;
         for (int i = 0; i < icosList.length; i++) {
            if (icosList[x].volume() < 0.02) {
               smallest = icosList[x];
            }
            if (icosList[x + 1] != null) {
               x++;
            }
         }
         
         return smallest;
      }
      return null;
   }
   
   /**
     *Finds the icosahedron with the largest volume.
     *
     *@return the icosahedron.
     */
   public Icosahedron findIcosahedronWithLargestVolume() {
      int x = 0;
      if (this.numOfIcos > 0) {
         Icosahedron largest = icosList[0];
         for (int i = 0; i < icosList.length; i++) {
            if (icosList[x].volume() > 4090000.0) {
               largest = icosList[x];
            }
            if (icosList[x + 1] != null) {
               x++;
            }
         }
         
         return largest;
      }
      return null;
   }
}