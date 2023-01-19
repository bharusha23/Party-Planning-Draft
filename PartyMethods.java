/**
 * File by Shanaya Bharucha
 * 3:30; January 20th
 * Program Name: PartyMethods.java
 * This program contains all the methods called in PartyTester to organize a list of party guests into tables depending on their company. 
 * Its methods include uploading and inputting the party guests, adding more guests, checking that there aren't too many guests, placing guests at tables, 
 * printing rosters by table & company, and giving the table and chair of any given person in the guest list. 
 * */
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;//Import ArrayList


public class PartyMethods {
	private int numTables = 10;
	private int peoplePerTable = 10;
	private int numCompanies = 16;
	ArrayList<Person> guestList = new ArrayList <Person>();
	ArrayList<String>companyList = new ArrayList<String>();
	
	public void makeGuestList() {
		try {
			File myObj = new File("PartyList.csv"); //get a new file
			Scanner myReader = new Scanner(myObj);//scan in the new file
			while (myReader.hasNextLine()) {//if there is still information in the file
				String data = myReader.nextLine();//data = the next set of information
				//for each of these sections, I am finding where the comma is, setting the necessary variable equal to the data value, and then redeclaring data as the rest of the line
				int comma = data.indexOf(",");//get rid of the numbering system
				data = data.substring(comma+1);
					
				comma = data.indexOf(",");
				String ln = data.substring(0, comma); //get the last name
				data = data.substring(comma+1);
						
				comma = data.indexOf(",");
				String fn = data.substring(0, comma); //get the first name
				data = data.substring(comma+1);
						
				int cn = Integer.parseInt(data);//get the number of the company
					
				guestList.add(new Person(ln, fn, cn));//add a new instance of the Person class to guestList
			}//close while
			myReader.close();
		}//close try 
		catch (FileNotFoundException e) {//just in case the file isn't found
			System.out.println("An error occurred.");
			e.printStackTrace();
		}//close catch
		System.out.println(guestList.get(12).toString());//print out the Person object at 12th spot 
	}//close makeGuestList
	
	public void addGuests() {
		boolean addP = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("\nWould you like to add a guest? Input 'true' or 'false': ");
		Boolean check = scan.nextBoolean();
		addP = check;
		while (addP == true) {
			System.out.println("\nWhat's the guest's last name?");
			String x = scan.nextLine();
			String lastname = scan.nextLine();
			System.out.println("\nWhat's the guest's first name?");
			//String y = scan.nextLine();
			String firstname = scan.nextLine();
			System.out.println("\nWhat's the company's number?");
			int companynumber = scan.nextInt();
			guestList.add(new Person(lastname, firstname, companynumber));//add a new instance of the Person class to guestList	
			System.out.println("\nWould you like to add another guest? Input 'true' or 'false': ");
			Boolean checker = scan.nextBoolean();
			addP = checker;
		}//close while (addP == true)
	}//close addGuests
	
	public void checkPPerCompany() {
		for (int i = 1; i<=numCompanies; i++) {
			int ppc = 0;
			for (Person p : guestList) {
				if (i == p.getCompanyNum()) {
					ppc++;
				}//close if loop
			}//close for each loop
			if (ppc>numTables) {
				System.out.print("You have too many people from company " + i+ ". This program will exit. Please try again.");
				SleepMs(1000);
				System.exit(0);//BREAK OUT OF PROGRAM HERE
			}		
		}//close for if loop
	}//close check PPerCompany
	
	public void SleepMs(int t){ //this method will pause the program for the number of milliseconds in the arguement
		try { //attempt to run this program
			Thread.sleep(t);
		} // close try
		catch (Exception e) { //catch the intrupted exception error
			System.out.println(e);
		}	//close catch	
	} // close SleepMs	
	
}//close PartyMethods
