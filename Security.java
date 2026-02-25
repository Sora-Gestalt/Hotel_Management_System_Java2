package Projects;

public class Security extends HotelEmployee{
	// class attrs
	private String SecuritySector;
	
	// constructors
	
	// parameterized constructor
	public Security(String Name,int Age,double Salary,String SecuritySector) {
		super(Name,Age,Salary);
		this.setSecuritySector(SecuritySector);
	}
	// copy constructor
	public Security(Security Original) {
		super(Original.getName(),Original.getAge(),Original.getSalary());
		this.setSecuritySector(Original.getSecuritySector());
	}
	
	// helping methods
	
	
	// setters
	public void setSecuritySector(String Sector) {
		String[] Choices = {"cyber security","VSS","PSIM"};
		
		for(int i = 0; i < Choices.length ; i++) {
			if(Choices[i].equalsIgnoreCase(Sector)) {
				this.SecuritySector = Sector.toLowerCase();
				break;
			}
		}
		System.out.println("choices: cyber security,VSS,PSIM");
	}
	
	// getters
	public String getSecuritySector() {
		return this.SecuritySector;
	}
	
	// class related methods
	
	public String displayInfo() {
		return (super.displayInfo() + " Security Sector: " + this.getSecuritySector());
	}
	
	@Override
	public String toString() {
		return this.displayInfo();
	}
}
