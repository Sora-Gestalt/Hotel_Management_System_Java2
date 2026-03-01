package Projects;
import java.util.Scanner;

import Projects.Hotel;
public class main {

	public static void main(String[] args) {
		String choice = "none";
		Scanner console = new Scanner(System.in);
		
		// hotel info
		String hotel_n = "empty";
		int hotel_rc = 0;
		int hotel_cc = 0;
		int hotel_ec = 0;
		
		
		// client info
		
		String client_n = "empty";
		int client_a = 0;
		String client_r = "empty";
		boolean client_record = true;
		
		// room info
		
		String ra = "empty";
		int rbd = 0;
		int rba = 0;
		int rk = 0;
		
		// suite info
		
		int sb = 0;
		
		// royal suite info
		int pp = 0;
		
		
		// Hotel Employees Info
		
		String e_n = "empty";
		int e_a = 0;
		double e_s = 0;
		
		// cleaners
		
		String cl_sec = "empty";
		Cleaner temp_cl = null;
		// Cooks
		
		String co_wt = "empty";
		Cook temp_co = null;
		// Security
		String sc_sec = "empty";
		Security temp_s = null;
		
		// Reciptionest
		String lang = "empty";
		Reciptionest temp_r = null;
		// Manager
		Manager temp_m = null;
		Manager temp_m2 = null;
		String m_dept = "empty";
		String dept = "empty";
		int m_team_size = 0;
	
		
		
		
		System.out.println("---------------------------------");
		System.out.println("Welcome");
		System.out.println("Enter Hotel Name ");
		
		
		// check valid name
		hotel_n = getString(console,"Input =>: ");
		
		
		System.out.println("Enter Rooms Capacity: ");
		hotel_rc = getInt(console, "Input =>: ");
		
		System.out.println("Enter Clients Capacity: ");
		hotel_cc = getInt(console, "Input =>: ");
		
		System.out.println("Enter Employees Capacity: ");
		hotel_ec = getInt(console, "Input =>: ");
		
		
		System.out.println("Creating Hotel!");
		System.out.println("---------------------------------");
		
		Hotel hotel = new Hotel(hotel_n,hotel_rc,hotel_ec,hotel_cc);
		
		// lists to help in related methods
		
		Client[] clientlist = new Client[hotel_cc];
		int noc = 0;
		
		HotelEmployee[] employees = new HotelEmployee[hotel_ec];
		int noe = 0;
		
		Room[] rooms = new Room[hotel_rc];
		int nor = 0;
		
		do {
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Hotel " + hotel.getName() + " Management System");
			System.out.println("Welcome");
			System.out.println("[1] set new name");
			System.out.println("[2] display all information");
			System.out.println("[3] display hotel information");
			System.out.println("[4] get revenue");
			System.out.println("[5] Clients Properties");
			System.out.println("[6] Employees Properties");
			System.out.println("[7] Rooms Properties");
			System.out.println("[8] exit");
			System.out.println("Input =>: ");
			
			choice = console.nextLine();
			
			if(choice.equalsIgnoreCase("1")) {
				
				System.out.println("Enter Hotel Name ");

				
				
				// check valid name
				hotel_n = getString(console,"Input =>: ");
				
				hotel.setName(hotel_n);
			}
			
			
			else if(choice.equalsIgnoreCase("2")){
				hotel.displayAllInfo();
			}
			
			else if(choice.equalsIgnoreCase("3")) {
				System.out.println(hotel);
			}
			
			
			else if(choice.equalsIgnoreCase("4")) {
				System.out.println("Revenue per night: " + hotel.getRevenue());
			}
			
			
			else if(choice.equalsIgnoreCase("5")) {
				
				do {
					
					System.out.println("-------------------------------------------------------------------");
					System.out.println("[1] Create & Add Client");
					System.out.println("[2] Search Client");
					System.out.println("[3] Remove Client");
					System.out.println("[4] Add Room To Client");
					System.out.println("[5] Remove Room From Client");
					System.out.println("[6] Search Room of Client");
					System.out.println("[7] Print Client's Info");
					System.out.println("[8] exit");
					System.out.println("Input =>: ");
					
					choice = console.nextLine();
					
					if(choice.equalsIgnoreCase("1") && hotel.getNumOfClients() < hotel_cc) {
						
						
						client_n = getString(console,"Enter Client Name Input =>: ");
						
						client_a = getInt(console,"Enter Age Input =>: ");
						
						while(true) {
							
							client_r = getString(console,"Is Violation Record Of The Client Clear ? ans(yes/no) Input =>: ");
							
							if(client_r.equalsIgnoreCase("yes")) {
								client_record = true;
								break;
							}
							
							else if(client_r.equalsIgnoreCase("no")) {
								client_record = false;
								break;
							}
							
							else
								System.out.println("Invalid input,Enter yes or no");
						}
						
						Client client = new Client(client_n,client_a,client_record);
						hotel.addClient(client);
						clientlist[noc++] = client;
						
						
						
					}

					
				

					
					else if(choice.equalsIgnoreCase("2")) {

						
						
						if(hotel.getNumOfClients() > 0) {
							Client client = getClientFromClientList(console,clientlist,noc);
							System.out.println("Client Index in hotel: " + hotel.SearchClient(client));
						}
						
						else {
							System.out.println("number of clients is zero");
						}
						
					}
					
					else if(choice.equalsIgnoreCase("3")) {
						
						if(hotel.getNumOfClients() > 0) {
							Client client = getClientFromClientList(console,clientlist,noc);
							hotel.removeClient(client);
							System.out.println("Client has been removed");
						}
						
						else {
							System.out.println("number of clients is zero");
						}
						
					}
					
					else if(choice.equalsIgnoreCase("4")) {
						
						if(hotel.getNumOfClients() > 0 && hotel.getNumOfRooms() > 0) {
						Client client = getClientFromClientList(console,clientlist,noc);
						Room room = getRoomFromRooms(console,rooms,nor);
						client.addRoom(room);
						}
						
						else {
							System.out.println("number of clients or rooms is zero");
						}
					}
					
					else if(choice.equalsIgnoreCase("5")) {
						
						if(hotel.getNumOfClients() > 0 && hotel.getNumOfRooms() > 0) {
						Client client = getClientFromClientList(console,clientlist,noc);
						Room room = getRoomFromRooms(console,rooms,nor);
						client.removeRoom(room);
						}
						
						else {
							System.out.println("number of clients or rooms is zero");
						}
						
					}
					
					else if(choice.equalsIgnoreCase("6")) {
						if(hotel.getNumOfClients() > 0 && hotel.getNumOfRooms() > 0) {
						Client client = getClientFromClientList(console,clientlist,noc);
						Room room = getRoomFromRooms(console,rooms,nor);
						System.out.println("Index of Room: " + client.Search(room));
						}
						
						else {
							System.out.println("number of clients or rooms is zero");
						}
					}
					
					else if(choice.equalsIgnoreCase("7")) {
						
						if(hotel.getNumOfClients() > 0) {
							Client client = getClientFromClientList(console,clientlist,noc);
							System.out.println(client);
						}
						
						else {
							System.out.println("number of clients is zero");
						}
					}
					
					else if(choice.equalsIgnoreCase("8")) {
						break;
					}
					
					
					
					
					
					
					
				} while(true);
				
				
				
				
				
			}
			
			else if(choice.equalsIgnoreCase("6")) {
				do {
					System.out.println("-------------------------------------------------------------------");
					System.out.println("[1] Create Manager");
					System.out.println("[2] Create Reciptionest");
					System.out.println("[3] Create Security");
					System.out.println("[4] Create Cleaner");
					System.out.println("[5] Create Cook");
					System.out.println("[6] Add Language For Reciptionest ");
					System.out.println("[7] Remove Language From Reciptionest");
					System.out.println("[8] Add Member To Manager Team");
					System.out.println("[9] Search Member of Manager Team");
					System.out.println("[10] Remove Member From Manager Team");
					System.out.println("[11] exit");
					System.out.println("Input =>: ");
					
					choice = console.nextLine();
					
			
					
					if(choice.equalsIgnoreCase("1") && hotel.getNumOfEmployees() < hotel_ec) {
						e_n = getString(console,"Enter Name Input =>: ");
						e_a = getInt(console,"Enter Age Input =>: ");
						e_s = getDouble(console,"Enter Salary Input =>: ");
						m_dept = pickManagerDept(console,choice);
						
						while(true) {
							m_team_size = getInt(console,"Enter Team Size Input =>: ");
							if(m_team_size < 10 && m_team_size > 0)
								break;
							else {
								System.out.println("Invalid Size , Size must be > 0 & < 10");
								m_team_size = getInt(console,"Choose team size ( 0 < size < 10 )Input =>: ");
							}
						}
						
						Manager manager = new Manager(e_n,e_a,e_s,m_dept,m_team_size);
						hotel.addEmployee(manager);
						employees[noe++] = manager;
						
					}
					
					else if (choice.equalsIgnoreCase("2") && hotel.getNumOfEmployees() < hotel_ec) {
						e_n = getString(console,"Enter Name Input =>: ");
						e_a = getInt(console,"Enter Age nput =>: ");
						e_s = getDouble(console,"Enter Salary Input =>: ");
						
						Reciptionest reciptionest = new Reciptionest(e_n,e_a,e_s);
						hotel.addEmployee(reciptionest);
						employees[noe++] = reciptionest;
					}
					
					else if (choice.equalsIgnoreCase("3") && hotel.getNumOfEmployees() < hotel_ec) {
						e_n = getString(console,"Enter Name Input =>: ");
						e_a = getInt(console,"Enter Age Input =>: ");
						e_s = getDouble(console,"Enter Salary Input =>: ");
						sc_sec = pickSecuritySection(console,choice);
						
						Security security = new Security(e_n,e_a,e_s,sc_sec);
						hotel.addEmployee(security);
						employees[noe++] = security;
						
					}
					
					else if (choice.equalsIgnoreCase("4") && hotel.getNumOfEmployees() < hotel_ec) {
						e_n = getString(console,"Enter Name Input =>: ");
						e_a = getInt(console,"Enter Age Input =>: ");
						e_s = getDouble(console,"Enter Salary Input =>: ");
						cl_sec = pickCleaningSection(console,choice);
						
						Cleaner cleaner = new Cleaner(e_n,e_a,e_s,cl_sec);
						hotel.addEmployee(cleaner);
						employees[noe++] = cleaner;
					}
					
					else if (choice.equalsIgnoreCase("5") && hotel.getNumOfEmployees() < hotel_ec) {
						e_n = getString(console,"Enter Name Input =>: ");
						e_a = getInt(console,"Enter Age Input =>: ");
						e_s = getDouble(console,"Enter Salary Input =>: ");
						co_wt = pickCookTime(console,choice);
						
						Cook cook = new Cook(e_n,e_a,e_s,co_wt);
						hotel.addEmployee(cook);
						employees[noe++] = cook;
						
					}
					
					else if (choice.equalsIgnoreCase("6")) {
						lang = pickReciptionestLanguage(console,choice);
						temp_r = pickReciptionest(console,employees,noe);
						temp_r.addLang(lang);
					}
					
					else if (choice.equalsIgnoreCase("7")) {
						lang = pickReciptionestLanguage(console,choice);
						temp_r = pickReciptionest(console,employees,noe);
						temp_r.removeLang(lang);
					}
					
					else if (choice.equalsIgnoreCase("8")) {
						
						dept = pickManagerDept(console,choice);
						
						while(true) {
							temp_m = pickManager(console,employees,noe);
							if(temp_m.getManagerDept().equalsIgnoreCase(dept))
								break;
							else {
								System.out.println("Chooses Dept and Manager's Dept are different");
								temp_m = pickManager(console,employees,noe);
							}
						}
						
						if(temp_m.getManagerDept().equalsIgnoreCase("resturant")) {
							
							temp_co = pickCook(console,employees,noe);
							temp_m.addEmployeeToTeam(temp_co);
							
						}
						
						else if(temp_m.getManagerDept().equalsIgnoreCase("employees")) {
							
							temp_m2 = pickManager(console,employees,noe);
							temp_m.addEmployeeToTeam(temp_m2);
							
						}
						
						else if(temp_m.getManagerDept().equalsIgnoreCase("rooms")) {
							temp_r = pickReciptionest(console,employees,noe);
							temp_m.addEmployeeToTeam(temp_r);
						}
						
						else if(temp_m.getManagerDept().equalsIgnoreCase("security")) {
							temp_s = pickSecurity(console,employees,noe);
							temp_m.addEmployeeToTeam(temp_s);
						}
						
						else if(temp_m.getManagerDept().equalsIgnoreCase("cleaning")) {
							temp_cl = pickCleaner(console,employees,noe);
							temp_m.addEmployeeToTeam(temp_cl);
						}
						
						
					}
					
					else if (choice.equalsIgnoreCase("9")) {
						
						dept = pickManagerDept(console,choice);
						
						while(true) {
							temp_m = pickManager(console,employees,noe);
							if(temp_m.getManagerDept().equalsIgnoreCase(dept))
								break;
							else {
								System.out.println("Chooses Dept and Manager's Dept are different");
								temp_m = pickManager(console,employees,noe);
							}
						}
						
						if(temp_m.getManagerDept().equalsIgnoreCase("resturant")) {
							
							temp_co = pickCook(console,employees,noe);
							temp_m.searchEmployee(temp_co);
							
						}
						
						else if(temp_m.getManagerDept().equalsIgnoreCase("employees")) {
							
							temp_m2 = pickManager(console,employees,noe);
							temp_m.searchEmployee(temp_m2);
							
						}
						
						else if(temp_m.getManagerDept().equalsIgnoreCase("rooms")) {
							temp_r = pickReciptionest(console,employees,noe);
							temp_m.searchEmployee(temp_r);
						}
						
						else if(temp_m.getManagerDept().equalsIgnoreCase("security")) {
							temp_s = pickSecurity(console,employees,noe);
							temp_m.searchEmployee(temp_s);
						}
						
						else if(temp_m.getManagerDept().equalsIgnoreCase("cleaning")) {
							temp_cl = pickCleaner(console,employees,noe);
							temp_m.searchEmployee(temp_cl);
						}
						
					}
					
					else if (choice.equalsIgnoreCase("10")) {
						
						dept = pickManagerDept(console,choice);
						
						while(true) {
							temp_m = pickManager(console,employees,noe);
							if(temp_m.getManagerDept().equalsIgnoreCase(dept))
								break;
							else {
								System.out.println("Chooses Dept and Manager's Dept are different");
								temp_m = pickManager(console,employees,noe);
							}
						}
						
						if(temp_m.getManagerDept().equalsIgnoreCase("resturant")) {
							
							temp_co = pickCook(console,employees,noe);
							temp_m.removeEmployee(temp_co);
							
						}
						
						else if(temp_m.getManagerDept().equalsIgnoreCase("employees")) {
							
							temp_m2 = pickManager(console,employees,noe);
							temp_m.removeEmployee(temp_m2);
							
						}
						
						else if(temp_m.getManagerDept().equalsIgnoreCase("rooms")) {
							temp_r = pickReciptionest(console,employees,noe);
							temp_m.removeEmployee(temp_r);
						}
						
						else if(temp_m.getManagerDept().equalsIgnoreCase("security")) {
							temp_s = pickSecurity(console,employees,noe);
							temp_m.removeEmployee(temp_s);
						}
						
						else if(temp_m.getManagerDept().equalsIgnoreCase("cleaning")) {
							temp_cl = pickCleaner(console,employees,noe);
							temp_m.removeEmployee(temp_cl);
						}
						
						
						
					}
					
					else if (choice.equalsIgnoreCase("11")) {
						break;
					}
					
				} while(true);
			}
				
			else if(choice.equalsIgnoreCase("7")) {
				do {
					

					System.out.println("-------------------------------------------------------------------");
					System.out.println("[1] Create Standard Room");
					System.out.println("[2] Create Studio Room");
					System.out.println("[3] Create Suite Room");
					System.out.println("[4] Create Royal Suite");
					System.out.println("[5] Display Room Info");
					System.out.println("[6] Calculate Room Price ");
					System.out.println("[7] exit");
					System.out.println("Input =>: ");
					
					choice = console.nextLine();
					
				
					
					
					if(choice.equalsIgnoreCase("1") && hotel.getNumOfRooms() < hotel_rc) {
						ra = getAddress(console,"Enter Address Input =>: ");
						rbd = getInt(console,"Enter Number of Beds Input =>: ");
						rba = getInt(console,"Enter Number of Bathrooms Input =>: ");
						rk = getInt(console,"Enter Number of Kitchens Input =>: ");
						
						Standard standard = new Standard(ra,rbd,rba,rk);
						hotel.addRoom(standard);
						rooms[nor++] = standard;
					}
					
					else if (choice.equalsIgnoreCase("2") && hotel.getNumOfRooms() < hotel_rc) {
						ra = getAddress(console,"Enter Address Input =>: ");
						rbd = getInt(console,"Enter Number of Beds Input =>: ");
						rba = getInt(console,"Enter Number of Bathrooms Input =>: ");
						rk = getInt(console,"Enter Number of Kitchens Input =>: ");
						
						Studio studio = new Studio(ra,rbd,rba,rk);
						hotel.addRoom(studio);
						rooms[nor++] = studio;
					}
					
					else if (choice.equalsIgnoreCase("3") && hotel.getNumOfRooms() < hotel_rc) {
						ra = getAddress(console,"Enter Address Input =>: ");
						rbd = getInt(console,"Enter Number of Beds Input =>: ");
						rba = getInt(console,"Enter Number of Bathrooms Input =>: ");
						rk = getInt(console,"Enter Number of Kitchens Input =>: ");
						sb = getInt(console,"Enter Number of Balconies Input =>: ");
						
						Suite suite = new Suite(ra,rbd,rba,rk,sb);
						hotel.addRoom(suite);
						rooms[nor++] = suite;
					}
					
					else if (choice.equalsIgnoreCase("4") && hotel.getNumOfRooms() < hotel_rc) {
						ra = getAddress(console,"Enter Address Input =>: ");
						rbd = getInt(console,"Enter Number of Beds Input =>: ");
						rba = getInt(console,"Enter Number of Bathrooms Input =>: ");
						rk = getInt(console,"Enter Number of Kitchens Input =>: ");
						sb = getInt(console,"Enter Number of Balconies Input =>: ");
						pp = getInt(console,"Enter Number of Private Pools Input =>: ");
						
						RoyalSuite royalSuite = new RoyalSuite(ra,rbd,rba,rk,sb,pp);
						hotel.addRoom(royalSuite);
						rooms[nor++] = royalSuite;
					}
					
					else if (choice.equalsIgnoreCase("5")) {
						
						if(hotel.getNumOfRooms() > 0) {
							Room room = getRoomFromRooms(console,rooms,nor);
							System.out.println(room);
						}
						
					}
					
					else if (choice.equalsIgnoreCase("6")) {
						
						if(hotel.getNumOfRooms() > 0) {
							Room room = getRoomFromRooms(console,rooms,nor);
							int nights = getInt(console,"Enter Number of Nights Input =>: ");
							System.out.println("Price: " + room.calculatePrice(nights));
						}
						
					}
					
					else if (choice.equalsIgnoreCase("7")) {
						break;
					}
					
				} while(true);
			}
			
			else if(choice.equalsIgnoreCase("8")) {
				break;
			}
			
			
			
		} while(true);
		

	
	console.close();
	
	
	
	
	}

public static boolean isValidName(String n) {
		/*
		 * Abstract: this methods checks that name has only letters and spaces
		 * 
		 * 
		 * Parameters: n : String
		 * 
		 * Return: boolean
		 * 
		 * */
	
		for(int i = 0; i < n.length();i++) {
			if(!Character.isAlphabetic(n.charAt(i)) && n.charAt(i) != ' ') {
				System.out.println("Invalid Name!");
				return false;
			}
		}
		
		return true;
	}	


public static boolean isValidAddress(String n) {
	/*
	 * Abstract: this methods checks that name has only letters and spaces
	 * 
	 * 
	 * Parameters: n : String
	 * 
	 * Return: boolean
	 * 
	 * */

	for(int i = 0; i < n.length();i++) {
		if(!Character.isDigit(n.charAt(i)) && n.charAt(i) != ' ') {
			System.out.println("Invalid Name!");
			return false;
		}
	}
	
	return true;
}	




public static String getString(Scanner console, String prompt) {
    while (true) {
        System.out.println(prompt);
        String value = console.nextLine(); 

        if (isValidName(value)) {
            return value; 
        }
        

        System.out.println("Invalid input. Please use letters and spaces only.");
    }
}


public static String getAddress(Scanner console, String prompt) {
    while (true) {
        System.out.println(prompt);
        String value = console.nextLine(); 

        if (isValidAddress(value)) {
            return value; 
        }
        

        System.out.println("Invalid input. Please use Digits only.");
    }
}



public static int getInt(Scanner console, String prompt) {
	/*
	 * Abstract: this method checks that the value passed to the console is an integer 
	 * 
	 * 
	 * Parameters: console: Scanner | prompt : String
	 * 
	 * 
	 * 
	 * Return: int
	 * 
	 * */
    while(true) {
        System.out.println(prompt);
        if(console.hasNextInt()) {
            int value = console.nextInt();
            console.nextLine(); 
            return value;
        }
        System.out.println("Invalid input. Please enter a number");
        console.next();
    }
}


public static double getDouble(Scanner console, String prompt) {
	/*
	 * Abstract: this method checks that the value passed to the console is a double
	 * 
	 * 
	 * Parameters: console: Scanner | prompt : String
	 * 
	 * 
	 * 
	 * Return: double
	 * 
	 * */
    while(true) {
        System.out.println(prompt);
        if(console.hasNextDouble()) {
            double value = console.nextDouble();
            console.nextLine(); 
            return value;
        }
        System.out.println("Invalid input. Please enter a number");
        console.next();
    }
}



public static Client getClientFromClientList(Scanner console,Client[] clientlist,int noc) {
	
	for(int i = 0; i < noc;i++) {
		System.out.println("[" + i + "] " + clientlist[i].displayInfo());
	}
	
	System.out.println("Choose Client");

	int clientindex = getInt(console,"Input =>: ");
	
	while(true) {
		if(clientindex < noc && clientindex >= 0)
			return clientlist[clientindex];
		else {
			System.out.println("Choose number less than or equal to: " + noc);
			clientindex = getInt(console,"Input =>: ");
		}
	}
	
}

public static Room getRoomFromRooms(Scanner console,Room[] rooms,int nor) {
	
		for(int i = 0 ; i < nor ; i ++) {
			System.out.println("[" + i + "] " + rooms[i].displayInfo());
		}
	
		System.out.println("Choose Room");
	
		int roomindex = getInt(console,"Input =>: ");
	
		while(true) {
			if(roomindex < nor && roomindex >=0)
				return rooms[roomindex];
			else {
				System.out.println("Choose number less than or equal to or write -100 to return back: " + nor);
				roomindex = getInt(console,"Input =>: ");
			}
		}
	
}


public static HotelEmployee getEmployeeFromEmployees(Scanner console,HotelEmployee[] employees , int noe) {
	
	for(int i = 0; i < noe ; i++) {
		System.out.println("[" + i + "] " + employees[i].displayInfo());
	}
	
	System.out.println("Choose Employee");
	
	int employeeindex = getInt(console,"Input =>: ");
	
	
	while(true) {
		if(employeeindex < noe && employeeindex >= 0)
			return employees[employeeindex];
		else {
			System.out.println("Choose number less than or equal to: " + noe);
			employeeindex = getInt(console,"Input =>: ");
		}
	}
}

public static String pickCleaningSection(Scanner console,String choice) {
	
	
	while(true) {
		
		System.out.println("Choose Section");
		System.out.println("[1] Roof");
		System.out.println("[2] Bathrooms");
		System.out.println("[3] Rooms");
		System.out.println("[4] Kitchen");
		System.out.println("[5] Storage");
		
		
		if(console.hasNextLine()) {
			choice = console.nextLine();
			
			if(choice.equalsIgnoreCase("1"))
				return "roof";
			else if(choice.equalsIgnoreCase("2"))
				return "bathrooms";
			else if(choice.equalsIgnoreCase("3"))
				return "rooms";
			else if(choice.equalsIgnoreCase("4"))
				return "kitchens";
			else if(choice.equalsIgnoreCase("5"))
				return "storage";
			else {
				System.out.println("Invalid Input!");
				choice = console.nextLine();
			}
		}
	}
 }

public static String pickCookTime(Scanner console,String choice) {
	
	
	while(true) {
		
		System.out.println("Choose Section");
		System.out.println("[1] Breakfast");
		System.out.println("[2] Lunch");
		System.out.println("[3] Dinner");
		
		
		if(console.hasNextLine()) {
			choice = console.nextLine();
			
			if(choice.equalsIgnoreCase("1"))
				return "breakfast";
			else if(choice.equalsIgnoreCase("2"))
				return "lunch";
			else if(choice.equalsIgnoreCase("3"))
				return "dinner";
			else {
				System.out.println("Invalid Input!");
				choice = console.nextLine();
			}
		}
	}
 }

public static String pickSecuritySection(Scanner console,String choice) {
	
	
	while(true) {
		
		System.out.println("Choose Section");
		System.out.println("[1] Cyber Security");
		System.out.println("[2] VSS");
		System.out.println("[3] PSIM");
		System.out.println("Input =>: ");
		
		if(console.hasNextLine()) {
			choice = console.nextLine();
			
			if(choice.equalsIgnoreCase("1"))
				return "cyber security";
			else if(choice.equalsIgnoreCase("2"))
				return "vss";
			else if(choice.equalsIgnoreCase("3"))
				return "psim";
			else {
				System.out.println("Invalid Input!");
				choice = console.nextLine();
			}
		}
	}
 }

public static String pickReciptionestLanguage(Scanner console,String choice) {
	
	
	while(true) {
		
		System.out.println("Choose Section");
		System.out.println("[1] Arabic");
		System.out.println("[2] English");
		System.out.println("[3] French");
		System.out.println("[4] Chinese");
		System.out.println("[5] Japanese");
		
		
		if(console.hasNextLine()) {
			choice = console.nextLine();
			
			if(choice.equalsIgnoreCase("1"))
				return "arabic";
			
			else if(choice.equalsIgnoreCase("2"))
				return "english";
			
			else if(choice.equalsIgnoreCase("3"))
				return "french";
			
			else if(choice.equalsIgnoreCase("4"))
				return "chinese";
			
			else if(choice.equalsIgnoreCase("5"))
				return "japanese";
			
			else {
				System.out.println("Invalid Input!");
				choice = console.nextLine();
			}
		}
	}
 }



public static String pickManagerDept(Scanner console,String choice) {
	
	
	while(true) {
		
		System.out.println("Choose Section");
		System.out.println("[1] Employees");
		System.out.println("[2] Resturant");
		System.out.println("[3] Cleaning");
		System.out.println("[4] Security");
		System.out.println("[5] Rooms");
		
		
		if(console.hasNextLine()) {
			choice = console.nextLine();
			
			if(choice.equalsIgnoreCase("1"))
				return "employees";
			
			else if(choice.equalsIgnoreCase("2"))
				return "resturant";
			
			else if(choice.equalsIgnoreCase("3"))
				return "cleaning";
			
			else if(choice.equalsIgnoreCase("4"))
				return "security";
			
			else if(choice.equalsIgnoreCase("5"))
				return "rooms";
			
			else {
				System.out.println("Invalid Input!");
				choice = console.nextLine();
			}
		}
	}
 }


public static Reciptionest pickReciptionest(Scanner console,HotelEmployee[] employees,int noe) {
	int[] indexes = {};
	int counter = 0;
	int choice  = 0;
	
	System.out.println("Choose Reciptionest");
	for(int i = 0; i < noe ; i++) {
		if(employees[i] instanceof Reciptionest) {
			System.out.println("Index [" + i + "] Info: " + employees[i].displayInfo());
			indexes[counter++] = i;
			}
		}
	
	while(true) {
		choice = getInt(console,"Input the index [i] of the Reciptionest =>: ");
		if(choice >= 0 && choice < noe && employees[choice] instanceof Reciptionest)
			return (Reciptionest) employees[choice];
		}
	}


public static Cleaner pickCleaner(Scanner console,HotelEmployee[] employees,int noe) {

	
	System.out.println("Choose Cleaner");
	for(int i = 0; i < noe ; i++) {
		if(employees[i] instanceof Cleaner) {
			System.out.println("Index [" + i + "] Info: " + employees[i].displayInfo());

			}
		}
	
	while(true) {
		int choice = getInt(console,"Input the index [i] of the Cleaner =>: ");
		if(choice >= 0 && choice < noe && employees[choice] instanceof Cleaner)
			return (Cleaner) employees[choice];
		}
	}

public static Cook pickCook(Scanner console,HotelEmployee[] employees,int noe) {

	
	System.out.println("Choose Cook");
	for(int i = 0; i < noe ; i++) {
		if(employees[i] instanceof Cook) {
			System.out.println("Index [" + i + "] Info: " + employees[i].displayInfo());
			}
		}
	
	while(true) {
		int choice = getInt(console,"Input the index [i] of the Cook =>: ");
		if(choice >= 0 && choice < noe && employees[choice] instanceof Cook)
			return (Cook) employees[choice];
		}
	}

public static Security pickSecurity(Scanner console,HotelEmployee[] employees,int noe) {

	
	System.out.println("Choose Security");
	for(int i = 0; i < noe ; i++) {
		if(employees[i] instanceof Security) {
			System.out.println("Index [" + i + "] Info: " + employees[i].displayInfo());
			}
		}
	
	while(true) {
		int choice = getInt(console,"Input the index [i] of the Security =>: ");
		if(choice >= 0 && choice < noe && employees[choice] instanceof Security)
			return (Security) employees[choice];
		
		}
	}

public static Manager pickManager(Scanner console,HotelEmployee[] employees,int noe) {

	
	System.out.println("Choose Manager");
	for(int i = 0; i < noe ; i++) {
		if(employees[i] instanceof Manager) {
			System.out.println("Index [" + i + "] Info: " + employees[i].displayInfo());
			}
		}
	
	while(true) {
		int choice = getInt(console,"Input the index [i] of the Manager =>: ");
		if(choice >= 0 && choice < noe && employees[choice] instanceof Manager)
			return (Manager) employees[choice];
		
		}
	}






}


