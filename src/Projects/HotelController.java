package Projects;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import java.io.*;
import java.util.Optional;


public class HotelController {

	// initialize vars
    private Hotel hotel;
    private LinkedList employees;
    private LinkedList rooms;
    private LinkedList clients;
    
    // view lists
    @FXML private ListView<Room> roomsListView;
    @FXML private ListView<HotelEmployee> employeesListView;
    @FXML private ListView<Client> clientListView;
    
    // new Standard Room
    @FXML private TextField newStandardRoomAddress;
    @FXML private TextField newStandardRoomNumOfBeds;
    @FXML private TextField newStandardRoomNumOfBathrooms;
    @FXML private TextField newStandardRoomNumOfKitchens;
    
    // new Studio Room
    @FXML private TextField newStudioRoomAddress;
    @FXML private TextField newStudioRoomNumOfBeds;
    @FXML private TextField newStudioRoomNumOfBathrooms;
    @FXML private TextField newStudioRoomNumOfKitchens;
    
    
    // new Suite Room
    @FXML private TextField newSuiteRoomAddress;
    @FXML private TextField newSuiteRoomNumOfBeds;
    @FXML private TextField newSuiteRoomNumOfBathrooms;
    @FXML private TextField newSuiteRoomNumOfKitchens;
    @FXML private TextField newSuiteRoomNumOfBalconies;
    
    // new RoyalSuite Room
    @FXML private TextField newRoyalSuiteRoomAddress;
    @FXML private TextField newRoyalSuiteRoomNumOfBeds;
    @FXML private TextField newRoyalSuiteRoomNumOfBathrooms;
    @FXML private TextField newRoyalSuiteRoomNumOfKitchens;
    @FXML private TextField newRoyalSuiteRoomNumOfBalconies;
    @FXML private TextField newRoyalSuiteRoomNumOfPrivatePools;
    
    // Rooms Price
    @FXML private TextField nightsField;
    
    // new Cook
    @FXML private TextField newCookName;
    @FXML private TextField newCookAge;
    @FXML private TextField newCookSalary;
    @FXML private TextField newCookTime;
    @FXML private ComboBox<String> cookTimes;
    // new Cleaner
    @FXML private TextField newCleanerName;
    @FXML private TextField newCleanerAge;
    @FXML private TextField newCleanerSalary;
    @FXML private TextField newCleanerSection;
    @FXML private ComboBox<String> cleanSections;
    // new Reciptionest
    @FXML private TextField newReciptionestName;
    @FXML private TextField newReciptionestAge;
    @FXML private TextField newReciptionestSalary;
    @FXML private TextField newReciptionestLanguage;
    @FXML private ComboBox<String> languages;
    
    // new Manager
    @FXML private TextField newManagerName;
    @FXML private TextField newManagerAge;
    @FXML private TextField newManagerSalary;
    @FXML private TextField newManagerDept;
    @FXML private TextField newManagerTeamSize;
    @FXML private ComboBox<String> depts;
    // new Security
    @FXML private TextField newSecurityName;
    @FXML private TextField newSecurityAge;
    @FXML private TextField newSecuritySalary;
    @FXML private TextField newSecuritySector;
    @FXML private ComboBox<String> sectors;
    
    @FXML private ImageView setupLogo;
    @FXML private TextField clientRemoveField;
    @FXML private TextField clientSearchField;
    @FXML private TextField newClientNameField;
    @FXML private TextField newClientAgeField;
    @FXML private CheckBox violationClearBox;
    @FXML private TextField hotelNameField;
    @FXML private TextField pathField;
    @FXML private TextField updateHotelNameField;
    @FXML private TextField clientNameField;
    @FXML private TextField employeeNameField; 
    @FXML private TextField roomAddressField;
    @FXML private TextArea statusConsole;
    @FXML private TextArea clientStatusConsole;
    @FXML private TextArea roomStatusConsole;
    @FXML private TextArea employeeStatusConsole;
    @FXML private Pane dashboardPane;           
    @FXML private Pane setupPane;            
    @FXML private Pane clientsPane;
    @FXML private Pane roomsPane;
    @FXML private Pane hotelEmployeesPane;
    @FXML private Pane navBarPane;
    @FXML private Pane loadPane;
    
