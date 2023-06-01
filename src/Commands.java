//2019 version

import java.util.*;

/*
 * 
 * All green comments are tasks for these checkpoints
 * Note that this code will be used for both checkpoints 3 and 4.
 * Be sure to focus only on the checkpoint you are currently assigned to work on.
 * 
 */


/**
 * Creates the class Commands, 
 * There will only be one instance used by the game
 * therefore all of its methods are static to prevent multiple
 */

public class Commands {



/*
 * TODO: Checkpoint 3 Tasks
 * 
 * add class level variables
 * Declare a two dimensional array called "map" it should be of type "Room"
 * Declare two variables of type int called "row" and "column"
 * Declare a Room object called currentRoom
 * 
 * note that these variables should be "static" because there should only be one world
 */
 public static Room[][] map = new Room[5][5];
 public static int row;
 public static int column;
 public static Room currentRoom; 
 
 //added 4/18/20 but still ask question on wether there should only be one in room or one in each
private static ArrayList<InventoryItem> userInventory;
private static double userHealth;
public static int 	 cheatActivated = 0;
//userInventory = new ArrayList<InventoryItem>();
	
	
	
	
	

/**
 * runGame method
 * method responsible for running a console version of the game
 * this method returns nothing and has no parameters
 * it contains the while loop that is used to run the game
 */
	
	public static void runGame(){
		userInventory = new ArrayList<InventoryItem>();
		userHealth = 100.0;

/*
 * TODO: Checkpoint 3 Tasks
 * 
 * initialize your map 
 * 
 * then construct each room of your world, 
 * be sure they match the correct locations of you map and have the appropriate 
 * passages set to true and false
 * Any spot in your map that is not used should be built with the default constructor
 * 
 * HINT: The upper left is row 0 and column 0
 */ 
		 //Room map[][] = new Room [5][5];
		 map[0][0] = new Room();
		 map[0][1] = new Room();
		 map[0][2] = new Room (false, true,false, false, "Back of House", "Starting area", zapguns,witch1);
		 //map[0][2] = getCurrentRoom().addObject(apple);
		 map[0][3] = new Room();
		 map[0][4] = new Room();
		 map[1][0] = new Room();
		 map[1][1] = new Room(false,true,false,false,"Basement", "Holds the witch", knife, basementWitch);
		 map[1][2] = new Room(true,true,true,false,"Corridor", "Hallway cluttered things", key1,witch3);
		 map[1][3] = new Room(false,false,false,true,"Kitchen", "Holds many secrets", bread, witch4);
		 map[1][4] = new Room();
		 map[2][0] = new Room();
		 map[2][1] = new Room(false,false,true,false,"Closet","Holds tools", Hatchet,witch1);
		 map[2][2]= new Room (true,false,false,true,"Main Hall", "Holds clues about the families past",turkey ,witch2);
		 map[2][3] = new Room();
		 map[2][4] = new Room();
		 map[3][0] = new Room();
		 map[3][1]  = new Room();
		 map[3][2] = new Room(true,false,false,false,"Front section of house", "Contains more clues and items",key2,witch2);
		 map[3][3] = new Room(false,false,false,false,"Dungeon ", "You have a chance to reedem yourself", healingPotion, gulagWitch);
		 map[3][4] = new Room();
		 map[4][0] = new Room();
		 map[4][1] = new Room();
		 map[4][2] = new Room(true,false,false,false,"Trophy Room", "Trophy Romm after defeating the Witch");
		 map[4][3] = new Room();
		 map[4][4] = new Room();





/*
 * TODO: Checkpoint 3 Tasks
 * 
 * initialize the values for your variables "row" and "column"
 * to represent the starting location of your game, 
 * then set the currentRoom to the starting location
 * 
 */
    row = 0;
    column = 2;
    currentRoom = map[row][column];
    
    
    
    

		
		String userInput = "";
		String command = "";
		String item = "";
		Scanner s = new Scanner(System.in);
		
//TODO: When you have made your game work in the console
//change done to true to play your game in the JFrame		
		boolean done = false;
		String output ="";
		if(!done){
			output = gameIntro();
			System.out.println(output);
		}
		
		while(!done){
			System.out.print("\n\n>>");      
			userInput = s.nextLine().toLowerCase();
			command = getFirstWord(userInput);
			item = getRestOfSentence(userInput);
			output = executeCommand(command, item);

/*
 * TODO: Checkpoint 3 Task
 * 
 * Update the currentRoom to the new location on the map
 * Hint: there is a new method for this, go to the bottom and make it
 * using the currentRoom object. 
 */


			getCurrentRoom();
			System.out.println(output +"\n"); 

			if(command.equals("quit"))
				done = true;
		  }
		  s.close();	
	}
	
/**
 * gameIntro method 
 * used to set the scene to the opening of your game 
 * @return: a String that is the opening description to your game, 
 *          be sure to note the help option 
 *          (i.e. "type help for a list of commands").  
 */

//TODO: Update this to your Intro (copy and paste it here)	
	public static String gameIntro(){
	return "Your are trapped  inside an abandoned house are entering it and there is an evil soul that is trying to kill you for entering."
 +"\nThe only way to stop her is to find her spawner and destroy it.The door to room holding the spawner is locked." 
+ "\nThe key must be forged back together. You must navigate the surrounding areas to find tools and items that will help you forge the key back." 
 + "\nWhile discovering other dark secrets that are hiding you will also find enemies and obstacles." 
 + "\nThis will require the use of the tools and knowledge you have to destroy them." 
+ "\n (Type \"help\" to see alist of commands)";
	}
	
/**
 * getFirstWord method
 * pulls the first word out of any phrase (1 or more words)
 * @param a string that contains the commands from the user
 * @return a string that is only the first word, 
 *         returns a blank string "" if nothing entered, 
 *         do not use print or println
 */
	
