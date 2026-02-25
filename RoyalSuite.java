package Projects;

public class RoyalSuite extends Suite{
	// class attrs
	private int PrivatePools;
	
	// constructors
	
	
	// parameterized constructor
	public RoyalSuite(String Address,int Beds,int Bathrooms,int Kitchens,int Balconies,int PrivatePools) {
		super(Address,Beds,Bathrooms,Kitchens,Balconies);
		this.setPrivatePools(PrivatePools);
	}
	
	// copy constructor
	public RoyalSuite(RoyalSuite Original) {
		super(Original.getAddress(),Original.getBeds(),Original.getBathrooms(),Original.getKitchens(),Original.getBalconies());
		this.setPrivatePools(Original.getPrivatePools());
	}
	
	
	// helping methods
	
	
	// setters
	public void setPrivatePools(int PrivatePools) {
		if(this.isValidNumOf(PrivatePools))
			this.PrivatePools = PrivatePools;
		else
			System.out.println("Number of Private Pools must be positive!");
	}
	
	// getters
	
	public int getPrivatePools() {
		return this.PrivatePools;
	}
	
	
	// class related methods
	
	public String displayInfo() {
		/*
		 * ----------------------------------------
		 * Abstraction : this method prints all RoyalSuite's object attributes
		 * 
		 * Parameters : None
		 * 
		 * Returns : String to be used in toString method
		 * ----------------------------------------
		 * */
		return (super.displayInfo() + "\n Number Of Private Pools: " + this.getPrivatePools());
	}
	
	
	
	@Override
	public String toString() {
		return this.displayInfo();
	}
	
	@Override
	
	public int getPrice() {
		/*
		 * Abstract: this method returns the price of renting RoyalSuite per night
		 * 
		 * 
		 * Parameters: None
		 * 
		 * Returns : int
		 * */
		return 4500;
	}
}
