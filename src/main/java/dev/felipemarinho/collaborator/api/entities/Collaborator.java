package dev.felipemarinho.collaborator.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import dev.felipemarinho.collaborator.api.enums.RoleEnum;
import dev.felipemarinho.collaborator.api.enums.TeamEnum;

@Entity
@Table(name = "collaborator")
public class Collaborator implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7370894886716753295L;
	private Long id;
	private String name;
	private TeamEnum team;
	private RoleEnum role;
	private List<ProfessionalExperiences> experiences;
	private List<Contact> contacts;
	private String local;
	private Date createdAt;
	private Date updatedAt;
	
	public Collaborator() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "team", nullable = false)
	public TeamEnum getTeam() {
		return team;
	}

	public void setTeam(TeamEnum team) {
		this.team = team;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	@OneToMany(mappedBy = "collaborator")
	public List<ProfessionalExperiences> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<ProfessionalExperiences> experiences) {
		this.experiences = experiences;
	}

	@OneToMany(mappedBy = "collaborator")
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	@Column(name = "created_at", nullable = false)
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Column(name = "updated_at", nullable = false)
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Column(name = "local", nullable = true)
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	@PrePersist
    public void prePersist() {
        final Date now = new Date();
        createdAt = now;
        updatedAt = now;
    }
	
	@PreUpdate
	public void preUpdate() {
		final Date now = new Date();
		updatedAt = now;
	}

	@Override
	public String toString() {
		return "Collaborator [id=" + id + ", name=" + name + ", team=" + team + ", role=" + role + ", experiences="
				+ experiences + ", contact=" + contacts + ", local=" + local + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

	

}
