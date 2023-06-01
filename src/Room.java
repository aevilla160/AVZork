import java.util.*;
//TODO: Create a public class named "Room"   
	public class Room{
private  ArrayList<InventoryItem> inventoryU;
	/*
	 *TODO:  Create the following private instance variables: 
	 *
	 * canGo<Direction> - type Boolean - stores the ability to move in a given direction
	 *  <Direction> should be replaced with North, South, East, West (example, canGoEast)
	 * description - type String - will store the description of the Room
	 * name - type String - will store the name of the Room
	 * be sure to encapsulate aka make you fields private
	 */
	
	private boolean canGoNorth;  //canGoNorth is completed for you
	private boolean canGoSouth;
	private boolean canGoEast;
	private boolean canGoWest;
	private String description;
	private String roomName;
	private String NpcName;
	private Npc npc;

	
	
	
	
	/**
	 * Default Room constructor
	 * sets all canGo<Direction> fields to false  (i.e.  canGoSouth = false)
	 * sets the name of the room to "Not a room"
	 * sets the description of the room to "This is not a room, you shouldn't be here!!!"
	 */
	 
	 //TODO: make the Room default constructor
	public Room(){
		canGoNorth = false;
		canGoSouth = false;
		canGoEast = false;
		canGoWest = false;
		description = "This is not a room, you shouldn't be here!!!";
		roomName = "Not a room";
		
	}







	
	/**
	 * Custom Room constructor 
	 * this allows the client code to build a Room a room with custom parameters
	 * populates all fields using parameters
	 * 
	 * @param canGoNorth
	 * @param canGoSouth
	 * @param canGoEast
	 * @param canGoWest
	 * @param name
	 * @param description
	 */
	 
	 //TODO: make the custom Room constructor
	public Room(boolean canGoNorth, boolean canGoSouth, boolean canGoEast, boolean canGoWest, String name, String description){
		this.canGoNorth = canGoNorth;
		this.canGoSouth = canGoSouth;
		this.canGoEast = canGoEast;
		this.canGoWest = canGoWest;
		roomName = name;
		this.description = description;
		inventoryU = new ArrayList<InventoryItem>();
	}
	public Room(boolean canGoNorth, boolean canGoSouth, boolean canGoEast, boolean canGoWest, String name, String description, InventoryItem x, Npc witch){
		this.canGoNorth = canGoNorth;
		this.canGoSouth = canGoSouth;
		this.canGoEast = canGoEast;
		this.canGoWest = canGoWest;
		roomName = name;
		this.description = description;
		inventoryU = new ArrayList<InventoryItem>();
		inventoryU.add(x);
		npc = witch;
		NpcName = npc.getName();
		
	}
	/**
	 * Accessor method called getDescription
	 * It gets the room description
	 * @return the description
	 */
	 
	
	public boolean hasObject(String objectName){
		boolean output = false;
		for(int x = 0; x < inventoryU.size(); x++){
			if(objectName.equalsIgnoreCase(inventoryU.get(x).getName())){
				output =  true;
			}	
		}
		return output;
	}
	
	public void addObject(InventoryItem invObject){
		//inventoryU is the room inventory and not the player inventory
		inventoryU.add(invObject);
	}

	public InventoryItem removeObject(String invObject){
		for(int x = 0; x < inventoryU.size();x++){
			if(invObject.equalsIgnoreCase(inventoryU.get(x).getName())){
			return inventoryU.remove(x);
			}
		}
		return null;
	}
	 //TODO: make the getDescription method
public String getDescription(){
	String output = description + getNamesofObjects() +"\n" + getNpcName();
	if(getNpcName() == ""){
		output = description + getNamesofObjects();
	}
	return output;
}

	
	/**
	 * Accessor method called getName
	 * It gets the room name
	 * @return the name
	 */
	 
	 //TODO: make the getName method
public String getName(){
	return roomName;
}



	
	/**
	 * Mutator method called setDescription
	 * It updates the room description
	 * @param d is the description of the room
	 */
	 
	 //TODO: make the setDescription method
public void setDescription(String d){
	description = d;
}




	
	/**
	 * Mutator method called setName
	 * It updates the room name
	 * @param n is the name you want the room to have
	 */
	 
	 //TODO: make the setName method

public void setName(String n){
	roomName = n;
}



	
	
	/**
	 * Accessor method called getCanGoNorth
	 * used to determine if the player can move North
	 * @return the value of canGoNorth
	 */
	 
	 //TODO: make the getCanGoNorth method
public boolean getCanGoNorth(){
	return canGoNorth;
}

	

	/**
	 * Accessor method called getCanGoSouth
	 * used to determine if the player can move South
	 * @return the value of canGoSouth
	 */
	 
	 //TODO: make the getCanGoSouth method
public boolean getCanGoSouth(){
	return canGoSouth;
}

	
	/**
	 * Accessor method called getCanGoEast
	 * used to determine if the player can move East
	 * @return the value of canGoEast
	 */
	 
	 //TODO: make the getCanGoEast method
public boolean getCanGoEast(){
	return canGoEast;
}




	
	/**
	 * Accessor method called getCanGoWest
	 * used to determine if the player can move West
	 * @return the value of canGoWest
	 */
	 
	 //TODO: make the getCanGoWest method
public boolean getCanGoWest(){
	return canGoWest;
}




	
	/**
	 * Mutator method called setCanGoNorth
	 * used to change the ability to move North
	 * @param b a boolean value that changes the canGoNorth field
	 */
	 
	 //TODO: make the setCanGoNorth method
public void setCanGoNorth(boolean b){
canGoNorth = b;
}




	/**
	 * Mutator method called setCanGoSouth
	 * used to change the ability to move South
	 * @param b a boolean value that changes the canGoSouth field
	 */
	 
	 //TODO: make the setCanGoSouth method

public void setCanGoSouth(boolean b){
	canGoSouth = b;
}



	
	/**
	 * Mutator method called setCanGoEast
	 * used to change the ability to move East
	 * @param b a boolean value that changes the canGoEast field
	 */
	 
	 //TODO: make the setCanGoEast method

public void setCanGoEast(boolean b){
	canGoEast = b;
}



	
	/**
	 * Mutator method called setCanGoWest
	 * used to change the ability to move West
	 * @param b a boolean value that changes the canGoWest field
	 */
	 
	 //TODO: make the setCanGoWest method
public void setCanGoWest(boolean b){
	canGoWest = b;
}

// get name of objects in room that you are currently in.
public String getNamesofObjects(){
	String namesofObjectsInRoom = " The objects in this room are: ";
	for(int i = 0; i < inventoryU.size(); i++){
		namesofObjectsInRoom += inventoryU.get(i).getName() + ", ";
		if(inventoryU.size() == -1){
			namesofObjectsInRoom += " None";
		}
	}
	return namesofObjectsInRoom;
}

public String getNpc(){
	String output = "This room does not have any enemies but remember to be on the lookout";
	if(NpcName != ""){
		output = "Be careful in this room do not make any sudden actions, " + NpcName;
	}
	return output;
}

public boolean checkNpc(){
	boolean output = false;
	if(NpcName != ""){
		output = true;
	}
	return output;
}

public String getNpcName(){
	return NpcName;
}

public Npc bringNpc(){
	return npc;
}

public void setNpc(){
	NpcName = "";
	npc = null;
}
	
	/**
	 * Accessor method called toString
	 * used to retreive the current state of the room
	 * 
	 * example output:  
	 * Kitchen
	 * There is a strange smell coming from the partially opened refrigerator door
	 * canGoNorth: true  canGoSouth: false canGoEast: false canGoWest: true
	 * 
	 * @return a String with the Room Name, Description, and the ability to move each direction 
	 * 
	 */
	 
	 //TODO: make the toString method
public String toString(){
return "You are in" + roomName + "that holds " + description + canGoNorth +canGoSouth +canGoWest + canGoEast;
}



	

}