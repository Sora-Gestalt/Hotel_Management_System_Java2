package Projects;

import java.util.Scanner;
public class HotelUtils {

	/* ----------------------------------------
	 * Abstract: this method picks Manager
	 * * Parameters: console: Scanner | employees : LinkedList
	 * * Return: Manager
	 * ----------------------------------------
	 */
	public static Manager pickManager(Scanner console, LinkedList employees) {
		Node curr = employees.getHead();
		int i = 0;
		while (curr != null) {
			if (curr.data instanceof Manager) {
				System.out.println("[" + i + "] " + ((Manager) curr.data).displayInfo());
			}
			curr = curr.next;
			i++;
		}
		int idx = getInt(console, "Select Manager Index =>: ");
		return (Manager) getByIndex(employees, idx);
	}
	
	
	
	/* ----------------------------------------
	 * Abstract: this method resets rooms addresses after demolishing rooms
	 * * Parameters: rooms : LinkedList
	 * * Return: None
	 * ----------------------------------------
	 */
	public static void refreshRoomsAddresses(LinkedList rooms) {
	    Node current = rooms.getHead();
	    int index = 0;
	    
	    
	    while (current != null) {
	        Room r = (Room) current.getData();
	        r.setAddress(HotelUtils.resetRoomAddress(index));
	        
	        index++;
	        current = current.next;
	    }
	}
	
	/* ----------------------------------------
	 * Abstract: this method helps HotelUtils.refreshRoomsAddresses to reset Address from 0001 - xxxx
	 * * Parameters: roomIndex : int
	 * * Return: String
	 * ----------------------------------------
	 */
	public static String resetRoomAddress(int roomIndex) {
	    return String.format("%04d", roomIndex);
	}
	
	/* ----------------------------------------
	 * Abstract: this method generate new address based on LinkedList size
	 * * Parameters: rooms : LinkedList
	 * * Return: String
	 * ----------------------------------------
	 */
	public static String generateRoomAddress(LinkedList rooms) {
	    return String.format("%04d", rooms.size());
	}
	
	public static boolean validName(String name) {
		return (name != null && !name.trim().isEmpty() && name.matches("^[a-zA-Z]*$"));
	}

	/* ----------------------------------------
	 * Abstract: this method picks Security
	 * * Parameters: console: Scanner | employees : LinkedList
	 * * Return: Security
	 * ----------------------------------------
	 */
	public static Security pickSecurity(Scanner console, LinkedList employees) {
		Node curr = employees.getHead();
		int i = 0;
		while (curr != null) {
			if (curr.data instanceof Security) {
				System.out.println("[" + i + "] " + ((Security) curr.data).displayInfo());
			}
			curr = curr.next;
			i++;
		}
		int idx = getInt(console, "Select Security Index =>: ");
		return (Security) getByIndex(employees, idx);
	}

	/* ----------------------------------------
	 * Abstract: this method picks Cook
	 * * Parameters: console: Scanner | employees : LinkedList
	 * * Return: Cook
	 * ----------------------------------------
	 */
	public static Cook pickCook(Scanner console, LinkedList employees) {
		Node curr = employees.getHead();
		int i = 0;
		while (curr != null) {
			if (curr.data instanceof Cook) {
				System.out.println("[" + i + "] " + ((Cook) curr.data).displayInfo());
			}
			curr = curr.next;
			i++;
		}
		int idx = getInt(console, "Select Cook Index =>: ");
		return (Cook) getByIndex(employees, idx);
	}

	/* ----------------------------------------
	 * Abstract: this method picks Cleaner
	 * * Parameters: console: Scanner | employees : LinkedList
	 * * Return: Cleaner
	 * ----------------------------------------
	 */
	public static Cleaner pickCleaner(Scanner console, LinkedList employees) {
		Node curr = employees.getHead();
		int i = 0;
		while (curr != null) {
			if (curr.data instanceof Cleaner) {
				System.out.println("[" + i + "] " + ((Cleaner) curr.data).displayInfo());
			}
			curr = curr.next;
			i++;
		}
		int idx = getInt(console, "Select Cleaner Index =>: ");
		return (Cleaner) getByIndex(employees, idx);
	}

	/* ----------------------------------------
	 * Abstract: this method picks Reciptionest
	 * * Parameters: console: Scanner | employees : LinkedList
	 * * Return: Reciptionest
	 * ----------------------------------------
	 */
	public static Reciptionest pickReciptionest(Scanner console, LinkedList employees) {
		Node curr = employees.getHead();
		int i = 0;
		while (curr != null) {
			if (curr.data instanceof Reciptionest) {
				System.out.println("[" + i + "] " + ((Reciptionest) curr.data).displayInfo());
			}
			curr = curr.next;
			i++;
		}
		int idx = getInt(console, "Select Reciptionest Index =>: ");
		return (Reciptionest) getByIndex(employees, idx);
	}