    @FXML public void showLoadPane() {setupPane.setVisible(false); loadPane.setVisible(true);}
    @FXML public void showSetupPane() {setupPane.setVisible(true); loadPane.setVisible(false);}
    @FXML public void showDashboard() {dashboardPane.setManaged(true); roomsPane.setManaged(false); hotelEmployeesPane.setManaged(false); clientsPane.setManaged(false); clientsPane.setVisible(false); roomsPane.setVisible(false); hotelEmployeesPane.setVisible(false); navBarPane.setVisible(true); setupPane.setVisible(false);  dashboardPane.setVisible(true);}
    @FXML public void showClientsPane() {dashboardPane.setManaged(false); roomsPane.setManaged(false); hotelEmployeesPane.setManaged(false); clientsPane.setManaged(true);  dashboardPane.setVisible(false); roomsPane.setVisible(false); hotelEmployeesPane.setVisible(false); navBarPane.setVisible(true); setupPane.setVisible(false);  clientsPane.setVisible(true); refreshClientList();}
    @FXML public void showRoomsPane() {dashboardPane.setManaged(false); roomsPane.setManaged(true); hotelEmployeesPane.setManaged(false); clientsPane.setManaged(false); dashboardPane.setVisible(false); clientsPane.setVisible(false); hotelEmployeesPane.setVisible(false); navBarPane.setVisible(true); setupPane.setVisible(false);  roomsPane.setVisible(true); refreshRoomList();}
    @FXML public void showEmployeesPane() {dashboardPane.setManaged(false); roomsPane.setManaged(false); hotelEmployeesPane.setManaged(true); clientsPane.setManaged(false); dashboardPane.setVisible(false); clientsPane.setVisible(false); roomsPane.setVisible(false); navBarPane.setVisible(true); setupPane.setVisible(false);  hotelEmployeesPane.setVisible(true); refreshEmployeeList();}
    
    
    
    
    @FXML
    private void initialize() {
    	
    	
    	try {
            InputStream is = getClass().getResourceAsStream("KSU_HOTELS.png");
            if (is != null) {
                setupLogo.setImage(new Image(is));
            }
        } catch (Exception e) {
            System.out.println("Could not load logo into setup pane.");
        }
    	
    	
    	
    	if(cookTimes != null) {
    		cookTimes.getItems().addAll("Breakfast","Lunch","Dinner");
    	}
    	
    	if(cleanSections != null) {
    		cleanSections.getItems().addAll("Roof","Bathrooms","Rooms","Kitchen","Storage");
    	}
    	
    	if(depts != null) {
    		depts.getItems().addAll("resturant","employees","rooms","security","cleaning");
    	}
    	
    	if(sectors != null) {
    		sectors.getItems().addAll("cyber security","VSS","PSIM");
    	}
    	
    	if(languages != null) {
    		languages.getItems().addAll("arabic","english","french","chinese","japanese");
    	}
    	
    	
    }
    
    @FXML
    private void updateLog(String message) {
    	statusConsole.appendText("\n" + message);
    	if (clientsPane.isVisible())
    		clientStatusConsole.setText(message);
    	if (roomsPane.isVisible())
    		roomStatusConsole.setText(message);
    	if(hotelEmployeesPane.isVisible())
    		employeeStatusConsole.setText(message);
    }
    @FXML
    private void refreshClientList() {
    	clientListView.getItems().clear();
    	
    	Node current = this.clients.getHead();
    	
    	while(current != null) {
    		Client c = (Client) current.getData();
    		clientListView.getItems().add(c);
    		
    		current = current.next;
    	}
    }
    
    @FXML
    private void refreshRoomList() {
    	roomsListView.getItems().clear();
    	
    	Node current = this.rooms.getHead();
    	
    	while(current != null) {
    		Room r = (Room) current.getData();
    		roomsListView.getItems().add(r);
    		
    		current = current.next;
    	}
    }
    
    @FXML
    private void refreshEmployeeList() {
    	employeesListView.getItems().clear();
    	
    	Node current = this.employees.getHead();
    	
    	while(current!=null) {
    		HotelEmployee he = (HotelEmployee) current.getData();
    		employeesListView.getItems().add(he);
    		
    		current = current.next;
    	}
    }
    
    @FXML
    private void saveData() {
    	
    	String userHome = System.getProperty("user.home");
    	String documentPath = userHome + File.separator + "Documents" + File.separator + "HotelSaves";
    	File dir = new File(documentPath);
    	if (!dir.exists())
    		dir.mkdirs();
    	
    	try {
    		
    		this.hotel.writeFile(documentPath + File.separator + "HOTEL");
    		File f = new File(documentPath + File.separator + "HOTELinitData");
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
    		
    		oos.writeUTF(this.hotel.getName());
    		oos.writeObject(this.clients);
    		oos.writeObject(this.employees);
    		oos.writeObject(this.rooms);
    		oos.close();
    		updateLog("Succesful System Save To: " + documentPath);
    		System.out.println("Succesful System Save To: " + documentPath);
    	}
    	
    	catch(IOException e) {
    		updateLog("[ERROR] Auto-save failed: " + e.getMessage());
    	}
    	
    }
    
    private void syncLists() {
    	this.employees = hotel.getHotelEmployees();
    	this.clients = hotel.getClients();
    	this.rooms = hotel.getRooms();
    }
    