	public static String getFirstWord(String input){
		int spaceLocation = input.indexOf(" ");
		if(spaceLocation > 0)
			return input.substring(0,spaceLocation);
		if(input.length() >0)
			return input;
		return "";
	}

/**
 * getRestOfSentence 
 * pulls everything after the first word and the space behind it
 * @param a string that contains the commands from the user
 * @return a string that returns everything after the first word 
 *         and the space behind it, returns a blank string "" if 1 word entry 
 *         or nothing entered. 
 *         Do not use print or println
 */
		
	public static String getRestOfSentence(String input){
		int spaceLocation = input.indexOf(" ");
		if(spaceLocation >= 0)
			return input.substring(spaceLocation+1);
		return "";
	}	

	
/**
 * north method
 * Method to state that you moved north, you will add movement functionality
 * in checkpoint 3
 * @return a string that states you moved North, do not use print or println	
 */

/*
 * TODO: Checkpoint 3 Task
 * 
 * Update the "north" method to allow the player to move North only if possible
 * Be sure to both move the player north and state that the player moved North
 * If you cannot move North, then state that you cannot move North
 */

	public static String north(){
		if(currentRoom.getCanGoNorth()){
			row--;
			updateRoom();
			checkLocation();
			return "You moved North.";  
		} else {
			return "You may not move North";
		}
	}



/**
 * south method
 * Method to state that you moved south, you will add movement functionality
 * in checkpoint 3
 * @return a string that states you moved South, do not use print or println
 */		

/*
 * TODO: Checkpoint 3 Task
 * 
 * Update the "south" method to allow the player to move South only if possible
 * Be sure to move the player South and state that the player moved South
 * If you cannot move South, then state that you cannot move South
 */
	public static String south(){
		if(currentRoom.getCanGoSouth()){
			row++;
			updateRoom();
			checkLocation();
			return "You moved South.";  
		} else {
			return "You may not move South";
		}
	}

/**
 * east method
 * Method to state the you moved East,  you will add movement functionality in 
 * checkpoint 3
 * @return a string that states you moved East, do not use print or println
 */
	
/*
 * TODO: Checkpoint 3 Task
 * 
 * Update the "east" method to allow the player to move East only if possible
 * Be sure to both move the player East and state that the player moved East
 * If you cannot move East, then state that you cannot move East
 */
	public static String east(){
		if(currentRoom.getCanGoEast()){
			column++;
			updateRoom();
			checkLocation();
			return "You moved east.";  
		} else {
			return "You may not move east";
		}
	}

/**
 * west method
 * Method to state the you moved West, you will add movement functionality in 
 * checkpoint 3
 * @return a string that states you moved West, do not use print or println
 */
	
/*
 * TODO: Checkpoint 3 Task
 * 
 * Update the "west" method to allow the player to move West only if possible
 * Be sure to move the player West and state that the player moved West
 * If you cannot move West, then state that you cannot move West
 */
	
