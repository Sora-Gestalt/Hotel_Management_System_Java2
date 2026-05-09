package Projects;

import java.io.*;

public class Client implements Absher,Serializable{
	// class attrs
	private String Name;
	private int Age;
	private boolean ClearViolationRecord;
	private LinkedList Rooms;

	// constructors

	// parameterized constructor;
	public Client(String Name,int Age,boolean ClearViolationRecord) {
		this.setName(Name);
		this.setAge(Age);
		this.setViolationRecord(ClearViolationRecord);
		this.Rooms = new LinkedList();
	}

	// copy constructor
	public Client(Client Original) {
		this.setName(Original.getName());
		this.setAge(Original.getAge());
		this.setViolationRecord(Original.getViolationRecord());
		this.Rooms = new LinkedList();
		
		Node current = this.Rooms.getHead();
		while(current!=null) {
			this.Rooms.insertAtBack(current);
			current = current.next;
		}
	}

	// helping methods
	private boolean isDuplicateRoom(Room room) {
		/*
		 * Abstract : this method helps method addRoom , it checks if the passed Room is a duplicate
		 * 
		 * Parameters : room : Room
		 * 
		 * Returns : boolean
		 * */
		Node current = this.Rooms.getHead();
		while (current != null) {
			if (((Room)current.data).getAddress().equalsIgnoreCase(room.getAddress())) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

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
	
	public LinkedList getRooms() {
		return this.Rooms;
	}

	public int getNumOfRooms() {
		return this.Rooms.size();
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
		Node current = this.Rooms.getHead();
		while (current != null) {
			if (((Room)current.data).getAddress().equalsIgnoreCase(Room.getAddress())) {
				return (Room)current.data;
			}
			current = current.next;
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
		if(!this.isDuplicateRoom(Room))
			this.Rooms.insertAtBack(Room);
		else
			throw new IllegalArgumentException("Duplicated Room");
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
		Node current = this.Rooms.getHead();
		int index = 0;
		boolean found = false;
		while (current != null) {
			if (((Room)current.data).getAddress().equalsIgnoreCase(Room.getAddress())) {
				try {
					this.Rooms.removeAtIndex(index);
					found = true;
					break;
				} catch (Exception e) {
					System.out.println("Error removing room: " + e.getMessage());
				}
			}
			current = current.next;
			index++;
		}
		
		if (!found) {
			throw new IllegalArgumentException("Client does not own room: " + Room.getAddress());
		}
	}

	public void releaseAllRooms() {
		/*
		 * Abstract: this methods deletes all rooms from client
		 * 
		 * Parameters: None
		 * 
		 * Returns: void
		 * */

		this.Rooms.clearList();
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
