/*
 * Read: Contains Checkpoint 4 tasks
 */
 
 /**
 * This is the Key class.
 * It is a child of the InventoryItem parent class.  
 * 
 * 
 * This class inherits fields for name, description, and weight. They should NOT be declared here.
 * 
 * This class contains fields for the room it works in called "roomIWorkIn" and the direction to
 * open called "directionToOpen"
 * 
 * To construct a key, you can accept parameters for name, description, and the room it works in.
 * The weight must be 0.3.
 * 
 * This class inherits the methods of the parent and should not implement them here.
 * 
 * Override the method, getDescription to include the RoomIWorKIn
 * 
 * You will need to add the following methods:
 * 
 * getRoomIWorkIn
 * getDirectionToOpen
 * 
 * 
 * Note, you may add more functions as your game requires
 * 
 * Finally, be sure to add the value of roomIWorkIn to the toString inherited from the parent.
 * 
 */
 
 //TODO Checkpoint 4: create the Key class
public class Key extends InventoryItem{
private String roomIWorkIN;
private String directionToOpen;
	
	public Key(String n, String d,String whereKeyWorks, String directionUnlock){
		super(n, d, 0.3);
		roomIWorkIN = whereKeyWorks;
		directionToOpen = directionUnlock;
	}
	
	public String getDescription(){
		return super.getDescription() + roomIWorkIN;
	}
	
	public String getroomIWorkIN(){
		return roomIWorkIN;
	}
	
	public String getDirectionToOpen(){
		return directionToOpen;
	}
//	public String getName(){
//		return super.getName();
//	}
	

	
	
	
	
	
	
	
}

