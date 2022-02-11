/*********************************
* Creates a program that define new subclass.
* @author Jacob Howard
*********************************/
public class InvalidCategoryException extends Exception {
  /*********************************
  * Invalid Category Exception for invalid category.
  *********************************/
   public InvalidCategoryException() {
   
      super("*** invalid category ***");
   }
}