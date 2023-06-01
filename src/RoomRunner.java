
//DO NOT TOUCH THIS FILE 
//IT TESTS IF YOUR ROOM FUNCTIONS PROPERLY

public class RoomRunner {

	public static void main(String[] args) {
		int errorCounter = 0;  
		
		//build a default room
		Room room1 = new Room();              
		
		//Tests if you can a custom room
		Room room2 = new Room(true,false, true, false, "Hall","All directions");
		
		System.out.println("This section tests your default constructor");
		testRoom(room1);
		
		
		
		errorCounter = testRoom(room2);
		System.out.println("\n");
		
		System.out.println("This section tests your constructor with parameters");
		System.out.println(errorCounter+ " error(s) were encountered when running test cases on your room class using the constructed room");
		System.out.println("Note that one error could be counted in multiple test cases, so fixing 1 issue may resolve multiple errors.");
		System.out.println("\n Scroll to the top to read all comments");

	}
	
	public static int testRoom(Room room){
		int numErrors = 0;
		if(room.getName().equals("Hall")){
			if(!(room.getDescription().equals("All directions"))){
				numErrors++;
			}
			for(int a = 0; a <2; a++){
				boolean b1 = true;
				if(a%2 == 1)
					b1 = false;
				for(int b = 0; b <2; b++){
					boolean b2 = true;
					if(b%2 == 1)
						b2 = false;
					for(int c = 0; c <2; c++){
						boolean b3 = true;
						if(c%2 == 1)
							b3 = false;
						for(int d = 0; d <2; d++){
							boolean b4 = true;
							if(d%2 == 1)
								b4 = false;
							 numErrors += directionTest(room, b1, b2, b3, b4);
						}
					}
				}	
			}
				
			room.setName("Updated");
			room.setDescription("No exit");		
			
			if(!room.getName().equals("Updated"))
				numErrors++;
			if(!room.getDescription().equals("No exit"))
				numErrors++;
				
				
		} else {
			System.out.println("This should print out all of the fields for your room");
			System.out.println("All fields of the form canGo<Direction> should be false \nyour room name should state: Not a room \nthe description should say:  you shouldn't be here");
			System.out.println("\nYour toString output:");
			System.out.println(room.toString());
		}
		
		return numErrors;
	}

	public static int directionTest(Room room, boolean n, boolean s, boolean e, boolean w){
		int errorCount = 0;
		room.setCanGoEast(e);
		room.setCanGoWest(w);
		room.setCanGoNorth(n);
		room.setCanGoSouth(s);
		if(!(n == room.getCanGoNorth())){
			errorCount++;
		}
		if(!(s == room.getCanGoSouth())){
			errorCount++;
		}
		if(!(e == room.getCanGoEast())){
			errorCount++;
		}
		if(!(w == room.getCanGoWest())){
			errorCount++;
		}
		return errorCount;
	}
	
}
