/**
* @author Jacob Howard
* Description : Code for a customer.
*/

public class Customer implements Comparable<Customer> {
   private String name;
   private String location;
   private double balance;

   /**
    *
    * @param nameIn takes name in
    */
   public Customer(String nameIn) {
      name = nameIn;
      location = "";
      balance = 0;
   }

   /**
    * String to return string.
    * @return returns name
    */
   public String getName() {
      return name;
   }

   /**
    * Set location.
    * @param locationIn takes location in
    */
   public void setLocation(String locationIn) {
      location = locationIn;
   }

   /**
    * change ballance.
    * @param amount takes balance in
    */
   public void changeBalance(double amount) {
      balance = balance + amount;
   }

   /**
    * get location.
    * @return returns location
    */
   public String getLocation() {
      return location;
   }

   /**
    * get balance.
    * @return returns the balance
    */
   public double getBalance() {
      return balance;
   }

   /**
    * set location.
    * @param city takes city in
    * @param state takes state in
    */
   public void setLocation(String city, String state) {
      location = city + ", " + state;
   }

   /**
    * string to string.
    * @return returns the toString 
    */
   public String toString() {
      return getName() + "\n" + getLocation() + "\n$" + getBalance();
   }

   /**
    * compare to.
    * @param obj takes in an object
    * @return returns if it is less, greater, or equal
    */
   public int compareTo(Customer obj) {
      if (Math.abs(this.balance - obj.getBalance()) < 0.000001) {
         return 0;
      } else if (this.balance < obj.getBalance()) {
         return -1;
      } else {
         return 1;
      }
   }
}

