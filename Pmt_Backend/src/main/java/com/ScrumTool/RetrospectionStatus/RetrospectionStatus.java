package com.ScrumTool.RetrospectionStatus;

import java.util.ArrayList;
import java.util.List;

import com.ScrumTool.Retrospection.Retrospection;
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
@Table(name="Retrospection_Status")
public class RetrospectionStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Retrospection_Status_Id")
	private long retrospectionStatusId;
	
	@Column(name="Retrosepection_Staus_Name")
	String retrospectionStatusName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Retrospection> retrospection = new ArrayList<>();

	public long getRetrospectionStatusId() {
		return retrospectionStatusId;
	}

	public void setRetrospectionStatusId(long retrospectionStatusId) {
		this.retrospectionStatusId = retrospectionStatusId;
	}

	public String getRetrospectionStatusName() {
		return retrospectionStatusName;
	}

	public void setRetrospectionStatusName(String retrospectionStatusName) {
		this.retrospectionStatusName = retrospectionStatusName;
	}

	public List<Retrospection> getRetrospection() {
		return retrospection;
	}

	public void setRetrospection(List<Retrospection> retrospection) {
		this.retrospection = retrospection;
	}

	public RetrospectionStatus(long retrospectionStatusId, String retrospectionStatusName,
			List<Retrospection> retrospection) {
		super();
		this.retrospectionStatusId = retrospectionStatusId;
		this.retrospectionStatusName = retrospectionStatusName;
		this.retrospection = retrospection;
	}

	public RetrospectionStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}