package com.ScrumTool.ProjectUserRole;

import java.util.ArrayList;
import java.util.List;

import com.ScrumTool.BacklogItems.BacklogItems;
import com.ScrumTool.Impediment.Impediment;
import com.ScrumTool.Issue.Issue;
import com.ScrumTool.Project.Project;
import com.ScrumTool.ReleaseSprintBacklog.ReleaseSprintBacklog;
import com.ScrumTool.Retrospection.Retrospection;
import com.ScrumTool.RetrospectionDetails.RetrospectionDetails;
import com.ScrumTool.Role.Role;
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
@Table(name = "Project_User_Role")

public class ProjectUserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Project_User_Role_Id")
	private long projectUserRoleId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Project_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Project projectId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private User userId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Role_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Role roleId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "who", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BacklogItems> backlogItems = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "assignedTo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ReleaseSprintBacklog> releaseSprintBacklog = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "assignedTo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Issue> issue = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "raisedBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Issue> issues = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "assignedTo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Impediment> impediment = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "raisedBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Impediment> impediments = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Retrospection> restrospection = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RetrospectionDetails> restrospectionDetails = new ArrayList<>();

	public long getProjectUserRoleId() {
		return projectUserRoleId;
	}

	public void setProjectUserRoleId(long projectUserRoleId) {
		this.projectUserRoleId = projectUserRoleId;
	}

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public List<BacklogItems> getBacklogItems() {
		return backlogItems;
	}

	public void setBacklogItems(List<BacklogItems> backlogItems) {
		this.backlogItems = backlogItems;
	}

	public List<ReleaseSprintBacklog> getReleaseSprintBacklog() {
		return releaseSprintBacklog;
	}

	public void setReleaseSprintBacklog(List<ReleaseSprintBacklog> releaseSprintBacklog) {
		this.releaseSprintBacklog = releaseSprintBacklog;
	}

	public List<Issue> getIssue() {
		return issue;
	}

	public void setIssue(List<Issue> issue) {
		this.issue = issue;
	}

	public List<Issue> getIssues() {
		return issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	public List<Impediment> getImpediment() {
		return impediment;
	}

	public void setImpediment(List<Impediment> impediment) {
		this.impediment = impediment;
	}

	public List<Impediment> getImpediments() {
		return impediments;
	}

	public void setImpediments(List<Impediment> impediments) {
		this.impediments = impediments;
	}

	public List<Retrospection> getRestrospection() {
		return restrospection;
	}

	public void setRestrospection(List<Retrospection> restrospection) {
		this.restrospection = restrospection;
	}

	public List<RetrospectionDetails> getRestrospectionDetails() {
		return restrospectionDetails;
	}

	public void setRestrospectionDetails(List<RetrospectionDetails> restrospectionDetails) {
		this.restrospectionDetails = restrospectionDetails;
	}

	public ProjectUserRole(long projectUserRoleId, Project projectId, User userId, Role roleId,
			List<BacklogItems> backlogItems, List<ReleaseSprintBacklog> releaseSprintBacklog, List<Issue> issue,
			List<Issue> issues, List<Impediment> impediment, List<Impediment> impediments,
			List<Retrospection> restrospection, List<RetrospectionDetails> restrospectionDetails) {
		super();
		this.projectUserRoleId = projectUserRoleId;
		this.projectId = projectId;
		this.userId = userId;
		this.roleId = roleId;
		this.backlogItems = backlogItems;
		this.releaseSprintBacklog = releaseSprintBacklog;
		this.issue = issue;
		this.issues = issues;
		this.impediment = impediment;
		this.impediments = impediments;
		this.restrospection = restrospection;
		this.restrospectionDetails = restrospectionDetails;
	}

	public ProjectUserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}