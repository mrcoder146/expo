package com.ScrumTool.Invitation;

import java.sql.Date;

import com.ScrumTool.InvitationStatus.InvitationStatus;
import com.ScrumTool.Project.Project;
import com.ScrumTool.Role.Role;
import com.ScrumTool.User.User;
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
@Table(name = "Invitataion")

public class Invitation {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "Invitation_id")
		private long invitationId;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "Invited_By")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private User invitedBy;

		@Column(name = "Email_Id")
		private String emailId;

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "Project_Id")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private Project projectId;

		@Column(name = "Token")
		private String token;

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "Role_Id")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private Role roleId;

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "Status")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private InvitationStatus invitationStatus;
		
		@Column(name = "Invited_On")
		private Date invitedOn;
		
		@Column(name = "Accepted_On")
		private Date acceptedOn;

		@Column(name = "Rejected_On")
		private Date rejectedOn;

		public long getInvitationId() {
			return invitationId;
		}

		public void setInvitationId(long invitationId) {
			this.invitationId = invitationId;
		}

		public User getInvitedBy() {
			return invitedBy;
		}

		public void setInvitedBy(User invitedBy) {
			this.invitedBy = invitedBy;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public Project getProjectId() {
			return projectId;
		}

		public void setProjectId(Project projectId) {
			this.projectId = projectId;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public Role getRoleId() {
			return roleId;
		}

		public void setRoleId(Role roleId) {
			this.roleId = roleId;
		}

		public InvitationStatus getInvitationStatus() {
			return invitationStatus;
		}

		public void setInvitationStatus(InvitationStatus invitationStatus) {
			this.invitationStatus = invitationStatus;
		}

		public Date getInvitedOn() {
			return invitedOn;
		}

		public void setInvitedOn(Date invitedOn) {
			this.invitedOn = invitedOn;
		}

		public Date getAcceptedOn() {
			return acceptedOn;
		}

		public void setAcceptedOn(Date acceptedOn) {
			this.acceptedOn = acceptedOn;
		}

		public Date getRejectedOn() {
			return rejectedOn;
		}

		public void setRejectedOn(Date rejectedOn) {
			this.rejectedOn = rejectedOn;
		}

		public Invitation(long invitationId, User invitedBy, String emailId, Project projectId, String token,
				Role roleId, InvitationStatus invitationStatus, Date invitedOn, Date acceptedOn, Date rejectedOn) {
			super();
			this.invitationId = invitationId;
			this.invitedBy = invitedBy;
			this.emailId = emailId;
			this.projectId = projectId;
			this.token = token;
			this.roleId = roleId;
			this.invitationStatus = invitationStatus;
			this.invitedOn = invitedOn;
			this.acceptedOn = acceptedOn;
			this.rejectedOn = rejectedOn;
		}

		public Invitation() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	
}
