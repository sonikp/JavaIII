package week6;
// fig 24.30
public class Person
{
	private int addressID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	// constructor
	public Person() {}
	
	// constructor
	public Person(int addressID, String firstName, String lastName, String email, String phoneNumber)
	{
		setAddressID(addressID);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPhoneNumber(phoneNumber);
	}
	
	// sets the addressID
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	
	// returns the addressID
	public int getAddressID() {
		return addressID;
	}
	
	// set the first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// return first name
	public String getFirstName() {
		return firstName;
	}
	
	// set the last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// return the last name
	public String getLastName() {
		return lastName;
	}
	
	// set email
	public void setEmail(String email) {
		this.email = email;
	}
	
	// return email
	public String getEmail() {
		return email;
	}
	
	// set phone number
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	// return phone number
	public String getPhoneNumber() {
		return phoneNumber;
	}
}