	public static String west(){
		if(currentRoom.getCanGoWest()){
			column--;
			updateRoom();
			checkLocation();
			return "You moved west.";  
		} else {
			return "You may not move west";
		}
	}
	//read the weight and adjust the take method
/**
 * take method
 * Method to allow you to take an item, for now you will just state that 
 * "You took the <itemName>." where <itemName> is the actual name of the item.
 * 
 * example return statement:
 * "You took the apple." 
 * 
 * You will actually pick up items in checkpoint 4
 * 
 * @param takes in a String to determine what object was picked up
 * @return a String that states "You took the <itemName>", do not use print or println
 */
public static String take(String input){
	String output = "You have successfully taken the item";
		if(currentRoom.hasObject(input)){
			InventoryItem x = currentRoom.removeObject(input);
			userInventory.add(x);
			} else {
				output = "This item does not exist";
			}
		return output;
}
				

			
		
	


/** 
 * drop method
 * Method to allow you to drop an item, for now you will just state that 
 * "You dropped the <itemName>." where <itemName> is the actual name of the item.
 * 
 * example return statement:
 * "You dropped the apple."
 * 
 * You will actually drop items in checkpoint 4
 * @param takes in a string to determine what object was dropped
 * @return a string that states "You dropped the <itemName>", do not use print or println 
 */
	
public static String drop(String objectName){
	String output = "You do not have that item in your inventory";
	//String output = "You dropped the " + objectName;
	for(int x = 0; x < userInventory.size(); x++){
		if(userInventory.get(x).getName().equalsIgnoreCase(objectName)){
			currentRoom.addObject(userInventory.remove(x));
			 output = "You dropped the " + objectName +".";
		}
		
	}
	return output;
}
	
	
	
/** 
 * look method
 * Method to allow you to look around the room
 * In checkpoint3, this will change to the room description
 *  @return a string that states "You looked around the room", do not use print or println
 */	
 
/*  
 * TODO: Checkpoint 3 task
 * 
 * update the "look" method to return the Name of the Room, 
 * then a new line, and then the room's description instead of its current output.
 */
 
	public static String look(){
		String output ="You looked around the " + currentRoom.getName() 
		+ currentRoom.getDescription();
		//if()
		return output;
	}
	
/** 
 * inventory method
 * Method to display the items in your inventory, for now state
 * "The current items in your inventory are:"
 * 
 * In checkpoint 4 you will create a String that consists of all of the 
 * items in your inventory
 *  @return the "The current items in your inventory are:", do not use print or println
 */
 
	public static  String inventory(){
		
	  String output ="";
	  //TODO add checkpoint inventory logic here
	  for(int x = 0; x < userInventory.size(); x++){
		  output += userInventory.get(x).getName() +", ";
	  }
		return "The current items in your inventory are:" + output;
	}	


	
/**
 * examine method
 * Method that returns the description on an item in your inventory, for now state:
 * "Description of <itemName>" where <itemName> is the itemName
 * 
 * example return statement:
 * "Description of apple"
 * 
 * In checkpoint 4 you will return the description of the object you are examining
 * @param takes in a string to determine what item you want the description of
 * @return a string that is the description of the item, do not use print or println
 */


