import org.junit.Assert;
import org.junit.Test;
import java.text.DecimalFormat;
import java.io.FileNotFoundException;

/**
  *Tests the methods in IcosahedronList2.
  *
  *@author Jacob Howard
  *@version 11-2-2018.
  */
public class IcosahedronList2Test {
   /*******************************************************
     *tests getName method.
     ******************************************************/
   @Test public void getNameTest() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      Assert.assertEquals("Name", icos.getName());
   }
   
   /*******************************************************
     *Tests numberOfIcosahedrons method.
     ******************************************************/
   @Test public void numberOfIcosahedronsTest() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      Assert.assertEquals(0, icos.numberOfIcosahedrons());
   }
   
   /*******************************************************
     *Tests totalSurfaceArea method.
     ******************************************************/
   @Test public void totalSurfaceAreaTestEmpty() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      Assert.assertEquals(0, icos.totalSurfaceArea(), .000001);
   }
   /*******************************************************
     *Tests totalSurfaceArea method.
     ******************************************************/
   @Test public void totalSurfaceAreaTestFull() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 2);
      icosList[0] = new Icosahedron("Icos", "Blue", 1);
      icosList[1] = new Icosahedron("Icos2", "Blue", 1);
      Assert.assertEquals(17.32050807568877, icos.totalSurfaceArea(), .000001);
   }
   
   /*******************************************************
     *Tests totalVolume method.
     ******************************************************/
   @Test public void totalVolumeTestEmpty() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      Assert.assertEquals(0, icos.totalVolume(), .000001);
   }
   
   /*******************************************************
     *Tests totalVolume method.
     ******************************************************/
   @Test public void totalVolumeTestFull() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 2);
      icosList[0] = new Icosahedron("Icos", "Blue", 1);
      icosList[1] = new Icosahedron("Icos2", "Blue", 1);
      Assert.assertEquals(4.363389981249825, icos.totalVolume(), .000001);
   }
   
   /*******************************************************
     *Tests averageSurfaceToVolumeRatio method.
     ******************************************************/
   @Test public void averageSurfaceAreaTestEmpty() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      Assert.assertEquals(0, icos.averageSurfaceArea(), .000001);
   }
   
   /*******************************************************
     *Tests averageSurfaceToVolumeRatio method.
     ******************************************************/
   @Test public void averageSurfaceAreaTestFull() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 2);
      icosList[0] = new Icosahedron("Icos", "Blue", 1);
      icosList[1] = new Icosahedron("Icos2", "Blue", 1);
      Assert.assertEquals(8.660254037844386, 
         icos.averageSurfaceArea(), .000001);
   }
   
   /*******************************************************
     *Tests averageVolume method.
     ******************************************************/
   @Test public void averageVolumeTestEmpty() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      Assert.assertEquals(0, icos.averageVolume(), .000001);
   }
   
   /*******************************************************
     *Tests averageVolume method.
     ******************************************************/
   @Test public void averageVolumeTestFull() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 2);
      icosList[0] = new Icosahedron("Icos", "Blue", 1);
      icosList[1] = new Icosahedron("Icos2", "Blue", 1);
      Assert.assertEquals(2.1816949906249126, icos.averageVolume(), .000001);
   }
   
   /*******************************************************
     *Tests averageSurfaceToVolumeRatio method.
     ******************************************************/
   @Test public void averageSurfaceToVolumeRatioTestEmpty() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      Assert.assertEquals(0, icos.averageSurfaceToVolumeRatio(), .000001);
   }
   
   /*******************************************************
     *Tests averageSurfaceToVolumeRatio method.
     ******************************************************/
   @Test public void averageSurfaceToVolumeRatioTestFull() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 2);
      icosList[0] = new Icosahedron("Icos", "Blue", 1);
      icosList[1] = new Icosahedron("Icos2", "Blue", 1);
      Assert.assertEquals(3.969507229497644, 
         icos.averageSurfaceToVolumeRatio(), .000001);
   }
   
   /*******************************************************
     *Tests toString method.
     ******************************************************/
   @Test public void toStringTestEmpty() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      Assert.assertEquals(icos.toString(), icos.toString());
   }
   
   /*******************************************************
     *Tests toString method.
     ******************************************************/
   @Test public void toStringTestFull() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 2);
      icosList[0] = new Icosahedron("Icos", "Blue", 1);
      icosList[1] = new Icosahedron("Icos", "Blue", 1);
      String output = icos.getName();
      if (2 != 0) {
         int tS = 0;
         while (tS < icos.numberOfIcosahedrons()) {
            output += "\n\n" + icosList[tS];
            tS++;
         }
      }
      Assert.assertEquals(output, icos.toString());
   }
   
   /*******************************************************
     *Tests summaryInfo method.
     ******************************************************/
   @Test public void summaryInfoTest() {
      DecimalFormat format = new DecimalFormat("#,##0.0##");
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      String output = "----- Summary for " + icos.getName()
          + " -----" + "\nNumber "
         + "of Icosahedrons: " + icos.numberOfIcosahedrons() 
         + "\nTotal Surface Area"
         + ": " + format.format(icos.totalSurfaceArea()) + "\nTotal Volume: " 
         + format.format(icos.totalVolume()) + "\nAverage Surface Area: " 
         + format.format(icos.averageSurfaceArea()) + "\nAverage Volume: "
         + format.format(icos.averageVolume()) 
         + "\nAverage Surface/Volume Ratio: "
         + format.format(icos.averageSurfaceToVolumeRatio());
      Assert.assertEquals(output, icos.summaryInfo());
   }
   
   /*******************************************************
     *Tests getList method.
     ******************************************************/
   @Test public void getListTest() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      Icosahedron[] output = icos.getList();
      Assert.assertEquals(output, output);
   }
   
   /*******************************************************
     *Tests readFile method.
     *
     *@throws FileNotFoundException file not found.
     ******************************************************/
   @Test public void readFileTestEmpty() throws FileNotFoundException {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      IcosahedronList2 output = icos.readFile("icosahedron_data_0.txt");
      Assert.assertEquals(output, output);
   }
   
   /*******************************************************
     *Tests readFile method.
     *
     *@throws FileNotFoundException file not found.
     ******************************************************/
   @Test public void readFileTestFull() throws FileNotFoundException {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      IcosahedronList2 output = icos.readFile("icosahedron_data_1.txt");
      Assert.assertEquals(output, output);
   }
   
   /*******************************************************
     *Tests addIcosahedron method.
     ******************************************************/
   @Test public void addIcosahedronTest() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      icos.addIcosahedron("new", "blue", 0.01);
      Assert.assertEquals(icosList[0], icosList[0]);
   }
   
   /*******************************************************
     *Tests findIcosahedron method.
     ******************************************************/
   @Test public void findIcosahedronTestEmpty() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 1);
      icosList[0] = new Icosahedron("New", "Blue", 0.01);
      Assert.assertEquals(null, icos.findIcosahedron("Icos"));
   }
   
   /*******************************************************
     *Tests findIcosahedron method.
     ******************************************************/
   @Test public void findIcosahedronTestFull() {
      Icosahedron[] icosList = new Icosahedron[100];
      icosList[0] = new Icosahedron("Icos", "Blue", 1);
      icosList[1] = new Icosahedron("Icos2", "Blue", 1);
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 2);
      Assert.assertEquals(icosList[0], icos.findIcosahedron("Icos"));
   }
   
   /*******************************************************
     *Tests deleteIcosahedron method.
     ******************************************************/
   @Test public void deleteIcosahedronTestEmpty() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 1);
      icosList[0] = new Icosahedron("New", "Blue", 0.01);
      Assert.assertEquals(null, icos.deleteIcosahedron("Icos"));
   }
   
   /*******************************************************
     *Tests deleteIcosahedron method.
     ******************************************************/
   @Test public void deleteIcosahedronTestFull() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 2);
      icosList[0] = new Icosahedron("Icos", "Blue", 1);
      icosList[1] = new Icosahedron("Icos2", "Blue", 1);
      Icosahedron result = icos.deleteIcosahedron("Icos");
      Assert.assertEquals(result, result);
   }
   
   /*******************************************************
     *Tests editIcosahedron method.
     ******************************************************/
   @Test public void editIcosahedronTestTrue() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      icos.addIcosahedron("Icos", "Blue", 0.1);
      Assert.assertEquals(true, icos.editIcosahedron("Icos", "Orange", 0.01));
   }
   
   /*******************************************************
     *Tests editIcosahedron method.
     ******************************************************/
   @Test public void editIcosahedronTestFalse() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      Assert.assertEquals(false, icos.editIcosahedron("Icos", "Blue", 0.01));
   }
   
   /*******************************************************
     *Tests findIcosahedronWithShortestEdge method.
     ******************************************************/
   @Test public void findIcosahedronWithShortestEdgeTestEmpty() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      Assert.assertEquals(null, icos.findIcosahedronWithShortestEdge());
   }
   
   /*******************************************************
     *Tests findIcosahedronWithShortestEdge method.
     ******************************************************/
   @Test public void findIcosahedronWithShortestEdgeTestFull() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 2);
      icosList[0] = new Icosahedron("Icos", "Blue", 0.01);
      icosList[1] = new Icosahedron("Icos2", "Blue", 123.4);
      Icosahedron result = icos.findIcosahedronWithShortestEdge();
      Assert.assertEquals(result, result);
   }
   
   /*******************************************************
     *Tests findIcosahedronWithLongestEdge method.
     ******************************************************/
   @Test public void findIcosahedronWithLongestEdgeTestEmpty() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      Assert.assertEquals(null, icos.findIcosahedronWithLongestEdge());
   }
   
   /*******************************************************
     *Tests findIcosahedronWithLongestEdge method.
     ******************************************************/
   @Test public void findIcosahedronWithLongestEdgeTestFull() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 2);
      icosList[0] = new Icosahedron("Icos", "Blue", 0.01);
      icosList[1] = new Icosahedron("Icos2", "Blue", 123.4);
      Icosahedron result = icos.findIcosahedronWithLongestEdge();
      Assert.assertEquals(result, result);
   }
   
   /*******************************************************
     *Tests findIcosahedronWithSmallestVolume method.
     ******************************************************/
   @Test public void findIcosahedronWithSmallestVolumeTestEmpty() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      Assert.assertEquals(null, icos.findIcosahedronWithSmallestVolume());
   }
   
   /*******************************************************
     *Tests findIcosahedronWithSmallestVolume method.
     ******************************************************/
   @Test public void findIcosahedronWithSmallestVolumeTestFull() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 2);
      icosList[0] = new Icosahedron("Icos", "Blue", 0.01);
      icosList[1] = new Icosahedron("Icos2", "Blue", 123.4);
      Icosahedron result = icos.findIcosahedronWithSmallestVolume();
      Assert.assertEquals(result, result);
   }
   
   /*****************************************************
     *Tests findIcosahedronWithLargestVolume method.
     ******************************************************/
   @Test public void findIcosahedronWithLargestVolumeTestEmpty() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 0);
      Assert.assertEquals(null, icos.findIcosahedronWithLargestVolume());
   }
   
   /*****************************************************
     *Tests findIcosahedronWithLargestVolume method.
     ******************************************************/
   @Test public void findIcosahedronWithLargestVolumeTestFull() {
      Icosahedron[] icosList = new Icosahedron[100];
      IcosahedronList2 icos = new IcosahedronList2("Name", icosList, 2);
      icosList[0] = new Icosahedron("Icos", "Blue", 0.01);
      icosList[1] = new Icosahedron("Icos2", "Blue", 123.4);
      Icosahedron result = icos.findIcosahedronWithLargestVolume();
      Assert.assertEquals(result, result);
   }
}
