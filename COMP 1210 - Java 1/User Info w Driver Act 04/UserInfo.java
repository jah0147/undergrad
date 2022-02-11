/******************************
* @author Jacob Howard
* Description : Gets user name,
age, location, and log 
******************************/
public class UserInfo {

// instance variables
   private String firstName;
   private String lastName;
   private String location;
   private int age;
   private int status;
   private static final int OFFLINE = 0, ONLINE = 1;
   
   // constructor
   /**
   * Specifies user info for first and last name.
   * @param firstNameIn (created for initial first name)
   * @param lastNameIn (created for initial last name)
   */
   public UserInfo(String firstNameIn, String lastNameIn) {
      firstName = firstNameIn;
      lastName = lastNameIn;
      location = "Not specified";
      age = 0;
      status = OFFLINE;
   }
   //methods
   /**
   * Prints information.
   * @return used for output
   */
   public String toString() {
      String output = "Name: " + firstName + " "
         + lastName + "\n";
      output += "Location: " + location + "\n";
      output += "Age: " + age + "\n";
      output += "Status: ";
      
      // Prints status in words
      if (status == OFFLINE) {
         output += "Offline";
      }
      else {
         output += "Online";
      }
      return output;
   }
   
   /**
   * Sets location.
   * @param locationIn used to set initial location
   */
   public void setLocation(String locationIn) {
      location = locationIn;
   }
   
   /**
   * boolean set for age if greater than zero
   to display age.
   * @return age used to call age
   * @param ageIn created for initial age
   */
   public boolean setAge(int ageIn) {
      boolean isSet = false;
      if (ageIn > 0) {
         age = ageIn; isSet = true;
      }
      return isSet;
   }
   
   /**
   * Gets age.
   * @return age created to call age
   */
   public int getAge() {
      return age;
   }
   
   /**
   * Gets location.
   * @return location created to call location
   */
   public String getLocation() {
      return location;
   }
   
   /**
   * Allow user to log off.
   */
   public void logOff() {
      status = OFFLINE;
   }
   
   /**
   * Allows user to log on.
   */
   public void logOn() {
      status = ONLINE;
   }
}