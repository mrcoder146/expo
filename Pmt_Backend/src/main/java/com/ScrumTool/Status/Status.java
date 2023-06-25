   package com.ScrumTool.Status;

import java.util.ArrayList;
import java.util.List;

import com.ScrumTool.BacklogItemParentChild.BacklogItemParentChild;
import com.ScrumTool.ReleaseSprintBacklog.ReleaseSprintBacklog;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Status")
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Status_Id")
	private long statusId;

	@Column(name = "Status_Name")
	private String statusName;

	@Column(name = "Sequence")
	private int sequence;
	
	@JsonIgnore
	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BacklogItemParentChild> backlogItemParentChild = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ReleaseSprintBacklog> releaseSprintBacklog = new ArrayList<>();

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public List<BacklogItemParentChild> getBacklogItemParentChild() {
		return backlogItemParentChild;
	}

	public void setBacklogItemParentChild(List<BacklogItemParentChild> backlogItemParentChild) {
		this.backlogItemParentChild = backlogItemParentChild;
	}

	public List<ReleaseSprintBacklog> getReleaseSprintBacklog() {
		return releaseSprintBacklog;
	}

	public void setReleaseSprintBacklog(List<ReleaseSprintBacklog> releaseSprintBacklog) {
		this.releaseSprintBacklog = releaseSprintBacklog;
	}

	public Status(long statusId, String statusName, int sequence, List<BacklogItemParentChild> backlogItemParentChild,
			List<ReleaseSprintBacklog> releaseSprintBacklog) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
		this.sequence = sequence;
		this.backlogItemParentChild = backlogItemParentChild;
		this.releaseSprintBacklog = releaseSprintBacklog;
	}

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