	public static String examine(String item){
		String output = "You do not have this item in your inventory";
		for(int x = 0; x < userInventory.size(); x++){
			if(item.equalsIgnoreCase(userInventory.get(x).getName())){
				output = "You examined the " + item + "\tThis " + item + "offers you " + userInventory.get(x).getDescription() ;
			}
		}
		return output;
	}	

/**
 * eat method
 * Method that allows you to eat a Food object, for now state:
 * "You ate the <itemName>" where <itemName> is the name of the itemName
 * 
 * example return statement:
 * "You ate the apple."
 * 
 * In checkpoint 4, you will update this method to remove it from your inventory, 
 * but not drop it in the room.  Advanced: this could be useful for a health system
 * 
 * 
 * @param takes in a string to determine what item you want to eat
 * @return a string that states you ate the item, do not use print or println
 */	
 
	public static String eat(String item){
		double itemHealth = 0.0;
//		double healthOverFlow = 0.0;
		Food f;
		String output = "You do not have a "+ item;
		for(int i = 0; i < userInventory.size(); i++){
			if(userInventory.get(i).getName().equalsIgnoreCase(item)){
			if(userInventory.get(i) instanceof Food){
				 f = (Food)(userInventory.remove(i));
				itemHealth = f.getHealth();
				userHealth = userHealth + itemHealth;
				output = "You have enjoyed eating the " + item;
				//else statement removed as it was producing wrong string output 5/30
//				if(userHealth > 100){
//					healthOverFlow = userHealth - 100;
//					userHealth = 100;
//					f.setHealth(healthOverFlow);
//					userInventory.add(f);
//					output = output + ". The remaining health available for this " + item +" is " + f.getHealth();
//				}
			} else {
				output = "You can not eat this item. If it is a weapon or key try using those commands respectivly";
			}
		}
		}
		return output;
		}


/**  
 * use method
 * Method that allows you to use an item it, for now state:
 * "You used the <itemName>", where <itemName> is the name of the item.
 * 
 * example return statement:
 * "You used the apple."
 * 
 * In checkpoint 4 this will be updated to only allow the player to use a Key
 * in the room where the key can open a door
 * 
 * @param takes in a string to determine what item you want to use
 * @return a string that You used the item, do not use print or println
 */

//	public static String use(String item){
//		String output ="You used the " + item + ".";
//		for(int x = 0; x < userInventory.size(); x++){
//			if(userInventory.get(x).getName().equalsIgnoreCase(item)){
//				if(userInventory.get(x) instanceof Key ){
//					Key key1 = (Key)userInventory.get(x);
//					if(currentRoom.getName().equalsIgnoreCase(key1.getroomIWorkIN())){
//					String directionKey = key1.getDirectionToOpen();
//					if(directionKey.equalsIgnoreCase("north")){
//					currentRoom.setCanGoNorth(true);
//					output += "You are now able to travel north!";
//					} else if(directionKey.equalsIgnoreCase("east")){
//						currentRoom.setCanGoEast(true);
//						output += "You are now able to travel east!";
//					}	else if(directionKey.equalsIgnoreCase("west")){
//					currentRoom.setCanGoWest(true);
//					output += "You are now able to travel west!";
//					}else if(directionKey.equalsIgnoreCase("south")){
//					currentRoom.setCanGoSouth(true);
//					output += "You are now able to travel south!";
//					} else{
//						output = "This key does not open any doors";
//					}
//					}
//				}
//				
//				
//			}else{
//				output = "You do not have this item in your inventory or if it is a food or weapon try activating those commands";
//			}
//		}
//		return output;
//	}
	
