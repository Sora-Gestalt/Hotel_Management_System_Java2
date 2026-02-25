package Projects;

public class Cleaner extends HotelEmployee {
	// class attrs
	private String cleaningSection;
	
	// constructor
	
	
	// parameterized constructor
	public Cleaner(String Name,int Age,double Salary,String Section) {
		super(Name,Age,Salary);
		this.setCleaningSection(Section);
	}
	
	// copy constructor
	public Cleaner(Cleaner Original) {
		super(Original.getName(),Original.getAge(),Original.getSalary());
		this.setCleaningSection(Original.getCleaningSection());
	}
	
	
	// helping methods
	
	
	// setters
	public void setCleaningSection(String Section) {
		String[] choices = {"Roof","Bathrooms","Rooms","Kitchen","Storage"};
		for(int i = 0; i < choices.length ; i++) {
			if(choices[i].equalsIgnoreCase(Section)) {
				this.cleaningSection = Section;
				break;
			}
		}
		System.out.println("choose: Roof,Bathrooms,Rooms,Kitchen,Storage");
	}
	
	// getters
	public String getCleaningSection() {
		return this.cleaningSection;
	}
	
	// class related
	
	public String displayInfo() {
		return (super.displayInfo() + " Cleaning Section: " + this.getCleaningSection());
	}
	
	public String toString() {
		return this.displayInfo();
	}
}
