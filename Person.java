/**
 * File by Shanaya Bharucha
 * 3:30; January 20th
 * Program Name: Person.java
 * This program defines the class person,  which is used in the PartyMethods and PartyTester programs to store multiple bits of information  about the party guests. 
 * */

public class Person {
	private String lastName = "";
	private String firstName = "";
	private int companyNum = 0;
	
	public Person(String lastN, String firstN, int CompN) {
		lastName = lastN;
		firstName = firstN;
		companyNum = CompN;
	}	//close Person constructor
	
	public String getLastName() {
		return lastName;
	}//close getLastName
	
	public String getFirstName() {
		return firstName;
	} //close getFirstName
	
	public String getFullName() {
		return (firstName + " " + lastName);
	}//close getFullName
	
	public int getCompanyNum() {
		return companyNum;
	}//close getCompanyNum	
		
	
	public String toString() {
		return ("Name: " + firstName + " " + lastName + "\nCompany Number: " + companyNum + "\n" );
	}//close toString	
} //close public class Person
