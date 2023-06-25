package com.ScrumTool.DailyTaskProgress;

import java.sql.Date;

import com.ScrumTool.ReleaseSprintBacklog.ReleaseSprintBacklog;
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
@Table(name = "Daily_Task_Progress")
public class DailyTaskProgress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Release_Sprint_Backlog_progress_id")
	private long releaseSprintBacklogProgressId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Release_Sprint_Backlog_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ReleaseSprintBacklog releaseSprintBacklogId;

	@Column(name = "Date")
	private Date date;

	@Column(name = "Completed_Story_Point")
	private long completedStoryPoint;

	public long getReleaseSprintBacklogProgressId() {
		return releaseSprintBacklogProgressId;
	}

	public void setReleaseSprintBacklogProgressId(long releaseSprintBacklogProgressId) {
		this.releaseSprintBacklogProgressId = releaseSprintBacklogProgressId;
	}

	public ReleaseSprintBacklog getReleaseSprintBacklogId() {
		return releaseSprintBacklogId;
	}

	public void setReleaseSprintBacklogId(ReleaseSprintBacklog releaseSprintBacklogId) {
		this.releaseSprintBacklogId = releaseSprintBacklogId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getCompletedStoryPoint() {
		return completedStoryPoint;
	}

	public void setCompletedStoryPoint(long completedStoryPoint) {
		this.completedStoryPoint = completedStoryPoint;
	}

	public DailyTaskProgress(long releaseSprintBacklogProgressId, ReleaseSprintBacklog releaseSprintBacklogId,
			Date date, long completedStoryPoint) {
		super();
		this.releaseSprintBacklogProgressId = releaseSprintBacklogProgressId;
		this.releaseSprintBacklogId = releaseSprintBacklogId;
		this.date = date;
		this.completedStoryPoint = completedStoryPoint;
	}

	public DailyTaskProgress() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