	/* ----------------------------------------
	 * Abstract: this method picks Department for Manager
	 * * Parameters: console: Scanner | choice: String
	 * * Return: String
	 * ----------------------------------------
	 */
	public static String pickManagerDept(Scanner console, String choice) {
		System.out.println("Choose Section\n[1] Management\n[2] Resturant\n[3] Cleaning\n[4] Security\n[5] Rooms");
		String input = console.nextLine();
		if (input.equals("2")) return "resturant";
		if (input.equals("3")) return "cleaning";
		if (input.equals("4")) return "security";
		if (input.equals("5")) return "rooms";
		return "employees";
	}

	/* ----------------------------------------
	 * Abstract: this method picks Language for Reciptionest
	 * * Parameters: console: Scanner | choice: String
	 * * Return: String
	 * ----------------------------------------
	 */
	public static String pickReciptionestLanguage(Scanner console, String choice) {
		System.out.println("[1] Arabic\n[2] English\n[3] French");
		String input = console.nextLine();
		if (input.equals("1")) return "arabic";
		if (input.equals("3")) return "french";
		return "english";
	}

	/* ----------------------------------------
	 * Abstract: this method picks security section for Security
	 * * Parameters: console: Scanner | choice: String
	 * * Return: String
	 * ----------------------------------------
	 */
	public static String pickSecuritySection(Scanner console, String choice) {
		System.out.println("[1] Cyber Security\n[2] VSS\n[3] PSIM");
		String input = console.nextLine();
		if (input.equals("1")) return "cyber security";
		if (input.equals("3")) return "psim";
		return "vss";
	}

	/* ----------------------------------------
	 * Abstract: this method picks cooking time for Cook
	 * * Parameters: console: Scanner | choice: String
	 * * Return: String
	 * ----------------------------------------
	 */
	public static String pickCookTime(Scanner console, String choice) {
		System.out.println("[1] Breakfast\n[2] Lunch\n[3] Dinner");
		String input = console.nextLine();
		if (input.equals("1")) return "breakfast";
		if (input.equals("3")) return "dinner";
		return "lunch";
	}

	/* ----------------------------------------
	 * Abstract: this method picks cleaning section for Cleaner
	 * * Parameters: console: Scanner | choice: String
	 * * Return: String
	 * ----------------------------------------
	 */
	public static String pickCleaningSection(Scanner console, String choice) {
		System.out.println("[1] Roof\n[2] Rooms\n[3] Kitchen");
		String input = console.nextLine();
		if (input.equals("1")) return "roof";
		if (input.equals("3")) return "kitchen";
		return "rooms";
	}

	/* ----------------------------------------
	 * Abstract: this method gets employee
	 * * Parameters: console: Scanner | employees : LinkedList
	 * * Return: HotelEmployee
	 * ----------------------------------------
	 */
	public static HotelEmployee getEmployeeFromEmployees(Scanner console, LinkedList employees) {
		Node curr = employees.getHead();
		int i = 0;
		while (curr != null) {
			HotelEmployee e = (HotelEmployee) curr.data;
			System.out.println("[" + i + "] " + e.getName() + ", Salary: " + e.getSalary());
			curr = curr.next;
			i++;
		}
		int idx = getInt(console, "Choose Employee Index =>: ");
		return (HotelEmployee) getByIndex(employees, idx);
	}

	/* ----------------------------------------
	 * Abstract: this method gets room
	 * * Parameters: console: Scanner | rooms : LinkedList
	 * * Return: Room
	 * ----------------------------------------
	 */
	public static Room getRoomFromRooms(Scanner console, LinkedList rooms) {
		Node curr = rooms.getHead();
		int i = 0;
		while (curr != null) {
			Room r = (Room) curr.data;
			System.out.println("[" + i + "] " + r.getAddress() + " " + r.getType());
			curr = curr.next;
			i++;
		}
		int idx = getInt(console, "Choose Room Index =>: ");
		return (Room) getByIndex(rooms, idx);
	}

