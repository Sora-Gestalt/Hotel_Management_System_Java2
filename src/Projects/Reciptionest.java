package Projects;
import java.io.*;
public class Reciptionest extends HotelEmployee implements Serializable {
	// class attrs
	LinkedList languages;
	
	// constructors
	
	
	// parameterized constructor
	public Reciptionest(String Name,int Age, double Salary) {
		super(Name,Age,Salary);
		this.languages = new LinkedList();
	}
	
	// copy constructor
	public Reciptionest(Reciptionest Original) {
		super(Original.getName(),Original.getAge(),Original.getSalary());
		this.languages = new LinkedList();
		Node current = Original.languages.getHead();
		while(current != null) {
			this.languages.insertAtBack(current);
			current = current.next;
		}
	}
	
	// helping method
	private boolean notDuplicate(String Lang) {
		Node current = this.languages.getHead();
		while(current != null ) {
			if(((String) current.getData()).equalsIgnoreCase(Lang))
				return false;
			current = current.next;
		}
		
		return true;
	}
	
	
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
		String complete = "";
		Node current = this.languages.getHead();
		while(current != null) {
			complete += "\n Language: " + (String) current.getData();
			current = current.next;
		}
		return complete;
	}
	
	
	// setters
	
	
	// getters
	public int getNumOfLangs() {
		return this.languages.size();
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
		return (super.displayInfo() + " Number of Spoken Languages: " + this.getNumOfLangs() + "\n Spoken Languages => " + this.printSpokenLanguages() + "");
	}
	
	public boolean hasLang(String lang) {
		Node current = this.languages.getHead();
		while(current != null) {
			String selectedLang = (String) current.getData();
			if(selectedLang.equalsIgnoreCase(lang))
				return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return this.displayInfo();
	}
	
	public int searchLang(String Lang) {
		Node current = this.languages.getHead();
		int index = 0;
		while(current != null) {
			if(((String) current.getData()).equalsIgnoreCase(Lang)) {
				return index;
			}
			index++;
			current = current.next;
		}
		
		throw new IllegalArgumentException("not found!");
	}
	
	public boolean addLang(String Lang) {
		/*
		 * Abstract: this method adds String Lang if isNeededLang(Lang) method is satisfied
		 * 
		 * 
		 * Parameters: None
		 * 
		 * Returns : String
		 * */
		if(this.getNumOfLangs() < 4 && this.isNeededLang(Lang) && this.notDuplicate(Lang)) {
			this.languages.insertAtBack(Lang);
			return true;
		}
		else {
			System.out.println("Language is duplicated or number of spoken needed languages is full!");
			return false;
		}
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
		boolean found = false;
		Node current = this.languages.getHead();
		int index = 0;
		while(current != null) {
			if(((String) current.getData()).equalsIgnoreCase(Lang)){
				try {
					this.languages.removeAtIndex(index);
					found = true;
					return;
				}
				
				catch(Exception e) {
					System.out.println("couldn't remove language");
					return;
				}
					
			}
			
			index++;
			current = current.next;
		}
		
		if(!found)
			System.out.println("Language isn't found!");
	}
	
	
}
