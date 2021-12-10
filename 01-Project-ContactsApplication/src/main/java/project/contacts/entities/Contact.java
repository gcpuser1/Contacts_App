package project.contacts.entities;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="CONTACTS")
public class Contact {
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="contact_email")
	private String email;
	
	@Column(name="contact_number")
	private Long contact;
	
	@Column(name="active_switch")
	private String activeSwitch;
	
	
	@Column(name="updated_date")
	@CreationTimestamp
	private LocalDate updatedDate;
	
	@Column(name="created_date")
	@CreationTimestamp
	private LocalDate createdDate;
	
}