	/* ----------------------------------------
	 * Abstract: this method gets client
	 * * Parameters: console: Scanner | clientlist : LinkedList
	 * * Return: Client
	 * ----------------------------------------
	 */
	public static Client getClientFromClientList(Scanner console, LinkedList clientlist) {
		Node curr = clientlist.getHead();
		int i = 0;
		while (curr != null) {
			Client c = (Client) curr.data;
			System.out.println("[" + i + "] " + c.getName() + ", Rooms: " + c.getNumOfRooms());
			curr = curr.next;
			i++;
		}
		int idx = getInt(console, "Choose Client Index =>: ");
		return (Client) getByIndex(clientlist, idx);
	}

	/* ----------------------------------------
	 * Abstract: this method checks that the value is a positive double
	 * * Parameters: console: Scanner | prompt : String
	 * * Return: double
	 * ----------------------------------------
	 */
	public static double getDouble(Scanner console, String prompt) {
		while (true) {
			System.out.println(prompt);
			if (console.hasNextDouble()) {
				double val = console.nextDouble();
				console.nextLine();
				if (val > 0) return val;
			} else console.next();
			System.out.println("Invalid input. Enter a positive number.");
		}
	}

	/* ----------------------------------------
	 * Abstract: this method checks that the value is a positive integer
	 * * Parameters: console: Scanner | prompt : String
	 * * Return: int
	 * ----------------------------------------
	 */
	public static int getPositiveInt(Scanner console, String prompt) {
		while (true) {
			int val = getInt(console, prompt);
			if (val > 0) return val;
			System.out.println("Invalid input. Enter a positive integer.");
		}
	}

	/* ----------------------------------------
	 * Abstract: this method checks that the value is an integer
	 * * Parameters: console: Scanner | prompt : String
	 * * Return: int
	 * ----------------------------------------
	 */
	public static int getInt(Scanner console, String prompt) {
		while (true) {
			System.out.println(prompt);
			if (console.hasNextInt()) {
				int val = console.nextInt();
				console.nextLine();
				return val;
			}
			console.next();
			System.out.println("Invalid input. Enter a number.");
		}
	}

	/* ----------------------------------------
	 * Abstract: this method gets Address of room
	 * * Parameters: console: Scanner | prompt : String | rooms : LinkedList
	 * * Return: String
	 * ----------------------------------------
	 */
	public static String getAddress(Scanner console, String prompt, LinkedList rooms) {
		while (true) {
			System.out.println(prompt);
			String val = console.nextLine();
			if (isValidAddress(val, rooms)) return val;
			System.out.println("Invalid or Duplicate Address.");
		}
	}

	/* ----------------------------------------
	 * Abstract: this method checks if given input is string
	 * * Parameters: console: Scanner | prompt : String
	 * * Return: String
	 * ----------------------------------------
	 */
	public static String getString(Scanner console, String prompt) {
		while (true) {
			System.out.print(prompt);
			String val = console.nextLine();
			if (isValidName(val)) return val;
			System.out.println("Invalid input. Use letters only.");
		}
	}

	/* ----------------------------------------
	 * Abstract: this method gets file path
	 * * Parameters: console: Scanner | prompt : String
	 * * Return: String
	 * ----------------------------------------
	 */
	public static String getPath(Scanner console, String prompt) {
		while (true) {
			System.out.println(prompt);
			String val = console.nextLine();
			if (!val.trim().isEmpty()) return val;
			System.out.println("Invalid path.");
		}
	}

	/* ----------------------------------------
	 * Abstract: this method counts cleaners
	 * * Parameters: employees : LinkedList
	 * * Return: int
	 * ----------------------------------------
	 */
	public static int getNumOfCleaners(LinkedList employees) {
		int count = 0;
		Node curr = employees.getHead();
		while (curr != null) {
			if (curr.data instanceof Cleaner) count++;
			curr = curr.next;
		}
		return count;
	}

	/* ----------------------------------------
	 * Abstract: this method counts cooks
	 * * Parameters: employees : LinkedList
	 * * Return: int
	 * ----------------------------------------
	 */
	public static int getNumOfCooks(LinkedList employees) {
		int count = 0;
		Node curr = employees.getHead();
		while (curr != null) {
			if (curr.data instanceof Cook) count++;
			curr = curr.next;
		}
		return count;
	}

	/* ----------------------------------------
	 * Abstract: this method counts security
	 * * Parameters: employees : LinkedList
	 * * Return: int
	 * ----------------------------------------
	 */
	public static int getNumOfSecurity(LinkedList employees) {
		int count = 0;
		Node curr = employees.getHead();
		while (curr != null) {
			if (curr.data instanceof Security) count++;
			curr = curr.next;
		}
		return count;
	}

