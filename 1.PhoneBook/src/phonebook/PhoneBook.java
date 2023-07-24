package phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
	private List<Contact> contacts; // an array list named as "contacts" with the data type -"Contact" (as that of class)
   
	// Constructor to initialize the PhoneBook with an empty list of contacts
	//  The constructor initializes the contacts list as an empty ArrayList when a Phonebook object is created.
	public PhoneBook() {
		contacts = new ArrayList<>();
	}
	
	// Method to add contact in the phonebook
	public void addContact(Contact contact) {
		contacts.add(contact);  // adding new contact "contact" in the array list-contacts
	}
	
	// Method to search for a contact by name
	public Contact searchContact(String name) {
		for(Contact contact : contacts) {
			if(contact.getName().equalsIgnoreCase(name)) {
				return contact; // returning contact if the contact has been found
			}
			
		}
		return null; // return null if the contact is not in the list
	}
	
	
	// Method to display all contacts in the list
	public void displayContact() {
		for(Contact contact : contacts) {
			System.out.println(contact.getName() + " | " + contact.getphoneNumber() + " | " + contact.getemail());
		}
	}
	
	// Method to delete the contact by name
	public boolean deleteContact(String name) {
		Contact contactToRemove = searchContact(name);
		if(contactToRemove != null) {
			contacts.remove(contactToRemove);
			return true;
		}
		return false;
	}
	
	
	// Method to update contact
	public boolean updateContact(String name, Contact updatedContact) {
		Contact contactToUpdate = searchContact(name);
		if(contactToUpdate != null) {
			contactToUpdate.setName(updatedContact.getName());
			contactToUpdate.setphoneNumber(updatedContact.getphoneNumber());
			contactToUpdate.setemail(updatedContact.getemail());
			return true;	
		}
		return false;
	}
	
	
	
}
