package com.ScrumTool.BacklogItemParentChild;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.ScrumTool.BacklogItems.BacklogItems;
import com.ScrumTool.ReleaseSprintBacklog.ReleaseSprintBacklog;
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
@Table(name = "Backlog_Item_Parent_Child")

		
public class BacklogItemParentChild {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Backlog_Item_Parent_Child_Id")
	private long backolgItemParentChildId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Backlog_Item_Parent_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private BacklogItems backlogItemParentId;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Backlog_Item_Child_Id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private BacklogItems backlogItemChildId;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Status")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Status status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "backlogItemParentChildId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ReleaseSprintBacklog> releaseSprintBacklog = new ArrayList<>();

	public long getBackolgItemParentChildId() {
		return backolgItemParentChildId;
	}

	public void setBackolgItemParentChildId(long backolgItemParentChildId) {
		this.backolgItemParentChildId = backolgItemParentChildId;
	}

	public BacklogItems getBacklogItemParentId() {
		return backlogItemParentId;
	}

	public void setBacklogItemParentId(BacklogItems backlogItemParentId) {
		this.backlogItemParentId = backlogItemParentId;
	}

	public BacklogItems getBacklogItemChildId() {
		return backlogItemChildId;
	}

	public void setBacklogItemChildId(BacklogItems backlogItemChildId) {
		this.backlogItemChildId = backlogItemChildId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<ReleaseSprintBacklog> getReleaseSprintBacklog() {
		return releaseSprintBacklog;
	}

	public void setReleaseSprintBacklog(List<ReleaseSprintBacklog> releaseSprintBacklog) {
		this.releaseSprintBacklog = releaseSprintBacklog;
	}

	public BacklogItemParentChild(long backolgItemParentChildId, BacklogItems backlogItemParentId,
			BacklogItems backlogItemChildId, Status status, List<ReleaseSprintBacklog> releaseSprintBacklog) {
		super();
		this.backolgItemParentChildId = backolgItemParentChildId;
		this.backlogItemParentId = backlogItemParentId;
		this.backlogItemChildId = backlogItemChildId;
		this.status = status;
		this.releaseSprintBacklog = releaseSprintBacklog;
	}

	public BacklogItemParentChild() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
