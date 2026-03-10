package Projects;

public class Manager extends HotelEmployee {
	
	// class attrs
	private String ManagerDept;
	private int TeamSize;
	private int numOfEmployees;
	private HotelEmployee[] Team;

	
	// constructors
	
	
	// parameterized constructor
	public Manager(String Name,int Age,double Salary,String Dept,int Size) {
		super(Name,Age,Salary);
		this.setManageDept(Dept);
		this.setTeamSize(Size);
		this.numOfEmployees = 0;
		Team = new HotelEmployee[this.getTeamSize()];
	}
	
	// copy constructor
	public Manager(Manager Original) {
		super(Original.getName(),Original.getAge(),Original.getSalary());
		this.setManageDept(Original.getManagerDept());
		this.setTeamSize(Original.getTeamSize());
		this.numOfEmployees = Original.numOfEmployees;
		Team = new HotelEmployee[this.getTeamSize()];
		
		for(int i = 0; i < this.Team.length ; i++) {
			this.Team[i] = Original.Team[i];
		}
	}
	
	// helping methods
	private boolean isDuplicate(HotelEmployee employee) {
		/*
		 * Abstract : This method helps addEmployee method and checks if passed employee is already in team or not ( duplicate or not )
		 * 
		 * Parameters : employee : HotelEmployee
		 * 
		 * Returns : boolean
		 * */
		for(int i = 0; i < this.getNumOfEmployees() ; i++) {
			if(this.Team[i].Equals(employee))
				return true;
		}
		
		return false;
	}
	// setters
	public void setManageDept(String Dept) {
		String[] Depts = {"resturant","employees","rooms","security","cleaning"};
		boolean notFound = true;
		
		for(int i = 0; i < Depts.length; i++) {
			if(Depts[i].equalsIgnoreCase(Dept)) {
				this.ManagerDept = Dept.toUpperCase();
				notFound = false;
				break;
			}
		}
		if(notFound)
			System.out.println("Department doesn't exist!");
	}
	
	public void setTeamSize(int size) {
		if(size < 10)
			this.TeamSize = size;
		else
			System.out.println("Team size is too large!");
	}
	
	// getters
	public String getManagerDept() {
		return this.ManagerDept;
	}
	
	public int getNumOfEmployees() {
		return this.numOfEmployees;
	}
	
	public int getTeamSize() {
		return this.TeamSize;
	}
	
	// class related methods
	
	public int searchEmployee(HotelEmployee Employee) {
		/*
		 * ----------------------------------------
		 * Abstraction : this method finds if passed employee belongs to managers team and returns it's index if it's in the team
		 * 
		 * Parameters : Employee : HotelEmployee
		 * 
		 * Returns : int
		 * ----------------------------------------
		 * */
		for(int i = 0; i < this.getNumOfEmployees() ; i++) {
			if(this.Team[i].Equals(Employee))
				return i;
		}
		
		throw new IllegalArgumentException("not found!");
	}
	
	public void removeEmployee(HotelEmployee Employee) {
		/*
		 * ----------------------------------------
		 * Abstraction : this method removes employee from team
		 * 
		 * Parameters : Employee : HotelEmployee
		 * 
		 * Returns : void
		 * ----------------------------------------
		 * */
		boolean found = false;
		for(int i = 0; i < this.getNumOfEmployees();i++) {
			
			if(this.Team[i].Equals(Employee)) {
				this.Team[i] = this.Team[this.numOfEmployees - 1];
				this.Team[this.numOfEmployees - 1] = null;
				this.numOfEmployees--;
				found = true;
				System.out.println("Employee Removed!");
				break;
			}
		}
		
		if(!found)
			System.out.println("Employee not found!");
	}
	
