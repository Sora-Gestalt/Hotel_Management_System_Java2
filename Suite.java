package Projects;

public class Suite extends Room {
	
	// class attrs
	private int Balconies;
	private final boolean VipAccess = true;
	
	// constructors
	
	
	// parameterized constructor
	public Suite(String Address,int Beds,int Bathrooms,int Kitchens, int Balconies) {
		super(Address,Beds,Bathrooms,Kitchens);
		this.setBalconies(Balconies);
	}
	
	// copy constructor
	public Suite(Suite Original) {
		super(Original.getAddress(),Original.getBeds(),Original.getBathrooms(),Original.getKitchens());
		this.setBalconies(Original.getBalconies());
	}
	
	// helping methods
	
	
	// setters
	public void setBalconies(int Balconies) {
		if(this.isValidNumOf(Balconies))
			this.Balconies = Balconies;
		else
			System.out.println("Number of Baconies must be positive!");
	}
	
	
	
	// getters
	
	public int getBalconies() {
		return this.Balconies;
	}
	
	public boolean getVipAccess() {
		return this.VipAccess;
	}
	
	
	// class related methods
	
	public String displayInfo() {
		/*
		 * ----------------------------------------
		 * Abstraction : this method prints all Suite's object attributes to be used in toString
		 * 
		 * Parameters : None
		 * 
		 * Returns : String 
		 * ----------------------------------------
		 * */
		return (super.displayInfo() + " Number of Balconies: " + this.getBalconies() + " , Has Vip Access: " + this.getVipAccess());
	}
	
	@Override
	public String toString() {
		return this.displayInfo();
	}
	
	@Override
	public int getPrice() {
		/* ----------------------------------------
		 * Abstract: this method returns the price of renting Suite per night
		 * 
		 * 
		 * Parameters: None
		 * 
		 * Returns : int
		 *  ----------------------------------------
		 * */
		return 2500;
	}
	
}
