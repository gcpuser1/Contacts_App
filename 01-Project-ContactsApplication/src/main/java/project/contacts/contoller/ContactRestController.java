package project.contacts.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.contacts.bindings.ContactForm;
import project.contacts.service.ContactService;

@RestController
public class ContactRestController {
	
	@Autowired
	private ContactService service;
	
	@PostMapping("/add")
	public String addContact(@RequestBody ContactForm contactForm) {
		System.out.println(contactForm);
		String status=service.addContact(contactForm);
		return status;
	}
	
	@GetMapping("/all")
	public List<ContactForm> viewAllContacts(){
		return service.viewAllContacts();
	}

	@GetMapping(path = "/edit/{ContactID}")
	public ContactForm editContact(@PathVariable int ContacID) {
		return service.editContact(ContacID);
	}

	@DeleteMapping(path="/delete/{ContactID}")
	public List<ContactForm> DeleteContact(@PathVariable int ContactID){
		return service.deleteContact(ContactID);
	}
	
	@GetMapping(path="/temp")
	public String temp() {
		return "done";
	}
}
