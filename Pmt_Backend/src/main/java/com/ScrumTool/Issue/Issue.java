package com.ScrumTool.Issue;


import java.sql.Date;

import com.ScrumTool.IssueImpedimentStatus.IssueImpedimentStatus;
import com.ScrumTool.ProjectUserRole.ProjectUserRole;
import com.ScrumTool.ReleaseSprint.ReleaseSprint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Issue")
public class Issue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Issue_Id")
	private long issueId;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Priority")
	private String priority;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Status_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private IssueImpedimentStatus statusId;
	
	@Column(name="Date")
	private Date date;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Raised_By")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ProjectUserRole raisedBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Assigned_To")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ProjectUserRole assignedTo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Release_Sprint_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ReleaseSprint releaseSprintId;

	public long getIssueId() {
		return issueId;
	}

	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public IssueImpedimentStatus getStatusId() {
		return statusId;
	}

	public void setStatusId(IssueImpedimentStatus statusId) {
		this.statusId = statusId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ProjectUserRole getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(ProjectUserRole raisedBy) {
		this.raisedBy = raisedBy;
	}

	public ProjectUserRole getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(ProjectUserRole assignedTo) {
		this.assignedTo = assignedTo;
	}

	public ReleaseSprint getReleaseSprintId() {
		return releaseSprintId;
	}

	public void setReleaseSprintId(ReleaseSprint releaseSprintId) {
		this.releaseSprintId = releaseSprintId;
	}

	public Issue(long issueId, String title, String description, String priority, IssueImpedimentStatus statusId,
			Date date, ProjectUserRole raisedBy, ProjectUserRole assignedTo, ReleaseSprint releaseSprintId) {
		super();
		this.issueId = issueId;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.statusId = statusId;
		this.date = date;
		this.raisedBy = raisedBy;
		this.assignedTo = assignedTo;
		this.releaseSprintId = releaseSprintId;
	}

	public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}