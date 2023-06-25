package com.ScrumTool.BacklogType;

import java.util.ArrayList;
import java.util.List;

import com.ScrumTool.BacklogItems.BacklogItems;
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
@Table(name = "Backlog_Type")

public class BacklogType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Backlog_Type_Id")
	private long backlogTypeId;

	@Column(name = "Backlog_Type_Name")
	private String backlogTypeName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "backlogTypeId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BacklogItems> backlogItems = new ArrayList<>();

	public long getBacklogTypeId() {
		return backlogTypeId;
	}

	public void setBacklogTypeId(long backlogTypeId) {
		this.backlogTypeId = backlogTypeId;
	}

	public String getBacklogTypeName() {
		return backlogTypeName;
	}

	public void setBacklogTypeName(String backlogTypeName) {
		this.backlogTypeName = backlogTypeName;
	}

	public List<BacklogItems> getBacklogItems() {
		return backlogItems;
	}

	public void setBacklogItems(List<BacklogItems> backlogItems) {
		this.backlogItems = backlogItems;
	}

	public BacklogType(long backlogTypeId, String backlogTypeName, List<BacklogItems> backlogItems) {
		super();
		this.backlogTypeId = backlogTypeId;
		this.backlogTypeName = backlogTypeName;
		this.backlogItems = backlogItems;
	}

	public BacklogType() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
