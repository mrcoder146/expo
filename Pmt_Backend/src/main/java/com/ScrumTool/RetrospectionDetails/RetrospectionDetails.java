package com.ScrumTool.RetrospectionDetails;

import com.ScrumTool.ProjectUserRole.ProjectUserRole;
import com.ScrumTool.Retrospection.Retrospection;
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
@Table(name="Retrospection_Details")
public class RetrospectionDetails {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Retrospection_Details_id") 
	private long retrospectionDetailsId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Created_By")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ProjectUserRole createdBy;
	
	@Column(name="Is_Went_Well")
	private boolean isWentWell ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Retrospection_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Retrospection retrospectionId;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Action_Item")
	private String actionItem;

	public long getRetrospectionDetailsId() {
		return retrospectionDetailsId;
	}

	public void setRetrospectionDetailsId(long retrospectionDetailsId) {
		this.retrospectionDetailsId = retrospectionDetailsId;
	}

	public ProjectUserRole getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(ProjectUserRole createdBy) {
		this.createdBy = createdBy;
	}

	public boolean isWentWell() {
		return isWentWell;
	}

	public void setWentWell(boolean isWentWell) {
		this.isWentWell = isWentWell;
	}

	public Retrospection getRetrospectionId() {
		return retrospectionId;
	}

	public void setRetrospectionId(Retrospection retrospectionId) {
		this.retrospectionId = retrospectionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActionItem() {
		return actionItem;
	}

	public void setActionItem(String actionItem) {
		this.actionItem = actionItem;
	}

	public RetrospectionDetails(long retrospectionDetailsId, ProjectUserRole createdBy, boolean isWentWell,
			Retrospection retrospectionId, String description, String actionItem) {
		super();
		this.retrospectionDetailsId = retrospectionDetailsId;
		this.createdBy = createdBy;
		this.isWentWell = isWentWell;
		this.retrospectionId = retrospectionId;
		this.description = description;
		this.actionItem = actionItem;
	}

	public RetrospectionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}