	public static String use(String item){
		String output ="This item does not exist";
		Key key1;
		String directionKey = "";
		for(int x = 0; x < userInventory.size(); x++){
			if(item.equalsIgnoreCase(userInventory.get(x).getName())){
				if(userInventory.get(x) instanceof Key ){
					 key1 = (Key)userInventory.get(x);
					if(getCurrentRoom().getName().equalsIgnoreCase(key1.getroomIWorkIN())){
						 directionKey = key1.getDirectionToOpen();
						if(directionKey.equalsIgnoreCase("north")){
							currentRoom.setCanGoNorth(true);
						output = "You are now able to travel north!";
						}
						if(directionKey.equalsIgnoreCase("south")){
							currentRoom.setCanGoSouth(true);
						output = "You are now able to travel south!";
						}
						if(directionKey.equalsIgnoreCase("west")){
							currentRoom.setCanGoWest(true);
						output = "You are now able to travel west!";
						}
						if(directionKey.equalsIgnoreCase("east")){
							currentRoom.setCanGoEast(true);
						output = "You are now able to travel east!";
						}
					} else {
						output = "This key does not work for this room";
					}

				} else{
					output = "You do not have this item in your inventory or if it is a food or weapon try activating those commands";
				}

			}
		}
		return output;
	}

		
	
	
/**
 * help method
 * Method that returns all of the commands and what they do
 * 
 * example return output:
 * "Command      Example      Description
 *  take         take apple   used to pick up objects"
 * 
 * @return a String that contains all the command names, an example of use, and a description of what they do.  Be sure to consider readability of the player.  Do not use print or println.
 */
		
	public static  String help(){
		return "The following commands are used to play the game\n"
				+ "Command    Example      Description\n"
				+ "North      North        Allows you to move North\n"
				+ "South      south        Allows you to move South\n"
				+ "East       east         allows you to move East\n"
				+ "West       west         allows you to move West\n"
				+ "Look       Look         provides a detailed descriptoin of the room\n"
				+ "Take       take key     adds an item in a room to your inventory\n"
				+ "Drop       drop key     removes an item from your inventory and leaves it in the room\n"
				+ "Inventory  inventory    displays the names of items in your inventory\n"
				+ "Examine    examine key  provides a detailed description of the specified item, it must be in your inventory\n"
				+ "Eat        eat apple    Allows you to eat an edible item\n"
				+ "Use        use key      Allows you to use the item\n"
				+ "Help       help         displays the help menu\n"
				+ "Quit       quit         player initiated end of game\n";
	}

	
/**
 * quit Method
 * Method that states "You have decided to quit the game"
 * @return a message saying You have decided to quit the game, do not use print or println
 */
	
	public static  String quit(){
		 
		return "You have decided to quit the game.";
		
	}
	
/**
 * invalid method
 * Method called when a player tries a command that is not used in the game
 * @return message "I do not understand", do not use print or println
 */
	
