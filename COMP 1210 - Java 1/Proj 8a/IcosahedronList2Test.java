import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
* Class icosahedron list 2.
*/
public class IcosahedronList2Test {


   // Variables, objects and list
   private String listName = "List Test Name";
   private static int arrSizeTest = 0;
   private Icosahedron[] iList = new Icosahedron[20];
   private Icosahedron[] iNullList = new Icosahedron[20];

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Before
   public void setUp() throws Exception {
      arrSizeTest = 0;
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
 @Test public void gettersTest()
   {
      Icosahedron[] iList = new Icosahedron[100];
      iList2 cList = new iList2("label", iList, 3);
   
      Assert.assertEquals("getName test", "label", iList.getName());
      Assert.assertArrayEquals("getList test", jList, iList.getList());
   

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void numberOfIcosahedronsTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color"  
                                                            + i, i + .25);
         iList[i] = j;
         arrSizeTest++;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName, 
                                                   iList, arrSizeTest);
      Assert.assertEquals("", 5, jTest2.numberOfIcosahedrons());
   
      IcosahedronList2 jNullTest2 = new IcosahedronList2(listName,  
                                                   iNullList, 1);
      Assert.assertEquals("", 0, jNullTest2.numberOfIcosahedrons());
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void totalSurfaceAreaTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color"  
                                                            + i, i + .25);
         iList[i] = j;
         arrSizeTest++;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName,  
                                                   iList, arrSizeTest);
      double total = 0;
      for (int i = 0; i < arrSizeTest; i++) {
         total += iList[i].surfaceArea();
      }
      Assert.assertEquals("", total, jTest2.totalSurfaceArea(), .001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void totalVolumeTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color"  
                                                            + i, i + .25);
         iList[i] = j;
         arrSizeTest++;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName,  
                                                   iList, arrSizeTest);
      double total = 0;
      for (int i = 0; i < arrSizeTest; i++) {
         total += iList[i].volume();
      }
      Assert.assertEquals("", total, jTest2.totalVolume(), .001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void averageSurfaceAreaTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color"  
                                                            + i, i + .25);
         iList[i] = j;
         arrSizeTest++;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName,  
                                                   iList, arrSizeTest);
      double total = 0;
      for (int i = 0; i < arrSizeTest; i++) {
         total += (iList[i].surfaceArea()) / arrSizeTest;
      }
      Assert.assertEquals("", total, jTest2.averageSurfaceArea(), .001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void averageVolumeTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color"  
                                                            + i, i + .25);
         iList[i] = j;
         arrSizeTest++;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName,  
                                                   iList, arrSizeTest);
      double total = 0;
      for (int i = 0; i < arrSizeTest; i++) {
         total += (iList[i].volume()) / arrSizeTest;
      }
      Assert.assertEquals("", total, jTest2.averageVolume(), .0001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void averageSurfaceToVolumeRatioTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color"  
                                                            + i, i + .25);
         iList[i] = j;
         arrSizeTest++;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName,  
                                                   iList, arrSizeTest);
      double total = 0;
      for (int i = 0; i < arrSizeTest; i++) {
         total += iList[i].surfaceToVolumeRatio()
                 / arrSizeTest;
      }
      Assert.assertEquals("", total, jTest2.averageSurfaceToVolumeRatio(), 
                                                                     .0001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void toStringTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color"  
                                                            + i, i + .25);
         iList[i] = j;
      }
      Assert.assertEquals("", true, iList[4].toString()
                                    .contains(" with 30 edges of length "));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void summaryInfoTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color"  
                                                            + i, i + .25);
         iList[i] = j;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName,  
                                                   iList, arrSizeTest);
      Assert.assertEquals("", true, jTest2.summaryInfo()
                                                .contains("Total Volume: "));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void getListTest() throws Exception {
      setUp();
      IcosahedronList2 jTest2 = new IcosahedronList2(listName,  
                                                   iList, arrSizeTest);
      Assert.assertArrayEquals("", iList, jTest2.getList());
   }

   /**
    *
    * @throws FileNotFoundException thows exception bc it might not fine a file
    */
   @Test
   public void readFileTest() throws FileNotFoundException {
      //Icosahedron[] iList = new Icosahedron[100];
      IcosahedronList2 jList2 = new IcosahedronList2("Icosahedron Test List",
         iList, 0);
      jList2 = jList2.readFile("icosahedron_data_1.txt");
      Assert.assertEquals("", "Icosahedron Test List", jList2.getName());
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void addIcosahedronTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color"  
                                                            + i, i + .25);
         iList[i] = j;
         arrSizeTest++;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName,  
                                                   iList, arrSizeTest);
      Icosahedron dTrue = new Icosahedron("test", "cyan", 2.5);
      jTest2.addIcosahedron("test", "cyan", 2.5);
   
      Assert.assertEquals("", dTrue, iList[arrSizeTest]);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void findIcosahedronTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color"  
                                                            + i, i + .25);
         iList[i] = j;
         arrSizeTest++;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName,  
                                                   iList, arrSizeTest);
      Icosahedron dTrue = new Icosahedron("test4", "color4", 4.25);
      Assert.assertEquals("", dTrue, jTest2.findIcosahedron("test4"));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void deleteIcosahedronTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color"  
                                                            + i, i + .25);
         iList[i] = j;
         arrSizeTest++;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName, 
                                                iList, arrSizeTest);
      jTest2.deleteIcosahedron("test4");
      Icosahedron dTrue = new Icosahedron("test2", "color2", 2.25);
      Assert.assertFalse("", dTrue == jTest2.findIcosahedron("test2"));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void editIcosahedronTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color" 
                                                            + i, i + .25);
         iList[i] = j;
         arrSizeTest++;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName, 
                                                iList, arrSizeTest);
      jTest2.editIcosahedron("test4", "cyan", 425);
      Icosahedron dTrue = new Icosahedron("test4", "cyan", 425);
      Assert.assertEquals("", dTrue, jTest2.findIcosahedron("test4"));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
    public void findIcosahedronWithShortestEdgeTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color" 
                                                            + i, i + .25);
         iList[i] = j;
         arrSizeTest++;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName, 
                                                iList, arrSizeTest);
      Icosahedron dTrue = new Icosahedron("test0", "color0", .25);
      Assert.assertEquals("", dTrue, 
                              jTest2.findIcosahedronWithShortestEdge());
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void findIcosahedronWithLongestEdgeTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color" 
                                                            + i, i + .25);
         iList[i] = j;
         arrSizeTest++;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName, 
                                                iList, arrSizeTest);
      Icosahedron dTrue = new Icosahedron("test4", "color4", 4.25);
      Assert.assertEquals("", dTrue, 
                              jTest2.findIcosahedronWithLongestEdge());
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void findIcosahedronWithSmallestVolumeTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color"
                                                               + i, i + .25);
         iList[i] = j;
         arrSizeTest++;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName, 
                                                iList, arrSizeTest);
      Icosahedron dTrue = new Icosahedron("test0", "color0", .25);
      Assert.assertEquals("", dTrue, 
                           jTest2.findIcosahedronWithSmallestVolume());
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void findIcosahedronWithLargestVolumeTest() throws Exception {
      setUp();
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color" 
                                                         + i, i + .25);
         iList[i] = j;
         arrSizeTest++;
      }
      IcosahedronList2 jTest2 = new IcosahedronList2(listName, 
                                             iList, arrSizeTest);
      Icosahedron dTrue = new Icosahedron("test4", "color4", 4.25);
      Assert.assertEquals("", dTrue, 
                        jTest2.findIcosahedronWithLargestVolume());
   }

  //  /** A test that always fails. **/
//    @Test public void defaultTest() {
//       Assert.assertEquals("Default test added by jGRASP. Delete "
//             + "this test once you have added your own.", 0, 1);
}

