package Projects;

public class Reciptionest extends HotelEmployee {
	// class attrs
	String[] languages = new String[10];
	int NumOfLangs;
	
	// constructors
	
	
	// parameterized constructor
	public Reciptionest(String Name,int Age, double Salary) {
		super(Name,Age,Salary);
		this.NumOfLangs = 0;
	}
	
	// copy constructor
	public Reciptionest(Reciptionest Original) {
		super(Original.getName(),Original.getAge(),Original.getSalary());
		this.NumOfLangs = Original.NumOfLangs;
		for(int i = 0; i < Original.getNumOfLangs();i++) {
			this.languages[i] = Original.languages[i];
		}
	}
	
	// helping method
	private boolean isNeededLang(String Lang) {
		/*
		 * Abstract: this method checks if Lang in Langs
		 * 
		 * 
		 * Parameters: Lang String
		 * 
		 * Returns : boolean
		 * */
		String[] Langs = {"arabic","english","french","chinese","japanese"};
		for(int i = 0; i < Langs.length ; i++) {
			if(Langs[i].equalsIgnoreCase(Lang))
				return true;
		}
		return false;
	}
	
	private String printSpokenLanguages() {
		/*
		 * Abstract: this method prints all spoken languages in instance Reciptionest to help with method displayInfo
		 * 
		 * 
		 * Parameters: None
		 * 
		 * Returns : String
		 * */
		for(int i = 0; i < this.getNumOfLangs() ; i++) {
			System.out.println("\nLanguage: " + this.languages[i]);
		}
		return "";
	}
	
	
	// setters
	
	
	// getters
	public int getNumOfLangs() {
		return this.NumOfLangs;
	}
	
	// class related
	
	public String displayInfo() {
		/*
		 * Abstract: this method prints all information of instance Reciptionest and returns a String type to be used in toString overridden method
		 * 
		 * 
		 * Parameters: None
		 * 
		 * Returns : String
		 * */
		return (super.displayInfo() + "Number of Spoken Languages: " + this.getNumOfLangs() + "\n Spoken Languages => " + this.printSpokenLanguages() + "");
	}
	
	
	@Override
	public String toString() {
		return this.displayInfo();
	}
	
	public int searchLang(String Lang) {
		for(int i = 0; i < this.getNumOfLangs();i++) {
			if(this.languages[i].equalsIgnoreCase(Lang))
				return i;
		}
		
		throw new IllegalArgumentException("not found!");
	}
	
	public void addLang(String Lang) {
		/*
		 * Abstract: this method adds String Lang if isNeededLang(Lang) method is satisfied
		 * 
		 * 
		 * Parameters: None
		 * 
		 * Returns : String
		 * */
		if(this.getNumOfLangs() < this.languages.length && this.isNeededLang(Lang))
			this.languages[this.NumOfLangs++] = Lang;
	}
	
	public void removeLang(String Lang) {
		/*
		 * Abstract: this method removes Lang from Spoken Langs of instance Reciptionest
		 * 
		 * 
		 * Parameters: Lang String
		 * 
		 * Returns : void
		 * */
		for(int i = 0; i < this.getNumOfLangs() ; i++) {
			if(this.languages[i].equalsIgnoreCase(Lang)) {
				this.languages[i] = this.languages[this.NumOfLangs - 1];
				this.languages[this.NumOfLangs - 1] = null;
				this.NumOfLangs--;
				System.out.println("Language Removed!");
				break;
			}
			
		}
		System.out.println("Language isn't found!");
	}
	
	
}