	public static  String invalid(){
		return "I do not understand.";
	}
public static String Kit(){
	String output = "you have already activated this cheat once before";
	if(cheatActivated == 0){
	output = "Cheat Activated, Player has been a starter kit you have been given a hatchet, bread, and a flashlight";
	userInventory.add(Hatchet);
	userInventory.add(bread);
	userInventory.add(goldenApple);
	cheatActivated++;
	}

		return output;
	}
	public static String currentHealth(){
		return "Your current health is " + userHealth;
	}
	
public static String  zapCheat(){
	userInventory.add(zapguns);
	return "You have recieved the zap guns";
}

public static String shoot(String item){
	String output = "You do not harness that weapon";
	double weaponDamage = 0.0;
	for(int x = 0; x < userInventory.size();x++){
		if(currentRoom.bringNpc() == null){
			output = "There are no more enemies in this room";
		}else if(userInventory.get(x).getName().equalsIgnoreCase(item)){
				Weapons gun = (Weapons)userInventory.get(x);
				weaponDamage = gun.getWeaponDamage();
				Npc w = currentRoom.bringNpc();
				w.setHealth(weaponDamage);
				updatePlayerHealth(w.getDamage());
				output = "you have injured the " + currentRoom.getNpcName() +" the remaining health is " + w.getHealth() + "\n Your remaining ammo count for this weapon is " + gun.updateAmmo();
				if(gun.getACount() == 0){
					userInventory.remove(x);
					output = "You have ran out of ammo for this weapon so you can no longer use it.";
				}
				
				if(w.getHealth() <= 0){
					output = "you have killed the witch, congratulations.";
					currentRoom.setNpc();
					output = "There are no more enemies in this room";	
			}
			//output = "There are no more enemies in this room";	
		}
	}
	
	if(currentRoom == map[3][3]){
		gulag();
	}
	
	if(currentRoom == map[1][1]){
		bossFight();
		//currentRoom.setCanGoSouth(false);
		
	}
		
		return output;
		
	}


public static void updatePlayerHealth(double damageInput){
	String output = "You have died. You have been sent to the dungeon where you can fight for a second chance at life";
	userHealth = userHealth - damageInput;
	if(userHealth <= 0 ){
		if(currentRoom != map[4][3]){
		currentRoom = map[3][3];
		userHealth = 100;
		System.out.println(output);
		gulag();
		
		//quit();
		}
	}
}

public static void gulag(){
	String output = "You have died in the gulag";
//	userHealth = 100;
	if(gulagWitch.getHealth() < 0 && userHealth > 0){
		output = "Congratulations! You have defeated the witch. You will be sent back to the house but with only 25 health. Now. Go out there and redeem yourself. But another potion of healing has been added to your inventory that only does 125 extra health This potion is called 'potion of healingII'";
		System.out.println(output);
		currentRoom = map[1][2];
		userHealth = 25.0;
		userInventory.add(healingPotionII);
	}else if (gulagWitch.getHealth() > 0 && userHealth < 1){
		quit();
		output = "Dang, thats tough. You have lost the game";
		System.out.println(output);
	} else if(gulagWitch.getHealth() < 1 && userHealth < 1){
		quit();
		output = "You defeated the witch, but you also died doing it. Thats tough. :(";
		System.out.println(output);
	}
	//return output;
}


public static void bossFight(){
	String output = "You have died in the the basement fighting the boss";
	if(basementWitch.getHealth() < 1 && userHealth > 0){
		output = "Congratulations! You have defeated the witch. You will be able to go back into the house with full health but first take a look aroung.";
		System.out.println(output);
		currentRoom.setCanGoSouth(true);
		currentRoom.addObject(key3);
		currentRoom.addObject(apple);
	}else if (basementWitch.getHealth() > 0 && userHealth < 1){
		quit();
		output = "Dang, thats tough. You have lost the game";
		System.out.println(output);
	} else if(basementWitch.getHealth() < 1 && userHealth < 1){
		quit();
		output = "You defeated the witch, but you also died doing it. Thats tough. :(";
		System.out.println(output);
	}
	//return output;
}
//}

public static void checkLocation(){
	//String output = "";
	if (currentRoom == map[1][1]){
		if(currentRoom.getNpcName() != ""){
		userHealth = 350;
		currentRoom.setCanGoSouth(false);
		userInventory.add(raygun);
		System.out.println( "You have recieved the raggun, your health has been temporarily raised to 350 as you face the final boss. Here the boss has a health of 300 and you must defeat to win the game");
		}else if(currentRoom.getNpcName() == ""){
			System.out.println("Welcome back player.");
		}
	}
	
	if(currentRoom == map[4][2]){
		System.out.println("Congratulations you have reached the trophy room and have destroyed the boss witch. You have defended the house from the evils. You have now completed the game. :)");
		quit();
	}
//	return output;
}
/**
 * executeCommand method
 * This method uses the first word to call the appropriate method that you
 * made above.  Basically, this method manages complexity by hosting the 
 * logic to determine which method should be used.
 * (for example, if the command is north, call the north() method). 
 * @param the String command used to check which method to call
 * @param the String item used for methods that interact with objects 
 * @return a String that is passed back from the appropriate method, 
 *         do not use print or print linen
 */
		
