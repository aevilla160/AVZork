/*
 * Read: Contains Checkpoint 4 tasks
 */
 
 /**
 * This is the Food class.
 * It is a child of the InventoryItem parent class.  
 * 
 * 
 * This class inherits fields for name, description, and weight. They should NOT be declared here
 * nor should any inherited methods.
 * 
 * This class contains a field that holds a health value called healthValue. 
 * 
 * To construct a food item, you can accept parameters for name, description, weight and health.
 * 
 * This class inherits the methods of the parent, but you will need to add the following methods:
 * 
 *  getHealth and setWeight
 * 
 * 
 * Finally, be sure to add the value of health to the toString inherited from the parent.
 * 
 */
 
 //TODO Checkpoint 4: create the Key class

public class Food extends InventoryItem{
	private   double healthValue;
	public Food(String n, String d, double w, double h ){
		super(n,d,w);
		healthValue = h;
	}
	
	public  double getHealth(){
		return healthValue;
	}
	
	public  void setHealth(double x){
		healthValue = x;
	}
	
	//public String setWeight(){
		
	//}
	
	public String toString(){
		return super.toString() + "Your current health is: " + getHealth();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}