package com.ScrumTool.Project;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.ScrumTool.BacklogItems.BacklogItems;
import com.ScrumTool.Invitation.Invitation;
import com.ScrumTool.ProjectUserRole.ProjectUserRole;
import com.ScrumTool.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Project_Table")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Project_Id")
	private long projectId;

	@Column(name = "Project_Name")
	private String projectName;
	
	@Column(name = "Company_Name")
	private String companyName;

	@Column(name = "Created_On")
	private Date createdOn;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Created_By")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private User createdBy;

	@JsonIgnore
	@OneToMany(mappedBy = "projectId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Invitation> invitation = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "projectId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BacklogItems> backlogItems = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "projectId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProjectUserRole> projectStatusRole = new ArrayList<>();

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public List<Invitation> getInvitation() {
		return invitation;
	}

	public void setInvitation(List<Invitation> invitation) {
		this.invitation = invitation;
	}

	public List<BacklogItems> getBacklogItems() {
		return backlogItems;
	}

	public void setBacklogItems(List<BacklogItems> backlogItems) {
		this.backlogItems = backlogItems;
	}

	public List<ProjectUserRole> getProjectStatusRole() {
		return projectStatusRole;
	}

	public void setProjectStatusRole(List<ProjectUserRole> projectStatusRole) {
		this.projectStatusRole = projectStatusRole;
	}

	public Project(long projectId, String projectName, String companyName, Date createdOn, User createdBy,
			List<Invitation> invitation, List<BacklogItems> backlogItems, List<ProjectUserRole> projectStatusRole) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.companyName = companyName;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.invitation = invitation;
		this.backlogItems = backlogItems;
		this.projectStatusRole = projectStatusRole;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
