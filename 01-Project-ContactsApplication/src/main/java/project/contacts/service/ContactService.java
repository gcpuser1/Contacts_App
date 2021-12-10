package project.contacts.service;

import java.util.List;
import org.springframework.stereotype.Service;
import project.contacts.bindings.ContactForm;

public interface ContactService {	
	/*
	 * addContact -> input (ContactForm) output (Sting)
	 * deleteContact -> input (int ContactID) output (List <Contact>)
	 * viewAllContacts -> input (void) output (List <Contact>)
	 * editContact -> input (int contactID) output ( ContactForm)
	 * 
	 */
	
	public String addContact(ContactForm contactForm);
	public List< ContactForm > deleteContact(int ContactID);
	public ContactForm editContact(int ContacID);
	public List<ContactForm> viewAllContacts();
}