	public void addEmployeeToTeam(HotelEmployee Employee) {
		/*
		 * ----------------------------------------
		 * Abstraction : this method adds employee to team
		 * 
		 * Parameters : Employee : HotelEmployee
		 * 
		 * Returns : void
		 * ----------------------------------------
		 * */
		if(this.getNumOfEmployees() < this.getTeamSize()) {
			
			if(this.getManagerDept().equalsIgnoreCase("resturant")){
				
				if(Employee instanceof Cook && !this.isDuplicate(Employee)) {
					this.Team[this.numOfEmployees++] = Employee;
				}
				
				else {
					if(this.isDuplicate(Employee))
						throw new IllegalArgumentException("Duplicated Employee");
					else
						System.out.println("Employee doesn't belong to this department!");
				}
			}
			
			else if(this.getManagerDept().equalsIgnoreCase("security")){
				
				if(Employee instanceof Security && !this.isDuplicate(Employee)) {
					this.Team[this.numOfEmployees++] = Employee;
				}
				
				else {
					if(this.isDuplicate(Employee))
						throw new IllegalArgumentException("Duplicated Employee");
					else
						System.out.println("Employee doesn't belong to this department!");
				}
			}
			
			else if(this.getManagerDept().equalsIgnoreCase("cleaning")){
				
				if(Employee instanceof Cleaner && !this.isDuplicate(Employee)) {
					this.Team[this.numOfEmployees++] = Employee;
				}
				
				else {
					if(this.isDuplicate(Employee))
						throw new IllegalArgumentException("Duplicated Employee");
					else
						System.out.println("Employee doesn't belong to this department!");
				}
				
			}
			
			else if(this.getManagerDept().equalsIgnoreCase("rooms")){
				
				if(Employee instanceof Reciptionest && !this.isDuplicate(Employee)) {
					this.Team[this.numOfEmployees++] = Employee;
				}
				
				else {
					if(this.isDuplicate(Employee))
						throw new IllegalArgumentException("Duplicated Employee");
					else
						System.out.println("Employee doesn't belong to this department!");
				}
			}
			
			else if(this.getManagerDept().equalsIgnoreCase("employees")){
				
				if(Employee instanceof Manager && !this.isDuplicate(Employee) ) {
					this.Team[this.numOfEmployees++] = Employee;
				}
				
				else {
					if(this.isDuplicate(Employee))
						throw new IllegalArgumentException("Duplicated Employee");
					else
						System.out.println("Employee doesn't belong to this department!");
				}
			}
			
			else 
				System.out.println("No related department found");
			
			
			
		}
		
		
	}
	
	
	public void disableTeam() {
		/*
		 * ----------------------------------------
		 * Abstraction : this method unassigns all team members
		 * 
		 * Parameters : None
		 * 
		 * Returns : void
		 * ----------------------------------------
		 * */
		for(int i = this.getNumOfEmployees() - 1; i > -1 ; i--) {
			this.Team[i] = null;
		}
		
		this.numOfEmployees = 0;
		
		
		System.out.println("Team has been unassign");
	}
	
	public boolean inTeam(HotelEmployee employee) {
		/*
		 * ----------------------------------------
		 * Abstraction : this method checks if Employee exist in team or not
		 * 
		 * Parameters : Employee : HotelEmployee
		 * 
		 * Returns : boolean
		 * ----------------------------------------
		 * */
		for(int i = 0 ; i < this.getNumOfEmployees() ; i++) {
			if(this.Team[i].Equals(employee))
				return true;
		}
		return false;
	}
	
	public String displayTeam() {
		/*
		 * ----------------------------------------
		 * Abstraction : this method prints all Team members and their info
		 * 
		 * Parameters : None
		 * 
		 * Returns : String to be used in displayInfo
		 * ----------------------------------------
		 * */
		String teamInfo = "";
		for(int i = 0 ; i < this.numOfEmployees ; i++)
			teamInfo += ("\n Team Member [" + i + "] " + this.Team[i].displayInfo());
		return teamInfo;
	}
	
	public String displayInfo() {
		/*
		 * ----------------------------------------
		 * Abstraction : this method prints all Manager's info
		 * 
		 * Parameters : None
		 * 
		 * Returns : String to be used in toString method
		 * ----------------------------------------
		 * */
		return ("Manager: " + this.getName() + ", Age: " + this.getAge() + ", Salary: " + this.getSalary() + ", Dept: " + this.getManagerDept() + ", Team Size: " + this.getTeamSize() + "\n" + this.displayTeam());
	}
	
	@Override
	public String toString() {
		return this.displayInfo();
	}
	
}
