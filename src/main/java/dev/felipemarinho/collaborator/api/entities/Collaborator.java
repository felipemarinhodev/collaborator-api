package dev.felipemarinho.collaborator.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import dev.felipemarinho.collaborator.api.enums.RoleEnum;
import dev.felipemarinho.collaborator.api.enums.TeamEnum;

@Entity
@Table(name = "collaborators")
public class Collaborator implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7370894886716753295L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(name = "team", nullable = false)
	private TeamEnum team;
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private RoleEnum role;

	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
	    )
    @JoinColumn(name = "collaborator_id", nullable = false)
	private List<ProfessionalExperiences> professionalExperiences;
	
//	@OneToMany(
//		cascade = CascadeType.ALL,
//		fetch = FetchType.EAGER,
//		orphanRemoval = true
//	)
//	@JoinColumn(name = "collaborator_id", nullable = false)
//	private List<Contact> contacts;
	@Column(name = "local", nullable = true)
	private String local;
	@Column(name = "created_at", nullable = false)
	private Date createdAt;
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;
	
	public Collaborator() {}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TeamEnum getTeam() {
		return team;
	}

	public void setTeam(TeamEnum team) {
		this.team = team;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	public List<ProfessionalExperiences> getProfessionalExperiences() {
		return professionalExperiences;
	}

	public void setProfessionalExperiences(List<ProfessionalExperiences> professionalExperiences) {
		this.professionalExperiences = professionalExperiences;
	}

//	public List<Contact> getContacts() {
//		return contacts;
//	}
//
//	public void setContacts(List<Contact> contacts) {
//		this.contacts = contacts;
//	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Collaborator [id=" + id + ", name=" + name + ", team=" + team + ", role=" + role + ", experiences="
				+ professionalExperiences + ", local=" + local + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

	

}
