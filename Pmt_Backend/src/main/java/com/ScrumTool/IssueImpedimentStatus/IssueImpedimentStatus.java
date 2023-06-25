package com.ScrumTool.IssueImpedimentStatus;

import java.util.ArrayList;
import java.util.List;

import com.ScrumTool.Impediment.Impediment;
import com.ScrumTool.Issue.Issue;
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
	@Table(name = "Issue_Impediment_Staus")

	public class IssueImpedimentStatus {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "Status_Id")
		private long statusId;

		@Column(name = "Status_name")
		private String statusName;
		
		@JsonIgnore
		@OneToMany(mappedBy = "statusId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
		private List<Issue> issue = new ArrayList<>();
		
		@JsonIgnore
		@OneToMany(mappedBy = "statusId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
		private List<Impediment> impediment = new ArrayList<>();

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

		public List<Issue> getIssue() {
			return issue;
		}

		public void setIssue(List<Issue> issue) {
			this.issue = issue;
		}

		public List<Impediment> getImpediment() {
			return impediment;
		}

		public void setImpediment(List<Impediment> impediment) {
			this.impediment = impediment;
		}

		public IssueImpedimentStatus(long statusId, String statusName, List<Issue> issue, List<Impediment> impediment) {
			super();
			this.statusId = statusId;
			this.statusName = statusName;
			this.issue = issue;
			this.impediment = impediment;
		}

		public IssueImpedimentStatus() {
			super();
			// TODO Auto-generated constructor stub
		}

		
}

