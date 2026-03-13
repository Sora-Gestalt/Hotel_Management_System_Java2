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

		int num_of_managers = 0;
		int num_of_security = 0;
		int num_of_reciptionests = 0;
		int num_of_cleaners = 0;
		int num_of_cooks = 0;

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


		// create hotel
		System.out.println("---------------------------------");
		System.out.println("Welcome");
		System.out.println("Enter Hotel Name ");


		// check valid name
		hotel_n = getString(console,"Input =>: ");


		System.out.println("Enter Rooms Capacity: ");
		hotel_rc = getPositiveInt(console, "Input =>: ");

		System.out.println("Enter Clients Capacity: ");
		hotel_cc = getPositiveInt(console, "Input =>: ");

		System.out.println("Enter Employees Capacity: ");
		hotel_ec = getPositiveInt(console, "Input =>: ");

		if(hotel_rc <= 0 || hotel_cc <= 0 || hotel_ec <= 0) {
			throw new IllegalArgumentException("all capacities must be > 0 \n shutdown...");
		}
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

		// main menu
		do {
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Hotel " + hotel.getName() + "| Management System Dashboard");
			System.out.println("Welcome");
			System.out.println("[1] set new name");
			System.out.println("[2] display all information");
			System.out.println("[3] display hotel information");
			System.out.println("[4] get revenue");
			System.out.println("[5] Clients Properties");
			System.out.println("[6] Employees Properties");
			System.out.println("[7] Rooms Properties");
			System.out.println("[8] Kick Employee");
			System.out.println("[9] Demolish Room");
			System.out.println("[10] exit");
			System.out.println("Input =>: ");

			choice = console.nextLine();
			// set new hotel name
			if(choice.equalsIgnoreCase("1")) {

				System.out.println("Enter Hotel Name ");



				// check valid name
				hotel_n = getString(console,"Input =>: ");

				hotel.setName(hotel_n);
			}

			// display all information of hotel
			else if(choice.equalsIgnoreCase("2")){
				hotel.displayAllInfo();
			}
			// display information of hotel
			else if(choice.equalsIgnoreCase("3")) {
				System.out.println(hotel);
			}

			// get revenue per night
			else if(choice.equalsIgnoreCase("4")) {
				System.out.println("Revenue per night: " + hotel.getRevenue());
			}

			// client menu

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
					// 1. Create & Add Client
					if(choice.equalsIgnoreCase("1")) {
						if(hotel.getNumOfClients() < hotel_cc) {
							client_n = getString(console,"Enter Client Name Input =>: ");
							client_a = getInt(console,"Enter Age Input =>: ");

							if(client_a > 18){
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
							else {
								System.out.println("Age must be bigger than 18 according to ABSHER constrains!");
							}
						}
						else {
							System.out.println("Limit has been reached");
						}
					}

					// 2. Search Client
					else if(choice.equalsIgnoreCase("2")) {
						if(hotel.getNumOfClients() > 0) {
							Client client = getClientFromClientList(console,clientlist,noc);
							System.out.println("Client Index in hotel: " + hotel.SearchClient(client));
						}
						else {
							System.out.println("number of clients is zero");
						}
					}

					// 3. Remove Client
					else if(choice.equalsIgnoreCase("3")) {
						if(hotel.getNumOfClients() > 0) {
							Client client = getClientFromClientList(console,clientlist,noc);
							client.releaseAllRooms();
							hotel.removeClient(client);
							for(int i = 0; i < noc ; i++) {
								if(clientlist[i].Equals(client)) {
									clientlist[i] = clientlist[noc-1];
									clientlist[noc-1] = null;
									noc--;
									break;
								}
							}
							System.out.println("Client has been removed");
						}
						else {
							System.out.println("number of clients is zero");
						}
					}

					// 4. Add Room to Client
					else if(choice.equalsIgnoreCase("4")) {
						if(hotel.getNumOfClients() > 0 && hotel.getNumOfRooms() > 0) {
							Client client = getClientFromClientList(console, clientlist, noc);
							Room room = getRoomFromRooms(console, rooms, nor);

							if (client.getAge() < 18) {
								System.out.println("Booking Denied: Client does not meet the age requirement (18+).");
							} 
							else if (roomBelongsToClient(room, clientlist, noc)) {
								System.out.println("Booking Denied: Room " + room.getAddress() + " is already occupied by another client.");
							} 
							else {
								try {
									client.addRoom(room);
									System.out.println("Success: Room " + room.getAddress() + " assigned to " + client.getName() + ".");
								} catch (Exception e) {
									System.out.println("Error: " + e.getMessage());
								}
							}
						} else {
							System.out.println("number of clients or rooms is zero");
						}
					}

					// 5. Remove Room from Client
					else if(choice.equalsIgnoreCase("5")) {
						if(hotel.getNumOfClients() > 0 && hotel.getNumOfRooms() > 0) {
							Client client = getClientFromClientList(console,clientlist,noc);
							Room room = getRoomFromRooms(console,rooms,nor);
							try {
								client.removeRoom(room);
								System.out.println("room removed!");
							}
							catch (IllegalArgumentException e){
								System.out.println(e.getMessage());
							}
						}
						else {
							System.out.println("number of clients or rooms is zero");
						}
					}

					// 6. Search Room of Client
					else if(choice.equalsIgnoreCase("6")) {
						if(hotel.getNumOfClients() > 0 && hotel.getNumOfRooms() > 0) {
							Client client = getClientFromClientList(console,clientlist,noc);
							Room room = getRoomFromRooms(console,rooms,nor);
							try {
								System.out.println("Index of Room: " + client.Search(room));
							}
							catch(IllegalArgumentException e) {
								System.out.println("Not Found!");
							}
						}
						else {
							System.out.println("number of clients or rooms is zero");
						}
					}

					// 7. Print Client Info
					else if(choice.equalsIgnoreCase("7")) {
						if(hotel.getNumOfClients() > 0) {
							Client client = getClientFromClientList(console,clientlist,noc);
							System.out.println(client);
						}
						else {
							System.out.println("number of clients is zero");
						}
					}

					// 8. Exit
					else if(choice.equalsIgnoreCase("8")) {
						break;
					}

				} while(true);
			}
			// employees menu
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

					// 1. Create Manager
					if(choice.equalsIgnoreCase("1")) {
						if(hotel.getNumOfEmployees() < hotel_ec) {
							e_n = getString(console,"Enter Name Input =>: ");
							e_a = getInt(console,"Enter Age Input =>: ");

							if(e_a < 19) {
								System.out.println("Invalid Age, age must be bigger than 18");
								continue;
							}

							e_s = getDouble(console,"Enter Salary Input =>: ");
							m_dept = pickManagerDept(console,choice);

							while(true) {
								m_team_size = getInt(console,"Enter Team Size Input =>: ");
								if(m_team_size < 10 && m_team_size > 0)
									break;
								else {
									System.out.println("Invalid Size , must be between 10 and 0");
								}
							}

							Manager manager = new Manager(e_n,e_a,e_s,m_dept,m_team_size);
							hotel.addEmployee(manager);
							employees[noe++] = manager;
						} else {
							System.out.println("Limit has been reached");
						}
					}

					// 2. Create Receptionist
					else if (choice.equalsIgnoreCase("2")) {
						if(hotel.getNumOfEmployees() < hotel_ec) {
							e_n = getString(console,"Enter Name Input =>: ");
							e_a = getInt(console,"Enter Age nput =>: ");

							if(e_a < 19) {
								System.out.println("Invalid Age, age must be bigger than 18");
								continue;
							}

							e_s = getDouble(console,"Enter Salary Input =>: ");

							Reciptionest reciptionest = new Reciptionest(e_n,e_a,e_s);
							hotel.addEmployee(reciptionest);
							employees[noe++] = reciptionest;
						} else {
							System.out.println("Limit has been reached");
						}
					}

					// 3. Create Security
					else if (choice.equalsIgnoreCase("3")) {
						if(hotel.getNumOfEmployees() < hotel_ec) {
							e_n = getString(console,"Enter Name Input =>: ");
							e_a = getInt(console,"Enter Age Input =>: ");

							if(e_a < 19) {
								System.out.println("Invalid Age, age must be bigger than 18");
								continue;
							}

							e_s = getDouble(console,"Enter Salary Input =>: ");
							sc_sec = pickSecuritySection(console,choice);

							Security security = new Security(e_n,e_a,e_s,sc_sec);
							hotel.addEmployee(security);
							employees[noe++] = security;
						} else {
							System.out.println("Limit has been reached");
						}
					}

					// 4. Create Cleaner
					else if (choice.equalsIgnoreCase("4")) {
						if(hotel.getNumOfEmployees() < hotel_ec) {
							e_n = getString(console,"Enter Name Input =>: ");
							e_a = getInt(console,"Enter Age Input =>: ");

							if(e_a < 19) {
								System.out.println("Invalid Age, age must be bigger than 18");
								continue;
							}

							e_s = getDouble(console,"Enter Salary Input =>: ");
							cl_sec = pickCleaningSection(console,choice);

							Cleaner cleaner = new Cleaner(e_n,e_a,e_s,cl_sec);
							hotel.addEmployee(cleaner);
							employees[noe++] = cleaner;
						} else {
							System.out.println("Limit has been reached");
						}
					}

					// 5. Create Cook
					else if (choice.equalsIgnoreCase("5")) {
						if(hotel.getNumOfEmployees() < hotel_ec) {
							e_n = getString(console,"Enter Name Input =>: ");
							e_a = getInt(console,"Enter Age Input =>: ");

							if(e_a < 19) {
								System.out.println("Invalid Age, age must be bigger than 18");
								continue;
							}

							e_s = getDouble(console,"Enter Salary Input =>: ");
							co_wt = pickCookTime(console,choice);

							Cook cook = new Cook(e_n,e_a,e_s,co_wt);
							hotel.addEmployee(cook);
							employees[noe++] = cook;
						} else {
							System.out.println("Limit has been reached");
						}
					}

					// 6. Add Language
					else if (choice.equalsIgnoreCase("6")) {
						if(getNumOfReciptionests(employees,noe) > 0) {
							lang = pickReciptionestLanguage(console,choice);
							temp_r = pickReciptionest(console,employees,noe);
							temp_r.addLang(lang);
						} else {
							System.out.println("No Reciptionests");
						}
					}

					// 7. Remove Language
					else if (choice.equalsIgnoreCase("7")) {
						if(getNumOfReciptionests(employees,noe) > 0) {
							lang = pickReciptionestLanguage(console,choice);
							temp_r = pickReciptionest(console,employees,noe);
							temp_r.removeLang(lang);
						} else {
							System.out.println("No Reciptionests");
						}
					}

					// 8. Add Member to Team
					else if (choice.equalsIgnoreCase("8")) {
						dept = pickManagerDept(console,choice);
						if (!hasManagerDept(employees,noe,dept)) {
							System.out.println("No managers found for the " + dept + " department.");
							continue;
						} else {
							while(true) {
								temp_m = pickManager(console,employees,noe);
								if(temp_m.getManagerDept().equalsIgnoreCase(dept))
									break;
								else {
									System.out.println("Chooses Dept and Manager's Dept are different");
								}
							}
						}

						if(temp_m.getManagerDept().equalsIgnoreCase("resturant") && getNumOfCooks(employees,noe) > 0) {
							temp_co = pickCook(console,employees,noe);
							try {
								temp_m.addEmployeeToTeam(temp_co);
								
								System.out.println("Employee has been added to the team!");
								
							} catch (IllegalArgumentException e){
								
								System.out.println(e.getMessage());
							}
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("employees") && getNumOfManagers(employees,noe) > 1) {
							
							temp_m2 = pickManager(console,employees,noe);
							
							if(!temp_m2.Equals(temp_m)) {
								
								try { temp_m.addEmployeeToTeam(temp_m2); }
								
								catch(IllegalArgumentException e) 
								{ System.out.println(e.getMessage()); }
								
							} else {
								
								System.out.println("Can't add the same manager to it's team");
							}
							
						} 
						else if(temp_m.getManagerDept().equalsIgnoreCase("rooms") && getNumOfReciptionests(employees,noe) > 0) {
							
							temp_r = pickReciptionest(console,employees,noe);
							
							try { temp_m.addEmployeeToTeam(temp_r); }
							
							catch(IllegalArgumentException e) 
							
							{ System.out.println(e.getMessage()); }
							
						} 
						else if(temp_m.getManagerDept().equalsIgnoreCase("security") && getNumOfSecurity(employees,noe) > 0) {
							
							temp_s = pickSecurity(console,employees,noe);
							
							try { temp_m.addEmployeeToTeam(temp_s); }
							
							catch(IllegalArgumentException e) 
							
							{ System.out.println(e.getMessage()); }
							
						} 
						else if(temp_m.getManagerDept().equalsIgnoreCase("cleaning") && getNumOfCleaners(employees,noe) > 0) {
							temp_cl = pickCleaner(console,employees,noe);
							
							try { temp_m.addEmployeeToTeam(temp_cl); }
							
							catch(IllegalArgumentException e)
							
							{ System.out.println(e.getMessage()); }
						}
					}

					// 9. Search Member
					else if (choice.equalsIgnoreCase("9")) {
						
						dept = pickManagerDept(console,choice);
						
						if(!hasManagerDept(employees,noe,dept)) {
							
							System.out.println("No managers found for the " + dept + " department.");
							
							continue;
							
						} else {
							
							while(true) {
								
								temp_m = pickManager(console,employees,noe);
								
								if(temp_m.getManagerDept().equalsIgnoreCase(dept)) break;
								
								else {
									System.out.println("Chooses Dept and Manager's Dept are different");
									temp_m = pickManager(console,employees,noe);
								}
							}	
						}

						if(temp_m.getManagerDept().equalsIgnoreCase("resturant")) {
							
							temp_co = pickCook(console,employees,noe);
							
							try { temp_m.searchEmployee(temp_co); }
							
							catch (IllegalArgumentException e)
							{ System.out.println("Not Found!"); }
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("employees")) {
							
							temp_m2 = pickManager(console,employees,noe);
							
							try { temp_m.searchEmployee(temp_m2); }
							
							catch (IllegalArgumentException e)
							{ System.out.println("Not Found!"); }
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("rooms")) {
							
							temp_r = pickReciptionest(console,employees,noe);
							
							try { temp_m.searchEmployee(temp_r); }
							
							catch (IllegalArgumentException e)
							{ System.out.println("Not Found!"); }
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("security")) {
							
							temp_s = pickSecurity(console,employees,noe);
							
							try { temp_m.searchEmployee(temp_s); }
							
							catch (IllegalArgumentException e)
							{ System.out.println("Not Found!"); }
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("cleaning")) {
							
							temp_cl = pickCleaner(console,employees,noe);
							
							try { temp_m.searchEmployee(temp_cl); }
							
							catch (IllegalArgumentException e)
							{ System.out.println("Not Found!"); }
						}
					}

					// 10. Remove Member
					else if (choice.equalsIgnoreCase("10")) {
						dept = pickManagerDept(console,choice);
						if(!hasManagerDept(employees,noe,dept)) {
							System.out.println("No managers found for the " + dept + " department.");
							continue;
						} else {
							while(true) {
								temp_m = pickManager(console,employees,noe);
								if(temp_m.getManagerDept().equalsIgnoreCase(dept)) break;
								else {
									System.out.println("Chooses Dept and Manager's Dept are different");
									temp_m = pickManager(console,employees,noe);
								}
							}
						}

						if(temp_m.getManagerDept().equalsIgnoreCase("resturant")) {
							
							temp_co = pickCook(console,employees,noe);
							
							temp_m.removeEmployee(temp_co);
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("employees")) {
							
							temp_m2 = pickManager(console,employees,noe);
							
							temp_m.removeEmployee(temp_m2);
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("rooms")) {
							
							temp_r = pickReciptionest(console,employees,noe);
							
							temp_m.removeEmployee(temp_r);
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("security")) {
							
							temp_s = pickSecurity(console,employees,noe);
							
							temp_m.removeEmployee(temp_s);
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("cleaning")) {
							
							temp_cl = pickCleaner(console,employees,noe);
							
							temp_m.removeEmployee(temp_cl);
						}
					}

					else if (choice.equalsIgnoreCase("11")) {
						break;
					}

				} while(true);
			}
			// rooms menu	
			else if (choice.equalsIgnoreCase("7")) {
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

					// create standard room
					if (choice.equalsIgnoreCase("1")) {
						
						if (hotel.getNumOfRooms() < hotel_rc) {
							
							ra = getAddress(console, "Enter Address Input =>: ", rooms, nor);
							
							rbd = getInt(console, "Enter Number of Beds Input =>: ");
							
							rba = getInt(console, "Enter Number of Bathrooms Input =>: ");
							
							rk = getInt(console, "Enter Number of Kitchens Input =>: ");

							if (rbd > 0 && rba > 0 && rk > 0) {
								Standard standard = new Standard(ra, rbd, rba, rk);
								hotel.addRoom(standard);
								rooms[nor++] = standard;
								System.out.println("Room created!");
							} else {
								System.out.println("Beds,Bathrooms,Kitchens must be > 0");
							}
						} else {
							System.out.println("Limit has been reached");
						}
					}

					// create Studio
					else if (choice.equalsIgnoreCase("2")) {
						
						if (hotel.getNumOfRooms() < hotel_rc) {
							
							ra = getAddress(console, "Enter Address Input =>: ", rooms, nor);
							
							rbd = getInt(console, "Enter Number of Beds Input =>: ");
							
							rba = getInt(console, "Enter Number of Bathrooms Input =>: ");
							
							rk = getInt(console, "Enter Number of Kitchens Input =>: ");
							

							if (rbd > 0 && rba > 0 && rk > 0) {
								Studio studio = new Studio(ra, rbd, rba, rk);
								hotel.addRoom(studio);
								rooms[nor++] = studio;
								System.out.println("Room created!");
							} else {
								System.out.println("Beds,Bathrooms,Kitchens must be > 0");
							}
						} else {
							System.out.println("Limit has been reached");
						}
					}

					// create Suite
					else if (choice.equalsIgnoreCase("3")) {
						
						if (hotel.getNumOfRooms() < hotel_rc) {
							
							ra = getAddress(console, "Enter Address Input =>: ", rooms, nor);
							
							rbd = getInt(console, "Enter Number of Beds Input =>: ");
							
							rba = getInt(console, "Enter Number of Bathrooms Input =>: ");
							
							rk = getInt(console, "Enter Number of Kitchens Input =>: ");
							
							sb = getInt(console, "Enter Number of Balconies Input =>: ");
							
							if (rbd > 0 && rba > 0 && rk > 0 && sb > 0) {
								
								Suite suite = new Suite(ra, rbd, rba, rk, sb);
								hotel.addRoom(suite);
								rooms[nor++] = suite;
								System.out.println("Room created!");
							} else {
								System.out.println("Beds,Bathrooms,Kitchens,balconies must be > 0");
							}
						} else {
							System.out.println("Limit has been reached");
						}
					}

					// create Royal Suite
					else if (choice.equalsIgnoreCase("4")) {
						
						if (hotel.getNumOfRooms() < hotel_rc) {
							
							ra = getAddress(console, "Enter Address Input =>: ", rooms, nor);
							
							rbd = getInt(console, "Enter Number of Beds Input =>: ");
							
							rba = getInt(console, "Enter Number of Bathrooms Input =>: ");
							
							rk = getInt(console, "Enter Number of Kitchens Input =>: ");
							
							sb = getInt(console, "Enter Number of Balconies Input =>: ");
							
							pp = getInt(console, "Enter Number of Private Pools Input =>: ");
							

							if (rbd > 0 && rba > 0 && rk > 0 && sb > 0 && pp > 0) {
								RoyalSuite royalSuite = new RoyalSuite(ra, rbd, rba, rk, sb, pp);
								hotel.addRoom(royalSuite);
								rooms[nor++] = royalSuite;
								System.out.println("Room created!");
							} else {
								System.out.println("Beds,Bathrooms,Kitchens,balconies,private pools must be > 0");
							}
						} else {
							System.out.println("Limit has been reached");
						}
					}

					// display room info
					else if (choice.equalsIgnoreCase("5")) {
						if (hotel.getNumOfRooms() > 0) {
							Room room = getRoomFromRooms(console, rooms, nor);
							System.out.println(room);
						} else {
							System.out.println("No Rooms");
						}
					}

					// calculate price
					else if (choice.equalsIgnoreCase("6")) {
						
						if (hotel.getNumOfRooms() > 0) {
							
							Room room = getRoomFromRooms(console, rooms, nor);
							
							int nights = getPositiveInt(console, "Enter Number of Nights Input =>: ");
							
							System.out.println("Price: " + room.calculatePrice(nights));
							
						} else {
							
							System.out.println("No Rooms");
						}
					}

					// exit room menu
					else if (choice.equalsIgnoreCase("7")) {
						break;
					}
				} while (true);
			}

			// Kick Employee
			else if(choice.equalsIgnoreCase("8")) {
				
				if(hotel.getNumOfEmployees() > 0) {
					
					try {
						
						HotelEmployee employee = getEmployeeFromEmployees(console, employees, noe);



						for (int i = 0; i < noe; i++) {
							
							if (employees[i] instanceof Manager) {
								
								Manager boss = (Manager) employees[i];
								
								if (boss != employee && boss.inTeam(employee)) {
									
									boss.removeEmployee(employee);
								}
							}
						}


						if(employee instanceof Manager) {
							
							System.out.println("Unassigning manager's team...");
							
							((Manager) employee).disableTeam();
						}

						// remove from hotel
						hotel.removeEmployee(employee);

						if(employee instanceof Reciptionest)
							
							num_of_reciptionests--;
						
						else if(employee instanceof Manager)
							
							num_of_managers--;
						
						else if(employee instanceof Cook)
							
							num_of_cooks--;
						
						else if(employee instanceof Cleaner)
							
							num_of_cleaners--;
						
						else if(employee instanceof Security)
							
							num_of_security--;


						// remove from main's
						for(int i = 0; i < noe; i++) {
							if(employees[i].Equals(employee)) {
								employees[i] = employees[noe-1];
								employees[noe-1] = null;
								noe--;

								break;
							}
						}
						System.out.println("Employee fully removed from system.");
					}
					catch(Exception e) {
						System.out.println("Error: " + e.getMessage());
					}
				}

				else {
					System.out.println("No Employees");
				}
			}


			// Destroy room
			else if(choice.equalsIgnoreCase("9")) {
				if(hotel.getNumOfRooms() > 0) {
					try {
						Room room = getRoomFromRooms(console,rooms,nor);
						boolean isBooked = false;

						for(int j = 0 ; j < noc ; j++) {
							try {
								Room found = clientlist[j].Search(room);
								if(found.getAddress().equalsIgnoreCase(room.getAddress())) {
									System.out.println("Room " + room.getAddress() + " belongs to client " + clientlist[j].getName() + ".");
									System.out.println("Room can't be destroyed until removed by client.");
									isBooked = true;
									break;
								}
							}

							catch (IllegalArgumentException e){
								// skip to next client
							}
						}

						// remove from hotels array
						if(!isBooked) {
							hotel.removeRoom(room);
							for(int i = 0; i < nor;i++) {
								if(rooms[i].getAddress().equalsIgnoreCase(room.getAddress())) {
									rooms[i] = rooms[nor-1];
									rooms[nor-1] = null;
									nor--;
									break;
								}
							}


							// remove from main's local array


						}


					}



					catch(Exception e) {
						System.out.println("An unexpected error occurred: " + e);
					}
				}


				else {
					System.out.println("No Rooms!");
				}





			}


			// close program
			else if(choice.equalsIgnoreCase("10")) {
				System.out.println("Closing System....");
				break;
			}



		} while(true);


		System.out.println("System closed!");
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
				return false;
			}
		}

		return true;
	}	



	public static boolean isUniqueAddress(String n,Room[] rooms, int nor) {
		/*
		 * Abstract: this methods checks that address isn't duplicated
		 * 
		 * 
		 * Parameters: n : String | rooms : Room[] | nor : int
		 * 
		 * 
		 * Return: boolean
		 * 
		 * */
		for(int i = 0 ; i < nor ; i++) {
			if(rooms[i].getAddress().equalsIgnoreCase(n))
				return false;
		}

		return true;
	}


	public static boolean roomBelongsToClient(Room room , Client[] clientlist , int noc) {

		for(int i = 0 ; i < noc ; i++) {
			try {
				clientlist[i].Search(room);
				return true;
			}
			catch (Exception e) {

			}
		}
		return false;
	}

	public static boolean hasManagerDept(HotelEmployee[] employees,int noe,String dept) {
		/*
		 * Abstract: this methods checks that there exist a manager for given dept
		 * 
		 * 
		 * Parameters: n : String | rooms : Room[] | nor : int
		 * 
		 * 
		 * Return: boolean
		 * 
		 * */
		for(int i = 0; i < noe ; i++) {
			if(employees[i] instanceof Manager && ((Manager) employees[i]).getManagerDept().equalsIgnoreCase(dept))
				return true;
		}

		return false;
	}

	public static boolean isValidAddress(String n,Room[] rooms,int nor) {
		/*
		 * Abstract: this methods checks that name has only letters and spaces
		 * 
		 * 
		 * Parameters: n : String
		 * 
		 * Return: boolean
		 * 
		 * */
		if(n.length() != 4) {
			System.out.println("Length must be 4");
			return false;
		}


		for(int i = 0; i < n.length();i++) {
			if(!Character.isDigit(n.charAt(i)) && n.charAt(i) != ' ') {
				return false;
			}
		}

		if(!isUniqueAddress(n,rooms,nor)) {
			System.out.println("Not Unique Address");
			return false;

		}

		return true;
	}	

	public static int getNumOfManagers(HotelEmployee[] employees,int noe) {
		/*
		 * Abstract: this methods counts managers
		 * 
		 * 
		 * Parameters: employees : HotelEmployee[] | noe : int
		 * 
		 * 
		 * Return: int
		 * 
		 * */
		int counter = 0;
		for(int i = 0 ; i < noe;i++) {
			if(employees[i] instanceof Manager)
				counter++;
		}

		return counter;
	}

	public static int getNumOfReciptionests(HotelEmployee[] employees,int noe) {
		/*
		 * Abstract: this methods counts reciptionests
		 * 
		 * 
		 * Parameters: employees : HotelEmployee[] | noe : int
		 * 
		 * 
		 * Return: int
		 * 
		 * */
		int counter = 0;
		for(int i = 0 ; i < noe;i++) {
			if(employees[i] instanceof Reciptionest)
				counter++;
		}

		return counter;
	}

	public static int getNumOfSecurity(HotelEmployee[] employees,int noe) {
		/*
		 * Abstract: this methods counts security
		 * 
		 * 
		 * Parameters: employees : HotelEmployee[] | noe : int
		 * 
		 * 
		 * Return: int
		 * 
		 * */
		int counter = 0;
		for(int i = 0 ; i < noe;i++) {
			if(employees[i] instanceof Security)
				counter++;
		}

		return counter;
	}

	public static int getNumOfCooks(HotelEmployee[] employees,int noe) {
		/*
		 * Abstract: this methods counts cooks
		 * 
		 * 
		 * Parameters: employees : HotelEmployee[] | noe : int
		 * 
		 * 
		 * Return: int
		 * 
		 * */
		int counter = 0;
		for(int i = 0 ; i < noe;i++) {
			if(employees[i] instanceof Cook)
				counter++;
		}

		return counter;
	}

	public static int getNumOfCleaners(HotelEmployee[] employees,int noe) {
		/*
		 * Abstract: this methods counts cleaners
		 * 
		 * 
		 * Parameters: employees : HotelEmployee[] | noe : int
		 * 
		 * 
		 * Return: int
		 * 
		 * */
		int counter = 0;
		for(int i = 0 ; i < noe;i++) {
			if(employees[i] instanceof Cleaner)
				counter++;
		}

		return counter;
	}




	public static String getString(Scanner console, String prompt) {
		/*
		 * Abstract: this method checks if given input is string
		 * 
		 * 
		 * Parameters: console: Scanner | prompt : String
		 * 
		 * 
		 * 
		 * Return: String
		 * 
		 * */
		while (true) {
			System.out.println(prompt);
			String value = console.nextLine(); 

			if (isValidName(value)) {
				return value; 
			}


			System.out.println("Invalid input. Please use letters and spaces only.");
		}
	}


	public static String getAddress(Scanner console, String prompt,Room[] rooms,int nor) {
		/*
		 * Abstract: this method gets Address of room
		 * 
		 * 
		 * Parameters: console: Scanner | prompt : String | rooms : Room[] | nor : int
		 * 
		 * 
		 * 
		 * Return: String
		 * 
		 * */
		while (true) {
			System.out.println(prompt);
			String value = console.nextLine(); 

			if (isValidAddress(value,rooms,nor)) {
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

	public static int getPositiveInt(Scanner console, String prompt) {
		/*
		 * Abstract: this method checks that the value passed to the console is a positive integer 
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
				if(value > 0)
					return value;


			} else {

				console.next(); 
			}

			System.out.println("Invalid input, Please enter a positive integer");
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
				if(value > 0)
					return value;
			}
			else {
				console.next();
			}
			System.out.println("Invalid input. Please enter a positive number");
		}
	}



	public static Client getClientFromClientList(Scanner console,Client[] clientlist,int noc) {

		for(int i = 0; i < noc;i++) {
			System.out.println("[" + i + "] " + clientlist[i].getName() + ", Number of Rooms: " + clientlist[i].getNumOfRooms());
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

	public static Room getRoomFromRooms(Scanner console, Room[] rooms, int nor) {
		/*
		 * Abstract: this method gets room
		 * 
		 * 
		 * Parameters: console: Scanner | rooms : Room[] | nor : int
		 * 
		 * 
		 * 
		 * Return: Room
		 * 
		 * */
		for(int i = 0 ; i < nor ; i ++) {
			System.out.println("[" + i + "] " + rooms[i].getAddress() + " " + rooms[i].getType());
		}

		System.out.println("Choose Room");
		int roomindex = getInt(console, "Input =>: ");

		while(true) {

			if(roomindex < nor && roomindex >= 0) {
				return rooms[roomindex];
			} else {

				System.out.println("Invalid Selection. Choose a number from 0 to " + (nor - 1));
				roomindex = getInt(console, "Input =>: ");
			}
		}
	}


	public static HotelEmployee getEmployeeFromEmployees(Scanner console,HotelEmployee[] employees , int noe) {
		/*
		 * Abstract: this method gets employee
		 * 
		 * 
		 * Parameters: console: Scanner | employees : HotelEmployee[] | noe : int
		 * 
		 * 
		 * 
		 * Return: HotelEmployee
		 * 
		 * */
		for(int i = 0; i < noe ; i++) {
			System.out.println("[" + i + "] " + employees[i].getName() + ", Salary: " + employees[i].getSalary());
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
		/*
		 * Abstract: this method picks cleaning section for Cleaner
		 * 
		 * 
		 * Parameters: console: Scanner | choice:String
		 * 
		 * 
		 * 
		 * Return: String
		 * 
		 * */

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
		/*
		 * Abstract: this method picks cooking time for Cook
		 * 
		 * 
		 * Parameters: console: Scanner | choice:String
		 * 
		 * 
		 * 
		 * Return: String
		 * 
		 * */

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
		/*
		 * Abstract: this method picks security section for Security
		 * 
		 * 
		 * Parameters: console: Scanner | choice:String
		 * 
		 * 
		 * 
		 * Return: String
		 * 
		 * */

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
		/*
		 * Abstract: this method picks Language for Reciptionest
		 * 
		 * 
		 * Parameters: console: Scanner | choice:String
		 * 
		 * 
		 * 
		 * Return: String
		 * 
		 * */

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
		/*
		 * Abstract: this method picks Department for Manager
		 * 
		 * 
		 * Parameters: console: Scanner | choice:String
		 * 
		 * 
		 * 
		 * Return: String
		 * 
		 * */

		while(true) {

			System.out.println("Choose Section");
			System.out.println("[1] Management of Managers");
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


	public static Reciptionest pickReciptionest(Scanner console, HotelEmployee[] employees, int noe) {
		/*
		 * Abstract: this method picks Reciptionest
		 * 
		 * 
		 * Parameters: console: Scanner | employees : HotelEmployee[] | noe : int
		 * 
		 * 
		 * 
		 * Return: Reciptionest
		 * 
		 * */
		System.out.println("Choose Reciptionest:");


		for(int i = 0; i < noe; i++) {
			if(employees[i] instanceof Reciptionest) {
				System.out.println("Index [" + i + "] Info: " + employees[i].displayInfo());
			}
		}


		while(true) {
			int choice = getInt(console, "Input the index [i] of the Reciptionest =>: ");
			if(choice >= 0 && choice < noe && employees[choice] instanceof Reciptionest) {
				return (Reciptionest) employees[choice];
			}
			System.out.println("Invalid selection. Please try again.");
		}
	}


	public static Cleaner pickCleaner(Scanner console,HotelEmployee[] employees,int noe) {
		/*
		 * Abstract: this method picks Cleaner
		 * 
		 * 
		 * Parameters: console: Scanner | employees : HotelEmployee[] | noe : int
		 * 
		 * 
		 * 
		 * Return: Cleaner
		 * 
		 * */

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
		/*
		 * Abstract: this method picks Cook
		 * 
		 * 
		 * Parameters: console: Scanner | employees : HotelEmployee[] | noe : int
		 * 
		 * 
		 * 
		 * Return: Cook
		 * 
		 * */

		System.out.println("Choose Cook");
		for(int i = 0; i < noe ; i++) {
			if(employees[i] instanceof Cook) {
				System.out.println("Index [" + i + "] Info: " + employees[i].displayInfo());
			}
		}

		while(true) {
			int choice = getInt(console,"Input the index [i] of the Cook =>: ");
			if(choice >= 0 && choice < noe && employees[choice] instanceof Cook) {
				return (Cook) employees[choice];
			}
			else {
				System.out.println("Invalid selection. Index is out of bounds or the employee is not Cook.");
			}
		}
	}

	public static Security pickSecurity(Scanner console,HotelEmployee[] employees,int noe) {
		/*
		 * Abstract: this method picks Security
		 * 
		 * 
		 * Parameters: console: Scanner | employees : HotelEmployee[] | noe : int
		 * 
		 * 
		 * 
		 * Return: Security
		 * 
		 * */

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
			else {
				System.out.println("Invalid selection. Index is out of bounds or the employee is not Security.");
			}
		}
	}





	public static Manager pickManager(Scanner console,HotelEmployee[] employees,int noe) {
		/*
		 * Abstract: this method picks Manager
		 * 
		 * 
		 * Parameters: console: Scanner | employees : HotelEmployee[] | noe : int
		 * 
		 * 
		 * 
		 * Return: Manager
		 * 
		 * */

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
			else {
				System.out.println("Invalid selection. Index is out of bounds or the employee is not Manager.");
			}

		}
	}




}



