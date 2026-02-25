package Projects;

public abstract class Room {
	
	// abstract class attrs
	private String Address;
	private int Beds;
	private int Bathrooms;
	private int Kitchens;
	
	
	
	private final int BedsPriceMultiplication = 5;
	private final int BathroomBsPriceMutliplication = 8;
	private final int KitchensPriceMutliplication = 4;
	// constructors
	
	// parameterized constructor
	public Room(String Address,int Beds,int Bathrooms,int Kitchens) {
		this.setAddress(Address);
		this.setBeds(Beds);
		this.setBathrooms(Bathrooms);
		this.setKitchens(Kitchens);
	}
	
	
	// copy constructor
	public Room(Room Original) {

		this.setAddress(Original.getAddress());
		this.setBeds(Original.getBeds());
		this.setBathrooms(Original.getBathrooms());
		this.setKitchens(Original.getKitchens());
	}
	
	
	
	// helping methods
	
	private boolean isValidAddress(String Address) {
		/*
		 * ----------------------------------------
		 * Abstraction : this method checks if (given address's length is 4 & address's entries are digits)
		 * 
		 * Parameters: Address | String
		 * 
		 * Returns : boolean
		 * ----------------------------------------
		 * */
		if(Address.length() != 4)
			return false;
		
		else {
			
			// check every entry is digit
			for(int i = 0; i < Address.length() ; i++) {
				if(!Character.isDigit(Address.charAt(i)))
					return false;
			}
			
			return true;
		}
		
	}
	
	public boolean isValidNumOf(int input) {
		/*
		 * ----------------------------------------
		 * Abstraction : this method checks if (given num of (beds,kitchens,bathrooms) > 0)
		 * 
		 * Parameters : input | int
		 * 
		 * Returns : boolean
		 * ----------------------------------------
		 * */
		return  (input > 0);
	}
	// setters
	
	public void setAddress(String Address) {
		if(this.isValidAddress(Address))
			this.Address = Address;
		else
			System.out.println("Invalid Address!");
	}
	
	public void setBeds(int Beds) {
		if(this.isValidNumOf(Beds))
			this.Beds = Beds;
		else
			System.out.println("Number of beds must be positive!");
	}
	
	public void setBathrooms(int Bathrooms) {
		if(this.isValidNumOf(Bathrooms))
			this.Bathrooms = Bathrooms;
		else
			System.out.println("Number of bathrooms must be positive!");
	}
	
	public void setKitchens(int Kitchens) {
		if(this.isValidNumOf(Kitchens))
			this.Kitchens = Kitchens;
		else
			System.out.println("Number of kitchens must be positive!");
	}
	
	
	// getters 
	
	public String getAddress() {
		return this.Address;
	}
	
	public int getBeds() {
		return this.Beds;
	}
	
	public int getBathrooms() {
		return this.Bathrooms;
	}
	
	public int getKitchens() {
		return this.Kitchens;
	}
	
	
	// class related methods
	public String displayInfo() {
		/*
		 * ----------------------------------------
		 * Abstraction : this method prints all Room's object attributes
		 * 
		 * Parameters : None
		 * 
		 * Returns : String to be used in toString method
		 * ----------------------------------------
		 * */
		return ("Room: " + this.getAddress() + "\n Number of Beds: " + this.getBeds() + ", Number of Bathrooms: " + this.getBathrooms() + ", Number of Kitchens: " + this.getKitchens());
	}
	
	
	public int calculatePrice(int nights) {
		/*
		 * ----------------------------------------
		 * Abstraction : this method finds the price based on number of nights (multiplications are fixed)
		 * 
		 * Parameters : nights | int
		 * 
		 * Returns : String to be used in toString method
		 * ----------------------------------------
		 * */
		return (this.getBeds() * nights * BedsPriceMultiplication) + (this.getBathrooms() * nights * BathroomBsPriceMutliplication) + (this.getKitchens() * nights * KitchensPriceMutliplication);
	}
	
	@Override
	
	public String toString() {
		return this.displayInfo();
	}
	
	public abstract int getPrice();
	
}

