/*
 * Read: Contains Checkpoint 4 tasks
 */
 
 /**
 * This is your class.  You will need to come up with a name and rename the file to match.
 * 
 * It must be the child of the InventoryItem parent class or one of its children.  
 * 
 * 
 * You will decide what you need in this class and how it works.  Be sure to use the functionality in the
 * parent class.
 */
 
 //TODO Checkpoint 4: create a class of your design, but sure to utilize the parent class as appropriate

public class Weapons extends InventoryItem{
	private  int ammuntionCount;
	private  double WeaponDamage;
	public Weapons(String n, String d, double w, double dam, int ammo) {
		super(n, d, w);
		ammuntionCount = ammo;
		WeaponDamage = dam;
		
	}
	
	public  int getACount(){
		return ammuntionCount;
	}
	public  double getWeaponDamage(){
		return WeaponDamage;
	}
	public int updateAmmo(){
		ammuntionCount = ammuntionCount - 1;
		if(ammuntionCount <= 0){
			ammuntionCount = 0;
		}
		return ammuntionCount;
		
	}
	
	public String toString(){
		return super.toString() + getACount();
	}
}
