import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
*
*/
public class IcosahedronTest {

// variables and objects
   private Icosahedron d = new Icosahedron("test", "cyan", 2.5);
   private Icosahedron dTrue = new Icosahedron("test", "cyan", 2.5);
   private Icosahedron dFalse = new Icosahedron("false", "fasle", .25);
   private double edge = d.getEdge();
   
   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Before
   public void setUp() throws Exception {
   
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void getLabel() throws Exception {
      Assert.assertEquals("test", d.getLabel());
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void setLabel() throws Exception {
      Assert.assertEquals(true, d.setLabel("test2"));
      Assert.assertEquals(false, d.setLabel(null));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void getColor() throws Exception {
      Assert.assertEquals("cyan", d.getColor());
      Assert.assertEquals(false, d.setLabel(null));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void setColor() throws Exception {
      Assert.assertEquals(true, d.setColor("blue"));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void getEdge() throws Exception {
      Assert.assertEquals(2.5, d.getEdge(), .001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void setEdge() throws Exception {
      Assert.assertEquals(true, d.setEdge(.25));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void surfaceArea() throws Exception {
      Assert.assertEquals(5 * Math.sqrt(3)
                                 * Math.pow(edge, 2), d.surfaceArea(), .001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void volume() throws Exception {
      Assert.assertEquals("Check your volume equation", 5 * ((3
               + Math.sqrt(5)) / (12)) * Math.pow(edge, 3), d.volume(), .001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void surfaceToVolumeRatio() throws Exception {
      Assert.assertEquals(
             (5 * Math.sqrt(3) * Math.pow(edge, 2)) 
                    / ((5 * (3 + Math.sqrt(5)) / (12)) * Math.pow(edge, 3)),
              d.surfaceToVolumeRatio(), .001);
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void toStringTest() {
      Icosahedron[] iList = new Icosahedron[10];
      for (int i = 0; i < 5; i++) {
         Icosahedron j = new Icosahedron("test" + i, "color" + i, 
                                                               i + .25);
         iList[i] = j;
      }
      Assert.assertEquals("", true, iList[4].toString().contains("4.25"));
   }

   /**
    * get count test.
    * @throws Exception thows exception bc it might
    */
   
   
   @Test
   public void getresetCountTest() {
      Icosahedron x = new Icosahedron("test", "cyan", 2.5);
      Icosahedron.resetCount();
      Assert.assertEquals("getCount test", 0, x.getCount());
   }
   
  

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void equalsTest() throws Exception {
      Assert.assertFalse(d.equals(dFalse));
      Assert.assertTrue(d.equals(dTrue));
   }

   /**
    *
    * @throws Exception thows exception bc it might
    */
   @Test
   public void hashCodeTest() {
      Assert.assertTrue(0 == d.hashCode());
   }


   /** Fixture initialization (common initialization
    *  for all tests). **/
   


  //  /** A test that always fails. **/
//    @Test public void defaultTest() {
//       Assert.assertEquals("Default test added by jGRASP. Delete "
//             + "this test once you have added your own.", 0, 1);
}

