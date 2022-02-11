/**
* Creates a program that defines a new subclass of the Exception class.
* 
* @author Katie Varady
* @version November 30, 2018
* Project 11
*/
public class InvalidCategoryException extends Exception {
  /**
  * Invalid Category Exception for an invalid category.
  */
   public InvalidCategoryException() {
   
      super("*** invalid category ***");
   }
}