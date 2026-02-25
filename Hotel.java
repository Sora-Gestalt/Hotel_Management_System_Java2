package Projects;

public class Hotel implements MOMAH,HotelHRreqs {
	// class attr
	private String name;
	private Room[] Rooms;
	private HotelEmployee[] HotelEmployees;
	private Client[] Clients;
	private String[] Addresses;
	private int NumOfRooms;
	private int NumOfEmployees;
	private int NumOfClients;
	
	

	// constructors
	
	
	// parameterized constructor
	public Hotel(int HotelRoomsCapacity,int HotelEmployeesCapacity,int HotelClientsCapacity){
		Rooms = new Room[HotelRoomsCapacity];
		HotelEmployees = new HotelEmployee[HotelEmployeesCapacity];
		Clients = new Client[HotelClientsCapacity];
		Addresses = new String[HotelRoomsCapacity];
	}
	
	// copy constructor
	
	public Hotel(Hotel Original) {
		
		this.Rooms = new Room[Original.Rooms.length];
		this.HotelEmployees = new HotelEmployee[Original.HotelEmployees.length];
		this.Clients = new Client[Original.Clients.length];
		this.NumOfEmployees = Original.NumOfEmployees;
		this.NumOfRooms = Original.NumOfRooms;
		this.NumOfClients = Original.NumOfClients;
		
		for(int i = 0; i < Original.getNumOfRooms() ; i ++) {
			this.Rooms[i] = Original.Rooms[i];
		}
		
		for(int j = 0; j < Original.getNumOfEmployees(); j++) {
			this.HotelEmployees[j] = Original.HotelEmployees[j];
		}
		
		for(int k = 0 ; k < Original.getNumOfClients(); k ++) {
			this.Clients[k] = Original.Clients[k];
		}
		
	}
	
	// helping methods
	

	
	
	private boolean uniqueAddress(String Address) {
		/* ----------------------------------------
		 * Abstract: this methods checks if Address is Unique in instance of hotel
		 * 
		 * 
		 * Parameters: Address String
		 * 
		 * Returns : boolean
		 *  ----------------------------------------
		 * */
		for(int i = 0; i < this.getNumOfRooms() ; i++) {
			if(this.Rooms[i].getAddress().equals(Address))
				return false;
		}
			return true;
	}
	
	// setters
	public void setName(String name) {
		this.name = name;
	}
	
	// getters
	public String getName() {
		return this.name;
	}
	
	public int getNumOfRooms(){
		return this.NumOfRooms;
	}
	
	public int getNumOfEmployees() {
		return this.NumOfEmployees;
	}
	
	public int getNumOfClients() {
		return this.NumOfClients;
	}
	// class related methods
	
	
	// recursion method
	private int calculateRevenueRecursion(Room[] Rooms , int n) {
		/* ----------------------------------------
		 * Abstract: this method is a recursion method to find total revenue in instance of hotel using getPrice method for each descendant of Room Class
		 * The method uses a wrapper getRevenue to ensure accurate calculations
		 * 
		 * 
		 * Parameters: Rooms Room[] & n int ( number of rooms inside Rooms )
		 * 
		 * Returns : int
		 *  ----------------------------------------
		 * */
		if(n <= 0)
			return 0;
		
		return this.Rooms[n-1].getPrice() + calculateRevenueRecursion(Rooms,n-1);
	}
	
	
	// wrapper method for the recursion method
	public int getRevenue() {
		return this.calculateRevenueRecursion(this.Rooms, this.NumOfRooms);
	}
	
	// MOMAH Interface Requirements
	public boolean isFollowingStructureCode() {
		/* ----------------------------------------
		 * Abstract: this methods checks if hotel instance satisfies two methods conditions "EmployeesLessThanFifty" & "ManagersLessThanFive"
		 * 
		 * 
		 * Parameters: None
		 * 
		 * Returns : boolean
		 *  ----------------------------------------
		 * */
		return (this.ManagersLessThanFive() && this.EmployeesLessThanFifty());
	}
	
