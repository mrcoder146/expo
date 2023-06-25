package com.ScrumTool.ReleaseSprint;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.ScrumTool.Impediment.Impediment;
import com.ScrumTool.Issue.Issue;
import com.ScrumTool.Release.Release;
import com.ScrumTool.ReleaseSprintBacklog.ReleaseSprintBacklog;
import com.ScrumTool.Retrospection.Retrospection;
import com.ScrumTool.SprintProgress.SprintProgress;
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
@Table(name = "Release_Sprint")

public class ReleaseSprint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Release_Sprint_Id")
	private long releaseSprintId;

	@Column(name = "Sprint_Name")
	private String sprintName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Release_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Release releaseId;

	@Column(name = "Start_Date")
	private Date startDate;

	@Column(name = "End_Date")
	private Date endDate;

	@Column(name = "Total_Estimated_Story_Point")
	private long totalEstimatedStoryPoint;
	
	@JsonIgnore
	@OneToMany(mappedBy = "releaseSprintId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ReleaseSprintBacklog> releaseSprintBacklog = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "releaseSprintId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SprintProgress> sprintProgress = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "releaseSprintId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Issue> issue = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "releaseSprintId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Impediment> impediment = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "releaseSprintId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Retrospection> retrospection = new ArrayList<>();

	public long getReleaseSprintId() {
		return releaseSprintId;
	}

	public void setReleaseSprintId(long releaseSprintId) {
		this.releaseSprintId = releaseSprintId;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public Release getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(Release releaseId) {
		this.releaseId = releaseId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getTotalEstimatedStoryPoint() {
		return totalEstimatedStoryPoint;
	}

	public void setTotalEstimatedStoryPoint(long totalEstimatedStoryPoint) {
		this.totalEstimatedStoryPoint = totalEstimatedStoryPoint;
	}

	public List<ReleaseSprintBacklog> getReleaseSprintBacklog() {
		return releaseSprintBacklog;
	}

	public void setReleaseSprintBacklog(List<ReleaseSprintBacklog> releaseSprintBacklog) {
		this.releaseSprintBacklog = releaseSprintBacklog;
	}

	public List<SprintProgress> getSprintProgress() {
		return sprintProgress;
	}

	public void setSprintProgress(List<SprintProgress> sprintProgress) {
		this.sprintProgress = sprintProgress;
	}

	public List<Issue> getIssue() {
		return issue;
	}

	public void setIssue(List<Issue> issue) {
		this.issue = issue;
	}

	public List<Impediment> getImpediment() {
		return impediment;
	}

	public void setImpediment(List<Impediment> impediment) {
		this.impediment = impediment;
	}

	public List<Retrospection> getRetrospection() {
		return retrospection;
	}

	public void setRetrospection(List<Retrospection> retrospection) {
		this.retrospection = retrospection;
	}

	public ReleaseSprint(long releaseSprintId, String sprintName, Release releaseId, Date startDate, Date endDate,
			long totalEstimatedStoryPoint, List<ReleaseSprintBacklog> releaseSprintBacklog,
			List<SprintProgress> sprintProgress, List<Issue> issue, List<Impediment> impediment,
			List<Retrospection> retrospection) {
		super();
		this.releaseSprintId = releaseSprintId;
		this.sprintName = sprintName;
		this.releaseId = releaseId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalEstimatedStoryPoint = totalEstimatedStoryPoint;
		this.releaseSprintBacklog = releaseSprintBacklog;
		this.sprintProgress = sprintProgress;
		this.issue = issue;
		this.impediment = impediment;
		this.retrospection = retrospection;
	}

	public ReleaseSprint() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
