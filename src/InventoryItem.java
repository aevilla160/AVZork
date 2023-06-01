/*
 * Read: Contains Checkpoint 4 tasks
 */
 
 /**
 * This is the InventoryItem class.
 * It is the parent class for any item that can be carried in your inventory.  
 * 
 * 
 * This class has fields for name, description, and weight (type double), be sure they are encapsulated.
 * 
 * Build constructors that you deem are necessary, note that a constructor that allows the user to 
 * specify the name, description, and weight will be needed at a minimum.
 * 
 * You should be able to get and set the name and description, but only get the weight.
 * 
 * Finally, overwrite the toString method from the Object class.  Be sure it returns
 * the name, description, and weight of the object.
 * 
 */
 
 //TODO Checkpoint 4: create the InventoryItem class
 public class InventoryItem{
	 private String name;
	 private String description;
	 private double weight;
	 
	 public InventoryItem(String n, String d, double w){
		 name = n;
		 description = d;
		 weight = w;
	 }
	 public String getName(){
		 return name;
	 }
	 
	 public String getDescription(){
		 return description;
	 }
	 
	 public double getWeight(){
		 return weight;
	 }
	 
	 public void setName(String inputName){
		 name = inputName;
	 }
	 
	 public void setDescription(String inputDescription){
		 description = inputDescription;
	 }
	 
	 //Fix toString just a placeholder
	 public String toString(){
		 return "The name of this item is: " + name + "This item does " + description + "The weight is " + weight;
	 }
//	public static Room get(int i) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	 
		 
		 
	 
	 
	 
	 
 }