	public static String executeCommand(String command, String item){
		if(command.equals("north"))
			return north();
		if(command.equals("south"))
			return south();
		if(command.equals("east"))
			return east();
		if(command.equals("west"))
			return west();
		if(command.equals("inventory"))
			return inventory();
		if(command.equals("look"))
			return look();
	    if(command.equals("take"))
			return take(item);
		if(command.equals("drop"))
			return drop(item);
		if(command.equals("examine"))
			return examine(item);
		if(command.equals("eat"))
			return eat(item);
		if(command.equals("use"))
			return use(item);
		if(command.equals("help"))
			return help();
		if(command.equals("quit"))
			return quit();
		if(command.equals("starter"))
			return Kit();
		if(command.equals("health"))
			return currentHealth();
		if(command.equals("zapguns"))
			return zapCheat();
		if(command.equals("shoot"))
			return shoot(item);
		return invalid();
				
	}

/**  
 * updateRoom method
 * Method to update the room you are in (currentRoom)
 * this method uses the row and column values to 
 * update the currentRoom location
 * no parameters or return values
 */
/*
 * TODO: Checkpoint 3 Task
 * 
 * make the updateRoom method
 */
	public static void updateRoom(){
		//checkLocation();
		currentRoom = map[row][column];
		
	}
			
/**
 * 	getCurrentRoom method
 *  In order to work with the JFrame, we need a way to get the room
 *  create an accessor method that returns the currentRoom called getCurrentRoom
 * @return 
 *  @return the current room, but sure to update the room first
 */

/* 
 * TODO: Checkpoint 3 Task
 * 
 * make the getCurrentRoom method
 */
	
public static  Room getCurrentRoom(){
	return currentRoom;
}

// checkpoint commands

//initalizing player array 
 //userInventory = new ArrayList<InventoryItem>();
// certain objects might be added later on in after final testing
public static Key key1 = new Key("spawnkey", "Key to unlock a metal door", "Main hall", "south");
public static Weapons knife = new Weapons("Knife", "A knife you can use to defend yourself", 0.3, 30.0, 0);
public static Food bread = new Food("Bread", "eat to replenish some health", .1 , 10.0);
//public static Weapons flashlight = new Weapons("FlashLight","Can increase your field of view", .3, 0.0, 0);
public static Key key2 = new Key("basement Key", "Key to unlock the basement", "closet", "north");
public static Key key3 = new Key("Trophy key", "Used to unlock the treasure lurking in the house", "Front section of house", "south");
public static Weapons Hatchet = new Weapons("Hatchet", "Can knock down objects including doors", 3.7,45.0, 30);
//public static Weapons nightpotion = new Weapons("Night Potion", "Can automatically tell you what objects are nearby", .15, 0.0,0);
public static Weapons zapguns = new Weapons("zapgun", "Can be shot to release a shot of energy which has a chain affect",2.5,35.0,12);
public static Food turkey = new Food("turkey","Consume to regain 30 health", .5,30.0);
public static Npc witch1 = new Npc("Ice Witch", 100.0, "A enemy that can hurt you by shooting ice crystals that can disable your weapons and take 20 health",15.0);
public static Npc witch2 = new Npc("Fire Witch", 100.0, "A enemy that can hurt you by shooting fire balls that can cause additional damage over time if you do not leave the room",25.0);
public static Npc witch3 = new Npc("Ice Witch", 100.0, "A enemy that can hurt you by shooting ice crystals that can disable your weapons and take 20 health",15.0);
public static Npc witch4 = new Npc("Fire Witch", 100.0, "A enemy that can hurt you by shooting fire balls that can cause additional damage over time if you do not leave the room",25.0);	
public static Npc gulagWitch = new Npc("Dungeon Witch", 500.0 ,"You must defeat this witch to be able to go back to house and have a second chance to win. This Witch can fire balls of electricity", 45.0);
public static Food healingPotion = new Food("potion of healing", "Consume to recieve an instant 80 to your health", .7, 800.0);
public static Food healingPotionII = new Food("potion of healingII", "Consume to recieve an instant 80 to your health", .7, 125.0);
public static Npc basementWitch = new Npc("Boss Witch", 300.0, "You must defeat this boss to win! This boss shoots balls of strong winds", 30.0);
public static Weapons raygun = new Weapons("raygun", "Can a shoot a power laserbeam that does a lot of damage", 3.0, 50.0,15);
public static Food apple = new Food("apple","Consume to regain health",.5,25.0);
public static Food goldenApple = new Food("golden apple", "Consume to regain health", .7, 60.0);
	//DO NOT TOUCH
	public static void main(String[] args){
		
		runGame();
	}
}

