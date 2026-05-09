package Projects;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import Projects.HotelUtils;
import Projects.Hotel;
import java.io.*;
public class main {

	public static void main(String[] args) {
		
		System.out.println("---------------------------");
		System.out.println("[1]  Read From File");
		System.out.println("[2] Create New Hotel");
		System.out.println("---------------------------");
		
		String choice = "none";
		Scanner console = new Scanner(System.in);
		
		// hotel info
				String hotel_n = "empty";
					

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
				
				LinkedList clientlist = new LinkedList();

				LinkedList employees = new LinkedList();

				LinkedList rooms = new LinkedList();
				
				Hotel hotel = null;
				
				choice = console.nextLine();
		
		if(choice.equalsIgnoreCase("1")) {
			String path = HotelUtils.getPath(console,"Enter save path");
			boolean isSaved = false;
			try {
				hotel = Hotel.readFile(path+ File.separator + "HOTEL");
				
				File f = new File(path+ File.separator + "HOTELinitData");
				
				FileInputStream fos = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fos);
				
			
				hotel_n = ois.readUTF();
				clientlist = (LinkedList) ois.readObject();
				employees = (LinkedList) ois.readObject();
				rooms = (LinkedList) ois.readObject();
				System.out.println("File has been read.");
				isSaved = true;
				ois.close();
			}
			
			catch(FileNotFoundException e) {
				System.out.println("Error: Invalid path");
			}
			
			catch(IOException e) {
				System.out.println("A system error occured during reading");
			}
			
			catch(ClassNotFoundException e) {
				System.out.println("an error has occured during reading");
				e.getMessage();
			}
			
		}
		
		
		else if(choice.equalsIgnoreCase("2")){
		// hotel info
			
		
		hotel_n = "empty";


		// client info

		client_n = "empty";
		client_a = 0;
		client_r = "empty";
		client_record = true;

		// room info

		ra = "empty";
		rbd = 0;
		rba = 0;
		rk = 0;

		// suite info

		sb = 0;

		// royal suite info
		pp = 0;


		// Hotel Employees Info

		e_n = "empty";
		e_a = 0;

		num_of_managers = 0;
		num_of_security = 0;
		num_of_reciptionests = 0;
		num_of_cleaners = 0;
		num_of_cooks = 0;

		e_s = 0;

		// cleaners

		cl_sec = "empty";
		temp_cl = null;
		// Cooks

		co_wt = "empty";
		temp_co = null;
		// Security
		sc_sec = "empty";
		temp_s = null;

		// Reciptionest
		lang = "empty";
		temp_r = null;
		// Manager
		temp_m = null;
		temp_m2 = null;
		m_dept = "empty";
		dept = "empty";
		m_team_size = 0;


		// create hotel
		System.out.println("---------------------------------");
		System.out.println("Welcome");
		System.out.println("Enter Hotel Name ");
		

		
		// check valid name
	
		hotel_n = HotelUtils.getString(console,"Input =>: ");

		System.out.println("Creating Hotel!");
		System.out.println("---------------------------------");

		hotel = new Hotel(hotel_n);

		// lists to help in related methods

		clientlist = new LinkedList();
		
		employees = new LinkedList();
		
		rooms = new LinkedList();
		
		}
		// main menu
		do {
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Hotel " + hotel.getName() + " | Management System Dashboard");
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
				hotel_n = HotelUtils.getString(console,"Input =>: ");

				hotel.setName(hotel_n);
			}

