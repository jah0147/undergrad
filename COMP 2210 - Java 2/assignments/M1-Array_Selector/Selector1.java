import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Jacob Howard (jah0147@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  1/17/19
*
*/
public final class Selector1 {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector1() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int min = a[0];
      for (int i = 1; i < a.length; i ++) {
         if (a[i] < min) {
            min = a[i];
         }
      }
      return min;
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int max = a[0];
      for (int i = 1; i < a.length; i ++) {
         if (a[i] > max) {
            max = a[i];
         }
      }
      return max;
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      //copies array to not change original.
      int[] b = new int[a.length];
      for (int i = 0; i < a.length; i ++) {
         b[i] = a[i];
      }
      //Sorts array
      Arrays.sort(b);
      int distinct = 1;
      int temp = b[0];
      int kmin = 0;
      if (k == 1) {
         kmin = b[0];
         return kmin;
      }
      //Checks array, if distinct = k, that is kmin.
      for (int i = 1; i < a.length; i++) {
         if (b[i] != temp) {
            distinct++;
            if (distinct == k) {
               kmin = b[i];
            }
         }
         temp = b[i];
      }
      //If k is bigger than distanct, there is no kmin.
      if (k > distinct) {
         throw new IllegalArgumentException();
      }
      return kmin;
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      //copies array like kmin
      int[] b = new int[a.length];
      for (int i = 0; i < a.length; i ++) {
         b[i] = a[i];
      }
      //Sorts array
      Arrays.sort(b);
      int distinct = 1;
      int temp = b[b.length - 1];
      int kmax = 0;
      if (k == 1) {
         kmax = b[b.length - 1];
         return kmax;
      }
      //Checks array, if distinct = k, that is kmin.
      for (int i = b.length - 1; i >= 0; i--) {
         if (b[i] != temp) {
            distinct++;
            if (distinct == k) {
               kmax = b[i];
            }
         }
         temp = b[i];
      }
      //If k is bigger than distanct, there is no kmin.
      if (k > distinct) {
         throw new IllegalArgumentException();
      }      
      return kmax;
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      /**Goes through to find how many are in the range bc size of array
      cannot be changed. **/
      int size = 0;
      for (int i = 0; i < a.length; i ++) {
         if (a[i] >= low && a[i] <= high) {
            size++;
         }
      }
      //Creates range array, returns if size = 0.
      int[] range = new int[size];
      if (size == 0) {
         return range;
      }
      //If size does not equal zero, fills in range array and returns it.
      int j = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= low && a[i] <= high) {
            range[j] = a[i];
            j++;
         }
      }
      return range;
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int ceiling = 0;
      //Tells if first ceiling found
      boolean found = false; 
      for (int i = 0; i < a.length; i ++) {
      //If no ceiling, only compare to key.
         if (!found && a[i] >= key) {
            ceiling = a[i];
            found = true;
         }
         //If already found a ceiling, compare to key and previous ceiling.
         else if (a[i] >= key && a[i] <= ceiling) {
            ceiling = a[i];
         }
      }
      //If never found a ceiling value, throw an exception.
      if (!found) {
         throw new IllegalArgumentException();
      }
      return ceiling;
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int floor = 0;
      //Tells if first floor found
      boolean found = false; 
      for (int i = 0; i < a.length; i ++) {
      //If no first floor, only compare to key.
         if (!found && a[i] <= key) {
            floor = a[i];
            found = true;
         }
         //If already found floor, compare to key and previous floor.
         else if (a[i] <= key && a[i] >= floor) {
            floor = a[i];
         }
      }
      //If never found floor value, throw exception.
      if (!found) {
         throw new IllegalArgumentException();
      }
      return floor;
   }

}
