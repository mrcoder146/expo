package com.ScrumTool.ReleaseSprintBacklog;

import java.util.ArrayList;
import java.util.List;

import com.ScrumTool.BacklogItemParentChild.BacklogItemParentChild;
import com.ScrumTool.DailyTaskProgress.DailyTaskProgress;
import com.ScrumTool.ProjectUserRole.ProjectUserRole;
import com.ScrumTool.ReleaseSprint.ReleaseSprint;
import com.ScrumTool.Status.Status;
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
@Table(name="Release_Sprint_Backlog")
public class ReleaseSprintBacklog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Release_Sprint_Backlog_id")
	private long releaseSprintBacklogId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Release_Sprint_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ReleaseSprint releaseSprintId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BacklogItem_Parent_Child_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private BacklogItemParentChild backlogItemParentChildId;
	
	@Column(name="Estimated_Story_Point")
	private long estimateStoryPoint;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Assigned_To")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ProjectUserRole assignedTo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Status")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Status status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "releaseSprintBacklogId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DailyTaskProgress> dailyTaskProgress = new ArrayList<>();

	public long getReleaseSprintBacklogId() {
		return releaseSprintBacklogId;
	}

	public void setReleaseSprintBacklogId(long releaseSprintBacklogId) {
		this.releaseSprintBacklogId = releaseSprintBacklogId;
	}

	public ReleaseSprint getReleaseSprintId() {
		return releaseSprintId;
	}

	public void setReleaseSprintId(ReleaseSprint releaseSprintId) {
		this.releaseSprintId = releaseSprintId;
	}

	public BacklogItemParentChild getBacklogItemParentChildId() {
		return backlogItemParentChildId;
	}

	public void setBacklogItemParentChildId(BacklogItemParentChild backlogItemParentChildId) {
		this.backlogItemParentChildId = backlogItemParentChildId;
	}

	public long getEstimateStoryPoint() {
		return estimateStoryPoint;
	}

	public void setEstimateStoryPoint(long estimateStoryPoint) {
		this.estimateStoryPoint = estimateStoryPoint;
	}

	public ProjectUserRole getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(ProjectUserRole assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<DailyTaskProgress> getDailyTaskProgress() {
		return dailyTaskProgress;
	}

	public void setDailyTaskProgress(List<DailyTaskProgress> dailyTaskProgress) {
		this.dailyTaskProgress = dailyTaskProgress;
	}

	public ReleaseSprintBacklog(long releaseSprintBacklogId, ReleaseSprint releaseSprintId,
			BacklogItemParentChild backlogItemParentChildId, long estimateStoryPoint, ProjectUserRole assignedTo,
			Status status, List<DailyTaskProgress> dailyTaskProgress) {
		super();
		this.releaseSprintBacklogId = releaseSprintBacklogId;
		this.releaseSprintId = releaseSprintId;
		this.backlogItemParentChildId = backlogItemParentChildId;
		this.estimateStoryPoint = estimateStoryPoint;
		this.assignedTo = assignedTo;
		this.status = status;
		this.dailyTaskProgress = dailyTaskProgress;
	}

	public ReleaseSprintBacklog() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
