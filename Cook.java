package Projects;

public class Cook extends HotelEmployee {
	// class attrs
	private String WorkingTime;
	
	
	// constructors
	
	
	// parameterized constructor
	public Cook(String Name,int Age,double Salary,String Time) {
		super(Name,Age,Salary);
		this.setWorkingTime(Time);
	}
	
	// copy constructor
	public Cook(Cook Original) {
		super(Original.getName(),Original.getAge(),Original.getSalary());
		this.setWorkingTime(Original.getWorkingTime());
	}
	
	// helping methods
	
	
	// setters
	public void setWorkingTime(String Time) {
		String[] choices = {"breakfast","lunch","dinner"};
		for(int i = 0; i < choices.length ; i++) {
			if(choices[i].equalsIgnoreCase(Time)) {
				this.WorkingTime = Time.toLowerCase();
				break;
			}
		}
		System.out.println("choose : breakfast,lunch,dinner");
	}
	
	// getters
	public String getWorkingTime() {
		return this.WorkingTime;
	}
	
	// class related methods
	public String displayInfo() {
		/* ----------------------------------------
		 * Abstract: this methods prints all information of instance Cook and returns a String type to be used in toString overridden method
		 * 
		 * 
		 * Parameters: None
		 * 
		 * Returns : String
		 *  ----------------------------------------
		 * */
		return (super.displayInfo() + " Working Time: " + this.getWorkingTime());
	}
	
	@Override
	
	public String toString() {
		return this.displayInfo();
	}
}
