package Projects;

public interface HotelHRreqs {
	/*
	 * Hotel Must Follow HR Requirements
	 * 
	 * Reqs:
	 * 1- Number of Managers mustn't surpass 5
	 * 2- Number of Employees not including Managers mustn't 50
	 * */
	
	public boolean ManagersLessThanFive();
	
	public boolean EmployeesLessThanFifty();
}