			// display all information of hotel
			else if(choice.equalsIgnoreCase("2")){
				System.out.println(hotel.displayAllInfo());
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
		                client_n = HotelUtils.getString(console,"Enter Client Name Input =>: ");
		                client_a = HotelUtils.getInt(console,"Enter Age Input =>: ");

		                if(client_a > 18){
		                    while(true) {
		                        client_r = HotelUtils.getString(console,"Is Violation Record Of The Client Clear ? ans(yes/no) Input =>: ");
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
		                    clientlist.insertAtBack(client); 
		                }
		                else {
		                    System.out.println("Age must be bigger than 18 according to ABSHER constrains!");
		                }
		            } 
		            
		            // 2. Search Client
		            else if(choice.equalsIgnoreCase("2")) {
		                if(hotel.getNumOfClients() > 0) {
		                    Client client = HotelUtils.getClientFromClientList(console, clientlist);
		                    System.out.println("Client Index in hotel: " + hotel.SearchClient(client));
		                }
		                else {
		                    System.out.println("number of clients is zero");
		                }
		            }

		            // 3. Remove Client
		            else if(choice.equalsIgnoreCase("3")) {
		                if(hotel.getNumOfClients() > 0) {
		                    Client client = HotelUtils.getClientFromClientList(console, clientlist);
		                    client.releaseAllRooms();
		                    hotel.removeClient(client);
		                    HotelUtils.removeClientFromList(clientlist, client);
		                    System.out.println("Client has been removed");
		                }
		                else {
		                    System.out.println("number of clients is zero");
		                }
		            }

		        	// 4. Add Room to Client
					else if(choice.equalsIgnoreCase("4")) {
						if(hotel.getNumOfClients() > 0 && hotel.getNumOfRooms() > 0) {
							Client client = HotelUtils.getClientFromClientList(console, clientlist);
							Room room = HotelUtils.getRoomFromRooms(console, rooms);

							if (client.getAge() < 18) {
								System.out.println("Booking Denied: Client does not meet the age requirement (18+).");
							} 
							else if (HotelUtils.roomBelongsToClient(room, clientlist)) {
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
							Client client = HotelUtils.getClientFromClientList(console,clientlist);
							Room room = HotelUtils.getRoomFromRooms(console,rooms);
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
							Client client = HotelUtils.getClientFromClientList(console,clientlist);
							Room room = HotelUtils.getRoomFromRooms(console,rooms);
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
							Client client = HotelUtils.getClientFromClientList(console,clientlist);
							System.out.println(client);
						}
						else {
							System.out.println("number of clients is zero");
						}
					}


		            // 8. Exit the Client Menu
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
						
							e_n = HotelUtils.getString(console,"Enter Name Input =>: ");
							e_a = HotelUtils.getInt(console,"Enter Age Input =>: ");

							if(e_a < 19) {
								System.out.println("Invalid Age, age must be bigger than 18");
								continue;
							}

							e_s = HotelUtils.getDouble(console,"Enter Salary Input =>: ");
							m_dept = HotelUtils.pickManagerDept(console,choice);

							while(true) {
								m_team_size = HotelUtils.getInt(console,"Enter Team Size Input =>: ");
								if(m_team_size < 10 && m_team_size > 0)
									break;
								else {
									System.out.println("Invalid Size , must be between 10 and 0");
								}
							}

							Manager manager = new Manager(e_n,e_a,e_s,m_dept,m_team_size);
							hotel.addEmployee(manager);
							employees.insertAtBack(manager);
					}

					// 2. Create Receptionist
					else if (choice.equalsIgnoreCase("2")) {
						
							e_n = HotelUtils.getString(console,"Enter Name Input =>: ");
							e_a = HotelUtils.getInt(console,"Enter Age nput =>: ");

							if(e_a < 19) {
								System.out.println("Invalid Age, age must be bigger than 18");
								continue;
							}

							e_s = HotelUtils.getDouble(console,"Enter Salary Input =>: ");

							Reciptionest reciptionest = new Reciptionest(e_n,e_a,e_s);
							hotel.addEmployee(reciptionest);
							employees.insertAtBack(reciptionest);
						
					}

					// 3. Create Security
					else if (choice.equalsIgnoreCase("3")) {
						
							e_n = HotelUtils.getString(console,"Enter Name Input =>: ");
							e_a = HotelUtils.getInt(console,"Enter Age Input =>: ");

							if(e_a < 19) {
								System.out.println("Invalid Age, age must be bigger than 18");
								continue;
							}

							e_s = HotelUtils.getDouble(console,"Enter Salary Input =>: ");
							sc_sec = HotelUtils.pickSecuritySection(console,choice);

							Security security = new Security(e_n,e_a,e_s,sc_sec);
							hotel.addEmployee(security);
							employees.insertAtBack(security);
						
					}

					// 4. Create Cleaner
					else if (choice.equalsIgnoreCase("4")) {
						
							e_n = HotelUtils.getString(console,"Enter Name Input =>: ");
							e_a = HotelUtils.getInt(console,"Enter Age Input =>: ");

							if(e_a < 19) {
								System.out.println("Invalid Age, age must be bigger than 18");
								continue;
							}

							e_s = HotelUtils.getDouble(console,"Enter Salary Input =>: ");
							cl_sec = HotelUtils.pickCleaningSection(console,choice);

							Cleaner cleaner = new Cleaner(e_n,e_a,e_s,cl_sec);
							hotel.addEmployee(cleaner);
							employees.insertAtBack(cleaner);
					}

					// 5. Create Cook
					else if (choice.equalsIgnoreCase("5")) {
						
							e_n = HotelUtils.getString(console,"Enter Name Input =>: ");
							e_a = HotelUtils.getInt(console,"Enter Age Input =>: ");

							if(e_a < 19) {
								System.out.println("Invalid Age, age must be bigger than 18");
								continue;
							}

							e_s = HotelUtils.getDouble(console,"Enter Salary Input =>: ");
							co_wt = HotelUtils.pickCookTime(console,choice);

							Cook cook = new Cook(e_n,e_a,e_s,co_wt);
							hotel.addEmployee(cook);
							employees.insertAtBack(cook);
						
					}

					// 6. Add Language
					else if (choice.equalsIgnoreCase("6")) {
						if(HotelUtils.getNumOfReciptionests(employees) > 0) {
							lang = HotelUtils.pickReciptionestLanguage(console,choice);
							temp_r = HotelUtils.pickReciptionest(console,employees);
							temp_r.addLang(lang);
						} else {
							System.out.println("No Reciptionests");
						}
					}

					// 7. Remove Language
					else if (choice.equalsIgnoreCase("7")) {
						if(HotelUtils.getNumOfReciptionests(employees) > 0) {
							lang = HotelUtils.pickReciptionestLanguage(console,choice);
							temp_r = HotelUtils.pickReciptionest(console,employees);
							temp_r.removeLang(lang);
						} else {
							System.out.println("No Reciptionests");
						}
					}

					// 8. Add Member to Team
					else if (choice.equalsIgnoreCase("8")) {
						dept = HotelUtils.pickManagerDept(console,choice);
						if (!HotelUtils.hasManagerDept(employees,dept)) {
							System.out.println("No managers found for the " + dept + " department.");
							continue;
						} else {
							while(true) {
								temp_m = HotelUtils.pickManager(console,employees);
								if(temp_m.getManagerDept().equalsIgnoreCase(dept))
									break;
								else {
									System.out.println("Chooses Dept and Manager's Dept are different");
								}
							}
						}

						if(temp_m.getManagerDept().equalsIgnoreCase("resturant") && HotelUtils.getNumOfCooks(employees) > 0) {
							temp_co = HotelUtils.pickCook(console,employees);
							try {
								temp_m.addEmployeeToTeam(temp_co);
								
								System.out.println("Employee has been added to the team!");
								
							} catch (IllegalArgumentException e){
								
								System.out.println(e.getMessage());
							}
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("employees") && HotelUtils.getNumOfManagers(employees) > 1) {
							
							temp_m2 = HotelUtils.pickManager(console,employees);
							
							if(!temp_m2.Equals(temp_m)) {
								
								try { temp_m.addEmployeeToTeam(temp_m2); }
								
								catch(IllegalArgumentException e) 
								{ System.out.println(e.getMessage()); }
								
							} else {
								
								System.out.println("Can't add the same manager to it's team");
							}
							
						} 
						else if(temp_m.getManagerDept().equalsIgnoreCase("rooms") && HotelUtils.getNumOfReciptionests(employees) > 0) {
							
							temp_r = HotelUtils.pickReciptionest(console,employees);
							
							try { temp_m.addEmployeeToTeam(temp_r); }
							
							catch(IllegalArgumentException e) 
							
							{ System.out.println(e.getMessage()); }
							
						} 
						else if(temp_m.getManagerDept().equalsIgnoreCase("security") && HotelUtils.getNumOfSecurity(employees) > 0) {
							
							temp_s = HotelUtils.pickSecurity(console,employees);
							
							try { temp_m.addEmployeeToTeam(temp_s); }
							
							catch(IllegalArgumentException e) 
							
							{ System.out.println(e.getMessage()); }
							
						} 
						else if(temp_m.getManagerDept().equalsIgnoreCase("cleaning") && HotelUtils.getNumOfCleaners(employees) > 0) {
							temp_cl = HotelUtils.pickCleaner(console,employees);
							
							try { temp_m.addEmployeeToTeam(temp_cl); }
							
							catch(IllegalArgumentException e)
							
							{ System.out.println(e.getMessage()); }
						}
					}

					// 9. Search Member
					else if (choice.equalsIgnoreCase("9")) {
						
						dept = HotelUtils.pickManagerDept(console,choice);
						
						if(!HotelUtils.hasManagerDept(employees,dept)) {
							
							System.out.println("No managers found for the " + dept + " department.");
							
							continue;
							
						} else {
							
							while(true) {
								
								temp_m = HotelUtils.pickManager(console,employees);
								
								if(temp_m.getManagerDept().equalsIgnoreCase(dept)) break;
								
								else {
									System.out.println("Chooses Dept and Manager's Dept are different");
									temp_m = HotelUtils.pickManager(console,employees);
								}
							}	
						}

						if(temp_m.getManagerDept().equalsIgnoreCase("resturant")) {
							
							temp_co = HotelUtils.pickCook(console,employees);
							
							try { temp_m.searchEmployee(temp_co); }
							
							catch (IllegalArgumentException e)
							{ System.out.println("Not Found!"); }
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("employees")) {
							
							temp_m2 = HotelUtils.pickManager(console,employees);
							
							try { temp_m.searchEmployee(temp_m2); }
							
							catch (IllegalArgumentException e)
							{ System.out.println("Not Found!"); }
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("rooms")) {
							
							temp_r = HotelUtils.pickReciptionest(console,employees);
							
							try { temp_m.searchEmployee(temp_r); }
							
							catch (IllegalArgumentException e)
							{ System.out.println("Not Found!"); }
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("security")) {
							
							temp_s = HotelUtils.pickSecurity(console,employees);
							
							try { temp_m.searchEmployee(temp_s); }
							
							catch (IllegalArgumentException e)
							{ System.out.println("Not Found!"); }
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("cleaning")) {
							
							temp_cl = HotelUtils.pickCleaner(console,employees);
							
							try { temp_m.searchEmployee(temp_cl); }
							
							catch (IllegalArgumentException e)
							{ System.out.println("Not Found!"); }
						}
					}

					// 10. Remove Member
					else if (choice.equalsIgnoreCase("10")) {
						dept = HotelUtils.pickManagerDept(console,choice);
						if(!HotelUtils.hasManagerDept(employees,dept)) {
							System.out.println("No managers found for the " + dept + " department.");
							continue;
						} else {
							while(true) {
								temp_m = HotelUtils.pickManager(console,employees);
								if(temp_m.getManagerDept().equalsIgnoreCase(dept)) break;
								else {
									System.out.println("Chooses Dept and Manager's Dept are different");
									temp_m = HotelUtils.pickManager(console,employees);
								}
							}
						}

						if(temp_m.getManagerDept().equalsIgnoreCase("resturant")) {
							
							temp_co = HotelUtils.pickCook(console,employees);
							
							temp_m.removeEmployee(temp_co);
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("employees")) {
							
							temp_m2 = HotelUtils.pickManager(console,employees);
							
							temp_m.removeEmployee(temp_m2);
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("rooms")) {
							
							temp_r = HotelUtils.pickReciptionest(console,employees);
							
							temp_m.removeEmployee(temp_r);
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("security")) {
							
							temp_s = HotelUtils.pickSecurity(console,employees);
							
							temp_m.removeEmployee(temp_s);
							
						} else if(temp_m.getManagerDept().equalsIgnoreCase("cleaning")) {
							
							temp_cl = HotelUtils.pickCleaner(console,employees);
							
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
						
						
							
							ra = HotelUtils.getAddress(console, "Enter Address Input =>: ", rooms);
							
							rbd = HotelUtils.getInt(console, "Enter Number of Beds Input =>: ");
							
							rba = HotelUtils.getInt(console, "Enter Number of Bathrooms Input =>: ");
							
							rk = HotelUtils.getInt(console, "Enter Number of Kitchens Input =>: ");

							if (rbd > 0 && rba > 0 && rk > 0) {
								Standard standard = new Standard(ra, rbd, rba, rk);
								hotel.addRoom(standard);
								rooms.insertAtBack(standard);
								System.out.println("Room created!");
							} else {
								System.out.println("Beds,Bathrooms,Kitchens must be > 0");
							}
					
					}

					// create Studio
					else if (choice.equalsIgnoreCase("2")) {
						
						
							
							ra = HotelUtils.getAddress(console, "Enter Address Input =>: ", rooms);
							
							rbd = HotelUtils.getInt(console, "Enter Number of Beds Input =>: ");
							
							rba = HotelUtils.getInt(console, "Enter Number of Bathrooms Input =>: ");
							
							rk = HotelUtils.getInt(console, "Enter Number of Kitchens Input =>: ");
							

							if (rbd > 0 && rba > 0 && rk > 0) {
								Studio studio = new Studio(ra, rbd, rba, rk);
								hotel.addRoom(studio);
								rooms.insertAtBack(studio);
								System.out.println("Room created!");
							} else {
								System.out.println("Beds,Bathrooms,Kitchens must be > 0");
							}
						
					}

					// create Suite
					else if (choice.equalsIgnoreCase("3")) {
						
							
							ra = HotelUtils.getAddress(console, "Enter Address Input =>: ", rooms);
							
							rbd = HotelUtils.getInt(console, "Enter Number of Beds Input =>: ");
							
							rba = HotelUtils.getInt(console, "Enter Number of Bathrooms Input =>: ");
							
							rk = HotelUtils.getInt(console, "Enter Number of Kitchens Input =>: ");
							
							sb = HotelUtils.getInt(console, "Enter Number of Balconies Input =>: ");
							
							if (rbd > 0 && rba > 0 && rk > 0 && sb > 0) {
								
								Suite suite = new Suite(ra, rbd, rba, rk, sb);
								hotel.addRoom(suite);
								rooms.insertAtBack(suite);
								System.out.println("Room created!");
							} else {
								System.out.println("Beds,Bathrooms,Kitchens,balconies must be > 0");
							}
						
					}

					// create Royal Suite
					else if (choice.equalsIgnoreCase("4")) {
						
						
							
							ra = HotelUtils.getAddress(console, "Enter Address Input =>: ", rooms);
							
							rbd = HotelUtils.getInt(console, "Enter Number of Beds Input =>: ");
							
							rba = HotelUtils.getInt(console, "Enter Number of Bathrooms Input =>: ");
							
							rk = HotelUtils.getInt(console, "Enter Number of Kitchens Input =>: ");
							
							sb = HotelUtils.getInt(console, "Enter Number of Balconies Input =>: ");
							
							pp = HotelUtils.getInt(console, "Enter Number of Private Pools Input =>: ");
							

							if (rbd > 0 && rba > 0 && rk > 0 && sb > 0 && pp > 0) {
								RoyalSuite royalSuite = new RoyalSuite(ra, rbd, rba, rk, sb, pp);
								hotel.addRoom(royalSuite);
								rooms.insertAtBack(royalSuite);
								System.out.println("Room created!");
							} else {
								System.out.println("Beds,Bathrooms,Kitchens,balconies,private pools must be > 0");
							}
						
					}

					// display room info
					else if (choice.equalsIgnoreCase("5")) {
						if (hotel.getNumOfRooms() > 0) {
							Room room = HotelUtils.getRoomFromRooms(console, rooms);
							System.out.println(room);
						} else {
							System.out.println("No Rooms");
						}
					}

					// calculate price
					else if (choice.equalsIgnoreCase("6")) {
						
						if (hotel.getNumOfRooms() > 0) {
							
							Room room = HotelUtils.getRoomFromRooms(console, rooms);
							
							int nights = HotelUtils.getPositiveInt(console, "Enter Number of Nights Input =>: ");
							
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
			            HotelEmployee employee = HotelUtils.getEmployeeFromEmployees(console, employees);

			
			            Node current = employees.getHead();
			            while(current != null) {
			                if(current.data instanceof Manager) {
			                    Manager boss = (Manager) current.data;
			                    
			                    if(boss != employee && boss.inTeam(employee)) {
			                        boss.removeEmployee(employee);
			                    }
			                }
			                current = current.next;
			            }

			         
			            if(employee instanceof Manager) {
			                System.out.println("Unassigning manager's team...");
			                ((Manager) employee).disableTeam();
			            }

			       
			            hotel.removeEmployee(employee);

			           
			            Node temp = employees.getHead();
			            while (temp != null) {
			                if (((HotelEmployee) temp.data).Equals(employee)) {
			                    Node prevNode = temp.previous;
			                    Node nextNode = temp.next;

			                    if (prevNode == null) {
			                        try { employees.removeAtFront(); } catch(Exception e) {}
			                    } else if (nextNode == null) {
			                        try { employees.removeAtBack(); } catch(Exception e) {}
			                    } else {
			                 
			                        prevNode.next = nextNode;
			                        nextNode.previous = prevNode;
			                    }
			                    break; 
			                }
			                temp = temp.next;
			            }
			            
			            System.out.println("Employee fully removed from system.");
			        }
			        catch(Exception e) {
			            System.out.println("Error: " + e.getMessage());
			        }
			    } else {
			        System.out.println("No Employees");
			    }
			}


			// Destroy room
			else if(choice.equalsIgnoreCase("9")) {
			    if(hotel.getNumOfRooms() > 0) {
			        try {
			            Room room = HotelUtils.getRoomFromRooms(console, rooms);
			            boolean isBooked = false;

			            Node currentClientNode = clientlist.getHead();
			            while (currentClientNode != null) {
			                Client client = (Client) currentClientNode.data;
			                try {
			                    Room found = client.Search(room);
			                    if (found.getAddress().equalsIgnoreCase(room.getAddress())) {
			                        System.out.println("Room " + room.getAddress() + " belongs to client " + client.getName() + ".");
			                        System.out.println("Room can't be destroyed until removed by client.");
			                        isBooked = true;
			                        break;
			                    }
			                } catch (IllegalArgumentException e) {
			                    
			                }
			                currentClientNode = currentClientNode.next;
			            }

			            if (!isBooked) {
			                hotel.removeRoom(room);
			                HotelUtils.removeRoomFromList(rooms, room);
			                System.out.println("Room successfully destroyed.");
			            }
			        } catch (Exception e) {
			            System.out.println("An unexpected error occurred: " + e.getMessage());
			        }
			    } else {
			        System.out.println("No Rooms!");
			    }
			}





			


			// close program
			else if(choice.equalsIgnoreCase("10")) {
				System.out.println("Closing System....");
				boolean isSaved = false;
				
				
				while(!isSaved) {
					String path = HotelUtils.getPath(console,"Enter save path");
					
					try {
						hotel.writeFile(path + File.separator + "HOTEL");
						
						File f = new File(path+ File.separator + "HOTELinitData");
						
						FileOutputStream fos = new FileOutputStream(f);
						
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						
						
						oos.writeUTF(hotel_n);
						oos.writeObject(clientlist);
						oos.writeObject(employees);
						oos.writeObject(rooms);
						System.out.println("File has been saved.");
						isSaved = true;
						oos.close();
					}
					
					catch(FileNotFoundException e) {
						System.out.println("Error: Invalid path");
					}
					
					catch(IOException e) {
						System.out.println("A system error occured during writing");
					}
				}
				break;
			}



		} while(true);


		System.out.println("System closed!");
		console.close();




	}

}


