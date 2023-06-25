package com.ScrumTool.Release;

import java.util.ArrayList;
import java.util.List;

import com.ScrumTool.ReleaseSprint.ReleaseSprint;
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
@Table(name = "Release")
public class Release {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Release_Id")
	private long releaseId;

	@Column(name = "Release_Name")
	private String releaseName;

	@Column(name = "Project_Id")
	private long projectId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "releaseId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ReleaseSprint> releaseSprint = new ArrayList<>();

	public long getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(long releaseId) {
		this.releaseId = releaseId;
	}

	public String getReleaseName() {
		return releaseName;
	}

	public void setReleaseName(String releaseName) {
		this.releaseName = releaseName;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public List<ReleaseSprint> getReleaseSprint() {
		return releaseSprint;
	}

	public void setReleaseSprint(List<ReleaseSprint> releaseSprint) {
		this.releaseSprint = releaseSprint;
	}

	public Release(long releaseId, String releaseName, long projectId, List<ReleaseSprint> releaseSprint) {
		super();
		this.releaseId = releaseId;
		this.releaseName = releaseName;
		this.projectId = projectId;
		this.releaseSprint = releaseSprint;
	}

	public Release() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
