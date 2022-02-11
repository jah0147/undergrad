import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.text.DecimalFormat;

/**
* The test file for Icosahedron.
* 
* @author Jacob Howard
* Project 08A
*/

public class IcosahedronTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** A test that always fails. **/
   
   
   
   @Test public void getEdgeTest() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Assert.assertEquals(2.0, icos.getEdge(), .00001);
   }
  /**
  * Test if edge is true.
  */ 
   @Test public void setEdgeTestTrue() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Assert.assertEquals(true, icos.setEdge(3));
   }
  /**
  * Test if edge is false.
  */ 
   @Test public void setEdgeTestFalse() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Assert.assertEquals(false, icos.setEdge(0));
   }
  /**
  * Test to get the label.
  */
   @Test public void getLabelTest() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Assert.assertEquals("New", icos.getLabel());
   }
  /**
  * Test if label is true.
  */ 
   @Test public void setLabelTestTrue() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Assert.assertEquals(true, icos.setLabel("Large"));
   }
  /**
  * Test if label is false.
  */ 
   @Test public void setLabelTestFalse() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Assert.assertEquals(false, icos.setLabel(null));
   }
  /**
  * Test for color.
  */ 
   @Test public void getColorTest() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Assert.assertEquals("Pink", icos.getColor());
   }
  /**
  * Test if color is true.
  */ 
   @Test public void setColorTestTrue() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Assert.assertEquals(true, icos.setColor("Blue"));
   }
  /**
  * Test if color is false.
  */ 
   @Test public void setColorTestFalse() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Assert.assertEquals(false, icos.setColor(null));
   }
  /**
  * Test to get the count.
  */   
   @Test public void getCountTest() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      icos.resetCount();
      Assert.assertEquals(0, icos.getCount(), .00001);
   }
  /**
  * Test to reset the count.
  */ 
   @Test public void resetCountTest() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      icos.resetCount();
      Assert.assertEquals(0.0, icos.getCount(), .00001);
   }
  /**
  * Test for the volume.
  */
   @Test public void volumeTest() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Assert.assertEquals(17.4535599249993, icos.volume(), .00001);
   }
  /**
  * Test for the surface area.
  */ 
   @Test public void surfaceAreaTest() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Assert.assertEquals(34.64101615137754, icos.surfaceArea(), .00001);
   }
  /**
  * Test for the surface to volume ratio.
  */ 
   @Test public void surfaceToVolumeRatioTest() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Assert.assertEquals(1.984753614748822, 
         icos.surfaceToVolumeRatio(), .00001);
   }
  /**
  * Test for equals method to be true.
  */    
   @Test public void equalsTestTrueLabel() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Assert.assertEquals(true, icos.equals(icos));
   }
  /**
  * Test for equals method to be false.
  */  
   @Test public void equalsTestFalse() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Object notIcos = new Object();
      Assert.assertEquals(false, icos.equals(notIcos));
   }
  /**
  * Test for equals method label to be false.
  */ 
   @Test public void equalsTestFalseLabel() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Icosahedron icos2 = new Icosahedron("New2", "Pink", 2);
      Assert.assertEquals(false, icos.equals(icos2));
   }
  /**
  * Test for equals color to be false.
  */  
   @Test public void equalsTestFalseColor() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Icosahedron icos2 = new Icosahedron("New", "Blue", 2);
      Assert.assertEquals(false, icos.equals(icos2));
   }
  /**
  * Test for equals edge to be false.
  */  
   @Test public void equalsTestFalseEdge() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Icosahedron icos2 = new Icosahedron("New", "Pink", 3);
      Assert.assertEquals(false, icos.equals(icos2));
   }
  /**
  * Test to string method.
  */      
   @Test public void toStringTest() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      String string = icos.toString();
      DecimalFormat df = new DecimalFormat("#,##0.0#####");
      String aF = df.format(icos.surfaceArea());
      String vF = df.format(icos.volume());
      String sVF = df.format(icos.surfaceToVolumeRatio());
      String correct = "Icosahedron \"New\" is \""
         + "Pink\" with 30 edges of length 2.0 units.\n"
         + "\tsurface area = " + aF + " square units\n\tvolume = " + vF 
         + " cubic units\n\tsurface/volume ratio = " + sVF;
      Assert.assertEquals(correct, string);
   }
  /**
  * Test for the hash code.
  */     
   @Test public void hashCodeTest() {
      Icosahedron icos = new Icosahedron("New", "Pink", 2);
      Assert.assertEquals(0, icos.hashCode(), .00001);
   }
}