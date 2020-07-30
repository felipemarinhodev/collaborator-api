package dev.felipemarinho.collaborator.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.felipemarinho.collaborator.api.enums.ContactEnum;

@Entity
@Table(name = "contacts")
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2296783485997701788L;
	private Long id;
	private String value;
	private ContactEnum type;
//	private Collaborator collaborator;
	public Contact() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "value", nullable = false)
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	public ContactEnum getType() {
		return type;
	}
	public void setType(ContactEnum type) {
		this.type = type;
	}
	
//	@ManyToOne
//	@JoinColumn(name = "collaborator_id", referencedColumnName = "id", nullable = false)
//	public Collaborator getCollaborator() {
//		return collaborator;
//	}
//
//	public void setCollaborator(Collaborator collaborator) {
//		this.collaborator = collaborator;
//	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", value=" + value + ", type=" + type + "]";
	}
	
}