	// HotelHRreqs Interface Requirements
	public boolean ManagersLessThanFive() {
		/* ----------------------------------------
		 * Abstract: this methods checks if total number of managers inside instance of hotel is less than 5
		 * 
		 * 
		 * Parameters: None
		 * 
		 * Returns : boolean
		 *  ----------------------------------------
		 * */
		int counter = 0;
		for(int i = 0; i < this.getNumOfEmployees(); i++) {
			if(this.HotelEmployees[i] instanceof Manager)
				counter++;
		}
		return counter < 5;
	}
	
	public boolean EmployeesLessThanFifty() {
		/* ----------------------------------------
		 * Abstract: this methods checks if total number of employees inside hotel instance is less than 50
		 * 
		 * 
		 * Parameters: None
		 * 
		 * Returns : boolean
		 *  ----------------------------------------
		 * */
		int counter = 0;
		for(int i = 0; i < this.getNumOfEmployees(); i++) {
			if(!(this.HotelEmployees[i] instanceof Manager))
				counter++;
		}
		return counter < 50;
	}
	
	public int SearchRoom(Room Room) {
		/* ----------------------------------------
		 * Abstract: this method finds Room inside Rooms return it's index if found else throw exception
		 * 
		 * 
		 * Parameters: Room Room(descendant) 
		 * 
		 * Returns : int
		 *  ----------------------------------------
		 * */
		for(int i = 0; i < this.getNumOfRooms() ; i++) {
			if(this.Rooms[i].getAddress().equals(Room.getAddress()))
				return i;
		}
		
		throw new IllegalArgumentException("not found.");
	}
	
	
	
	public void addRoom(Room Room) {
		/* ----------------------------------------
		 * Abstract: this methods adds a Room descendant to Rooms list of instance of Hotel
		 * 
		 * 
		 * Parameters: Room Room(descendant) 
		 * 
		 * Returns : void
		 *  ----------------------------------------
		 * */
		if(this.getNumOfRooms() < this.Rooms.length && this.uniqueAddress(Room.getAddress()))
			this.Rooms[this.NumOfRooms++] = Room;
		else
			System.out.println("Hotel Rooms Capacity is Full Or Address Isn't Unique!");
	}
	
	
	public void removeRoom(Room Room) {
		/* ----------------------------------------
		 * Abstract: this methods removes a Room descendant from Rooms list of instance of Hotel
		 * 
		 * 
		 * Parameters: Room Room(descendant) 
		 * 
		 * Returns : void
		 *  ----------------------------------------
		 * */
		for(int i = 0 ; i < this.getNumOfRooms(); i++) {
			if(this.Rooms[i].getAddress().equalsIgnoreCase(Room.getAddress())) {
				this.Rooms[i] = this.Rooms[this.NumOfRooms -1];
				this.Rooms[this.NumOfRooms-1] = null;
				this.NumOfRooms--;
				System.out.println("Room Removed!");
				break;
			}
		}
	}
	
	public int SearchClient(Client Client) {
		/* ----------------------------------------
		 * Abstract: this methods finds Client inside Clients return it's index if found else throw exception
		 * 
		 * 
		 * Parameters: Room Room(descendant) 
		 * 
		 * Returns : int
		 *  ----------------------------------------
		 * */
		
		for(int i = 0; i < this.getNumOfClients(); i++) {
			if(this.Clients[i].Equals(Client))
				return i;
		}
		throw new IllegalArgumentException("not found.");
	}
	
	
	public void addClient(Client Client) {
		/* ----------------------------------------
		 * Abstract: this methods adds an Client instance to Clients list of instance of Hotel
		 * 
		 * 
		 * Parameters: Client Client 
		 * 
		 * Returns : void
		 *  ----------------------------------------
		 * */
		if(this.getNumOfClients() < this.Clients.length)
			this.Clients[this.NumOfClients++] = Client;
	}
	
