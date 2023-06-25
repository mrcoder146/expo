package com.ScrumTool.BacklogItems;

import java.util.ArrayList;
import java.util.List;

import com.ScrumTool.BacklogItemParentChild.BacklogItemParentChild;
import com.ScrumTool.BacklogType.BacklogType;
import com.ScrumTool.Project.Project;
import com.ScrumTool.ProjectUserRole.ProjectUserRole;
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
@Table(name = "Backlog_Item")
public class BacklogItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Backlog_Item_Id")
	private long backlogItemId;

	@Column(name = "Backlog_Name")
	private String backlogName;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Backlog_Type_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private BacklogType backlogTypeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Project_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Project projectId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Who")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ProjectUserRole who;

	@Column(name = "What")
	private String what;

	@Column(name = "Benefits")
	private String benefits;

	@Column(name = "Acceptence_Critria")
	private String acceptenceCriteria;

	@Column(name = "Description")
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "backlogItemParentId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BacklogItemParentChild> backlogItemsParentChild = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "backlogItemChildId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BacklogItemParentChild> backlogItemParentChild = new ArrayList<>();

	public long getBacklogItemId() {
		return backlogItemId;
	}

	public void setBacklogItemId(long backlogItemId) {
		this.backlogItemId = backlogItemId;
	}

	public String getBacklogName() {
		return backlogName;
	}

	public void setBacklogName(String backlogName) {
		this.backlogName = backlogName;
	}

	public BacklogType getBacklogTypeId() {
		return backlogTypeId;
	}

	public void setBacklogTypeId(BacklogType backlogTypeId) {
		this.backlogTypeId = backlogTypeId;
	}

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	public ProjectUserRole getWho() {
		return who;
	}

	public void setWho(ProjectUserRole who) {
		this.who = who;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public String getAcceptenceCriteria() {
		return acceptenceCriteria;
	}

	public void setAcceptenceCriteria(String acceptenceCriteria) {
		this.acceptenceCriteria = acceptenceCriteria;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<BacklogItemParentChild> getBacklogItemsParentChild() {
		return backlogItemsParentChild;
	}

	public void setBacklogItemsParentChild(List<BacklogItemParentChild> backlogItemsParentChild) {
		this.backlogItemsParentChild = backlogItemsParentChild;
	}

	public List<BacklogItemParentChild> getBacklogItemParentChild() {
		return backlogItemParentChild;
	}

	public void setBacklogItemParentChild(List<BacklogItemParentChild> backlogItemParentChild) {
		this.backlogItemParentChild = backlogItemParentChild;
	}

	public BacklogItems(long backlogItemId, String backlogName, BacklogType backlogTypeId, Project projectId,
			ProjectUserRole who, String what, String benefits, String acceptenceCriteria, String description,
			List<BacklogItemParentChild> backlogItemsParentChild, List<BacklogItemParentChild> backlogItemParentChild) {
		super();
		this.backlogItemId = backlogItemId;
		this.backlogName = backlogName;
		this.backlogTypeId = backlogTypeId;
		this.projectId = projectId;
		this.who = who;
		this.what = what;
		this.benefits = benefits;
		this.acceptenceCriteria = acceptenceCriteria;
		this.description = description;
		this.backlogItemsParentChild = backlogItemsParentChild;
		this.backlogItemParentChild = backlogItemParentChild;
	}

	public BacklogItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}


