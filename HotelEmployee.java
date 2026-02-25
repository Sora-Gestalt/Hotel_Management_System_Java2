package Projects;

public abstract class HotelEmployee implements Absher {
	
	// class attrs
	private String Name;
	private int Age;
	private double Salary;
	
	// constructors
	
	
	// parameterized constructor
	public HotelEmployee(String Name,int Age,double Salary) {
		this.setName(Name);
		this.setAge(Age);
		this.setSalary(Salary);
	}
	
	
	// copy constructor
	
	public HotelEmployee(HotelEmployee Original) {
		this.setName(Original.getName());
		this.setAge(Original.getAge());
		this.setSalary(Original.getSalary());
	}
	
	// helping method
	
	
	// setters
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public void setAge(int Age) {
		if(this.isValidAge())
			this.Age = Age;
		else
			System.out.println("Invalid Age!");
	}
	
	public void setSalary(double Salary) {
		this.Salary = Salary;
	}
	
	// getters
	public String getName() {
		return this.Name;
	}
	
	public int getAge() {
		return this.Age;
	}
	
	public double getSalary() {
		return this.Salary;
	}
	
	
	// class related methods
	
	public boolean isValidAge() {
		return this.Age > Absher.AgeBounary;
	}
	
	public boolean Equals(HotelEmployee Employee) {
		return(this.getName().equals(Employee.getName()) && this.getAge() == Employee.getAge() && this.getSalary() == Employee.getSalary());
	}
	
	
	public String displayInfo() {
		/*
		 * ----------------------------------------
		 * Abstraction : this method prints all HotelEmployee's object attributes
		 * 
		 * Parameters : None
		 * 
		 * Returns : String to be used in toString method
		 * ----------------------------------------
		 * */
		return ("Employee Info| Name: " + this.getName() + ", Age: " + this.getAge() + " , Salary: " + this.getSalary());
	}
	
	@Override
	public String toString() {
		return this.displayInfo();
	}
	
}