	public void removeClient(Client Client) {
		/* ----------------------------------------
		 * Abstract: this methods removes a Client from Clients list of instance of Hotel
		 * 
		 * 
		 * Parameters: Employee HotelEmployee(descendant) 
		 * 
		 * Returns : void
		 *  ----------------------------------------
		 * */
		for(int j = 0; j < this.NumOfClients ; j++) {
			if(this.Clients[j].Equals(Client)) {
				this.Clients[j] = this.Clients[this.NumOfClients - 1];
				this.Clients[this.NumOfClients - 1] = null;
				this.NumOfClients--;
				System.out.println("Client Removed!");
				break;
			}
		}
	}
	
	public int SearchEmployee(HotelEmployee Employee) {
		/* ----------------------------------------
		 * Abstract: this methods finds Employee inside HotelEmployees return it's index if found else throw exception
		 * 
		 * 
		 * Parameters: Room Room(descendant) 
		 * 
		 * Returns : int
		 *  ----------------------------------------
		 * */
		
		for(int i = 0; i < this.getNumOfEmployees(); i++) {
			if(this.HotelEmployees[i].Equals(Employee))
				return i;
		}
		throw new IllegalArgumentException("not found.");
	}
	
	public void addEmployee(HotelEmployee Employee) {
		/* ----------------------------------------
		 * Abstract: this methods adds an HotelEmployee descendant to Employees list of instance of Hotel
		 * 
		 * 
		 * Parameters: Employee HotelEmployee(descendant) 
		 * 
		 * Returns : void
		 *  ----------------------------------------
		 * */
		if(this.getNumOfEmployees() < this.HotelEmployees.length)
			// if instance Manager
			if(Employee instanceof Manager && this.EmployeesLessThanFifty())
				this.HotelEmployees[this.NumOfEmployees++] = Employee;
			// other instances
			else if (this.EmployeesLessThanFifty())
				this.HotelEmployees[this.NumOfEmployees++] = Employee;
		
	}
	public void removeEmployee(HotelEmployee Employee) {
		/* ----------------------------------------
		 * Abstract: this methods removes an HotelEmployee descendant from Employees list of instance of Hotel
		 * 
		 * 
		 * Parameters: Employee HotelEmployee(descendant) 
		 * 
		 * Returns : void
		 *  ----------------------------------------
		 * */
		for(int k = 0; k < this.NumOfEmployees ; k++) {
			if(this.HotelEmployees[k].Equals(Employee)) {}
		}
	}
	
	public String displayInfo() {
		/*
		 * ----------------------------------------
		 * Abstraction : this method prints all Hotel's object attributes
		 * 
		 * Parameters : None
		 * 
		 * Returns : String to be used in toString method
		 * ----------------------------------------
		 * */
		return ("Hotel: " + this.getName() + "\n Number Of Rooms: " + this.getNumOfRooms() + ", Number Of Employees: " + this.getNumOfEmployees() + ", Number Of Clients: " + this.getNumOfClients());
	}
	
	@Override
	public String toString() {
		return this.displayInfo();
	}
	
	public void displayAllInfo() {
		/*
		 * ----------------------------------------
		 * Abstraction : this method prints all Hotel's attributes & Client's Attributes & Employees Attributes & Rooms Attributes
		 * 
		 * Parameters : None
		 * 
		 * Returns : void
		 * ----------------------------------------
		 * */
		System.out.println(this);
		System.out.println("| Rooms Info");
		System.out.println("------------------------------------------------");
		
		for(int i = 0 ; i < this.getNumOfRooms() ; i++) {
			System.out.println(this.Rooms[i]);
		}
		System.out.println("------------------------------------------------");
		
		System.out.println("\n\n\n Clients Info");
		System.out.println("------------------------------------------------");
		for(int j = 0; j < this.getNumOfClients() ; j++) {
			System.out.println(this.Clients[j]);
		}
		System.out.println("------------------------------------------------");
		
		System.out.println("\n\n\n Employees Info");
		System.out.println("------------------------------------------------");
		for(int k = 0; k < this.getNumOfEmployees() ; k++) {
			System.out.println(this.HotelEmployees[k]);
		}
		System.out.println("------------------------------------------------");
		
	}
	
}
