package com.ScrumTool.SprintProgress;

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
@Table(name = "Sprint_Progress")
public class SprintProgress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "Sprint_Progress_Id")
	private long sprintProgressId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Release_Sprint_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ReleaseSprint releaseSprintId;

	@Column(name = "Remaining_Task_Estimation")
	private int remainingTaskEstimation;

	@Column(name = "Ideal_Remaining_Task_Estimation")
	private int idealRemainingTaskEstimation;

	public long getSprintProgressId() {
		return sprintProgressId;
	}

	public void setSprintProgressId(long sprintProgressId) {
		this.sprintProgressId = sprintProgressId;
	}

	public ReleaseSprint getReleaseSprintId() {
		return releaseSprintId;
	}

	public void setReleaseSprintId(ReleaseSprint releaseSprintId) {
		this.releaseSprintId = releaseSprintId;
	}

	public int getRemainingTaskEstimation() {
		return remainingTaskEstimation;
	}

	public void setRemainingTaskEstimation(int remainingTaskEstimation) {
		this.remainingTaskEstimation = remainingTaskEstimation;
	}

	public int getIdealRemainingTaskEstimation() {
		return idealRemainingTaskEstimation;
	}

	public void setIdealRemainingTaskEstimation(int idealRemainingTaskEstimation) {
		this.idealRemainingTaskEstimation = idealRemainingTaskEstimation;
	}

	public SprintProgress(long sprintProgressId, ReleaseSprint releaseSprintId, int remainingTaskEstimation,
			int idealRemainingTaskEstimation) {
		super();
		this.sprintProgressId = sprintProgressId;
		this.releaseSprintId = releaseSprintId;
		this.remainingTaskEstimation = remainingTaskEstimation;
		this.idealRemainingTaskEstimation = idealRemainingTaskEstimation;
	}

	public SprintProgress() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
