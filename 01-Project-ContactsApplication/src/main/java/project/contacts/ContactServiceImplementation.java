package project.contacts;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.contacts.bindings.ContactForm;
import project.contacts.entities.Contact;
import project.contacts.repository.ContactRepository;
import project.contacts.service.ContactService;

@Service
public class ContactServiceImplementation implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public String addContact(ContactForm contactForm) {
		// TODO Auto-generated method stub
		System.out.println("********* start");
		Contact entity = new Contact();
		System.out.println(entity);
		BeanUtils.copyProperties(contactForm, entity);
		entity.setActiveSwitch("y");
		entity = contactRepository.save(entity);
		if (entity.getId() != -1) {
			return "SUCCESS";
		}
		return "FAILURE";
	}

	@Override
	public List<ContactForm> viewAllContacts() {
		// TODO Auto-generated method stub
		List<ContactForm> dataList = new ArrayList<ContactForm>();
		List<Contact> contacts = contactRepository.findAll();
		for (Contact c : contacts) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(c, form);
			dataList.add(form);
		}
		return dataList;
	}

	@Override
	public List<ContactForm> deleteContact(int ContactID) {
		// TODO Auto-generated method stub
		Optional<Contact> c=contactRepository.findById(ContactID);
		if(c.isPresent()) {
			contactRepository.deleteById(c.get().getId());
		}
		return viewAllContacts();
	}

	@Override
	public ContactForm editContact(int ContacID) {
		// TODO Auto-generated method stub
		Optional<Contact> c = contactRepository.findById(ContacID);
		if (c.isPresent()) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(c.get(), form);
			return form;
		}
		return null;
	}
}