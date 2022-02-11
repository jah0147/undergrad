/*************************************
* @author Jacob Howard
* Description : This file will call
on UserInfo.Java.
**************************************/

//User Info Driver
public class UserInfoDriver {

 /**
 * This will run and take code from UserInfo.Java and plug in info.
 * @param args (not used).
 */
   public static void main(String[] args) {
      
      // User 1
      UserInfo user1 = new UserInfo("Pat", "Doe");
      System.out.println("\n" + user1);
      user1.setLocation("Auburn");
      user1.setAge(19);
      user1.logOn();
      System.out.println("\n" + user1);
      
      //User 2
      UserInfo user2 = new UserInfo("Sam", "Jones");
      System.out.println("\n" + user2);
      user2.setLocation("Atlanta");
      user2.setAge(21);
      user2.logOn();
      System.out.println("\n" + user2);
   }
}