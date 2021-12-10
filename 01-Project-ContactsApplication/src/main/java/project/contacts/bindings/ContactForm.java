package project.contacts.bindings;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ContactForm {
private int id;	
	private String name;
	private String email;
	private Long contact;
	private LocalDate updatedDate;
	private String activeSwitch;
	private LocalDate createdDate;

}