	/* ----------------------------------------
	 * Abstract: this method counts reciptionests
	 * * Parameters: employees : LinkedList
	 * * Return: int
	 * ----------------------------------------
	 */
	public static int getNumOfReciptionests(LinkedList employees) {
		int count = 0;
		Node curr = employees.getHead();
		while (curr != null) {
			if (curr.data instanceof Reciptionest) count++;
			curr = curr.next;
		}
		return count;
	}

	/* ----------------------------------------
	 * Abstract: this method counts managers
	 * * Parameters: employees : LinkedList
	 * * Return: int
	 * ----------------------------------------
	 */
	public static int getNumOfManagers(LinkedList employees) {
		int count = 0;
		Node curr = employees.getHead();
		while (curr != null) {
			if (curr.data instanceof Manager) count++;
			curr = curr.next;
		}
		return count;
	}

	/* ----------------------------------------
	 * Abstract: this method checks name and space
	 * * Parameters: n : String | rooms : LinkedList
	 * * Return: boolean
	 * ----------------------------------------
	 */
	public static boolean isValidAddress(String n, LinkedList rooms) {
		if (n.length() != 4) return false;
		for (int i = 0; i < n.length(); i++) {
			if (!Character.isDigit(n.charAt(i))) return false;
		}
		return isUniqueAddress(n, rooms);
	}

	/* ----------------------------------------
	 * Abstract: this method checks if room belongs to client
	 * * Parameters: room : Room | clientlist : LinkedList
	 * * Return: boolean
	 * ----------------------------------------
	 */
	public static boolean roomBelongsToClient(Room room, LinkedList clientlist) {
		Node curr = clientlist.getHead();
		while (curr != null) {
			try {
				((Client) curr.data).Search(room);
				return true;
			} catch (Exception e) {}
			curr = curr.next;
		}
		return false;
	}

	/* ----------------------------------------
	 * Abstract: checks if manager exists for dept
	 * * Parameters: employees : LinkedList | dept : String
	 * * Return: boolean
	 * ----------------------------------------
	 */
	public static boolean hasManagerDept(LinkedList employees, String dept) {
		Node curr = employees.getHead();
		while (curr != null) {
			if (curr.data instanceof Manager && ((Manager) curr.data).getManagerDept().equalsIgnoreCase(dept))
				return true;
			curr = curr.next;
		}
		return false;
	}

	/* ----------------------------------------
	 * Abstract: checks if address is unique
	 * * Parameters: n : String | rooms : LinkedList
	 * * Return: boolean
	 * ----------------------------------------
	 */
	public static boolean isUniqueAddress(String n, LinkedList rooms) {
		Node curr = rooms.getHead();
		while (curr != null) {
			if (((Room) curr.data).getAddress().equalsIgnoreCase(n)) return false;
			curr = curr.next;
		}
		return true;
	}
	
	
	
	public static void removeRoomFromList(LinkedList list,Room target) {
		Node current = list.getHead();
		int index = 0;
		while(current != null) {
			Room r = (Room) current.data;
			if(r.getAddress().equalsIgnoreCase(target.getAddress())) {
				try {
					list.removeAtIndex(index);
					return;
				}
				
				catch(Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
			current = current.next;
			index++;
		}
	}
	
	public static boolean removeClientFromList(LinkedList list,Client target) {
		Node current = list.getHead();
		int index = 0;
		while(current != null) {
			if(((Client) current.data).Equals(target)) {
				try {
					list.removeAtIndex(index);
					return true;
				}
				
				catch(Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
			
			current = current.next;
			index++;
		}
		return false;
	}
	
	public static void removeEmployeeFromList(LinkedList list,HotelEmployee target) {
		Node current = list.getHead();
		int index = 0;
		while(current != null) {
			if(((HotelEmployee) current.data).Equals(target)) {
				try {
					list.removeAtIndex(index);
					System.out.println("Employee removed!");
					return;
				}
				
				catch(Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
			current = current.next;
			index++;
		}
	}

	/* ----------------------------------------
	 * Abstract: checks alphabet and space
	 * * Parameters: n : String
	 * * Return: boolean
	 * ----------------------------------------
	 */
	public static boolean isValidName(String n) {
		for (int i = 0; i < n.length(); i++) {
			if (!Character.isAlphabetic(n.charAt(i)) && n.charAt(i) != ' ') return false;
		}
		return true;
	}

	/* ----------------------------------------
	 * Abstract: gets object by index
	 * * Parameters: list : LinkedList | index : int
	 * * Return: Object
	 * ----------------------------------------
	 */
	public static Object getByIndex(LinkedList list, int index) {
		Node curr = list.getHead();
		for (int i = 0; i < index && curr != null; i++) curr = curr.next;
		return (curr != null) ? curr.data : null;
	}
}