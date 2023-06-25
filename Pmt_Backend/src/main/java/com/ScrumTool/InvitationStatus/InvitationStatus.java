package com.ScrumTool.InvitationStatus;

import java.util.ArrayList;
import java.util.List;

import com.ScrumTool.Invitation.Invitation;
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
@Table(name = "Invitation_Status")
public class InvitationStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Invitation_Status_Id")
	private long invitationStatusId;

	@Column(name = "Invitation_Status_Name")
	private String invitationStatusName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "invitationStatus", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Invitation> invitation = new ArrayList<>();

	public long getInvitationStatusId() {
		return invitationStatusId;
	}

	public void setInvitationStatusId(long invitationStatusId) {
		this.invitationStatusId = invitationStatusId;
	}

	public String getInvitationStatusName() {
		return invitationStatusName;
	}

	public void setInvitationStatusName(String invitationStatusName) {
		this.invitationStatusName = invitationStatusName;
	}

	public List<Invitation> getInvitation() {
		return invitation;
	}

	public void setInvitation(List<Invitation> invitation) {
		this.invitation = invitation;
	}

	public InvitationStatus(long invitationStatusId, String invitationStatusName, List<Invitation> invitation) {
		super();
		this.invitationStatusId = invitationStatusId;
		this.invitationStatusName = invitationStatusName;
		this.invitation = invitation;
	}

	public InvitationStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
