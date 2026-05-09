package Projects;

import java.math.*;


import java.io.*;

public class Hotel implements MOMAH,HotelHRreqs,Serializable {
	// class attr
	private String name;
	private LinkedList Rooms;
	private LinkedList HotelEmployees;
	private LinkedList Clients;
	private LinkedList Addresses;
	
	
	
	private static int numOfEmployeesDeptManagers = 0;
	private static int numOfSecurityDeptManagers = 0;
	private static int numOfResturantDeptManagers = 0;
	private static int numOfCleanerDeptManagers = 0;
	private static int numOfRoomsDeptManagers = 0;
	private static int numOfReciptionests = 0;
	// constructors
	
	
	// parameterized constructor
	public Hotel(String name){
		this.setName(name);
		this.Rooms = new LinkedList();
		this.HotelEmployees = new LinkedList();
		this.Clients = new LinkedList();
		this.Addresses = new LinkedList();
		
	}
	
	// copy constructor
	
	public Hotel(Hotel Original) {
		this.setName(Original.getName());
		this.Rooms = new LinkedList();
		this.HotelEmployees = new LinkedList();
		this.Clients = new LinkedList();
		this.Addresses = new LinkedList();
		
		Node current = Original.Rooms.getHead();
		while(current != null) {
			this.Rooms.insertAtBack(current.data);
			current = current.next;
		}
		
		current = Original.HotelEmployees.getHead();
		while(current != null) {
			this.HotelEmployees.insertAtBack(current.data);
			current = current.next;
		}
		
		current = Original.Clients.getHead();
		while(current!=null) {
			this.Clients.insertAtFront(current.data);
			current = current.next;
		}
		
		current = Original.Addresses.getHead();
		while(current!=null) {
			this.Addresses.insertAtFront(current.data);
			current = current.next;
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
		Node current = this.Rooms.getHead();
		while(current != null) {
			Room r = (Room) current.data;
			if (r.getAddress().equals(Address))
				return false;
			current = current.next;
		}
			return true;
	}
	
	// setters
	public void setName(String name) {
		try {
			if(name.length() == 0) {
				throw new InvalidHotelName("Hotel Name is Empty!");
			}
				this.name = name;
		}
		
		catch(InvalidHotelName e) {
			System.out.println(e);
		}
	}
	
	// getters
	public String getName() {
		return this.name;
	}
	
	public int getNumOfRooms() {
		return this.Rooms.size();
	}
	
	public int getNumOfClients() {
		return this.Clients.size();
	}
	
	public int getNumOfEmployees() {
		return this.HotelEmployees.size();
	}
	
	public int getNumOfEmployeesDeptManagers() {
		return this.numOfEmployeesDeptManagers;
	}
	
	public int getNumOfSecurityDeptManagers() {
		return this.numOfSecurityDeptManagers;
	}
	
	public int getNumOfResturantDeptManagers() {
		return this.numOfResturantDeptManagers;
	}
	
	public int getNumOfCleaningDeptManagers() {
		return this.numOfCleanerDeptManagers;
	}
	
	public int getNumOfRoomsDeptManagers() {
		return this.numOfRoomsDeptManagers;
	}
	
	public int getNumOfReciptionests() {
		return this.numOfReciptionests;
	}
	// class related methods
	
	
	// recursion method
	private int calculateRevenueRecursion(Node node) {
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
		if (node == null)
			return 0;
		
		Room currentRoom = (Room) node.data;
		return currentRoom.getPrice() + calculateRevenueRecursion(node.next);
	}
	
	
	// wrapper method for the recursion method
	public int getRevenue() {
		return this.calculateRevenueRecursion(this.Rooms.getHead());
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
		Node current = this.HotelEmployees.getHead();
		while(current != null) {
			if ( current.data instanceof Manager)
				counter++;
			current = current.next;
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
		Node current = this.HotelEmployees.getHead();
		while(current!=null) {
			if(!(current.data instanceof Manager))
				counter++;
			current = current.next;
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
		Node current = this.Rooms.getHead();
        int index = 0;
        while (current != null) {
            if (((Room) current.data).getAddress().equals(Room.getAddress()))
                return index;
            current = current.next;
            index++;
        }
        throw new IllegalArgumentException("Room not found.");
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
		if(this.uniqueAddress(Room.getAddress()))
			this.Rooms.insertAtBack(Room);
		else
			System.out.println("Address Isn't Unique!");
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
		try {
			int index = this.SearchRoom(Room);
			this.Rooms.removeAtIndex(index);
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
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
		
		Node current = this.Clients.getHead();
        int index = 0;
        while (current != null) {
            if (((Client) current.data).Equals(Client))
                return index;
            current = current.next;
            index++;
        }
        throw new IllegalArgumentException("Client not found.");
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
		this.Clients.insertAtBack(Client);
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
		try {
			int index = this.SearchClient(Client);
			this.Clients.removeAtIndex(index);
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
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
		
		Node current = this.HotelEmployees.getHead();
		int index = 0;
		while(current != null) {
			if(((HotelEmployee) current.data).Equals(Employee))
				return index;
			current = current.next;
			index++;
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
		if(this.EmployeesLessThanFifty()) {
			
			if (Employee instanceof Manager) {
				Manager m = (Manager) Employee;
				String dept = m.getManagerDept();
				
				if (dept.equalsIgnoreCase("Employees")) {
	                numOfEmployeesDeptManagers++;
	            } else if (dept.equalsIgnoreCase("Rooms")) {
	                numOfRoomsDeptManagers++;
	            } else if (dept.equalsIgnoreCase("Resturant")) {
	                numOfResturantDeptManagers++;
	            } else if (dept.equalsIgnoreCase("Security")) {
	                numOfSecurityDeptManagers++;
	            } else if (dept.equalsIgnoreCase("Cleaning")) {
	                numOfCleanerDeptManagers++;
	            }
			}
			
			else if (Employee instanceof Reciptionest) {
				numOfReciptionests++;
			}
			
			this.HotelEmployees.insertAtBack(Employee);
		}
		
		else {
			System.out.println("Cannot add employee: HR limit(50) reached");
		}	
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
		Node current = this.HotelEmployees.getHead();
		int index = 0;
		
		while(current!=null) {
			HotelEmployee currentEmp = (HotelEmployee) current.data;
			
			if(currentEmp.Equals(Employee)) {
				if(currentEmp instanceof Manager) {
					Manager m = (Manager) currentEmp;
					String dept = m.getManagerDept();
					
					if (dept.equalsIgnoreCase("Employees")) {
	                    numOfEmployeesDeptManagers--;
	                } else if (dept.equalsIgnoreCase("Rooms")) {
	                    numOfRoomsDeptManagers--;
	                } else if (dept.equalsIgnoreCase("Resturant")) {
	                    numOfResturantDeptManagers--;
	                } else if (dept.equalsIgnoreCase("Security")) {
	                    numOfSecurityDeptManagers--;
	                } else if (dept.equalsIgnoreCase("Cleaning")) {
	                    numOfCleanerDeptManagers--;
	                }
				}
				
				else if (currentEmp instanceof Reciptionest) {
					numOfReciptionests--;
				}
				
				
				try {
					this.HotelEmployees.removeAtIndex(index);
					System.out.println("Employee Removed!");
					return;
				}
				
				catch(IllegalArgumentException e) {
					System.out.println("Employee not found.");
					return;
				}
				
				catch(NodeDoesntExistException e) {
					System.out.println("Error removing employee: " + e.getMessage());
					return;
				}
				
		
			}
			current = current.next;
			index++;
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
	
	public LinkedList getClients() {
		return this.Clients;	
	}
	
	public LinkedList getRooms() {
		return this.Rooms;
	}
	
	public LinkedList getHotelEmployees() {
		return this.HotelEmployees;
	}
	
	
	public String displayAllInfo() {
		/*
		 * ----------------------------------------
		 * Abstraction : this method prints all Hotel's attributes & Client's Attributes & Employees Attributes & Rooms Attributes
		 * 
		 * Parameters : None
		 * 
		 * Returns : void
		 * ----------------------------------------
		 * */
		String report = "";
		report += this.toString() + "\n";
		report += this.printHotelLicense() + "\n";
		
		if (this.ManagersLessThanFive())
            report += ("Managers less than 5, HR requirement satisfied\n");

        if (this.EmployeesLessThanFifty())
            report += ("Employees less than 50, HR requirement satisfied\n");
        
        
        report += ("| Rooms Info\n");
        report += ("------------------------------------------------\n");
        Node roomNode = this.Rooms.getHead();
        while (roomNode != null) {
            report += (roomNode.data + "\n");
            roomNode = roomNode.next;
        }
        report += ("------------------------------------------------\n");
        
        report +=("\n\n\n Clients Info\n");
        report += ("------------------------------------------------\n");
        Node clientNode = this.Clients.getHead();
        while (clientNode != null) {
        	report+=(clientNode.data + "\n");
        	clientNode = clientNode.next;
        }
        report += ("------------------------------------------------\n");
        
        report += ("\n\n\n Employees Info\n");
        report +=("------------------------------------------------\n");
        Node empNode = this.HotelEmployees.getHead();
        while (empNode != null) {
        	report += (empNode.data +"\n");
            empNode = empNode.next;
        }
        report += ("------------------------------------------------\n");
        
        return report;
	}
	
	public String printHotelLicense() {
		int end = Math.min(this.getName().length(), 3);
		String license = "";
		license += ("HTL-"+this.getName().substring(0,end) + "-" + this.Clients.size() + this.HotelEmployees.size() + this.Rooms.size());
		return license;
	}
	
	
	
	public static Hotel readFile(String path) throws FileNotFoundException,IOException,ClassNotFoundException{
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		System.out.println("Reading From File");
		Hotel loadedHotel = (Hotel) ois.readObject();
		ois.close();
		fis.close();
		return loadedHotel;

	}
	
	public void writeFile(String path) {
		try {
			File f = new File(path);
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			System.out.println("Creating File & Writing....");
			oos.writeObject(this);
			oos.flush();
			oos.close();
			fos.close();
		}
		
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
