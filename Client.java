package Projects;

public class Client implements Absher{
	// class attrs
	private String Name;
	private int Age;
	private boolean ClearViolationRecord;
	private Room[] Rooms = new Room[3];
	private int numOfRooms = 0;
	
	// constructors
	
	// parameterized constructor;
	public Client(String Name,int Age,boolean ClearViolationRecord) {
		this.setName(Name);
		this.setAge(Age);
		this.setViolationRecord(ClearViolationRecord);
	}
	
	// copy constructor
	public Client(Client Original) {}
	
	// helping methods
	
	
	// setters
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public void setAge(int Age) {
		if(this.isValidAge(Age))
			this.Age = Age;
		else
			System.out.println("Client Can't Book a Room due to Age Restrictions!");
	}
	
	public void setViolationRecord(boolean isClear) {
		this.ClearViolationRecord = isClear;
	}
	// getters
	public String getName() {
		return this.Name;
	}
	
	public int getAge() {
		return this.Age;
	}
	
	public boolean getViolationRecord() {
		return this.ClearViolationRecord;
	}
	
	public int getNumOfRooms() {
		return this.numOfRooms;
	}
	
	// class related methods
	public boolean isValidAge(int Age) {
		/* ----------------------------------------
		 * Abstract: this method check if Client's Age > AgeBoundary set by Absher System
		 * 
		 * 
		 * Parameters: None
		 * 
		 * Returns : boolean
		 *  ----------------------------------------
		 * */
		return Age > Absher.AgeBounary;
	}
	
	public boolean Equals(Client Client) {
		/* ----------------------------------------
		 * Abstract: this methods check if the invoker & input are equal
		 * 
		 * 
		 * Parameters: Client Client
		 * 
		 * Returns : boolean
		 *  ----------------------------------------
		 * */
		return (this.getName().equals(Client.getName()) && this.getAge() == Client.getAge() && this.getViolationRecord() == Client.getViolationRecord() && this.getNumOfRooms() == Client.getNumOfRooms());
	}
	
	public Room Search(Room Room) {
		for(int i = 0; i < this.getNumOfRooms() ; i++) {
			if(this.Rooms[i].equals(Room))
				return Room;
		}
		throw new IllegalArgumentException("not Found");
	}
	
	public void addRoom(Room Room) {
		/* ----------------------------------------
		 * Abstract: this methods adds a descendant of Room to Rooms list in instance of Client
		 * 
		 * 
		 * Parameters: Room Room
		 * 
		 * Returns : void
		 *  ----------------------------------------
		 * */
		if(this.getNumOfRooms() < this.Rooms.length)
			this.Rooms[this.numOfRooms++] = Room;
	}
	
	
	
	public void removeRoom(Room Room) {
		/* ----------------------------------------
		 * Abstract: this methods removes Room from Rooms in instance of Client
		 * 
		 * 
		 * Parameters: Room Room
		 * 
		 * Returns : void
		 * ----------------------------------------
		 * */
		for(int i = 0; i < this.getNumOfRooms() ; i++) {
			if(this.Rooms[i].getAddress().equalsIgnoreCase(Room.getAddress())) {
				this.Rooms[i] = this.Rooms[this.numOfRooms - 1];
				this.Rooms[this.numOfRooms - 1] = null; // safe code practice ( to prevent garbage collector from freeing up memory )
				this.numOfRooms--;
				break;
			}
		}
	}
	
	
	
	
	
	public String displayInfo() {
		/*
		 * ----------------------------------------
		 * Abstraction : this method prints all Client's object attributes
		 * 
		 * Parameters : None
		 * 
		 * Returns : String to be used in toString method
		 * ----------------------------------------
		 * */
		return ("Client Info| Name: " + this.getName() + " , Age: " + this.getAge() + " , Clear Violation Record: " + this.getViolationRecord() + ", Client Has " + this.getNumOfRooms() + " Rooms.");
	}
	
	@Override
	public String toString() {
		return this.displayInfo();
	}
	
}
