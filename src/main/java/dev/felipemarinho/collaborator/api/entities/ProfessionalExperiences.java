package dev.felipemarinho.collaborator.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="professional_experiences")
public class ProfessionalExperiences implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3894677117921960569L;

	private Long id;
	private String description;
	private String skills;
//	private Collaborator collaborator;
	private Date createdAt;
	private Date updatedAt;
	
	public ProfessionalExperiences() {}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Column(name = "skills", nullable = true)
	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	public Collaborator getCollaborator() {
//		return collaborator;
//	}

//	public void setCollaborator(Collaborator collaborator) {
//		this.collaborator = collaborator;
//	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "created_at", nullable = false)
	public Date getCreatedAt() {
		return createdAt;
	}

	@Column(name = "updated_at", nullable = false)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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
		return "ProfessionalExperiences [id=" + id + ", description=" + description + ", skills=" + skills
				+ " createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
