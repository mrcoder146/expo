package com.ScrumTool.Retrospection;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.ScrumTool.ProjectUserRole.ProjectUserRole;
import com.ScrumTool.ReleaseSprint.ReleaseSprint;
import com.ScrumTool.RetrospectionDetails.RetrospectionDetails;
import com.ScrumTool.RetrospectionStatus.RetrospectionStatus;
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
@Table(name = "Retrospection")
public class Retrospection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Retrospection_Id")
	private long rtrospectionId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Release_Sprint_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ReleaseSprint releaseSprintId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Created_By")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ProjectUserRole createdBy;
	
	@Column(name = "Created_On")
	private Date createdOn;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Status")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private RetrospectionStatus status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "retrospectionId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RetrospectionDetails> retrospectionDetails = new ArrayList<>();

	public long getRtrospectionId() {
		return rtrospectionId;
	}

	public void setRtrospectionId(long rtrospectionId) {
		this.rtrospectionId = rtrospectionId;
	}

	public ReleaseSprint getReleaseSprintId() {
		return releaseSprintId;
	}

	public void setReleaseSprintId(ReleaseSprint releaseSprintId) {
		this.releaseSprintId = releaseSprintId;
	}

	public ProjectUserRole getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(ProjectUserRole createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public RetrospectionStatus getStatus() {
		return status;
	}

	public void setStatus(RetrospectionStatus status) {
		this.status = status;
	}

	public List<RetrospectionDetails> getRetrospectionDetails() {
		return retrospectionDetails;
	}

	public void setRetrospectionDetails(List<RetrospectionDetails> retrospectionDetails) {
		this.retrospectionDetails = retrospectionDetails;
	}

	public Retrospection(long rtrospectionId, ReleaseSprint releaseSprintId, ProjectUserRole createdBy, Date createdOn,
			RetrospectionStatus status, List<RetrospectionDetails> retrospectionDetails) {
		super();
		this.rtrospectionId = rtrospectionId;
		this.releaseSprintId = releaseSprintId;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.status = status;
		this.retrospectionDetails = retrospectionDetails;
	}

	public Retrospection() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}