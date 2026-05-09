package Projects;
import java.io.*;
public class Manager extends HotelEmployee implements Serializable {
	
	// class attrs
	private String ManagerDept;
	private int TeamSize;
	private int numOfEmployees;
	private LinkedList Team;

	
	// constructors
	
	
	// parameterized constructor
	public Manager(String Name,int Age,double Salary,String Dept,int Size) {
		super(Name,Age,Salary);
		this.setManageDept(Dept);
		this.setTeamSize(Size);
		this.numOfEmployees = 0;
		this.Team = new LinkedList();
	}
	
	// copy constructor
	public Manager(Manager Original) {
		super(Original.getName(),Original.getAge(),Original.getSalary());
		this.setManageDept(Original.getManagerDept());
		this.setTeamSize(Original.getTeamSize());
		this.numOfEmployees = Original.numOfEmployees;
		this.Team = new LinkedList();
		
		Node current = Original.Team.getHead();
		while(current!=null) {
			this.Team.insertAtBack(current);
			current = current.next;
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
		Node current = this.Team.getHead();
		while(current!=null) {
			if(((HotelEmployee) current.data).Equals(employee))
				return true;
			current = current.next;
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
	
	public LinkedList getTeam() {
		return this.Team;
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
		Node current = this.Team.getHead();
		int index = 0;
		while(current != null) {
			if(((HotelEmployee) current.data).Equals(Employee))
				return index;
			current = current.next;
			index++;
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
		Node current = this.Team.getHead();
		int index = 0;
		boolean found = false;
		while(current != null) {
			if(((HotelEmployee) current.data).Equals(Employee)) {
				try {
					this.Team.removeAtIndex(index);
					found = true;
					System.out.println("Employee Removed from team!");
					break;
				}
				
				catch(Exception e) {
					System.out.println("Error removing from team: " + e.getMessage());
				}
				
			}
			current = current.next;
			index++;
		}
		if(!found)
			System.out.println("Employee not found in team!");
	}
	
	public boolean addEmployeeToTeam(HotelEmployee Employee) throws IllegalArgumentException {
		/*
		 * ----------------------------------------
		 * Abstraction : this method adds employee to team
		 * 
		 * Parameters : Employee : HotelEmployee
		 * 
		 * Returns : void
		 * ----------------------------------------
		 * */
		if(this.Team.size() < this.getTeamSize()) {
			String dept = this.getManagerDept().toLowerCase();
			
			boolean correctDept = false;
            if(dept.equals("resturant") && Employee instanceof Cook) correctDept = true;
            else if(dept.equals("security") && Employee instanceof Security) correctDept = true;
            else if(dept.equals("cleaning") && Employee instanceof Cleaner) correctDept = true;
            else if(dept.equals("rooms") && Employee instanceof Reciptionest) correctDept = true;
            else if(dept.equals("employees") && Employee instanceof Manager) correctDept = true;
            
            if(correctDept) {
            	if(!this.isDuplicate(Employee)) {
            		this.Team.insertAtBack(Employee);
            		return true;
            	}
            	else {
            		throw new IllegalArgumentException("Duplicated Employee");
    
            	}
            }
            
            else {
            	System.out.println("Team is full");
            	return false;
            }
		}
		return false;
		
		
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
		this.Team.clearList();
		System.out.println("Team has been usassigned");
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
		return isDuplicate(employee);
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
		Node current = this.Team.getHead();
		int i = 0;
		while(current!=null) {
			teamInfo += ("\n Team Member [" + i + "] " + ((HotelEmployee)current.data).displayInfo());
            current = current.next;
            i++;
		}
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
