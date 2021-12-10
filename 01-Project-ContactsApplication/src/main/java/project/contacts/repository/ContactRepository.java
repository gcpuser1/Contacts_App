package project.contacts.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import project.contacts.entities.Contact;


  public interface ContactRepository extends JpaRepository<Contact, Serializable>{
  
 
	}
