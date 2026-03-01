package Projects;

public class Studio extends Room{
	// class attrs
	private final boolean GymAccess = true;
	
	
	// constructors
	
	
	// parameterized constructor
	public Studio(String Address,int Beds,int Bathrooms,int Kitchens) {
		super(Address,Beds,Bathrooms,Kitchens);
	}
	// copy constructor
	public Studio(Studio Original) {
		super(Original.getAddress(),Original.getBeds(),Original.getBathrooms(),Original.getKitchens());
	}
	
	// helping methods
	
	// setters
	
	// getters
	public boolean getGymAccess(){
		return this.GymAccess;
	}
	
	// class related methods
	
	public String displayInfo() {
		/*
		 * ----------------------------------------
		 * Abstraction : this method prints all Studio's object attributes to be used in toString
		 * 
		 * Parameters : None
		 * 
		 * Returns : String 
		 * ----------------------------------------
		 * */
		return (super.displayInfo() + ", Has GymAccess: " + this.getGymAccess());
	}
	
	
	@Override
	
	public String toString() {
		return this.displayInfo();
	}
	
	@Override 
	
	public int getPrice() {
		/* ----------------------------------------
		 * Abstract: this method returns the price of renting Studio per night
		 * 
		 * 
		 * Parameters: None
		 * 
		 * Returns : int
		 *  ----------------------------------------
		 * */
		return 1500;
	}
}
