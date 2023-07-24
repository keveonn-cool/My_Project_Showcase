package phonebook;

import java.util.Scanner;

public class PhoneBookApp {

	public static void main(String[] args) {
		// Create a new phonebook object
		PhoneBook phonebook = new PhoneBook();
		
		
		// Creating a Scanner object to have user input
		Scanner scan = new Scanner(System.in);
		
		// Variable to store the user input
		int choice;
		
		// Menu loop
		do {
			System.out.println("\nPhonebook Menu:");
			System.out.println("1. Add Contact");
			System.out.println("2. Search Contact");
			System.out.println("3. Update Contact");
			System.out.println("4. Delete Contact");
			System.out.println("5. Display all Contacts");
			System.out.println("6. Exit");
			System.out.println("Enter your Choice: ");
			
			// Read the user's choice
			choice = scan.nextInt();
			
			switch (choice) {
			// Adding contact
			case 1:
				System.out.println("Enter contact details: ");
				System.out.println("Enter name: ");
				scan.nextLine(); // consume the newline character left by previous scan.nextInt() 
				String name = scan.nextLine();
				System.out.println("Enter phone number: ");
				String phonenumber = scan.nextLine();
				System.out.println("Enter email: ");
				String email = scan.nextLine();
				
				// create a new Contact object with the provided details
				Contact newContact = new Contact(name, phonenumber, email);
				phonebook.addContact(newContact);
				System.out.println("Contact added successfully!");
				break;
			// Searching contact	
			case 2:
				System.out.println("Enter the name you want to search: ");
				scan.nextLine(); // Consume the newline character left by previous scan.nextInt()

				String nameToSearch = scan.nextLine();
				
				Contact findContact = phonebook.searchContact(nameToSearch);
				if(findContact != null) {
					System.out.println("Contact found: ");
					System.out.println("Name: " + findContact.getName());
					System.out.println("Phone number: " + findContact.getphoneNumber());
					System.out.println("email: " + findContact.getemail());		
				}
				else {
					System.out.println("Contact not found.");
				}
				break;
			//Update contact 
			case 3:
				System.out.println("Enter the name of the contact that you want to update: ");
				scan.nextLine(); // consume the newline character left by previous scan.nextInt() 
				String nameToUpdate = scan.nextLine();
				
				Contact contactUpdate = phonebook.searchContact(nameToUpdate);
				
				if(contactUpdate != null) {
					System.out.println("Enter updated contact details:");
					System.out.println("Enter Name: ");
					String updatedName = scan.nextLine();
					System.out.println("Phone Number: ");
					String updatedPhoneNumber = scan.nextLine();
					System.out.println("Email: ");
					String updatedEmail = scan.nextLine();
					
					//Creating a new contact details(object)so that later these details be copied on to existing contact
					Contact updatedContact = new Contact(updatedName,updatedPhoneNumber,updatedEmail  );
					
					// Calling the update method to update the contact's details
					phonebook.updateContact(nameToUpdate, updatedContact);
					System.out.println("Contacted Updated ");
					
				}
				else {
					System.out.println("Contact not found");
				}
				
				break;
				
				// Case -4 Delete contact
			case 4:
				System.out.println("Enter the name of the contact you want to delete: ");
				scan.nextLine(); // consume the newline character left by previous scan.nextInt() 
				String nameToDelete = scan.nextLine();
				// finding the result of delete operation as it will return boolean
				boolean isDeleted = phonebook.deleteContact(nameToDelete);
				
				if(isDeleted) {
					System.out.println("Contacte Deleted");
				}
				else {
					System.out.println("Contact not found");
				}			
				break;
				
				// Displaying all contacts
			case 5:
				System.out.println("All contact in the phonebook are: ");
				phonebook.displayContact();
				
				break;
			case 6:
				System.out.println("Exiting Phonebook.Goodbye!");
				break;
			default:
				System.out.println("Invalid choice.Please try agian.");
			
			}
			
		}while(choice != 6); // Keep looping until the user choose option-6 to exit
 		
		
		// Closing the scan object
		scan.close(); 

	}

}
