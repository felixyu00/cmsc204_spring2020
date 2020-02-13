
public class Employee {
	
	private String lastName;
	private String firstName;
	
	public Employee(String firstName, String lastName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String toString() {
		return firstName + " " + lastName;
	}
	
    
}