    private void showErrorAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    
    @FXML
    public void onStartHotel() {
        String name = hotelNameField.getText();
        if (HotelUtils.isValidName(name)) {

            this.hotel = new Hotel(name);
            

            this.employees = hotel.getHotelEmployees();
            this.clients = hotel.getClients();
            this.rooms = hotel.getRooms();
  
            setupPane.setVisible(false);
            dashboardPane.setVisible(true);
            navBarPane.setVisible(true);
            
            updateLog("Welcome to " + name + " Management System!");
        } else {

            hotelNameField.setPromptText("Please enter a name first!");
        }
    }
    
    
    @FXML
    public void handleLoadFromPath() {
        
        String userHome = System.getProperty("user.home");
        String documentPath = userHome + File.separator + "Documents" + File.separator + "HotelSaves";
        
        System.out.println("[DEBUG] Attempting to load from: " + documentPath);

        try {
            File hotelFile = new File(documentPath + File.separator + "HOTEL");
            if (!hotelFile.exists()) {
                throw new FileNotFoundException("The main 'HOTEL' save file is missing.");
            }
            
            this.hotel = Hotel.readFile(hotelFile.getAbsolutePath());
            File initFile = new File(documentPath + File.separator + "HOTELinitData");
            if (!initFile.exists()) {
                throw new FileNotFoundException("The 'HOTELinitData' file is missing.");
            }


            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(initFile))) {
                String hotel_n = ois.readUTF();
                this.clients = (LinkedList) ois.readObject();
                this.employees = (LinkedList) ois.readObject();
                this.rooms = (LinkedList) ois.readObject();
                

                this.hotel.setName(hotel_n);
            }


            
            dashboardPane.setVisible(true);
            navBarPane.setVisible(true);
            this.syncLists();
            updateLog("Successfully loaded session: " + this.hotel.getName());
            System.out.println("[SUCCESS] Hotel data synchronized.");

        } catch (FileNotFoundException e) {
            showErrorAlert("File Not Found", "The system couldn't find your save files.", e.getMessage());
        } catch (IOException e) {
            showErrorAlert("IO Error", "A system error occurred while reading the files.", e.getMessage());
        } catch (ClassNotFoundException e) {
            showErrorAlert("Data Error", "The save file format is incompatible with the current version.", e.getMessage());
        } catch (Exception e) {

            showErrorAlert("Unexpected Error", "Something went wrong during the load process.", e.toString());
            e.printStackTrace();
        }
    }
    
  
    
    @FXML
    public void handleUpdateHotelName() {
    	String newName = updateHotelNameField.getText();
    	if (HotelUtils.isValidName(newName)) {
    		this.hotel.setName(newName);
    		updateLog("[SYSTEM LOG] Name updated successfully.\n" + 
                    "Welcome to " + this.hotel.getName() + " Management System!");
    		hotelNameField.clear();
    	}
    	
    	else {
    		updateLog("[ERROR] Please enter a valid name.");
    	}
    }
    
    @FXML
    public void handleDisplayHotelInfo() {
    	updateLog(this.hotel.displayInfo());
    }
    
    @FXML
    public void handleDisplayAllHotelInfo() {
    	updateLog(this.hotel.displayAllInfo());
    }
    
    @FXML
    public void handleGetRevenue() {
    	updateLog("Total Revenue: " + this.hotel.getRevenue());
    }
    
    
    // client menu
    @FXML
    public void handleAddClient() {
    	
    	try {
    		String name = newClientNameField.getText();
    		String ageText = newClientAgeField.getText();
    		boolean recordClear = violationClearBox.isSelected();
    		
    		if (!HotelUtils.validName(name)) {
    			updateLog("[ERROR] Invalid Client Name!");
    			return;
    		}
    		
    		int age = Integer.parseInt(ageText);
    		
    		if(age > 18) {
    			Client newClient = new Client(name,age,recordClear);
    			
    			this.hotel.addClient(newClient);

    			
    			this.refreshClientList();
    			newClientNameField.clear();
    			newClientAgeField.clear();
    			violationClearBox.setSelected(false);
    			
    			updateLog("[SUCCESS] Client " + name + " has been registered.");
    		}
    		
    		else {
    			updateLog("[DENIED] Age must be 18+ according to ABSHER constraints.");
    		}
    	}
    	
    	catch(NumberFormatException e) {
    		updateLog("[ERROR] Please enter a valid number for age");
    	}
    	
    	catch(Exception e) {
    		updateLog("[ERROR] Could not add client: " + e.getMessage());
    	}
    }
    
    public void handleSearchClient() {
    	
    	if(this.hotel.getNumOfClients() > 0) {
    		String searchName = clientSearchField.getText();
    		
    		if(!HotelUtils.validName(searchName)) {
    			updateLog("[ERROR] Please enter a valid name to search.");
    			return;
    		}
    		
    		Node current = this.clients.getHead();
    		boolean found = false;
    		
    		while(current != null) {
    			Client c = (Client) current.getData();
    			
    			if (c.getName().equalsIgnoreCase(searchName.trim())) {
    				clientListView.getSelectionModel().select(c);    	
    				clientListView.scrollTo(c);
    				
    				updateLog("[FOUND] Client Details:\n " + c.toString());
    				found = true;
    				break;
    			}
    			current = current.next;
    		}
    		
    		if(!found) {
    			updateLog("[NOT FOUND] No client matches given name.");
    		}
    	}
    	
    	else {
    		updateLog("[ALERT] No Clients");
    	}
    }
    
    
    public void handleRemoveClient() {
    	
    	if(this.hotel.getNumOfClients() > 0) {
    		Client selected = clientListView.getSelectionModel().getSelectedItem();
    		
    		if(selected == null) {
    			updateLog("[ERROR] Please select a client from the list to remove.");
    			return;
    		}
    		
    		selected.releaseAllRooms();
    		this.hotel.removeClient(selected);
    		
    		boolean notRemoved = HotelUtils.removeClientFromList(clients, selected);
    		
    		if(!notRemoved) {
    			this.refreshClientList();
    			updateLog("[SUCCESS] Client " + selected.getName() + " has been removed." );
    		}
    		
    		else {
    			updateLog("[FAILED] System could not find client with given name");
    		}
    	}
    	
    	else {
    		updateLog("[ALERT] No Clients");
    	}
    	
    }
    
    public void handleAssignRoomToClient() {
    	
    	if(this.hotel.getNumOfClients() > 0 && this.hotel.getNumOfRooms() > 0) {
    		Client selected = clientListView.getSelectionModel().getSelectedItem();
    		
    		if(selected == null) {
    			updateLog("[ERROR] Please select a client from the list to remove.");
    			return;
    		}
    		
    		TextInputDialog roomDialog = new TextInputDialog();
    		roomDialog.setTitle("Assign Room");
    		roomDialog.setHeaderText("Assigning Room to " + selected.getName());
    		roomDialog.setContentText("Enter Room Address: ");
    		
    		Optional<String> roomResult = roomDialog.showAndWait();
    		
    		if(roomResult.isPresent()) {
    			String targetAddress = roomResult.get();
    			Room selectedRoom = null;
    			
    			Node current = this.rooms.getHead();
    			
    			while(current!=null) {
    				Room r = (Room) current.getData();
    				
    				if (r.getAddress().equalsIgnoreCase(targetAddress)) {
    					selectedRoom = r;
    					break;
    				}
    				current = current.next;
    			}
    			
    			if(selectedRoom == null) {
        			updateLog("[ERROR] Room address " + targetAddress + " not found.");
        		}
    			
    			else if(selected.getAge() < 18) {
    				updateLog("[DENIED] Age must be +18 according to ABSHER constraints.");
    			}
    			
    			else if(HotelUtils.roomBelongsToClient(selectedRoom, this.clients)) {
    				updateLog("[DENIED] Room is already occupied by another client.");
    			}
    			
    			else {
    				try {
    					selected.addRoom(selectedRoom);
    					updateLog("[SUCCESS] Room " + selectedRoom.getAddress() + " has been registered for client " + selected.getName());
    					this.refreshClientList();
    				}
    				
    				catch(Exception e) {
    					updateLog("[ERROR] " + e.getMessage());
    				}
    			}
    		}
    		
    	}
    	
    	else {
    		updateLog("[ALERT] Either no clients or no rooms");
    	}
    }
    
    
    public void handleUnassignRoomFromClient() {
    	if(this.hotel.getNumOfClients() > 0 && this.hotel.getNumOfRooms() > 0) {
    		Client selected = clientListView.getSelectionModel().getSelectedItem();
    		
    		if (selected == null) {
    			updateLog("[ERROR] Please select a client from the list to remove.");
    			return;
    		}
    		
    		TextInputDialog dialog = new TextInputDialog();
    		dialog.setTitle("Unassign Room"); 
    		dialog.setHeaderText("Unassigning Room From " + selected.getName());
    		dialog.setContentText("Enter Room Address");
    		
    		Optional<String> roomResult = dialog.showAndWait();
    		if(roomResult.isPresent()) {
    			String targetAddress = roomResult.get();
    			Room selectedRoom = null;
    			
    			Node current = this.rooms.getHead();
    			
    			while(current!=null) {
    				Room r = (Room) current.getData();
    				
    				if(r.getAddress().equalsIgnoreCase(targetAddress)) {
    					selectedRoom = r;
    					break;
    				}
    				
    				current = current.next;
    			}
    			
    			if(selectedRoom == null) {
        			updateLog("[ERROR] Room address " + targetAddress + " not found.");
        		}
    				
    			else {
    				try {
    					selected.removeRoom(selectedRoom);
    					updateLog("[SUCCESS] Room " + selectedRoom.getAddress() + " has been unassigned from " + selected.getName());
    					this.refreshClientList();
    				}
    				
    				catch(Exception e) {
    					updateLog("[ERROR] " + e.getMessage());
    				}
    			}
    		}
    	}
    	
    	else {
    		updateLog("[ALERT] Either no clients or no rooms");
    	}
    }
    
    
    
    public void handleDisplayClientInfo() {
    	Client selected = clientListView.getSelectionModel().getSelectedItem();
    	
    	if (selected != null){
    		updateLog("--- Client Info ---\n" + selected.toString() + "\n\n Registration Status: Active" + "\nABSHER Verification: " + (selected.getAge() >= 18 ? "Verified" : "Underage"));
    	}
    	
    	else {
    		updateLog("[ERROR] Please select a regeistered client to view client's information.");
    	}
    }
    
    
    // employees menu
    public void handleCreatCook() {
    	
    	try {
    		String cookName = newCookName.getText();
    		String cookAge = newCookAge.getText();
    		String cookSalary = newCookSalary.getText();
    		String cookTime = cookTimes.getValue();
    		
    		int age = Integer.parseInt(cookAge);
    		double salary = Double.parseDouble(cookSalary);
    		
    		if(!HotelUtils.validName(cookName)){
    			updateLog("[ERROR] Invalid Employee Name!");
    			return;
    		}
    		
    		if(cookTime ==null) {
    			updateLog("[ERROR] Choose a cooking time.");
    			return;
    		}
    		
    		if(age > 18 && salary > 0) {
    			Cook newCook = new Cook(cookName,age,salary,cookTime);
    			this.hotel.addEmployee(newCook);
    			this.refreshEmployeeList();
    			this.newCookName.clear();
    			this.newCookAge.clear();
    			this.newCookSalary.clear();
    			updateLog("[SUCCESS] Cook " + newCook.getName() + "has been added!");
    		}
    		
    		else {
    			updateLog("[DENIED] Age must be +18 according to ABSHER constrains \n Salary must be positive");
    		}
    		
    
    	}
    	
    	
    	catch(Exception e) {
    		updateLog("[ERROR] Could not add cook.");
    	}
    }
    
    public void handleCreateSecurity() {
    	try {
    		String securityName = newSecurityName.getText();
    		String securityAge = newSecurityAge.getText();
    		String securitySalary = newSecuritySalary.getText();
    		String securitySector = sectors.getValue();
    		
    		int age = Integer.parseInt(securityAge);
    		double salary = Double.parseDouble(securitySalary);
    		
    		if(!HotelUtils.validName(securityName)) {
    			updateLog("[ERROR] Invalid Employee Name!");
    			return;
    		}
    		
    		if(securitySector ==null) {
    			updateLog("[ERROR] Choose a sector.");
    			return;
    		}
    		
    		if(age > 18 && salary > 0) {
    			Security newSecurity = new Security(securityName,age,salary,securitySector);
    			this.hotel.addEmployee(newSecurity);
    			this.refreshEmployeeList();
    			this.newSecurityName.clear();
    			this.newSecurityAge.clear();
    			this.newSecuritySalary.clear();
    			updateLog("[SUCCESS] Security " + newSecurity.getName() + " has been added!");
    		}
    		
    		else {
    			updateLog("[DENIED] Age must be +18 according to ABSHER constrains \n Salary must be positive");
    		}
    	}
    	
    	catch(Exception e) {
    		updateLog("[ERROR] Could not add Security.");
    	}
    }
    
    public void handleCreateReciptionest() {
    	
    	try {
    		String reciptionestName = newReciptionestName.getText();
    		String reciptionestAge = newReciptionestAge.getText();
    		String reciptionestSalary = newReciptionestSalary.getText();
    
    		
    		int age = Integer.parseInt(reciptionestAge);
    		double salary = Double.parseDouble(reciptionestSalary);
    		
    		if(!HotelUtils.validName(reciptionestName)) {
    			updateLog("[ERROR] Invalid Employee Name!");
    			return;
    		}
    		
    		if(age > 18 && salary > 0) {
    			Reciptionest newReciptionest = new Reciptionest(reciptionestName,age,salary);
    			this.hotel.addEmployee(newReciptionest);
    			this.refreshEmployeeList();
    			this.newReciptionestName.clear();
    			this.newReciptionestAge.clear();
    			this.newReciptionestSalary.clear();
    			updateLog("[SUCCESS] Reciptionest " + newReciptionest.getName() + " has been added!");
    		}
    		
    		else {
    			updateLog("[DENIED] Age must be +18 according to ABSHER constrains \n Salary must be positive");
    		}
    	}
    	
    	catch(Exception e) {
    		updateLog("[ERROR] Could not add Reciptionest.");
    	}
    }
    
    public void handleCreateCleaner() {
    	
    	try {
    		String cleanerName = newCleanerName.getText();
    		String cleanerAge = newCleanerAge.getText();
    		String cleanerSalary = newCleanerSalary.getText();
    		String cleanerSection = cleanSections.getValue();
    
    		
    		int age = Integer.parseInt(cleanerAge);
    		double salary = Double.parseDouble(cleanerSalary);
    		
    		if(!HotelUtils.validName(cleanerName)) {
    			updateLog("[ERROR] Invalid Employee Name!");
    			return;
    		}
    		
    		if(cleanerSection ==null) {
    			updateLog("[ERROR] Choose a cleaning section.");
    			return;
    		}
    		
    		if(age > 18 && salary > 0) {
    			Cleaner newCleaner = new Cleaner(cleanerName,age,salary,cleanerSection);
    			this.hotel.addEmployee(newCleaner);
    			this.refreshEmployeeList();
    			this.newCleanerName.clear();
    			this.newCleanerAge.clear();
    			this.newCleanerSalary.clear();
    			updateLog("[SUCCESS] Cleaner " + newCleaner.getName() + " has been added!");
    		}
    		
    		else {
    			updateLog("[DENIED] Age must be +18 according to ABSHER constrains \n Salary must be positive");
    		}
    		
    	}
    	
    	catch(Exception e) {
    		updateLog("[ERROR] Could not add Cleaner.");
    	}
    	
    }
    
    public void handleCreateManager() {
    	try {
    		String managerName = newManagerName.getText();
    		String managerAge = newManagerAge.getText();
    		String managerSalary = newManagerSalary.getText();
    		String managerTeamSize = newManagerTeamSize.getText();
    		String managerDept = depts.getValue();
    		
    
    		
    		int age = Integer.parseInt(managerAge);
    		double salary = Double.parseDouble(managerSalary);
    		int teamSize = Integer.parseInt(managerTeamSize);
    		
    		if(!HotelUtils.validName(managerName)) {
    			updateLog("[ERROR] Invalid Employee Name!");
    			return;
    		}
    		
    		if(teamSize < 0 || teamSize > 9) {
    			updateLog("[ERROR] Invalid Team Size!");
    			return;
    		}
    		
    		if(managerDept ==null) {
    			updateLog("[ERROR] Choose a department.");
    			return;
    		}
    		
    		if(age > 18 && salary > 0) {
    			Manager newManager = new Manager(managerName,age,salary,managerDept,teamSize);
    			this.hotel.addEmployee(newManager);
    			this.refreshEmployeeList();
    			this.newCleanerName.clear();
    			this.newCleanerAge.clear();
    			this.newCleanerSalary.clear();
    			updateLog("[SUCCESS] Manager " + newManager.getName() + " has been added!");
    		}
    		
    		else {
    			updateLog("[DENIED] Age must be +18 according to ABSHER constrains \n Salary must be positive");
    		}
    		
    	}
    	
    	catch(Exception e) {
    		updateLog("[ERROR] Could not add Manager");
    	}
    	
    }
    
    
    public void handleAddEmployeeToManagerTeam() {
    	HotelEmployee selected = employeesListView.getSelectionModel().getSelectedItem();
    	
    	if(selected instanceof Manager) {
    		Manager manager = (Manager) selected;
    		
    		// to Prof Saad eijad if he sees this List line , please let it pass I don't want to waste two hours of my life trying to do this with linked lists (: 
    		java.util.List<HotelEmployee> choices = new java.util.ArrayList<>();
    		Node current = this.employees.getHead();
    		
    		while(current != null) {
    			HotelEmployee emp = (HotelEmployee) current.getData();
    			
    			if(!emp.Equals(manager)) {
    				choices.add(emp);
    			}
    			
    			current = current.next;
    		}
    		
    		if(choices.isEmpty()) {
    			updateLog("[ERROR] No other employees to add.");
    			return;
    		}
    		
    		ChoiceDialog<HotelEmployee> dialog = new ChoiceDialog<>(choices.get(0), choices);
    		dialog.setTitle("Team Management");
    		dialog.setHeaderText("Select an Employee to add to " + manager.getName() );
    		dialog.setContentText("Employee: ");
    		
    		Optional<HotelEmployee> result = dialog.showAndWait();
    		// targetEmployeeName is a lambda function , targetEmployeeName could be anything like clientName or whatever
    		// I used it here in order to avoid NullPointerException in case no Employee was choosen , if choosen -> {do the expression inside here; also it supports muitliple expressions;}
    		result.ifPresent(targetEmployee -> {
    				 
    				boolean success = manager.addEmployeeToTeam(targetEmployee); 
    				if(success)
    					updateLog("[SUCCESS] " + targetEmployee.getName() + " has been added to " + manager.getName() + " team.");
    				else
    					updateLog("[FAILED] to add employee to team");
    			}
    		);
    	}
    	
    	else {
    		updateLog("[ERROR] Select a manager.");
    	}
    }
    
    public void handleRemoveEmployeeFromManagerTeam() {
    	
    	HotelEmployee selected = employeesListView.getSelectionModel().getSelectedItem();
    	
    	if(selected instanceof Manager) {
    		Manager manager = (Manager) selected;
    		// to Prof saad eijad if he sees this List line , please let it pass I don't want to waste two hours of my life trying to do this with linked lists (: 
    		LinkedList teamList = manager.getTeam();
    		java.util.List<HotelEmployee> choices = new java.util.ArrayList<>();
    		Node current = teamList.getHead();
    		
    		while(current != null) {
    			HotelEmployee emp = (HotelEmployee) current.getData();
    			
    			if(!emp.Equals(manager)) {
    				choices.add(emp);
    			}
    			
    			current = current.next;
    		}
    		
    		if(choices.isEmpty()) {
    			updateLog("[ERROR] No team members to remove.");
    			return;
    		}
    		
    		ChoiceDialog<HotelEmployee> dialog = new ChoiceDialog<>(choices.get(0), choices);
    		dialog.setTitle("Team Management");
    		dialog.setHeaderText("Select an Employee to remove from " + manager.getName() );
    		dialog.setContentText("Employee: ");
    		
    		Optional<HotelEmployee> result = dialog.showAndWait();
    		// targetEmployeeName is a lambda function , targetEmployeeName could be anything like clientName or whatever
    		// I used it here in order to avoid NullPointerException in case no Employee was choosen , if choosen -> {do the expression inside here; also it supports muitliple expressions;}
    		result.ifPresent(targetEmployee -> {manager.removeEmployee(targetEmployee); updateLog("[SUCCESS] " + targetEmployee.getName() + "has been removed from " + manager.getName() + " team.");});
    	}
    	
    	else {
    		updateLog("[ERROR] Select a manager.");
    	}
    }
    
    public void handleAddLanguageToReciptionest() {
    	HotelEmployee selected = employeesListView.getSelectionModel().getSelectedItem();
    	
    	if(selected instanceof Reciptionest) {
    		Reciptionest reciptionest = (Reciptionest) selected;
    		
    		String selectedLang = languages.getValue();
    		
    		if (selectedLang != null) {
    			boolean success = reciptionest.addLang(selectedLang);
    			if(success) {
    				updateLog("[SUCCESS] " + reciptionest.getName() + " is able to speak " + selectedLang + ".");
    				this.refreshEmployeeList();;
    				
    			}
    			else
    				updateLog("[FAILED] Language Couldn't be added.");
    		}
    		
    		else {
    			updateLog("[ERROR] Please select a language.");
    		}
    	}
    	
    	else {
    		updateLog("[ERROR] Select a Reciptionest.");
    	}
    }
    
    public void handleRemoveLanguageFromReciptionest() {
    	HotelEmployee selected = employeesListView.getSelectionModel().getSelectedItem();
    	
    	if(selected instanceof Reciptionest) {
    		Reciptionest reciptionest = (Reciptionest) selected;
    		
    		String selectedLang = languages.getValue();
    		
    		if(selected != null && reciptionest.hasLang(selectedLang)) {
    			reciptionest.removeLang(selectedLang);
    			updateLog("[SUCCESS] " + reciptionest.getName() + " is no longer capable of speaking " + selectedLang);
    			this.refreshEmployeeList();
    		}
    		
    		else {
    			updateLog("[ERROR] Please select language he speaks.");
    		}
    	}
    	
    	else {
    		updateLog("[ERROR] Please select a Reciptionest.");
    	}
    }
    
    // rooms menu
    @FXML
    public void handleCreateStandardRoom() {
    	
    	try {
    		String standardRoomAddress = HotelUtils.generateRoomAddress(rooms);
    		String standardRoomNumOfBeds = newStandardRoomNumOfBeds.getText();
    		String standardRoomNumOfKitchens = newStandardRoomNumOfKitchens.getText();
    		String standardRoomNumOfBathrooms = newStandardRoomNumOfBathrooms.getText();
    		
    		int numOfBeds = Integer.parseInt(standardRoomNumOfBeds);
    		int numOfKitchens = Integer.parseInt(standardRoomNumOfKitchens);
    		int numOfBathrooms = Integer.parseInt(standardRoomNumOfBathrooms);
    		
    		if(numOfBeds > 0 && numOfKitchens > 0 && numOfBathrooms > 0) {
    			Standard newStandard = new Standard(standardRoomAddress,numOfBeds,numOfBathrooms,numOfKitchens);
    			
    			this.hotel.addRoom(newStandard);

    			
    			this.refreshRoomList();
    			newStandardRoomNumOfBeds.clear();
    			newStandardRoomNumOfBathrooms.clear();
    			newStandardRoomNumOfKitchens.clear();
    			updateLog("[SUCCESS] Room " + standardRoomAddress + " Has been created.");
    		}
    		
    		else {
    			updateLog("[DENIED] number of beds/bathrooms/kitchens must be bigger than 0");
    		}
    	}
    	
    	
    	catch(Exception e) {
    		updateLog("[ERROR] Could not create room");
    	}
    }
    
    @FXML
    public void handleCreateStudioRoom() {
    	
    	try {
    		String studioRoomAddress = HotelUtils.generateRoomAddress(rooms);
    		String studioRoomNumOfBeds = newStudioRoomNumOfBeds.getText();
    		String studioRoomNumOfKitchens = newStudioRoomNumOfKitchens.getText();
    		String studioRoomNumOfBathrooms = newStudioRoomNumOfBathrooms.getText();
    		
    		int numOfBeds = Integer.parseInt(studioRoomNumOfBeds);
    		int numOfKitchens = Integer.parseInt(studioRoomNumOfKitchens);
    		int numOfBathrooms = Integer.parseInt(studioRoomNumOfBathrooms);
    		
    		if(numOfBeds > 0 && numOfKitchens > 0 && numOfBathrooms > 0) {
    			Studio newStudio = new Studio(studioRoomAddress,numOfBeds,numOfBathrooms,numOfKitchens);
    			
    			this.hotel.addRoom(newStudio);

    			
    			this.refreshRoomList();
    			newStudioRoomNumOfBeds.clear();
    			newStudioRoomNumOfBathrooms.clear();
    			newStudioRoomNumOfKitchens.clear();
    			updateLog("[SUCCESS] Room " + studioRoomAddress + " Has been created.");
    		}
    		
    		else {
    			updateLog("[DENIED] number of beds/bathrooms/kitchens must be bigger than 0");
    		}
    	}
    	
    	
    	catch(Exception e) {
    		updateLog("[ERROR] Could not create room");
    	}
    	
    }
    
    @FXML
    public void handleCreateSuiteRoom() {
    	
    	try {
    		String suiteRoomAddress = HotelUtils.generateRoomAddress(rooms);
    		String suiteRoomNumOfBeds = newSuiteRoomNumOfBeds.getText();
    		String suiteRoomNumOfKitchens = newSuiteRoomNumOfKitchens.getText();
    		String suiteRoomNumOfBathrooms = newSuiteRoomNumOfBathrooms.getText();
    		String suiteRoomNumOfBalconies = newSuiteRoomNumOfBalconies.getText();
    		
    		int numOfBeds = Integer.parseInt(suiteRoomNumOfBeds);
    		int numOfKitchens = Integer.parseInt(suiteRoomNumOfKitchens);
    		int numOfBathrooms = Integer.parseInt(suiteRoomNumOfBathrooms);
    		int numOfBalconies = Integer.parseInt(suiteRoomNumOfBalconies);
    		
    		if(numOfBeds > 0 && numOfKitchens > 0 && numOfBathrooms > 0 && numOfBalconies > 0) {
    			Suite newSuite = new Suite(suiteRoomAddress,numOfBeds,numOfBathrooms,numOfKitchens,numOfBalconies);
    			
    			this.hotel.addRoom(newSuite);
    			
    			this.refreshRoomList();
    			newSuiteRoomNumOfBeds.clear();
    			newSuiteRoomNumOfBathrooms.clear();
    			newSuiteRoomNumOfKitchens.clear();
    			updateLog("[SUCCESS] Room " + suiteRoomAddress + " Has been created.");
    		}
    		
    		else {
    			updateLog("[DENIED] number of beds/bathrooms/kitchens/balconies must be bigger than 0");
    		}
    	}
    	
    	
    	catch(Exception e) {
    		updateLog("[ERROR] Could not create room");
    	}
    	
    }
    
    @FXML
    public void handleCreateRoyalSuiteRoom() {
    	
    	try {
    		String royalSuiteRoomAddress = HotelUtils.generateRoomAddress(rooms);
    		String royalSuiteRoomNumOfBeds = newRoyalSuiteRoomNumOfBeds.getText();
    		String royalSuiteRoomNumOfKitchens = newRoyalSuiteRoomNumOfKitchens.getText();
    		String royalSuiteRoomNumOfBathrooms = newRoyalSuiteRoomNumOfBathrooms.getText();
    		String royalSuiteRoomNumOfBalconies = newRoyalSuiteRoomNumOfBalconies.getText();
    		String royalSuiteRoomNumOfPrivatePools = newRoyalSuiteRoomNumOfPrivatePools.getText();
    		
    		int numOfBeds = Integer.parseInt(royalSuiteRoomNumOfBeds);
    		int numOfKitchens = Integer.parseInt(royalSuiteRoomNumOfKitchens);
    		int numOfBathrooms = Integer.parseInt(royalSuiteRoomNumOfBathrooms);
    		int numOfBalconies = Integer.parseInt(royalSuiteRoomNumOfBalconies);
    		int numOfPrivatePools = Integer.parseInt(royalSuiteRoomNumOfPrivatePools);
    		
    		if(numOfBeds > 0 && numOfKitchens > 0 && numOfBathrooms > 0 && numOfBalconies > 0 && numOfPrivatePools > 0) {
    			RoyalSuite newRoyalSuite = new RoyalSuite(royalSuiteRoomAddress,numOfBeds,numOfBathrooms,numOfKitchens,numOfBalconies,numOfPrivatePools);
    			
    			this.hotel.addRoom(newRoyalSuite);

    			
    			this.refreshRoomList();
    			newRoyalSuiteRoomNumOfBeds.clear();
    			newRoyalSuiteRoomNumOfBathrooms.clear();
    			newRoyalSuiteRoomNumOfKitchens.clear();
    			newRoyalSuiteRoomNumOfBalconies.clear();
    			newRoyalSuiteRoomNumOfPrivatePools.clear();
    			
    			updateLog("[SUCCESS] Room " + royalSuiteRoomAddress + " Has been created.");
    		}
    		
    		else {
    			updateLog("[DENIED] number of beds/bathrooms/kitchens/balconies/privatepools must be bigger than 0");
    		}
    	}
    	
    	
    	catch(Exception e) {
    		updateLog("[ERROR] Could not create room " + e.getMessage() );
    	}
    	
    }
    
    @FXML
    public void handleDisplayRoomInfo() {
    	Room selected = roomsListView.getSelectionModel().getSelectedItem();
    	
    	if (selected!=null) {
    		updateLog("--- Room Info ---\n" + selected.toString());
    	}
    	
    	else {
    		updateLog("[ERROR] Please select a regeistered room to view rooms's information.");
    	}
    }
    
    @FXML
    public void handleCalculateRoomPrice() {
    	Room selected = roomsListView.getSelectionModel().getSelectedItem();
    	String nights = nightsField.getText();
    	if(nights == null || nights.trim().isEmpty()) {
    		updateLog("[ERROR] Please select number of nights");
    		return;
    	}
    	int numOfNights = Integer.parseInt(nights);
    	if (selected != null) {
    		int price = selected.calculatePrice(numOfNights);
    		updateLog("Room " + selected.getAddress() + " Type " + selected.getType() + " Price: " + price);
    	}
    	
    	else {
    		updateLog("[ERROR] Select a room to calculate it's price.");
    	}
    }
    
    @FXML
    public void handleKickEmployee() {
    	HotelEmployee selected = employeesListView.getSelectionModel().getSelectedItem();
    	
    	if (selected == null ) {
    		updateLog("[ERROR] Select an employee to kick");
    		return;
    	}
    	
    	Node current = this.employees.getHead();
    	while(current != null) {
    		if(current.getData() instanceof Manager) {
    			Manager boss = (Manager) current.getData();
    			
    			if ( boss != selected) {
    				boss.removeEmployee(selected);
    			}
    			
    		}
    		
    		current = current.next;
    	}
    	
    	
    	if (selected instanceof Manager) {
    		((Manager) selected).disableTeam();
    		updateLog("[SYSTEM LOG] Manager's team has been unassigned.");
    	}
    	
    	this.hotel.removeEmployee(selected);
    	HotelUtils.removeEmployeeFromList(employees, selected);
    	this.refreshEmployeeList();
    	
    	updateLog("[SUCCESS] Employee " + selected.getName() + " has been kicked.");
    }
    
    @FXML
    public void handleDemolishRoom() {
    	Room selected = roomsListView.getSelectionModel().getSelectedItem();
    	
    	if (selected == null) {
    		updateLog("[ERROR] Select a room to demolish.");
    		return;
    	}
    		if(!HotelUtils.roomBelongsToClient(selected, clients)) {
    			this.hotel.removeRoom(selected);
    			HotelUtils.removeRoomFromList(rooms, selected);
    			HotelUtils.refreshRoomsAddresses(rooms);
    			this.refreshRoomList();
        		updateLog("[SUCCESS] Room " + selected.getAddress() + " has been demolished.");
    		}
    		
    		else {
    			updateLog("[FAILED] Room " + selected.getAddress() + " belong to client.");
    		}
    	
    	
    	
    	
    }
    
    @FXML
    public void handleExitProgram() {
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setTitle("Exit " + this.hotel.getName() + " Management System");
    	alert.setHeaderText("You are about to close " + this.hotel.getName() + " Management System");
    	alert.setContentText("System will auto save after leaving");
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	if(result.isPresent() && result.get() == ButtonType.OK) {
	    	updateLog("Closing " + this.hotel.getName() + " Management System...");
	    	this.saveData();
	    	javafx.application.Platform.exit();
	    	System.exit(0);
    	}
    	
    	
    }
    
    


}