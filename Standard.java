package Projects;

public class Standard extends Room{
	
	// class attrs
	private final boolean PublicPoolAccess = true;
	
	// constructors
	
	
	// parameterized constructor
	public Standard(String Address,int Beds,int Bathrooms,int Kitchens) {
		super(Address,Beds,Bathrooms,Kitchens);
	}
	
	
	// copy constructor
	public Standard(Standard Original) {
		super(Original.getAddress(),Original.getBeds(),Original.getBathrooms(),Original.getKitchens());
	}
	
	// helping methods
	
	
	// setters
	
	
	// getters
	public boolean getPublicPoolAccess() {
		return this.PublicPoolAccess;
	}
	
	
	
	// class related methods
	
	public String displayInfo() {
		/*
		 * ----------------------------------------
		 * Abstraction : this method prints all Standard's object attributes
		 * 
		 * Parameters : None
		 * 
		 * Returns : String to be used in toString method
		 * ----------------------------------------
		 * */
		return (super.displayInfo() + " Has Public Pool Access: " + this.getPublicPoolAccess());
	}
	
	
	@Override
	public String toString() {
		return this.displayInfo();
	}
	
	@Override
	public int getPrice() {
		/* ----------------------------------------
		 * Abstract: this method returns the price of renting Standard per night
		 * 
		 * 
		 * Parameters: None
		 * 
		 * Returns : int
		 *  ----------------------------------------
		 * */
		return 1000;
	}
}
